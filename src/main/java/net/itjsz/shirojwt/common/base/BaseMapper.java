package net.itjsz.shirojwt.common.base;


import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;

import java.util.List;

/**
 * Created by lmy on 2018/8/31.
 *
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:07
 */
public interface BaseMapper<T> {
    /**
     * 带条件分页查询
     * @param pageRequestBean
     * @return
     */
    PageResponseBean<T> queryPage(PageRequestBean<T> pageRequestBean);

    /**
     * 删除（逻辑删除，更新del_flag为 -1）
     * @param t
     * @return
     */
    Integer delete(T t);

    /**
     * 增加
     * @param t
     * @return
     */
    Integer inster(T t);

    /**
     * 修改
     * @param t
     * @return
     */
    Integer update(T t);

    /**
     * 根据ID查询单个实体
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 根据实体查询列表
     * @param t
     * @return
     */
    List<T> findAllByT(T t);



}
