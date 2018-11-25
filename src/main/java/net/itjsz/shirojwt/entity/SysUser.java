package net.itjsz.shirojwt.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.itjsz.shirojwt.common.base.BaseEntity;

import java.util.List;

/**
 * 系统用户
 * 
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysUser", description="系统用户")
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = -6174479088318518840L;

	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;

	List<SysRole> roles;

}
