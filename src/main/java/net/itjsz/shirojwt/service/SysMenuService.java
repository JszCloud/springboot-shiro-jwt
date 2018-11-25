package net.itjsz.shirojwt.service;


import net.itjsz.shirojwt.common.base.BaseService;
import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysMenu;

import java.util.List;

/**
 * 菜单管理
 *
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
public interface SysMenuService extends BaseService<SysMenu> {

    PageResponseBean queryPage(PageRequestBean pageRequestBean);

    /**
     * 查询所有
     * @return
     */
    List<SysMenu> findAll();
}

