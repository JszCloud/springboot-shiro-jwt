package net.itjsz.shirojwt.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.itjsz.shirojwt.common.base.BaseEntity;

/**
 * 角色
 * 
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysRole", description="角色")
public class SysRole extends BaseEntity {

	private static final long serialVersionUID = -5918875171819945562L;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 备注
	 */
	private String remark;




}
