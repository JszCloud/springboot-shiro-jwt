package net.itjsz.shirojwt.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.itjsz.shirojwt.common.base.BaseEntity;

/**
 * 菜单管理
 * 
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysMenu", description="菜单管理")
public class SysMenu extends BaseEntity {

	private static final long serialVersionUID = 2241335337052462836L;

	/**
	 * 父菜单ID，一级菜单为0
	 */
	private Long parentId;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单URL
	 */
	private String url;
	/**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	private String perms;
	/**
	 * 类型   0：目录   1：菜单   2：按钮
	 */
	private Integer type;
	/**
	 * 菜单图标
	 */
	private String icon;
	/**
	 * 排序
	 */
	private Integer orderNum;

}
