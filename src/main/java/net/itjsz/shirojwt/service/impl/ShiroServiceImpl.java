package net.itjsz.shirojwt.service.impl;

import net.itjsz.shirojwt.entity.SysMenu;
import net.itjsz.shirojwt.entity.SysRole;
import net.itjsz.shirojwt.mapper.SysMenuMapper;
import net.itjsz.shirojwt.mapper.SysRoleMapper;
import net.itjsz.shirojwt.mapper.SysUserMapper;
import net.itjsz.shirojwt.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by lmy on 2018/11/15.
 *
 * @author lmy
 * @project shiro-jwt
 * @date 2018/11/15
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    SysUserMapper sysUserMapper;

    /**
     * 获取用户权限列表
     *
     * @param userId
     */
    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList = null;

        List<SysRole> roles = sysRoleMapper.findRolesByU(userId);
        for (SysRole role : roles) {
            permsList = new ArrayList<>();
            List<SysMenu> menus = sysMenuMapper.findMenusByR(role.getId());
            if (menus.size() > 0){
                for(SysMenu menu : menus){
                    if (menu.getPerms()!=null){
                    permsList.add(menu.getPerms());}
                }
            }
        }

        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

}
