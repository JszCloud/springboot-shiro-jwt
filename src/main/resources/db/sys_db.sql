/*
 Navicat Premium Data Transfer

 Source Server         : IT技术栈
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : mydkj123.mysql.rds.aliyuncs.com:3333
 Source Schema         : myd_sys

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 25/11/2018 23:58:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (31, 1, '角色', '/sys/role/', 'sys:role', 1, 'config', 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (32, 31, '查看', '/sys/role/list', 'sys:role:list,sys:role:info', 2, NULL, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (33, 31, '新增', '/sys/role/add', 'sys:role:save', 2, NULL, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (34, 31, '修改', '/sys/role/edit', 'sys:role:update', 2, NULL, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (35, 31, '删除', '/sys/role/del', 'sys:role:delete', 2, NULL, 2, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (36, 1, '用户', '/sys/user/', 'sys:user', 1, NULL, 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (37, 36, '查看', '/sys/user/list', 'sys:user:select,sys:user:info', 2, NULL, 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (38, 36, '新增', '/sys/user/add', 'sys:user:save', 2, NULL, 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (39, 36, '修改', '/sys/user/edit', 'sys:user:update', 2, NULL, 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (40, 36, '删除', '/sys/user/delete', 'sys:user:delete', 2, NULL, 1, NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '超级管理员', '最高权限', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (2, '管理员', '一般管理员权限（部分增删改权限）', NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_role` VALUES (3, '普通用户', '用户权限（仅有查看权限）', NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (1, 1, 31, '2018-11-15 14:19:11', '2018-11-15 14:19:16', 1, 1, 0);
INSERT INTO `sys_role_menu` VALUES (2, 3, 38, '2018-11-15 14:19:35', '2018-11-15 14:19:40', 1, 1, 0);
INSERT INTO `sys_role_menu` VALUES (3, 2, 36, '2018-11-18 03:34:41', '2018-11-18 03:34:48', 1, 1, 0);
INSERT INTO `sys_role_menu` VALUES (4, 1, 37, '2018-11-22 18:14:29', '2018-11-22 18:14:34', 1, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'supperadmin', '947bf9c4b5045c157f103fe788ecb523', 'superadmin', 'supperadmin@mydkj.net', '17585956456', 0, '2018-11-15 14:15:47', '2018-11-15 14:15:51', 1, 1, 0);
INSERT INTO `sys_user` VALUES (2, 'test', 'test', 'test', 'test@mydkj.net', '18385157376', 0, '2018-11-15 14:17:10', '2018-11-15 14:17:15', 1, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1, 1, '2018-11-15 14:16:21', '2018-11-15 14:16:26', 1, 1, 0);
INSERT INTO `sys_user_role` VALUES (2, 1, 3, '2018-11-15 14:17:32', '2018-11-15 14:17:37', 1, 1, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
