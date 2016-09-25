/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 100113
Source Host           : localhost:3306
Source Database       : bootadmin

Target Server Type    : MYSQL
Target Server Version : 100113
File Encoding         : 65001

Date: 2016-09-25 17:19:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `urls` varchar(255) DEFAULT NULL,
  `icons` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parentid` (`pid`),
  CONSTRAINT `sys_menu_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `sys_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', null, ' icon fa fa-tachometer', null, '1');
INSERT INTO `sys_menu` VALUES ('2', '用户管理', null, null, '1', '3');
INSERT INTO `sys_menu` VALUES ('3', '角色管理', '', null, '1', '3');
INSERT INTO `sys_menu` VALUES ('4', '菜单管理', '/admin/sys/menu/index', null, '1', '3');
INSERT INTO `sys_menu` VALUES ('5', '仪表盘', null, 'icon fa fa-desktop', null, '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `rolekey` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `menuid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`),
  KEY `menuid` (`menuid`),
  CONSTRAINT `sys_role_menu_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_menu_ibfk_2` FOREIGN KEY (`menuid`) REFERENCES `sys_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`),
  KEY `userid` (`userid`),
  CONSTRAINT `sys_role_user_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_user_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', '1', '1');
