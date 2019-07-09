/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : tools

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-12 14:01:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_information`
-- ----------------------------
DROP TABLE IF EXISTS `admin_information`;
CREATE TABLE `admin_information` (
  `Ad_no` varchar(30) NOT NULL,
  `Ad_pa` varchar(30) NOT NULL,
  PRIMARY KEY (`Ad_no`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_information
-- ----------------------------
INSERT INTO `admin_information` VALUES ('001', '111111');

-- ----------------------------
-- Table structure for `model`
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `basic` (
  `id` varchar(30) NOT NULL,
  `tid` varchar(30) NOT NULL,
  `tname` varchar(30) NOT NULL,
  `cid` varchar(30) NOT NULL,
  `cname` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of model
-- ----------------------------
INSERT INTO `basic` VALUES ('1', '00001', '耿耀君', '002', '数据结构');
INSERT INTO `basic` VALUES ('2', '00001', '耿耀君', '003', 'windows程序设计');
INSERT INTO `basic` VALUES ('3', '11111', '杜炜', '201', '离散数学');

-- ----------------------------
-- Table structure for `ss`
-- ----------------------------
DROP TABLE IF EXISTS `ss`;
CREATE TABLE `ss` (
  `number` varchar(10) NOT NULL,
  `password` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ss
-- ----------------------------
INSERT INTO `ss` VALUES ('2016012742', '202919');
INSERT INTO `ss` VALUES ('2016012748', '133512');
INSERT INTO `ss` VALUES ('2016012745', '569873');
INSERT INTO `ss` VALUES ('2016012744', '123456');
INSERT INTO `ss` VALUES ('2016012746', '999999');
INSERT INTO `ss` VALUES ('2016012456', '555555');
INSERT INTO `ss` VALUES ('2016012743', '222222');
INSERT INTO `ss` VALUES ('4444444444', '444444');
INSERT INTO `ss` VALUES ('2016012777', '777777');
INSERT INTO `ss` VALUES ('2016012888', '888888');
INSERT INTO `ss` VALUES ('2016012753', '123456');

-- ----------------------------
-- Table structure for `stu_introduction`
-- ----------------------------
DROP TABLE IF EXISTS `stu_introduction`;
CREATE TABLE `stu_introduction` (
  `id` varchar(30) NOT NULL DEFAULT '',
  `name` varchar(30) NOT NULL,
  `sex` varchar(30) NOT NULL,
  `college` varchar(30) NOT NULL,
  `classes` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_introduction
-- ----------------------------
INSERT INTO `stu_introduction` VALUES ('2016012748', '刘政琪', '男', '信息工程学院', '电子商务1601');
INSERT INTO `stu_introduction` VALUES ('2016012746', '张京', '男', '信息工程学院', '电子商务1601');
INSERT INTO `stu_introduction` VALUES ('2016012743', '王宇轩', '男', '信息工程学院', '电子商务1601');
INSERT INTO `stu_introduction` VALUES ('2016012744', '陶原', '男', '信息工程学院', '电子商务1601');
INSERT INTO `stu_introduction` VALUES ('2016012742', '王竟宇', '男', '信息工程学院', '电子商务1601');
INSERT INTO `stu_introduction` VALUES ('2016012777', '江鹏', '男', '信息工程学院', '电子商务1602');
INSERT INTO `stu_introduction` VALUES ('2016012888', '马明月', '男', '信息工程学院', '电子商务1602');
INSERT INTO `stu_introduction` VALUES ('2016012753', '严昊', '男', '信息工程学院', '电子商务1601');

-- ----------------------------
-- Table structure for `stu_select`
-- ----------------------------
DROP TABLE IF EXISTS `stu_select`;
CREATE TABLE `stu_select` (
  `sid` varchar(30) NOT NULL DEFAULT '',
  `sname` varchar(30) DEFAULT NULL,
  `cid` varchar(30) NOT NULL DEFAULT '',
  `course` varchar(30) DEFAULT NULL,
  `result` int(30) DEFAULT NULL,
  PRIMARY KEY (`sid`,`cid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_select
-- ----------------------------
INSERT INTO `stu_select` VALUES ('2016012748', '刘政琪', '001', '电子商务供应链', '72');
INSERT INTO `stu_select` VALUES ('2016012748', '刘政琪', '101', '体育', '85');
INSERT INTO `stu_select` VALUES ('2016012744', '陶原', '002', '数据结构', '86');
INSERT INTO `stu_select` VALUES ('2016012744', '陶原', '003', 'windows程序设计', '98');
INSERT INTO `stu_select` VALUES ('2016012888', '马明月', '004', '大学计算机基础', '95');
INSERT INTO `stu_select` VALUES ('2016012748', '刘政琪', '002', '数据结构', '80');
INSERT INTO `stu_select` VALUES ('2016012888', '马明月', '002', '数据结构', '99');
INSERT INTO `stu_select` VALUES ('2016012777', '江鹏', '002', '数据结构', '100');
INSERT INTO `stu_select` VALUES ('2016012753', '严昊', '002', '数据结构', '65');
INSERT INTO `stu_select` VALUES ('2016012742', '王竟宇', '002', '数据结构', '97');
INSERT INTO `stu_select` VALUES ('2016012742', '王竟宇', '201', '离散数学', '89');

-- ----------------------------
-- Table structure for `tea`
-- ----------------------------
DROP TABLE IF EXISTS `tea`;
CREATE TABLE `tea` (
  `tid` varchar(30) NOT NULL,
  `tpassowrd` varchar(30) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tea
-- ----------------------------
INSERT INTO `tea` VALUES ('00001', '123456');
INSERT INTO `tea` VALUES ('11111', '123456');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `college` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('00001', '耿耀君', '信息工程学院');
INSERT INTO `teacher` VALUES ('11111', '杜炜', '理学院');

-- ----------------------------
-- Table structure for `userif`
-- ----------------------------
DROP TABLE IF EXISTS `userif`;
CREATE TABLE `userif` (
  `uid` varchar(30) NOT NULL DEFAULT '',
  `pwd` varchar(30) DEFAULT NULL,
  `authority` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userif
-- ----------------------------
INSERT INTO `userif` VALUES ('00001', '123456', 'T');
INSERT INTO `userif` VALUES ('11111', '123456', 'T');
