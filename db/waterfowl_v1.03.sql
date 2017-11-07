/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : waterfowl

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2017-11-03 16:42:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aquaculture
-- ----------------------------
DROP TABLE IF EXISTS `aquaculture`;
CREATE TABLE `aquaculture` (
  `id` varchar(45) NOT NULL COMMENT '养殖记录表',
  `type` varchar(45) DEFAULT NULL COMMENT '禽舍类型',
  `id_fowlery` varchar(45) DEFAULT NULL COMMENT '禽舍表编号',
  `record_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `num_total` int(11) DEFAULT NULL COMMENT '当前个体总数',
  `feed_weight` float DEFAULT NULL COMMENT '饲料重量：单位为千克',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id_poultry` varchar(45) DEFAULT NULL,
  `id_outstorage` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL COMMENT '禽类的阶段标识',
  PRIMARY KEY (`id`),
  KEY `fk_aquaculture_user1_idx` (`id_recorder`),
  KEY `fk_aquaculture_user2_idx` (`id_charge`),
  KEY `fk_aquaculture_fowlery1_idx` (`id_fowlery`),
  KEY `fk_aquaculture_poultry1_idx` (`id_poultry`),
  KEY `fk_aquaculture_outstorage1_idx` (`id_outstorage`),
  KEY `fk_aquaculture_poultry1_idx1` (`id_poultry`),
  KEY `fk_aquaculture_outstorage1_idx1` (`id_outstorage`),
  KEY `type_dictionary_id` (`type`),
  KEY `status_dictionary_id` (`status`),
  CONSTRAINT `status_dictionary_id` FOREIGN KEY (`status`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aquaculture_ibfk_1` FOREIGN KEY (`id_fowlery`) REFERENCES `fowlery` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aquaculture_ibfk_3` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aquaculture_ibfk_4` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aquaculture_outstorage1` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aquaculture_poultry1` FOREIGN KEY (`id_poultry`) REFERENCES `poultry` (`id_poultry`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `type_dictionary_id` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aquaculture
-- ----------------------------

-- ----------------------------
-- Table structure for ddl
-- ----------------------------
DROP TABLE IF EXISTS `ddl`;
CREATE TABLE `ddl` (
  `id` varchar(45) NOT NULL COMMENT '病、死、淘汰记录表编号',
  `id_poultry` varchar(45) NOT NULL COMMENT '疫病情况表编号',
  `record_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `num_processed` int(11) NOT NULL COMMENT '需处理个体数量',
  `processing_mode` varchar(45) NOT NULL COMMENT '处理方式',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  `flag` int(11) NOT NULL DEFAULT '0' COMMENT '提交状态   0表示未提交，1表示提交',
  PRIMARY KEY (`id`),
  KEY `fk_ddl_poultry1_idx` (`id_poultry`),
  KEY `fk_ddl_user1_idx` (`id_recorder`),
  KEY `fk_ddl_user2_idx` (`id_charge`),
  CONSTRAINT `ddl_ibfk_1` FOREIGN KEY (`id_poultry`) REFERENCES `poultry` (`id_poultry`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ddl_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ddl_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ddl
-- ----------------------------

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` varchar(45) NOT NULL COMMENT '导航栏编号',
  `name` varchar(45) DEFAULT NULL COMMENT '栏目名称',
  `pid` varchar(45) DEFAULT NULL COMMENT '上一级导航栏编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('1000', '导航栏', '0');
INSERT INTO `dictionary` VALUES ('1001', '仓库', '1000');
INSERT INTO `dictionary` VALUES ('1002', '禽舍', '1000');
INSERT INTO `dictionary` VALUES ('2000', '国际单位', '0');
INSERT INTO `dictionary` VALUES ('2001', '千克(kg)', '2000');
INSERT INTO `dictionary` VALUES ('3000', '阶段', '0');
INSERT INTO `dictionary` VALUES ('3001', '受精蛋', '3000');
INSERT INTO `dictionary` VALUES ('4000', '禽舍类型', '0');
INSERT INTO `dictionary` VALUES ('4001', '孵化器', '4000');
INSERT INTO `dictionary` VALUES ('5000', '权限', '0');
INSERT INTO `dictionary` VALUES ('6000', '家禽种类', '0');
INSERT INTO `dictionary` VALUES ('6001', '鹅', '6000');

-- ----------------------------
-- Table structure for epidemic
-- ----------------------------
DROP TABLE IF EXISTS `epidemic`;
CREATE TABLE `epidemic` (
  `id_epidemic` varchar(45) NOT NULL COMMENT '疫情记录编号',
  `id_fowlery` varchar(45) NOT NULL COMMENT '禽舍编号',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date日期',
  `sign` varchar(45) NOT NULL COMMENT '免疫、疫病标志',
  `diseaes` varchar(45) NOT NULL COMMENT '疾病',
  `num_infected` int(11) NOT NULL COMMENT '染病个体数',
  `processing_mode` varchar(45) NOT NULL COMMENT '处理方式',
  `medication_mode` varchar(45) NOT NULL COMMENT '给药方式',
  `dose` float NOT NULL COMMENT '剂量',
  `dose_unit` varchar(45) NOT NULL COMMENT '剂量对应单位',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  `flag` int(11) NOT NULL DEFAULT '0' COMMENT '提交状态   0表示未提交，1表示提交',
  PRIMARY KEY (`id_epidemic`),
  KEY `fk_epidemic_fowlery1_idx` (`id_fowlery`),
  KEY `fk_epidemic_user1_idx` (`id_recorder`),
  KEY `fk_epidemic_user2_idx` (`id_charge`),
  KEY `epidemic_unit_dictionary_id` (`dose_unit`),
  CONSTRAINT `epidemic_unit_dictionary_id` FOREIGN KEY (`dose_unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_2` FOREIGN KEY (`id_fowlery`) REFERENCES `fowlery` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_4` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_5` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epidemic
-- ----------------------------

-- ----------------------------
-- Table structure for fowlery
-- ----------------------------
DROP TABLE IF EXISTS `fowlery`;
CREATE TABLE `fowlery` (
  `id` varchar(45) NOT NULL COMMENT '禽舍管理表',
  `date_establish` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '建立日期',
  `address` varchar(45) DEFAULT NULL COMMENT '地址',
  `num_max` int(11) DEFAULT NULL COMMENT '最大纳员数量',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `type` varchar(45) DEFAULT NULL COMMENT '禽舍类型',
  PRIMARY KEY (`id`),
  KEY `fk_fowlery_user1_idx` (`id_recorder`),
  KEY `fk_fowlery_user2_idx` (`id_charge`),
  KEY `fowlery_type_dictionary_id` (`type`),
  CONSTRAINT `fowlery_type_dictionary_id` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fowlery_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fowlery_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fowlery
-- ----------------------------

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id_material` varchar(45) NOT NULL COMMENT '材料入厂记录表',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `name` varchar(45) DEFAULT NULL COMMENT '材料名称',
  `quantity` varchar(45) DEFAULT NULL COMMENT '材料数量',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位',
  `associated_firm` varchar(45) DEFAULT NULL COMMENT '关联厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '关联厂商电话',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id_material`),
  UNIQUE KEY `Id_UNIQUE` (`id_material`),
  KEY `fk_material_user1_idx` (`id_recorder`),
  KEY `fk_material_user2_idx` (`id_charge`),
  KEY `mate_unit_dic_id` (`unit`),
  CONSTRAINT `mate_unit_dic_id` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `material_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `material_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------

-- ----------------------------
-- Table structure for outstorage
-- ----------------------------
DROP TABLE IF EXISTS `outstorage`;
CREATE TABLE `outstorage` (
  `id_outstorage` varchar(45) NOT NULL COMMENT '物资使用表',
  `date` timestamp NULL DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '材料名称',
  `quantity` varchar(45) DEFAULT NULL COMMENT '材料数量.用药总量，包含实际总使用量和损耗丢弃量。单位以对应消耗品在inv库存表中的unit属性为准，可以是：盒、ml、kg等',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id_storage` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_outstorage`),
  KEY `fk_storage_user1_idx` (`id_recorder`),
  KEY `fk_storage_user2_idx` (`id_charge`),
  KEY `fk_outstorage_storage1_idx` (`id_storage`),
  KEY `outst_unit_dic_id` (`unit`),
  CONSTRAINT `outst_unit_dic_id` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_outstorage_storage1` FOREIGN KEY (`id_storage`) REFERENCES `storage` (`id_storage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storage_ibfk_10` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storage_ibfk_20` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outstorage
-- ----------------------------

-- ----------------------------
-- Table structure for poultry
-- ----------------------------
DROP TABLE IF EXISTS `poultry`;
CREATE TABLE `poultry` (
  `id_poultry` varchar(45) NOT NULL COMMENT '家禽记录表',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `name` varchar(45) DEFAULT NULL COMMENT '家禽名称',
  `quantity` varchar(45) DEFAULT NULL COMMENT '本批次个体数',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位',
  `associated_firm` varchar(45) DEFAULT NULL COMMENT '关联厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '关联厂商电话',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `out_firm` varchar(45) DEFAULT NULL COMMENT '出产商',
  `out_phone` varchar(45) DEFAULT NULL COMMENT '出产商电话',
  PRIMARY KEY (`id_poultry`),
  UNIQUE KEY `Id_UNIQUE` (`id_poultry`),
  KEY `fk_material_user1_idx` (`id_recorder`),
  KEY `fk_material_user2_idx` (`id_charge`),
  KEY `poultry_name_dictionary_id` (`name`),
  CONSTRAINT `poultry_name_dictionary_id` FOREIGN KEY (`name`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `material_ibfk_20` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `material_ibfk_30` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poultry
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(45) NOT NULL COMMENT 'Permission table角色表',
  `name` varchar(45) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` varchar(45) NOT NULL COMMENT '角色编号',
  `permission_id` varchar(45) NOT NULL COMMENT '权限编号',
  KEY `fk_role_role_permission` (`role_id`),
  KEY `fk_role_permission_permission` (`permission_id`),
  CONSTRAINT `role_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
  `id_storage` varchar(45) NOT NULL COMMENT '库存表',
  `expiration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '产品有效期',
  `name` varchar(45) DEFAULT NULL COMMENT '材料名称',
  `quantity` varchar(45) DEFAULT NULL COMMENT '库存材料数量',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位',
  `storage_site` varchar(45) DEFAULT NULL COMMENT '储存地点',
  `mode` varchar(45) DEFAULT NULL COMMENT '储存方式',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id_material` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_storage`),
  KEY `fk_storage_user1_idx` (`id_recorder`),
  KEY `fk_storage_user2_idx` (`id_charge`),
  KEY `fk_storage_material1_idx` (`id_material`),
  KEY `storage_storage_unit_dic_id` (`unit`),
  KEY `storage_mode_dic_id` (`mode`),
  CONSTRAINT `storage_mode_dic_id` FOREIGN KEY (`mode`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_storage_material1` FOREIGN KEY (`id_material`) REFERENCES `material` (`id_material`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storage_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storage_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storage_storage_unit_dic_id` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storage
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(45) NOT NULL COMMENT '人员管理表编号',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) DEFAULT NULL COMMENT '登录密码',
  `duty` varchar(45) DEFAULT NULL COMMENT '员工职责',
  `name` varchar(45) DEFAULT NULL COMMENT '员工姓名',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `entry` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '入职时间',
  `sign` varchar(45) DEFAULT NULL COMMENT '入职状态标记:在职1,离职0',
  `turnover` timestamp NULL DEFAULT NULL COMMENT '离职时间',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `phone` varchar(45) DEFAULT NULL COMMENT '人员联系电话',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  KEY `fk_user_has_permission_permission1_idx` (`role_id`),
  KEY `fk_user_has_permission_user1_idx` (`user_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for weather
-- ----------------------------
DROP TABLE IF EXISTS `weather`;
CREATE TABLE `weather` (
  `id` varchar(45) NOT NULL COMMENT '天气记录编号',
  `id_fowlery` varchar(45) DEFAULT NULL COMMENT '禽舍表编号',
  `date` timestamp NULL DEFAULT NULL COMMENT '日期',
  `humidity_in` float DEFAULT NULL COMMENT '室内湿度：单位%',
  `humidity_out` varchar(45) DEFAULT NULL COMMENT '室外湿度:%',
  `co2` float DEFAULT NULL COMMENT '二氧化碳浓度',
  `temperature_out` varchar(45) DEFAULT NULL COMMENT '室外温度:单位摄氏度',
  `temperature_in` float DEFAULT NULL COMMENT '室内温度:单位摄氏度',
  `illuminance` float DEFAULT NULL COMMENT '光照度:单位勒克斯(lx)',
  `h2s` float DEFAULT NULL COMMENT '硫化氢浓度:单位ppm',
  `nh4` float DEFAULT NULL COMMENT '氨气浓度:单位ppm',
  `dust` float DEFAULT NULL COMMENT '粉尘浓度:单位mg/m3',
  `picture` varchar(45) DEFAULT NULL COMMENT '记录点视频图像截图存放位置',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位',
  PRIMARY KEY (`id`),
  KEY `fk_weather_fowlery1_idx` (`id_fowlery`),
  KEY `fk_weather_user1_idx` (`id_recorder`),
  KEY `fk_weather_user2_idx` (`id_charge`),
  KEY `weath_unit_dic_id` (`unit`),
  CONSTRAINT `weath_unit_dic_id` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `weather_ibfk_1` FOREIGN KEY (`id_fowlery`) REFERENCES `fowlery` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `weather_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `weather_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weather
-- ----------------------------
