package net.itjsz.shirojwt.service;


import java.util.Set;

/**
 * Created by lmy on 2018/11/15.
 *
 * @author lmy
 * @project shiro-jwt
 * @date 2018/11/15
 */
public interface ShiroService {

    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);


}
