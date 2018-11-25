package net.itjsz.shirojwt.common.shiro;

import lombok.extern.slf4j.Slf4j;
import net.itjsz.shirojwt.common.util.JWTUtil;
import net.itjsz.shirojwt.entity.SysUser;
import net.itjsz.shirojwt.service.ShiroService;
import net.itjsz.shirojwt.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by lmy on 2018/11/14.
 * 身份校验核心类
 * @author lmy
 * @project shiro-jwt
 * @date 2018/11/14
 */
@Slf4j
public class JWTRealm extends AuthorizingRealm {


    @Autowired
    SysUserService sysUserService;

    @Autowired
    ShiroService shiroService;


    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 认证信息(身份验证)
     * Authentication 是用来验证用户身份
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)
            throws AuthenticationException {
        log.info("认证-->JWTRealm.doGetAuthenticationInfo()");
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }
        //通过username从数据库中查找 SysUser对象
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser userInfo = sysUserService.findByUsername(username);

        if (userInfo == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtil.verify(token, username, userInfo.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "jwtRealm");
    }

    /**
     * 此方法调用hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*
         * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
         * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
         * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
         * 缓存过期之后会再次执行。
         */
        log.info("权限-->JWTRealm.doGetAuthorizationInfo()");
        String username = JWTUtil.getUsername(principals.toString());

        // 下面的可以使用缓存提升速度
        SysUser userInfo = sysUserService.findByUsername(username);

        Set<String> permsSet = shiroService.getUserPermissions(userInfo.getId());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.addStringPermissions(permsSet);

        return authorizationInfo;
    }

}