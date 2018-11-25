package net.itjsz.shirojwt.service.impl;

import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysRole;
import net.itjsz.shirojwt.mapper.SysRoleMapper;
import net.itjsz.shirojwt.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public PageResponseBean queryPage(PageRequestBean pageRequestBean) {


        return new PageResponseBean();
    }

    /**
     * 带条件统计数
     *
     * @param sysRole
     * @return
     */
    @Override
    public Long count(SysRole sysRole) {
        return null;
    }

    /**
     * 保存
     *
     * @param sysRole
     * @return
     */
    @Override
    public Integer save(SysRole sysRole) {
        return null;
    }

    /**
     * 修改
     *
     * @param sysRole
     * @return
     */
    @Override
    public Integer edit(SysRole sysRole) {
        return null;
    }

    /**
     * 删除
     *
     * @param sysRole
     * @return
     */
    @Override
    public Integer remove(SysRole sysRole) {
        return null;
    }

    /**
     * 根据ID查询单个实体
     *
     * @param id
     * @return
     */
    @Override
    public SysRole findById(Long id) {
        return null;
    }

    /**
     * 根据实体查询列表
     *
     * @param sysRole
     * @return
     */
    @Override
    public List<SysRole> findAllByT(SysRole sysRole) {
        return null;
    }
}
