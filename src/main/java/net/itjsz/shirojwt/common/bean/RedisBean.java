package net.itjsz.shirojwt.common.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lmy on 2018/11/28.
 *
 * @author lmy
 * @project shiro-jwt
 * @date 2018/11/28
 */
@Component
@Data
public class RedisBean {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.expire}")
    private int expire;

}
