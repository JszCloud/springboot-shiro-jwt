package net.itjsz.shirojwt.service.impl;

import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.entity.SysMenu;
import net.itjsz.shirojwt.mapper.SysMenuMapper;
import net.itjsz.shirojwt.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public PageResponseBean queryPage(PageRequestBean pageRequestBean) {


        return new PageResponseBean();
    }

    /**
     * 带条件统计数
     *
     * @param sysMenu
     * @return
     */
    @Override
    public Long count(SysMenu sysMenu) {
        return null;
    }

    /**
     * 保存
     *
     * @param sysMenu
     * @return
     */
    @Override
    public Integer save(SysMenu sysMenu) {
        return null;
    }

    /**
     * 修改
     *
     * @param sysMenu
     * @return
     */
    @Override
    public Integer edit(SysMenu sysMenu) {
        return null;
    }

    /**
     * 删除
     *
     * @param sysMenu
     * @return
     */
    @Override
    public Integer remove(SysMenu sysMenu) {
        return null;
    }

    /**
     * 根据ID查询单个实体
     *
     * @param id
     * @return
     */
    @Override
    public SysMenu findById(Long id) {
        return null;
    }

    /**
     * 根据实体查询列表
     *
     * @param sysMenu
     * @return
     */
    @Override
    public List<SysMenu> findAllByT(SysMenu sysMenu) {
        return null;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<SysMenu> findAll() {

        return sysMenuMapper.findAll();
    }
}
