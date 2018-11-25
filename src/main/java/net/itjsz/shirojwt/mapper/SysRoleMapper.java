package net.itjsz.shirojwt.mapper;


import net.itjsz.shirojwt.common.base.BaseMapper;
import net.itjsz.shirojwt.entity.SysRole;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 角色
 * 
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 根据用户id查询角色列表
     * @param userId
     * @return
     */
    List<SysRole> findRolesByU(Long userId);

}
