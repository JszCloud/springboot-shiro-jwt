package net.itjsz.shirojwt.service;

import net.itjsz.shirojwt.common.base.BaseService;
import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysRole;

/**
 * 角色
 *
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
public interface SysRoleService extends BaseService<SysRole> {

    PageResponseBean queryPage(PageRequestBean pageRequestBean);



}

