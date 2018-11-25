package net.itjsz.shirojwt.service;

import net.itjsz.shirojwt.common.base.BaseService;
import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysUserRole;

/**
 * 用户与角色对应关系
 *
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:05
 */
public interface SysUserRoleService extends BaseService<SysUserRole> {

    PageResponseBean queryPage(PageRequestBean pageRequestBean);
}

