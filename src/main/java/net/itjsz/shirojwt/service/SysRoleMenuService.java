package net.itjsz.shirojwt.service;

import net.itjsz.shirojwt.common.base.BaseService;
import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysRoleMenu;

/**
 * 角色与菜单对应关系
 *
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:05
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenu> {

    PageResponseBean queryPage(PageRequestBean pageRequestBean);
}

