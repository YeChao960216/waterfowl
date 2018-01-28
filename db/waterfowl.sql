/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : waterfowl

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-01-28 21:20:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `affiliation`
-- ----------------------------
DROP TABLE IF EXISTS `affiliation`;
CREATE TABLE `affiliation` (
  `id` varchar(45) NOT NULL COMMENT '所属大禽舍编号',
  `type` varchar(45) DEFAULT NULL COMMENT '规模',
  `position` varchar(45) DEFAULT NULL COMMENT '方位',
  `size` varchar(45) DEFAULT NULL COMMENT '容纳量',
  `status` varchar(45) DEFAULT '未满员' COMMENT '是否满员',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人',
  `name` varchar(45) NOT NULL COMMENT '大禽舍名称',
  PRIMARY KEY (`id`),
  KEY `FK_affi_dic_type` (`type`),
  KEY `FK_affi_dic_position` (`position`),
  KEY `FK_affi_dic_size` (`size`),
  KEY `FK_affi_dic_status` (`status`),
  KEY `FK_affi_user_record` (`id_record`),
  KEY `FK_affi_user_charge` (`id_charge`),
  KEY `name` (`name`),
  CONSTRAINT `FK_affi_dic_position` FOREIGN KEY (`position`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_affi_dic_type` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_affi_user_charge` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_affi_user_record` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of affiliation
-- ----------------------------
INSERT INTO `affiliation` VALUES ('4C875396D1DB46F1A1693AE695D524DA', '60001', '70001', '300', '满员', null, '3', '6');

-- ----------------------------
-- Table structure for `aquaculture`
-- ----------------------------
DROP TABLE IF EXISTS `aquaculture`;
CREATE TABLE `aquaculture` (
  `id` varchar(45) NOT NULL COMMENT '养殖记录表',
  `name` varchar(45) DEFAULT NULL COMMENT '养殖类型',
  `id_fowlery` varchar(45) DEFAULT NULL COMMENT '禽舍表编号',
  `id_patch` varchar(45) DEFAULT NULL COMMENT '养殖批次',
  `record_date` timestamp NULL DEFAULT NULL COMMENT '记录日期',
  `num_total` int(11) DEFAULT NULL COMMENT '当前个体总数',
  `feed_type` varchar(45) DEFAULT NULL COMMENT '饲料种类',
  `feed_weight` float DEFAULT NULL COMMENT '饲料重量：单位为千克',
  `remark` varchar(200) DEFAULT NULL COMMENT '关联厂商',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id_outstorage` varchar(45) DEFAULT NULL COMMENT '出库编号',
  `status` varchar(45) DEFAULT NULL COMMENT '禽类的阶段标识',
  `weight` float DEFAULT NULL COMMENT '生长重量，单位:kg',
  PRIMARY KEY (`id`),
  KEY `fk_aquaculture_user1_idx` (`id_recorder`),
  KEY `fk_aquaculture_user2_idx` (`id_charge`),
  KEY `fk_aquaculture_fowlery1_idx` (`id_fowlery`),
  KEY `fk_aquaculture_outstorage1_idx` (`id_outstorage`),
  KEY `fk_aquaculture_outstorage1_idx1` (`id_outstorage`),
  KEY `type_dictionary_id` (`name`),
  KEY `status_dictionary_id` (`status`),
  KEY `FK_aqua_patch_id` (`id_patch`),
  CONSTRAINT `FK_aqua_patch_id` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `aquaculture_ibfk_3` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `aquaculture_ibfk_4` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_aquaculture_outstorage1` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `status_dictionary_id` FOREIGN KEY (`status`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aquaculture
-- ----------------------------
INSERT INTO `aquaculture` VALUES ('2D2BA35BB02D410F9C9067ACBDF52292', '3', '606', '75001660620180127', '2018-01-28 13:12:38', '95', '超级水稻', '10', '阿里龙空供应商', '3', '3', null, '30003', '100');
INSERT INTO `aquaculture` VALUES ('7CB3D2DBAEE84E88890D78B4C7BDC4A4', '1', '606', '75001660620180127', '2018-01-27 21:48:25', '100', '超级水稻', '30', '阿里龙空供应商', '3', '3', null, '30002', '80');
INSERT INTO `aquaculture` VALUES ('A59AA061A6FB435C995E2851BE827599', '2', '606', '75001660620180127', '2018-01-27 21:49:02', '100', '超级水稻', '30', '阿里龙空供应商', '3', '3', null, '30002', '81');

-- ----------------------------
-- Table structure for `aqua_stor`
-- ----------------------------
DROP TABLE IF EXISTS `aqua_stor`;
CREATE TABLE `aqua_stor` (
  `id_outstorage` varchar(45) NOT NULL COMMENT '物资编号',
  `id` varchar(45) NOT NULL COMMENT '养殖编号',
  `aid` varchar(45) NOT NULL COMMENT '主键',
  PRIMARY KEY (`aid`),
  KEY `FK_aqua_stor_id` (`id`),
  KEY `FK_out_id` (`id_outstorage`),
  CONSTRAINT `FK_aqua_stor_id` FOREIGN KEY (`id`) REFERENCES `aquaculture` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_out_id` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aqua_stor
-- ----------------------------
INSERT INTO `aqua_stor` VALUES ('6609A0DD4249493981E483C074E8380D', 'A59AA061A6FB435C995E2851BE827599', '014512878AB64CBE9FAD4AA2A89EE88A');
INSERT INTO `aqua_stor` VALUES ('6609A0DD4249493981E483C074E8380D', '2D2BA35BB02D410F9C9067ACBDF52292', '12726465C18D4A29849D3F8981BF7A5F');
INSERT INTO `aqua_stor` VALUES ('6609A0DD4249493981E483C074E8380D', '7CB3D2DBAEE84E88890D78B4C7BDC4A4', '76546968832549D6AE52F7C2A684B5EA');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cid` varchar(45) NOT NULL COMMENT '顾客id',
  `name` varchar(45) DEFAULT NULL COMMENT '顾客姓名',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话号码',
  `license` varchar(200) DEFAULT NULL COMMENT '营业执照',
  `lng` float DEFAULT NULL COMMENT '经度',
  `lat` float DEFAULT NULL COMMENT '纬度',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for `ddl`
-- ----------------------------
DROP TABLE IF EXISTS `ddl`;
CREATE TABLE `ddl` (
  `id` varchar(45) NOT NULL COMMENT '病、死、淘汰记录表编号',
  `id_patch` varchar(45) DEFAULT NULL COMMENT '批次号',
  `record_date` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `num_processed` int(11) DEFAULT NULL COMMENT '需处理个体数量',
  `processing_mode` varchar(45) DEFAULT NULL COMMENT '处理方式',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id`),
  KEY `fk_ddl_poultry1_idx` (`id_patch`),
  KEY `fk_ddl_user1_idx` (`id_recorder`),
  KEY `fk_ddl_user2_idx` (`id_charge`),
  CONSTRAINT `FK_ddl_patch_id` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ddl_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ddl_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ddl
-- ----------------------------
INSERT INTO `ddl` VALUES ('15FA1CA7E2EE468AAB01B2615352BE85', '75001660620180127', '2018-01-27 22:27:50', '1', '95001', '12002', '3', '3');
INSERT INTO `ddl` VALUES ('40F1908059D8423593B40E71C25B441C', '75001660620180127', '2018-01-27 22:28:19', '1', '95002', '12001', '3', '3');
INSERT INTO `ddl` VALUES ('964C6D5E3B934E7FA5C367A7289732F6', '75001660620180127', '2018-01-27 22:27:40', '2', '95002', '12003', '3', '3');
INSERT INTO `ddl` VALUES ('C2B2A4A82B444AB38BE5A3FB61FC5017', '75001660620180127', '2018-01-27 22:27:59', '1', '95001', '12004', '3', '3');

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` varchar(45) NOT NULL COMMENT '导航栏编号',
  `name` varchar(45) DEFAULT NULL COMMENT '栏目名称',
  `pid` varchar(45) DEFAULT NULL COMMENT '上一级导航栏编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('10000', '导航栏', '0', 'navigation');
INSERT INTO `dictionary` VALUES ('10001', '物资管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10002', '禽舍管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10003', '基础信息管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10004', '养殖管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10005', '疫病防治管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10006', '人员管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10007', '字典管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10100', '物资入库管理', '10001', '10000');
INSERT INTO `dictionary` VALUES ('10101', '物资出库管理', '10001', '10000');
INSERT INTO `dictionary` VALUES ('10200', '禽舍管理', '10002', '10000');
INSERT INTO `dictionary` VALUES ('10201', '逻辑禽舍管理', '10002', '10000');
INSERT INTO `dictionary` VALUES ('10202', '批次管理', '10002', '10000');
INSERT INTO `dictionary` VALUES ('10300', '禽类入厂管理', '10002', '10000');
INSERT INTO `dictionary` VALUES ('10301', '禽类出厂管理', '10003', '10000');
INSERT INTO `dictionary` VALUES ('10400', '养殖管理', '10004', '10000');
INSERT INTO `dictionary` VALUES ('10500', '免疫防治管理', '10005', '10000');
INSERT INTO `dictionary` VALUES ('10501', '死淘管理', '10005', '10000');
INSERT INTO `dictionary` VALUES ('10600', '人员管理', '10006', '10000');
INSERT INTO `dictionary` VALUES ('10601', '角色管理', '10006', '10000');
INSERT INTO `dictionary` VALUES ('10602', '人员与角色管理', '10006', '10000');
INSERT INTO `dictionary` VALUES ('10603', '角色与权限管理', '10006', '10000');
INSERT INTO `dictionary` VALUES ('10604', '登陆管理', '10006', '10000');
INSERT INTO `dictionary` VALUES ('10700', '字典管理', '10007', '10000');
INSERT INTO `dictionary` VALUES ('11000', '阶段状态', '0', '');
INSERT INTO `dictionary` VALUES ('12002', '生病死去', '12000', '水水');
INSERT INTO `dictionary` VALUES ('12003', '打斗死去', '12000', '水水完善');
INSERT INTO `dictionary` VALUES ('12004', '饥饿过度', '12000', '水水');
INSERT INTO `dictionary` VALUES ('13000', '禽舍使用状况', '0', '分为可使用和未使用两种状态');
INSERT INTO `dictionary` VALUES ('14000', '剂量单位', '0', '');
INSERT INTO `dictionary` VALUES ('14001', '毫克', '14000', '');
INSERT INTO `dictionary` VALUES ('14002', '克', '14000', '');
INSERT INTO `dictionary` VALUES ('15000', '加工方式', '0', '加工厂的屠宰方式');
INSERT INTO `dictionary` VALUES ('15002', '人工清洗屠宰', '15000', '');
INSERT INTO `dictionary` VALUES ('20000', '国际单位', '0', 'unit');
INSERT INTO `dictionary` VALUES ('20001', '千克', '20000', 'kg');
INSERT INTO `dictionary` VALUES ('20002', '只', '20000', null);
INSERT INTO `dictionary` VALUES ('20003', '瓶', '20000', null);
INSERT INTO `dictionary` VALUES ('25000', '给药方式', '0', null);
INSERT INTO `dictionary` VALUES ('25001', '注射', '25000', null);
INSERT INTO `dictionary` VALUES ('25002', '喂药', '25000', null);
INSERT INTO `dictionary` VALUES ('30000', '溯源阶段', '0', 'status');
INSERT INTO `dictionary` VALUES ('30001', '入厂阶段', '30000', '');
INSERT INTO `dictionary` VALUES ('30002', '养殖阶段', '30000', '');
INSERT INTO `dictionary` VALUES ('30003', '可出厂阶段', '30000', null);
INSERT INTO `dictionary` VALUES ('30004', '已出厂阶段', '30000', null);
INSERT INTO `dictionary` VALUES ('30005', '加工阶段', '30000', '');
INSERT INTO `dictionary` VALUES ('30006', '待运输阶段', '30000', '');
INSERT INTO `dictionary` VALUES ('30007', '运输阶段', '30000', null);
INSERT INTO `dictionary` VALUES ('30008', '完成', '30000', null);
INSERT INTO `dictionary` VALUES ('50000', '权限', '0', null);
INSERT INTO `dictionary` VALUES ('50001', '删除用户', '50000', null);
INSERT INTO `dictionary` VALUES ('50002', '增加用户', '50000', null);
INSERT INTO `dictionary` VALUES ('60000', '规格', '0', 'type');
INSERT INTO `dictionary` VALUES ('60001', '大型', '60000', null);
INSERT INTO `dictionary` VALUES ('60002', '中型', '60000', null);
INSERT INTO `dictionary` VALUES ('60003', '小型', '60000', null);
INSERT INTO `dictionary` VALUES ('65000', '物资类型', '0', null);
INSERT INTO `dictionary` VALUES ('65001', '饲料', '65000', null);
INSERT INTO `dictionary` VALUES ('65002', '卫生消毒用品', '65000', null);
INSERT INTO `dictionary` VALUES ('65003', '免疫医疗用品', '65000', null);
INSERT INTO `dictionary` VALUES ('70000', '方位', '0', 'position');
INSERT INTO `dictionary` VALUES ('70001', '南', '70000', null);
INSERT INTO `dictionary` VALUES ('70002', '北', '70000', null);
INSERT INTO `dictionary` VALUES ('70003', '西', '70000', null);
INSERT INTO `dictionary` VALUES ('70004', '东', '70000', null);
INSERT INTO `dictionary` VALUES ('75000', '厂家名称', '0', 'firm');
INSERT INTO `dictionary` VALUES ('75001', '星系养鸡场', '75000', null);
INSERT INTO `dictionary` VALUES ('75002', '猪猪养鸭场', '75000', null);
INSERT INTO `dictionary` VALUES ('80000', '养殖类型', '0', null);
INSERT INTO `dictionary` VALUES ('80001', '鸡', '80000', null);
INSERT INTO `dictionary` VALUES ('80002', '鸭', '80000', null);
INSERT INTO `dictionary` VALUES ('80003', '鹅', '80000', null);
INSERT INTO `dictionary` VALUES ('85000', '疾病名称', '0', null);
INSERT INTO `dictionary` VALUES ('85001', '流感', '85000', null);
INSERT INTO `dictionary` VALUES ('85002', '发烧', '85000', null);
INSERT INTO `dictionary` VALUES ('85003', '猝死', '85000', null);
INSERT INTO `dictionary` VALUES ('90000', '登陆类型', '0', 'identity_type');
INSERT INTO `dictionary` VALUES ('90001', '微信', '90000', 'wechat');
INSERT INTO `dictionary` VALUES ('95000', '死淘处理方式', '0', null);
INSERT INTO `dictionary` VALUES ('95001', '烧死', '95000', null);
INSERT INTO `dictionary` VALUES ('95002', '合法丢弃', '95000', null);

-- ----------------------------
-- Table structure for `epidemic`
-- ----------------------------
DROP TABLE IF EXISTS `epidemic`;
CREATE TABLE `epidemic` (
  `id_patch` varchar(45) DEFAULT NULL COMMENT '批次编号',
  `name` varchar(45) DEFAULT NULL COMMENT '药品名称',
  `id_outstorage` varchar(45) DEFAULT NULL,
  `record_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date日期',
  `sign` varchar(45) DEFAULT '''有''' COMMENT '免疫、疫病标志',
  `diseaes` varchar(45) DEFAULT NULL COMMENT '疾病',
  `num_infected` int(11) DEFAULT NULL COMMENT '染病个体数',
  `processing_mode` varchar(45) DEFAULT NULL COMMENT '处理方式',
  `medication_mode` varchar(45) DEFAULT NULL COMMENT '给药方式',
  `dose` float DEFAULT NULL COMMENT '剂量',
  `dose_unit` varchar(45) DEFAULT NULL COMMENT '剂量对应单位',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id` varchar(45) NOT NULL COMMENT '疫情记录编号',
  PRIMARY KEY (`id`),
  KEY `fk_epidemic_fowlery1_idx` (`id_patch`),
  KEY `fk_epidemic_user1_idx` (`id_recorder`),
  KEY `fk_epidemic_user2_idx` (`id_charge`),
  KEY `epidemic_unit_dictionary_id` (`dose_unit`),
  KEY `epid_outstorage_id_storage` (`id_outstorage`),
  CONSTRAINT `epid_outstorage_id_storage` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `epidemic_ibfk_2` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `epidemic_ibfk_4` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `epidemic_ibfk_5` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `epidemic_unit_dictionary_id` FOREIGN KEY (`dose_unit`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epidemic
-- ----------------------------
INSERT INTO `epidemic` VALUES ('75001660620180127', '退烧灵', null, null, null, '85002', '95', '', '25001', '1', '14001', '阿里健健供应商', '3', '3', 'CD11458E5B4545E386CCD538B52ECE11');

-- ----------------------------
-- Table structure for `epi_stor`
-- ----------------------------
DROP TABLE IF EXISTS `epi_stor`;
CREATE TABLE `epi_stor` (
  `id_outstorage` varchar(45) NOT NULL COMMENT '物资编号',
  `id` varchar(45) NOT NULL COMMENT '免疫编号',
  `eid` varchar(45) NOT NULL COMMENT '主键',
  PRIMARY KEY (`eid`),
  KEY `FK_epi_outstor_id` (`id`),
  KEY `FK_outstorage_id` (`id_outstorage`),
  CONSTRAINT `FK_epi_outstor_id` FOREIGN KEY (`id`) REFERENCES `epidemic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_outstorage_id` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epi_stor
-- ----------------------------
INSERT INTO `epi_stor` VALUES ('AAADE922FF7148A18429DDADBD14435F', 'CD11458E5B4545E386CCD538B52ECE11', '4FC8A973C6494F318BB8ED13D159113F');

-- ----------------------------
-- Table structure for `fowlery`
-- ----------------------------
DROP TABLE IF EXISTS `fowlery`;
CREATE TABLE `fowlery` (
  `id` varchar(45) NOT NULL COMMENT '禽舍编号',
  `size` varchar(45) DEFAULT NULL COMMENT '容纳量',
  `status` varchar(45) DEFAULT '可使用' COMMENT '使用状态',
  `affiliation` varchar(45) DEFAULT NULL COMMENT '归属的大禽舍',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人',
  `name` varchar(45) DEFAULT NULL COMMENT '禽舍名称',
  PRIMARY KEY (`id`),
  KEY `FK_fowlery_affili_id` (`affiliation`),
  KEY `FK_fowlery_dic_size` (`size`),
  KEY `FK_fowlery_dic_status` (`status`),
  KEY `FK_fowlery_user_charge` (`id_charge`),
  KEY `FK_fowlery_user_record` (`id_record`),
  KEY `name` (`name`),
  CONSTRAINT `FK_fowlery_user_charge` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_fowlery_user_record` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fowlery
-- ----------------------------
INSERT INTO `fowlery` VALUES ('05805E2D4F854608A39B5974EE2F8B2E', '60', '可使用', '6', null, '3', '606');

-- ----------------------------
-- Table structure for `manufacture`
-- ----------------------------
DROP TABLE IF EXISTS `manufacture`;
CREATE TABLE `manufacture` (
  `id` varchar(45) NOT NULL COMMENT '加工编号',
  `firm` varchar(45) DEFAULT NULL COMMENT '加工厂商',
  `site` varchar(45) DEFAULT NULL COMMENT '加工地点',
  `method` varchar(45) DEFAULT NULL COMMENT '加工方式',
  `phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `record_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '加工日期',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '加工负责人',
  `id_patch` varchar(45) DEFAULT NULL COMMENT '加工的批次',
  `quantity` int(45) DEFAULT NULL COMMENT '加工该批次的数量',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_trans_patch` (`id_patch`),
  CONSTRAINT `FK_manu_outpoul_patch` FOREIGN KEY (`id_patch`) REFERENCES `out_poultry` (`id_patch`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manufacture
-- ----------------------------
INSERT INTO `manufacture` VALUES ('DB300C23EF54498DA835051565EA0990', '北京肉联加工厂', '北京中关村', '15001', '13189679384', '2018-01-28 14:47:31', '3', '75001660620180127', '100', '');

-- ----------------------------
-- Table structure for `material`
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id_storage` varchar(45) NOT NULL COMMENT '库存表',
  `date` timestamp NULL DEFAULT NULL COMMENT '进厂时间',
  `name` varchar(45) DEFAULT NULL COMMENT '材料名称',
  `expiration_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '产品有效期——用户填写',
  `associated_firm` varchar(45) DEFAULT NULL COMMENT '关联厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `quantity` float(45,0) DEFAULT NULL COMMENT '库存材料数量',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位——字典查给用户选',
  `storage_site` varchar(45) DEFAULT NULL COMMENT '储存地点',
  `mode` varchar(45) DEFAULT NULL COMMENT '储存方式',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id_storage`),
  KEY `fk_storage_user1_idx` (`id_recorder`),
  KEY `fk_storage_user2_idx` (`id_charge`),
  KEY `storage_storage_unit_dic_id` (`unit`),
  KEY `storage_mode_dic_id` (`mode`),
  CONSTRAINT `material_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `material_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `storage_mode_dic_id` FOREIGN KEY (`mode`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `storage_storage_unit_dic_id` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', '2017-11-19 21:59:11', '84消毒液', '2018-01-13 11:44:23', '叶超养鸡场', '123', '100', '20003', '仲恺709', '2001', '', '1', '1');
INSERT INTO `material` VALUES ('10', '2018-01-10 21:25:48', '84消毒液', '2018-01-13 11:43:52', '叶超养鸡场', '123', '152', '20003', '仲恺709', '2001', null, '1', '1');
INSERT INTO `material` VALUES ('11', '2018-01-13 11:34:44', '808鸡饲料', '2018-01-13 11:44:58', '成君饲料厂', '15818922646', '2000', '20001', '仲恺709', '2002', null, '2', '1');
INSERT INTO `material` VALUES ('12', '2018-01-13 11:37:05', '808鸡饲料', '2018-01-13 11:44:52', '成君饲料厂', '15818922646', '3000', '20001', '仲恺709', '2002', null, '2', '1');
INSERT INTO `material` VALUES ('13', '2018-01-13 11:37:11', '小优223稻谷', '2018-01-13 11:44:52', '曼曼农场', '110', '4000', '20001', '仲恺709', '2002', '', '2', '1');
INSERT INTO `material` VALUES ('14', '2018-01-13 11:37:08', '708鸡饲料', '2018-01-13 11:44:51', '成君饲料厂', '15818922646', '3500', '20001', '仲恺709', '2002', null, '2', '1');
INSERT INTO `material` VALUES ('15', '2018-01-13 11:37:12', '小优223稻谷', '2018-01-13 11:46:16', '曼曼农场', '110', '2900', '20001', '仲恺709', '2002', null, '2', '1');
INSERT INTO `material` VALUES ('16', '2018-01-13 11:56:09', '碘酒', '2018-01-13 11:57:54', '成君杂货店', '15818922646', '100', '20003', '仲恺709', '2001', null, '2', '2');
INSERT INTO `material` VALUES ('17', '2018-01-13 11:56:10', '碘酒', '2018-01-13 11:57:53', '成君杂货店', '15818922646', '100', '20003', '仲恺709', '2001', null, '2', '2');
INSERT INTO `material` VALUES ('18', '2018-01-13 11:56:10', '碘酒', '2018-01-13 11:57:53', '成君杂货店', '15818922646', '100', '20003', '仲恺709', '2001', null, '2', '2');
INSERT INTO `material` VALUES ('19', '2018-01-13 11:56:11', '碘酒', '2018-01-13 11:57:52', '成君杂货店', '15818922646', '120', '20003', '仲恺709', '2001', null, '2', '2');
INSERT INTO `material` VALUES ('2', '2018-01-10 21:25:57', '84消毒液', '2018-01-13 11:46:39', '叶超养鸡场', '123', '200', '20003', '仲恺709', '2001', null, '1', '1');
INSERT INTO `material` VALUES ('20', '2018-01-13 11:56:12', '碘酒', '2018-01-13 11:57:52', '成君杂货店', '15818922646', '130', '20003', '仲恺709', '2001', null, '2', '2');
INSERT INTO `material` VALUES ('3', '2018-01-10 21:25:56', '84消毒液', '2018-01-13 11:46:42', '叶超养鸡场', '123', '152', '20003', '仲恺709', '2001', null, '1', '1');
INSERT INTO `material` VALUES ('4', '2018-01-10 21:25:56', '84消毒液', '2018-01-13 11:43:59', '叶超养鸡场', '123', '55', '20003', '仲恺709', '2001', null, '1', '1');
INSERT INTO `material` VALUES ('5', '2018-01-10 21:25:53', '84消毒液', '2018-01-13 11:44:00', '叶超养鸡场', '123', '196', '20003', '仲恺709', '2001', null, '1', '1');
INSERT INTO `material` VALUES ('6', '2018-01-10 21:25:52', '84消毒液', '2018-01-13 11:44:00', '叶超养鸡场', '123', '250', '20003', '仲恺709', '2001', null, '1', '1');
INSERT INTO `material` VALUES ('7', '2018-01-10 21:25:51', '84消毒液', '2018-01-13 11:44:02', '叶超养鸡场', '123', '311', '20003', '仲恺709', '2001', null, '1', '1');
INSERT INTO `material` VALUES ('8', '2018-01-10 21:25:54', '84消毒液', '2018-01-13 11:44:03', '叶超养鸡场', '123', '138', '20003', '仲恺709', '2001', null, '1', '1');
INSERT INTO `material` VALUES ('9', '2018-01-10 21:25:50', '84消毒液', '2018-01-13 11:44:43', '叶超养鸡场', '123', '115', '20003', '仲恺709', '2001', null, '2', '1');

-- ----------------------------
-- Table structure for `outstorage`
-- ----------------------------
DROP TABLE IF EXISTS `outstorage`;
CREATE TABLE `outstorage` (
  `id_outstorage` varchar(45) NOT NULL COMMENT '物资使用表——自动生成用户不填',
  `name` varchar(45) DEFAULT NULL COMMENT '材料名称——name发送到storage获取库存数据，供用户下拉框选择我',
  `remark` varchar(200) DEFAULT NULL COMMENT '供应商',
  `record_date` timestamp NULL DEFAULT NULL,
  `quantity` float(45,0) DEFAULT NULL COMMENT '入厂总量',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `firm` varchar(45) DEFAULT NULL COMMENT '生产厂家',
  `type` varchar(45) DEFAULT NULL COMMENT '类型',
  `expiration_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '有效期',
  `rest` float(45,0) DEFAULT NULL COMMENT '剩余量',
  `phone` varchar(45) DEFAULT NULL COMMENT '联系方式',
  `valid` varchar(45) DEFAULT '未过期' COMMENT '是否过期',
  `site` varchar(45) DEFAULT NULL COMMENT '备用，暂不填',
  `mode` varchar(45) DEFAULT NULL COMMENT '备用，暂不填',
  `provide` varchar(45) DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`id_outstorage`),
  KEY `fk_storage_user1_idx` (`id_recorder`),
  KEY `fk_storage_user2_idx` (`id_charge`),
  KEY `outst_unit_dic_id` (`unit`),
  KEY `FK_dic_type` (`type`),
  CONSTRAINT `FK_dic_type` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outst_unit_dic_id` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `storage_ibfk_10` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `storage_ibfk_20` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outstorage
-- ----------------------------
INSERT INTO `outstorage` VALUES ('6609A0DD4249493981E483C074E8380D', '超级水稻', '阿里龙龙生产家', '2018-01-22 17:28:30', '200', '20001', '3', null, '阿里龙空供应商', '65001', '2018-01-22 19:28:18', '18', '13189679384', '未过期', null, null, null);
INSERT INTO `outstorage` VALUES ('9CCA41371F0043ABA0CDFEBDF24B4969', '消感一号', '啊里超超制药厂', '2018-01-22 19:38:03', '100', '20003', null, '3', '阿里健健供应商', '65003', '2018-05-30 00:00:00', '97', '13189679384', '未过期', null, null, null);
INSERT INTO `outstorage` VALUES ('AAADE922FF7148A18429DDADBD14435F', '退烧灵', '阿里超超制药厂', '2018-01-22 19:40:32', '10', '20003', null, '3', '阿里健健供应商', '65003', '2018-03-29 00:00:00', '8', '13189679385', '未过期', null, null, null);

-- ----------------------------
-- Table structure for `out_poultry`
-- ----------------------------
DROP TABLE IF EXISTS `out_poultry`;
CREATE TABLE `out_poultry` (
  `id` varchar(45) NOT NULL COMMENT '出厂编号',
  `record_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `quantity` int(11) DEFAULT NULL COMMENT '本批次数量售出数量',
  `id_patch` varchar(45) DEFAULT NULL COMMENT '出厂批次',
  `firm` varchar(45) NOT NULL COMMENT '出厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`),
  KEY `FK_out_poultry_user_charge` (`id_charge`),
  KEY `FK_out_poultry_user_record` (`id_record`),
  KEY `FK_out_aqua_fowlery_id` (`id_patch`),
  CONSTRAINT `FK_out_poul_aqua_patch` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_out_poultry_user_charge` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_out_poultry_user_record` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of out_poultry
-- ----------------------------
INSERT INTO `out_poultry` VALUES ('159B338CD07045438D4245110D77C181', null, '100', '75001660620180127', '北京肉联加工厂', '13189679385', '', '3', '3');

-- ----------------------------
-- Table structure for `patch`
-- ----------------------------
DROP TABLE IF EXISTS `patch`;
CREATE TABLE `patch` (
  `id_poultry` varchar(64) DEFAULT NULL COMMENT '入厂批次',
  `type` varchar(45) DEFAULT NULL COMMENT '类型',
  `position` varchar(45) DEFAULT NULL COMMENT '方位',
  `size` int(45) DEFAULT NULL COMMENT '该批次总数量',
  `id_affilation` varchar(45) DEFAULT NULL COMMENT '所属大禽舍',
  `id_fowlery` varchar(45) DEFAULT NULL COMMENT '禽舍编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  `id` varchar(64) NOT NULL COMMENT '禽舍管理表',
  `num_total` int(11) DEFAULT NULL COMMENT '当前个体总数',
  `status` varchar(45) DEFAULT NULL COMMENT '溯源阶段',
  PRIMARY KEY (`id`),
  KEY `fk_fowlery_user1_idx` (`id_recorder`),
  KEY `fk_fowlery_user2_idx` (`id_charge`),
  KEY `FK_fowlery_dic_id` (`id_fowlery`),
  KEY `FK_fowlery_poultry` (`id_poultry`),
  KEY `FK_patch_affil_id` (`id_affilation`),
  KEY `FK_patch_dic_type` (`type`),
  KEY `FK_patch_dic_position` (`position`),
  KEY `FK_patch_dic_size` (`size`),
  KEY `FK_patch_dic_status` (`status`),
  CONSTRAINT `FK_afflii_name` FOREIGN KEY (`id_affilation`) REFERENCES `affiliation` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_flowlery_name` FOREIGN KEY (`id_fowlery`) REFERENCES `fowlery` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_fowlery_poultry` FOREIGN KEY (`id_poultry`) REFERENCES `poultry` (`id_poultry`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_patch_dic_position` FOREIGN KEY (`position`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_patch_dic_status` FOREIGN KEY (`status`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_patch_dic_type` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patch
-- ----------------------------
INSERT INTO `patch` VALUES ('3D6A0F37608345FC937D7AD3FDFF0D39', '60001', '70001', '95', '6', '606', '3', '3', '2018-01-28 13:20:13', '75001660620180127', '100', '30001');

-- ----------------------------
-- Table structure for `poultry`
-- ----------------------------
DROP TABLE IF EXISTS `poultry`;
CREATE TABLE `poultry` (
  `id_poultry` varchar(45) NOT NULL COMMENT '家禽批次记录表',
  `record_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `type` varchar(45) DEFAULT NULL COMMENT '家禽类型',
  `quantity` varchar(45) DEFAULT NULL COMMENT '本批个体数',
  `unit` varchar(45) DEFAULT '只' COMMENT '计数单位',
  `associated_firm` varchar(45) DEFAULT NULL COMMENT '关联厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '关联厂商电话',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id_poultry`),
  UNIQUE KEY `Id_UNIQUE` (`id_poultry`),
  KEY `fk_material_user1_idx` (`id_recorder`),
  KEY `fk_material_user2_idx` (`id_charge`),
  KEY `poultry_name_dictionary_id` (`type`),
  KEY `FK_poultry_dic_unit` (`unit`),
  KEY `dic_id_firm` (`associated_firm`),
  CONSTRAINT `dic_id_firm` FOREIGN KEY (`associated_firm`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `material_ibfk_20` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `material_ibfk_30` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poultry
-- ----------------------------
INSERT INTO `poultry` VALUES ('3D6A0F37608345FC937D7AD3FDFF0D39', '2018-01-22 21:18:45', '80001', '1000', null, '75001', '13189679385', '', '3', '3');
INSERT INTO `poultry` VALUES ('A1D15C8F04A6428EB76F33602E051ED5', '2018-01-22 16:49:35', '80001', '30', null, '75001', '13189679385', '', '3', '3');

-- ----------------------------
-- Table structure for `role`
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
INSERT INTO `role` VALUES ('1', '游客');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` varchar(45) NOT NULL COMMENT '角色编号',
  `permission_id` varchar(45) NOT NULL COMMENT '权限编号',
  KEY `fk_role_role_permission` (`role_id`),
  KEY `fk_role_permission_permission` (`permission_id`),
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `role_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '50001');
INSERT INTO `role_permission` VALUES ('1', '50002');

-- ----------------------------
-- Table structure for `transcompany`
-- ----------------------------
DROP TABLE IF EXISTS `transcompany`;
CREATE TABLE `transcompany` (
  `tid` varchar(45) NOT NULL COMMENT '运输公司编号',
  `name` varchar(45) DEFAULT NULL COMMENT '运输公司',
  `phone` varchar(45) DEFAULT NULL COMMENT '运输公司联系方式',
  `license` varchar(200) DEFAULT NULL COMMENT '营业执照',
  `address` varchar(45) DEFAULT NULL COMMENT '公司地址',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transcompany
-- ----------------------------

-- ----------------------------
-- Table structure for `transportation`
-- ----------------------------
DROP TABLE IF EXISTS `transportation`;
CREATE TABLE `transportation` (
  `id` varchar(45) NOT NULL COMMENT '运输编号',
  `cid` varchar(45) NOT NULL COMMENT '顾客id',
  `tid` varchar(45) NOT NULL COMMENT '运输公司id',
  `id_patch` varchar(45) NOT NULL COMMENT '批次id',
  `curQuantity` float(11,0) DEFAULT NULL COMMENT '当前数量',
  `curLng` float DEFAULT NULL COMMENT '当前经度',
  `curLat` float DEFAULT NULL COMMENT '当前纬度',
  `curDate` timestamp NULL DEFAULT NULL COMMENT '当前日期',
  `driver` varchar(45) DEFAULT NULL COMMENT '司机姓名',
  `phone` varchar(45) DEFAULT NULL COMMENT '司机联系方式',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_trans_customer_cid` (`cid`),
  KEY `FK_trans_transCompany_tid` (`tid`),
  KEY `FK_trans_outpoul_oid` (`id_patch`),
  CONSTRAINT `FK_trans_customer_cid` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_trans_outpoul_patch` FOREIGN KEY (`id_patch`) REFERENCES `out_poultry` (`id_patch`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_trans_transCompany_tid` FOREIGN KEY (`tid`) REFERENCES `transcompany` (`tid`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transportation
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(45) NOT NULL COMMENT '人员管理表编号',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) DEFAULT NULL COMMENT '登录密码',
  `duty` varchar(45) DEFAULT NULL COMMENT '员工职责',
  `name` varchar(45) DEFAULT NULL COMMENT '员工姓名',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `entry` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '入职时间',
  `sign` varchar(45) DEFAULT NULL COMMENT '入职状态标记:在职1,离职0',
  `turnover` timestamp NULL DEFAULT NULL COMMENT '离职时间',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `phone` varchar(45) DEFAULT NULL COMMENT '人员联系电话',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '叶超', '960216', null, '叶超', null, '2018-01-22 14:19:22', '1', null, null, '15602495106', null);
INSERT INTO `user` VALUES ('2', '钱伟健', '123456', null, '钱伟健', null, '2018-01-22 14:20:25', '1', null, null, '15602495106', null);
INSERT INTO `user` VALUES ('3', 'willon', '0462b55987128695bd4e0fdd3ce62c01', null, 'willon', null, '2018-01-28 14:52:48', '3', null, null, '13189679385', null);

-- ----------------------------
-- Table structure for `user_auths`
-- ----------------------------
DROP TABLE IF EXISTS `user_auths`;
CREATE TABLE `user_auths` (
  `id` varchar(45) NOT NULL DEFAULT '' COMMENT '用户授权信息编号',
  `user_id` varchar(45) NOT NULL COMMENT '对应的用户id',
  `identity_type` varchar(45) DEFAULT NULL COMMENT '登陆类型',
  `identifier` varchar(45) DEFAULT NULL COMMENT '标识',
  `credential` varchar(45) DEFAULT NULL COMMENT '密码凭证',
  PRIMARY KEY (`id`),
  KEY `FK_auths_user_id` (`user_id`),
  KEY `FK_iden_type_dic_id` (`identity_type`),
  CONSTRAINT `FK_auths_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_iden_type_dic_id` FOREIGN KEY (`identity_type`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_auths
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  KEY `fk_user_has_permission_permission1_idx` (`role_id`),
  KEY `fk_user_has_permission_user1_idx` (`user_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `weather`
-- ----------------------------
DROP TABLE IF EXISTS `weather`;
CREATE TABLE `weather` (
  `id` varchar(45) NOT NULL COMMENT '天气记录编号',
  `id_affiliation` varchar(45) DEFAULT NULL COMMENT '禽舍表编号',
  `record_date` timestamp NULL DEFAULT NULL COMMENT '日期',
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
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id`),
  KEY `fk_weather_fowlery1_idx` (`id_affiliation`),
  KEY `fk_weather_user2_idx` (`id_charge`),
  CONSTRAINT `weather_affiliation_id` FOREIGN KEY (`id_affiliation`) REFERENCES `affiliation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `weather_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weather
-- ----------------------------
