/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : ittest

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2020-08-20 21:34:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for million_data_test
-- ----------------------------
DROP TABLE IF EXISTS `million_data_test`;
CREATE TABLE `million_data_test` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `create_time` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` varchar(22) DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
