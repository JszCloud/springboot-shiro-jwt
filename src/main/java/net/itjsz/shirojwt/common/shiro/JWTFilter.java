package net.itjsz.shirojwt.common.shiro;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.itjsz.shirojwt.common.bean.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lmy on 2018/11/15.
 * 自定义shiroFilter
 * @author lmy
 * @project shiro-jwt
 * @date 2018/11/15
 */
@Slf4j
public class JWTFilter extends BasicHttpAuthenticationFilter {

    /**
     * 判断用户是否想要登入。
     * 检测header里面是否包含token字段即可
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("token");
        return authorization != null;
    }

    /**
     * 执行登录
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader("token");
        JWTToken token = new JWTToken(authorization);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(token);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * isAccessAllowed：即是否允许访问，返回true表示允许
     * 如果在这里返回了false，请求会被直接拦截
     * 如果在这里返回true，Controller中可以通过 subject.isAuthenticated() 来判断用户是否登入
     * 如果有些资源只有登入用户才能访问，我们只需要在方法上面加上 @RequiresAuthentication 注解即可
     * 通过 mappedValue 与用户的权限进行匹配 匹配上了就允许访问
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        /*判断是否带有 token*/
        if (isLoginAttempt(request, response)) {
                //执行登录
                if(executeLogin(request, response)){
                String[] arra = (String[])mappedValue;
                Subject subject = getSubject(request, response);
                for (String s : arra) {
                    //判断权限
                    if (subject.isPermitted(s)){
                        return true;
                    }
                }
                }
                return false;
        }
        return false;
    }

    /**
     *  onAccessDenied：表示 （isAccessAllowed 返回false时） 访问拒绝时是否自己处理，如果返回true表示自己不处理且继续拦截器链执行，返回false表示自己已经处理了
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Subject subject = getSubject(request,response);
        //获取请求token，如果token不存在，直接返回401
        String token = req.getHeader("token");
        if(StringUtils.isBlank(token)){
            String json = JSON.toJSONString(new Result(null,org.apache.http.HttpStatus.SC_UNAUTHORIZED, "invalid token"));
            httpResponse.getWriter().print(json);
            return false;
        }
        // 未认证的情况
        if (null == subject || !subject.isAuthenticated()) {
            // 告知JWT认证失败
            String json = JSON.toJSONString(new Result(null,org.apache.http.HttpStatus.SC_UNAUTHORIZED, "error jwt"));
            httpResponse.getWriter().print(json);
        }else {
            //  已经认证但未授权的情况
            // 告知客户端JWT没有权限访问此资源
            String json = JSON.toJSONString(new Result(null,org.apache.http.HttpStatus.SC_UNAUTHORIZED, "no permission"));
            httpResponse.getWriter().print(json);
        }
        return false;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

}