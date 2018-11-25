package net.itjsz.shirojwt.common.base;


import java.util.List;

/**
 * Created by lmy on 2018/8/31.
 *
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:07
 */
public interface BaseService<T> {

    /**
     * 带条件统计数
     * @param t
     * @return
     */
    Long count(T t);

    /**
     * 保存
     * @param t
     * @return
     */
    Integer save(T t);

    /**
     * 修改
     * @param t
     * @return
     */
    Integer edit(T t);

    /**
     * 删除
     * @param t
     * @return
     */
    Integer remove(T t);

    /**
     * 根据ID查询单个实体
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 根据实体查询列表
     * @return
     */
    List<T> findAllByT(T t);
}
