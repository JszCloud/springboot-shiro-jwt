package net.itjsz.shirojwt.service.impl;

import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysUser;
import net.itjsz.shirojwt.mapper.SysUserMapper;
import net.itjsz.shirojwt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public PageResponseBean queryPage(PageRequestBean pageRequestBean) {


        return new PageResponseBean();
    }

    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.findByUsername(username);
    }

    /**
     * 带条件统计数
     *
     * @param sysUser
     * @return
     */
    @Override
    public Long count(SysUser sysUser) {
        return null;
    }

    /**
     * 保存
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer save(SysUser sysUser) {
        return null;
    }

    /**
     * 修改
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer edit(SysUser sysUser) {
        return null;
    }

    /**
     * 删除
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer remove(SysUser sysUser) {
        return null;
    }

    /**
     * 根据ID查询单个实体
     *
     * @param id
     * @return
     */
    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.findById(id);
    }

    /**
     * 根据实体查询列表
     *
     * @param sysUser
     * @return
     */
    @Override
    public List<SysUser> findAllByT(SysUser sysUser) {
        return null;
    }
}
