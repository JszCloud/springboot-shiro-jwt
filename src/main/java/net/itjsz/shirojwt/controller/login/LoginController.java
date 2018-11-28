package net.itjsz.shirojwt.controller.login;

/**
 * Created by lmy on 2018/11/17.
 * 登录
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @project shiro-jwt
 * @date 2018/11/17
 */

import io.swagger.annotations.Api;
import net.itjsz.shirojwt.common.bean.Result;
import net.itjsz.shirojwt.common.shiro.ShiroKit;
import net.itjsz.shirojwt.common.util.JWTUtil;
import net.itjsz.shirojwt.entity.SysUser;
import net.itjsz.shirojwt.mapper.SysUserMapper;
import org.apache.shiro.authz.UnauthorizedException;
import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description ="登录")
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    SysUserMapper sysUserMapper;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result<String> login(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        SysUser sysUser = sysUserMapper.findByUsername(username);
        //盐（用户名+随机数）
        String salt = sysUser.getSalt();
        //原密码
        String encodedPassword = ShiroKit.md5(password, username + salt);
        RedisManager redisManager =new RedisManager();
        if (sysUser.getPassword().equals(encodedPassword)) {
            String token = JWTUtil.sign(username,encodedPassword);
            redisManager.set(("token:"+sysUser.getUsername()).getBytes(),token.getBytes());
            return new Result<String>("登录成功",200,token);
        } else {
            throw new UnauthorizedException();
        }

    }
    @GetMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result unauthorized() {
        return new Result("Unauthorized",401, null);
    }

}
