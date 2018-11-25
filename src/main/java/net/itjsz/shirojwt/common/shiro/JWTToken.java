package net.itjsz.shirojwt.common.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by lmy on 2018/11/15.
 *
 * @author lmy
 * @project shiro-jwt
 * @date 2018/11/15
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
