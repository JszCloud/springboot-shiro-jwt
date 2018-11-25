package net.itjsz.shirojwt.common.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lmy on 2018/8/31.
 *
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -7129483297436942597L;

    private Long id;
    protected String createId;	// 创建者
    protected Date createTime;	// 创建日期
    protected String updateId;	// 更新者
    protected Date updateTime;	// 更新日期
    protected String deleted=DEL_FLAG_NORMAL; 	// 删除标记（0：正常；1：删除；2：审核）
    /**
     * 删除标记（0：正常；1：删除）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";

}
