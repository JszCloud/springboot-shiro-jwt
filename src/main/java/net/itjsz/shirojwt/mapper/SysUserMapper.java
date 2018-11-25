package net.itjsz.shirojwt.mapper;

import net.itjsz.shirojwt.common.base.BaseMapper;
import net.itjsz.shirojwt.entity.SysUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 系统用户
 * 
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByUsername(String username);

}
