package net.itjsz.shirojwt.mapper;

import net.itjsz.shirojwt.common.base.BaseMapper;
import net.itjsz.shirojwt.entity.SysMenu;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 菜单管理
 * 
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 查询全部
     * @return
     */
    List<SysMenu> findAll();

    List<SysMenu> findMenusByR(Long roleId);
}
