package net.itjsz.shirojwt.service;

import net.itjsz.shirojwt.common.base.BaseService;
import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysUser;

/**
 * 系统用户
 *
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
public interface SysUserService extends BaseService<SysUser> {

    PageResponseBean queryPage(PageRequestBean pageRequestBean);

    SysUser findByUsername(String username);


}

