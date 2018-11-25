package net.itjsz.shirojwt.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.itjsz.shirojwt.common.base.BaseEntity;

/**
 * 用户与角色对应关系
 * 
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysUserRole", description="用户与角色对应关系")
public class SysUserRole extends BaseEntity {

	private static final long serialVersionUID = -7791271039650963345L;

	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 角色ID
	 */
	private Long roleId;

}
