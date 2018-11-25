package net.itjsz.shirojwt.service.impl;

import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysRoleMenu;
import net.itjsz.shirojwt.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Override
    public PageResponseBean queryPage(PageRequestBean pageRequestBean) {


        return new PageResponseBean();
    }

    /**
     * 带条件统计数
     *
     * @param sysRoleMenu
     * @return
     */
    @Override
    public Long count(SysRoleMenu sysRoleMenu) {
        return null;
    }

    /**
     * 保存
     *
     * @param sysRoleMenu
     * @return
     */
    @Override
    public Integer save(SysRoleMenu sysRoleMenu) {
        return null;
    }

    /**
     * 修改
     *
     * @param sysRoleMenu
     * @return
     */
    @Override
    public Integer edit(SysRoleMenu sysRoleMenu) {
        return null;
    }

    /**
     * 删除
     *
     * @param sysRoleMenu
     * @return
     */
    @Override
    public Integer remove(SysRoleMenu sysRoleMenu) {
        return null;
    }

    /**
     * 根据ID查询单个实体
     *
     * @param id
     * @return
     */
    @Override
    public SysRoleMenu findById(Long id) {
        return null;
    }

    /**
     * 根据实体查询列表
     *
     * @param sysRoleMenu
     * @return
     */
    @Override
    public List<SysRoleMenu> findAllByT(SysRoleMenu sysRoleMenu) {
        return null;
    }
}
