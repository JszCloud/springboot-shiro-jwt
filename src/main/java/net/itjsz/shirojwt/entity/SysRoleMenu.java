package net.itjsz.shirojwt.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.itjsz.shirojwt.common.base.BaseEntity;

/**
 * 角色与菜单对应关系
 * 
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysRoleMenu", description="角色与菜单对应关系")
public class SysRoleMenu extends BaseEntity {

	private static final long serialVersionUID = -8032433901461563668L;

	/**
	 * 角色ID
	 */
	private Long roleId;
	/**
	 * 菜单ID
	 */
	private Long menuId;

}
