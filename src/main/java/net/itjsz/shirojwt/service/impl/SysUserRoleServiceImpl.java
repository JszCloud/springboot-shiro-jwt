package net.itjsz.shirojwt.service.impl;

import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysUserRole;
import net.itjsz.shirojwt.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Override
    public PageResponseBean queryPage(PageRequestBean pageRequestBean) {


        return new PageResponseBean();
    }

    /**
     * 带条件统计数
     *
     * @param sysUserRole
     * @return
     */
    @Override
    public Long count(SysUserRole sysUserRole) {
        return null;
    }

    /**
     * 保存
     *
     * @param sysUserRole
     * @return
     */
    @Override
    public Integer save(SysUserRole sysUserRole) {
        return null;
    }

    /**
     * 修改
     *
     * @param sysUserRole
     * @return
     */
    @Override
    public Integer edit(SysUserRole sysUserRole) {
        return null;
    }

    /**
     * 删除
     *
     * @param sysUserRole
     * @return
     */
    @Override
    public Integer remove(SysUserRole sysUserRole) {
        return null;
    }

    /**
     * 根据ID查询单个实体
     *
     * @param id
     * @return
     */
    @Override
    public SysUserRole findById(Long id) {
        return null;
    }

    /**
     * 根据实体查询列表
     *
     * @param sysUserRole
     * @return
     */
    @Override
    public List<SysUserRole> findAllByT(SysUserRole sysUserRole) {
        return null;
    }
}
