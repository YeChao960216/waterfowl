/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : waterfowl

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-01-20 22:18:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `affiliation`
-- ----------------------------
DROP TABLE IF EXISTS `affiliation`;
CREATE TABLE `affiliation` (
  `id` varchar(45) NOT NULL COMMENT '所属大禽舍编号',
  `type` varchar(45) DEFAULT NULL COMMENT '养殖类型',
  `position` varchar(45) DEFAULT NULL COMMENT '方位',
  `size` varchar(45) DEFAULT NULL COMMENT '规格',
  `status` varchar(45) DEFAULT '未满员' COMMENT '是否满员',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`),
  KEY `FK_affi_dic_type` (`type`),
  KEY `FK_affi_dic_position` (`position`),
  KEY `FK_affi_dic_size` (`size`),
  KEY `FK_affi_dic_status` (`status`),
  KEY `FK_affi_user_record` (`id_record`),
  KEY `FK_affi_user_charge` (`id_charge`),
  CONSTRAINT `FK_affi_dic_position` FOREIGN KEY (`position`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_affi_dic_size` FOREIGN KEY (`size`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_affi_dic_type` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_affi_user_charge` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_affi_user_record` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of affiliation
-- ----------------------------
INSERT INTO `affiliation` VALUES ('6', '60001', '70003', null, '未满员', '1', '1');
INSERT INTO `affiliation` VALUES ('7', '60002', '70002', null, '未满员', '1', '1');

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
  CONSTRAINT `aquaculture_ibfk_3` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `aquaculture_ibfk_4` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_aquaculture_outstorage1` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `status_dictionary_id` FOREIGN KEY (`status`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aquaculture
-- ----------------------------
INSERT INTO `aquaculture` VALUES ('0A5B47A5BCBD41DBBE07C503F2C2AD7B', '7', '606', '1116606', '2018-01-19 15:52:32', '20', '808鸡饲料', '10', '伟龙供应商', '6', '7', null, '30011', '43.3');
INSERT INTO `aquaculture` VALUES ('30ED279F8BDE417EAB506CD2CCB3AE87', '1', '606', '96CAE113218941CAA8ACE604D83984A6', null, '200', '小优223稻谷', '100', '伟龙供应商', '7', '7', null, '30011', '190.2');
INSERT INTO `aquaculture` VALUES ('53C7269C10984217B0594DED400EA1AA', '7', '606', '1116606', '2018-01-19 15:53:54', '20', '808鸡饲料', '11', '伟龙供应商', '7', '7', null, '30011', '45.3');
INSERT INTO `aquaculture` VALUES ('666', '1', '606', '1116606', '2018-01-15 17:19:03', '20', '谷物', '10', '', '1', '1', null, null, '23');
INSERT INTO `aquaculture` VALUES ('667', '2', '606', '1116606', '2018-01-15 17:45:50', '20', '谷物', '11', '', '1', '1', null, null, '24');
INSERT INTO `aquaculture` VALUES ('668', '3', '606', '1116606', '2018-01-15 17:47:28', '20', '谷物', '10', '', '1', '1', null, null, '26');
INSERT INTO `aquaculture` VALUES ('669', '4', '606', '1116606', '2018-01-15 17:48:19', '20', '谷物', '14', '', '1', '1', null, null, '28');
INSERT INTO `aquaculture` VALUES ('670', '5', '606', '1116606', '2018-01-15 17:49:21', '20', '谷物', '12', '', '1', '1', null, null, '30.5');
INSERT INTO `aquaculture` VALUES ('671', '6', '606', '1116606', '2018-01-15 17:50:39', '20', '谷物', '13', '', '1', '1', null, null, '33.8');
INSERT INTO `aquaculture` VALUES ('672', '2', '606', '1116606', '2018-01-15 17:51:35', '20', '谷物', '15.7', '没毛病', '1', '1', null, null, '36.7');
INSERT INTO `aquaculture` VALUES ('C749A8B9509347D98A0486E9BC2A6D1A', '2', '608', 'BE97BF7B9F224D2883506C7CC0224F6A', null, '300', '808鸡饲料', '300', '伟龙供应商', '7', '7', null, '30011', '260');
INSERT INTO `aquaculture` VALUES ('CAF270B869C140D0BCFA7C4F89106E58', '1', '608', 'BE97BF7B9F224D2883506C7CC0224F6A', null, '300', '808鸡饲料', '320', '伟龙供应商', null, null, null, '30011', '250');
INSERT INTO `aquaculture` VALUES ('D1A31B93C8024323B86F39E2EAD2AD14', '8', '606', '1116606', '2018-01-20 19:58:55', '18', '稻谷', '3', '阿里龙龙供应商', '7', '7', null, '30011', '39.5');
INSERT INTO `aquaculture` VALUES ('E571729208C14254A873B8711A8F18BD', '3', '608', 'BE97BF7B9F224D2883506C7CC0224F6A', null, '300', '808鸡饲料', '300', '伟龙供应商', '6', '7', null, '30011', '262');
INSERT INTO `aquaculture` VALUES ('F52345BBCDAE457CAF69DEB2673C1389', '1', '606', '96CAE113218941CAA8ACE604D83984A6', null, '200', '小优223稻谷', '80', '伟龙供应商', '7', '7', null, '30011', '180');

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
INSERT INTO `aqua_stor` VALUES ('74A3A97C9AED459DBB04F487971DF44A', 'D1A31B93C8024323B86F39E2EAD2AD14', 'B3EA0D981D95446190AA198512D2B070');

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
  CONSTRAINT `ddl_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ddl_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ddl
-- ----------------------------
INSERT INTO `ddl` VALUES ('4BB45AB521984775B45B55EFDD1D19C9', '96CAE113218941CAA8ACE604D83984A6', '2018-01-19 22:54:34', '1', '95002', '12001', '7', '7');
INSERT INTO `ddl` VALUES ('869C10F795314378BF2797750AEC2061', '1116606', '2018-01-20 13:58:30', '1', '95001', '12003', '7', '7');
INSERT INTO `ddl` VALUES ('C0E95C49DD6B4BFFB0A369A560C6AC0B', '1116606', '2018-01-20 14:21:07', '1', '95002', '12004', '7', '7');
INSERT INTO `ddl` VALUES ('E8B9923EED3F40B3B339C0768347AFBD', '1116606', '2018-01-19 22:28:59', '2', '95001', '12001', '9', '9');
INSERT INTO `ddl` VALUES ('F9ED168FAEE44EF6870B855307F659B4', '96CAE113218941CAA8ACE604D83984A6', '2018-01-19 22:52:27', '1', '95001', '12001', 'D94918840C0F44B2814E0C7CAD660B7E', 'D94918840C0F44B2814E0C7CAD660B7E');

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
INSERT INTO `dictionary` VALUES ('12000', '死亡原因', '0', '我');
INSERT INTO `dictionary` VALUES ('12001', '丢失', '12000', '水水');
INSERT INTO `dictionary` VALUES ('12002', '生病死去', '12000', '水水');
INSERT INTO `dictionary` VALUES ('12003', '打斗死去', '12000', '水水完善');
INSERT INTO `dictionary` VALUES ('12004', '饥饿过度', '12000', '水水');
INSERT INTO `dictionary` VALUES ('13000', '禽舍使用状况', '0', '分为可使用和未使用两种状态');
INSERT INTO `dictionary` VALUES ('13001', '可使用', '13000', '');
INSERT INTO `dictionary` VALUES ('14000', '剂量单位', '0', '');
INSERT INTO `dictionary` VALUES ('14001', '毫克', '14000', '');
INSERT INTO `dictionary` VALUES ('14002', '克', '14000', '');
INSERT INTO `dictionary` VALUES ('20000', '国际单位', '0', 'unit');
INSERT INTO `dictionary` VALUES ('20001', '千克', '20000', 'kg');
INSERT INTO `dictionary` VALUES ('20002', '只', '20000', null);
INSERT INTO `dictionary` VALUES ('20003', '瓶', '20000', null);
INSERT INTO `dictionary` VALUES ('25000', '给药方式', '0', null);
INSERT INTO `dictionary` VALUES ('25001', '注射', '25000', null);
INSERT INTO `dictionary` VALUES ('25002', '喂药', '25000', null);
INSERT INTO `dictionary` VALUES ('30000', '家禽养殖阶段', '0', 'status');
INSERT INTO `dictionary` VALUES ('30011', '小鸡（0~14日龄）', '30000', '');
INSERT INTO `dictionary` VALUES ('30012', '中鸡（15~35日龄）', '30000', null);
INSERT INTO `dictionary` VALUES ('30013', '大鸡（36~出栏）', '30000', null);
INSERT INTO `dictionary` VALUES ('30014', '可出栏', '30000', null);
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
  CONSTRAINT `epidemic_ibfk_4` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `epidemic_ibfk_5` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `epidemic_unit_dictionary_id` FOREIGN KEY (`dose_unit`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epidemic
-- ----------------------------
INSERT INTO `epidemic` VALUES ('1116606', '流感疫苗', null, '2018-01-20 16:53:36', '\'有\'', '85002', '2', null, '25002', '5', '14001', '阿里龙龙供应商', '7', '7', '666');
INSERT INTO `epidemic` VALUES ('1116606', '流感疫苗', null, '2018-02-01 16:55:25', null, '85001', '18', null, '25001', '5', '14001', '阿里龙龙供应商', '7', '7', '6DCF11DE7BC24B9B842D87D26B4945F5');
INSERT INTO `epidemic` VALUES ('1116606', '流感疫苗', null, '2018-01-20 16:54:10', '\'有\'', '85001', '4', null, '25001', '1', '14001', '阿里龙龙供应商', '7', '7', '777');

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
INSERT INTO `epi_stor` VALUES ('6', '6DCF11DE7BC24B9B842D87D26B4945F5', '6B6A466F34134B529A8E062E99CE507E');

-- ----------------------------
-- Table structure for `fowlery`
-- ----------------------------
DROP TABLE IF EXISTS `fowlery`;
CREATE TABLE `fowlery` (
  `id` varchar(45) NOT NULL COMMENT '禽舍编号',
  `size` varchar(45) DEFAULT NULL COMMENT '规格',
  `status` varchar(45) DEFAULT '可使用' COMMENT '使用状态',
  `affiliation` varchar(45) DEFAULT NULL COMMENT '归属的大禽舍',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`),
  KEY `FK_fowlery_affili_id` (`affiliation`),
  KEY `FK_fowlery_dic_size` (`size`),
  KEY `FK_fowlery_dic_status` (`status`),
  KEY `FK_fowlery_user_charge` (`id_charge`),
  KEY `FK_fowlery_user_record` (`id_record`),
  CONSTRAINT `FK_fowlery_affili_id` FOREIGN KEY (`affiliation`) REFERENCES `affiliation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_fowlery_dic_size` FOREIGN KEY (`size`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_fowlery_user_charge` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_fowlery_user_record` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fowlery
-- ----------------------------
INSERT INTO `fowlery` VALUES ('4859C85C81FD4A22BEE9E0E70E886389', '60001', '可使用', '7', '7', '7');
INSERT INTO `fowlery` VALUES ('606', '60001', '可使用', '6', '1', '1');
INSERT INTO `fowlery` VALUES ('608', '60002', '可使用', '6', '1', '1');
INSERT INTO `fowlery` VALUES ('708', '60002', '可使用', '6', '6', '7');

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
  CONSTRAINT `storage_ibfk_10` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `storage_ibfk_20` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outstorage
-- ----------------------------
INSERT INTO `outstorage` VALUES ('6', '流感疫苗', '沃德天病房疾控中心', '2018-01-16 19:01:52', '1000', '20002', '7', '6', '阿里龙龙供应商', '65003', '2018-01-19 21:14:28', '295', '13189679384', '未过期', null, null, null);
INSERT INTO `outstorage` VALUES ('74A3A97C9AED459DBB04F487971DF44A', '稻谷', '阿里旺旺生产商', '2018-01-18 15:11:53', '12', '20001', '7', '7', '阿里龙龙供应商', '65001', '2018-01-19 21:14:41', '7', '13189679384', '未过期', null, null, null);

-- ----------------------------
-- Table structure for `out_poultry`
-- ----------------------------
DROP TABLE IF EXISTS `out_poultry`;
CREATE TABLE `out_poultry` (
  `id` varchar(45) NOT NULL COMMENT '出厂编号',
  `record_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `type` varchar(45) DEFAULT '' COMMENT '类型',
  `quantity` float(11,0) DEFAULT NULL COMMENT '本批次数量售出数量',
  `unit` varchar(45) DEFAULT '只' COMMENT '单位',
  `id_patch` varchar(45) DEFAULT NULL COMMENT '出厂批次',
  `firm` varchar(45) NOT NULL COMMENT '出厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`),
  KEY `FK_out_poul_dic_unit` (`unit`),
  KEY `FK_out_poul_dic_type` (`type`),
  KEY `FK_out_poultry_user_charge` (`id_charge`),
  KEY `FK_out_poultry_user_record` (`id_record`),
  KEY `FK_out_aqua_fowlery_id` (`id_patch`),
  CONSTRAINT `FK_out_poul_aqua_patch` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_out_poul_dic_type` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_out_poul_patch_id` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_out_poultry_user_charge` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_out_poultry_user_record` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of out_poultry
-- ----------------------------

-- ----------------------------
-- Table structure for `patch`
-- ----------------------------
DROP TABLE IF EXISTS `patch`;
CREATE TABLE `patch` (
  `id_poultry` varchar(45) DEFAULT NULL COMMENT '入厂批次',
  `type` varchar(45) DEFAULT NULL COMMENT '类型',
  `position` varchar(45) DEFAULT NULL COMMENT '方位',
  `size` int(45) DEFAULT NULL COMMENT '规格',
  `id_affilation` varchar(45) DEFAULT NULL COMMENT '所属大禽舍',
  `id_fowlery` varchar(45) DEFAULT NULL COMMENT '禽舍编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  `id` varchar(45) NOT NULL COMMENT '禽舍管理表',
  `num_total` int(11) DEFAULT NULL COMMENT '当前个体总数',
  `status` varchar(45) DEFAULT '未售完' COMMENT '是否售完',
  PRIMARY KEY (`id`),
  KEY `fk_fowlery_user1_idx` (`id_recorder`),
  KEY `fk_fowlery_user2_idx` (`id_charge`),
  KEY `FK_fowlery_dic_id` (`id_fowlery`),
  KEY `FK_fowlery_poultry` (`id_poultry`),
  KEY `FK_patch_affil_id` (`id_affilation`),
  KEY `FK_patch_dic_type` (`type`),
  KEY `FK_patch_dic_position` (`position`),
  KEY `FK_patch_dic_size` (`size`),
  CONSTRAINT `FK_fowlery_fowl_id` FOREIGN KEY (`id_fowlery`) REFERENCES `fowlery` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_fowlery_poultry` FOREIGN KEY (`id_poultry`) REFERENCES `poultry` (`id_poultry`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_patch_dic_position` FOREIGN KEY (`position`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_patch_dic_type` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patch
-- ----------------------------
INSERT INTO `patch` VALUES (null, null, null, null, null, null, null, null, '2018-01-18 20:22:37', '080086A26BA546A490DBB0571208DC98', '2', null);
INSERT INTO `patch` VALUES ('111', '80001', '70001', '18', '6', '606', '1', '1', '2018-01-18 20:22:53', '1116606', '20', '未售完');
INSERT INTO `patch` VALUES ('111', '60001', '70003', '30', '6', '708', '7', '7', '2018-01-20 19:42:52', '95ECE5DE10D9438C85A55CA208918F4E', null, '养殖中');
INSERT INTO `patch` VALUES ('123', '60001', '70003', '41', '6', '606', '7', '7', '2018-01-18 20:22:30', '96CAE113218941CAA8ACE604D83984A6', '43', '养殖中');
INSERT INTO `patch` VALUES ('123', '60001', '70003', '300', '6', '608', '7', '7', '2018-01-18 20:22:45', 'BE97BF7B9F224D2883506C7CC0224F6A', '424', '养殖中');

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
  CONSTRAINT `material_ibfk_20` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `material_ibfk_30` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poultry
-- ----------------------------
INSERT INTO `poultry` VALUES ('1', '2018-01-15 16:43:28', '0', '1', '只', '75002', '123', '', '1', '1');
INSERT INTO `poultry` VALUES ('111', '2018-01-15 16:43:54', '80001', '300', '只', '75002', '13189679384', '测试', '1', '1');
INSERT INTO `poultry` VALUES ('123', '2018-01-15 16:44:18', '80001', '500', '只', '75001', '13189679386', '测试', '1', '1');

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
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '50001');
INSERT INTO `role_permission` VALUES ('1', '50002');

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
INSERT INTO `user` VALUES ('1', '叶超', '123', '这个用户是仅供测试的', '这是定时手动生成的用户', '1', '2018-01-10 22:54:06', '1', '2017-11-17 23:34:42', null, '1110', null);
INSERT INTO `user` VALUES ('10', '文智', '123', '这个用户是仅供测试的', '这是定时手动生成的用户', '1', '2018-01-10 22:54:06', '1', '2018-01-10 21:59:50', null, '112', null);
INSERT INTO `user` VALUES ('2', '成君', '123', '这个用户是仅供测试的', '这是定时自动生成的用户', '1', '2018-01-10 22:54:55', '1', '2018-01-10 21:59:52', null, '123', '943193747@qq.com');
INSERT INTO `user` VALUES ('2245C322A39C422B9DE4B3454423059F', 'Sat Jan 20 16:00:00 CST 2018', '123456', '这个用户是仅供测试的', '这是定时自动生成的用户', null, '2018-01-20 16:00:00', null, null, null, null, null);
INSERT INTO `user` VALUES ('3', '锦曼', '123', '这个用户是仅供测试的', '这是定时手动生成的用户', '1', '2018-01-10 22:54:06', '1', '2018-01-10 21:59:53', null, '123', null);
INSERT INTO `user` VALUES ('4', '展佳', '123', '这个用户是仅供测试的', '这是定时手动生成的用户', '1', '2018-01-10 22:54:07', '1', '2018-01-10 21:59:54', null, '123', null);
INSERT INTO `user` VALUES ('4886A67E192344C8BE5F06E9A51310A0', 'Tue Jan 16 16:00:00 CST 2018', '123456', '这个用户是仅供测试的', '这是定时自动生成的用户', null, '2018-01-16 16:00:00', null, null, null, null, null);
INSERT INTO `user` VALUES ('4B576A4661C94FC797D9CE4386CC199A', 'Wed Jan 17 16:00:00 CST 2018', '123456', '这个用户是仅供测试的', '这是定时自动生成的用户', null, '2018-01-17 16:00:00', null, null, null, null, null);
INSERT INTO `user` VALUES ('5', '瀚清', '123', '这个用户是仅供测试的', '这是定时手动生成的用户', '1', '2018-01-10 22:54:21', '1', '2018-01-10 21:59:54', null, '120', null);
INSERT INTO `user` VALUES ('6', '伟龙', '0462b55987128695bd4e0fdd3ce62c01', '这个用户是仅供测试的', 'willon', '1', '2018-01-16 14:10:02', '1', '2018-01-10 21:59:55', null, '13189679384', null);
INSERT INTO `user` VALUES ('7', '伟佳', '8ee1ae4e81a6355693cbd2d36562d69e', '这个用户是仅供测试的', 'willon', '2', '2018-01-18 15:43:32', '1', '2018-01-10 21:59:56', '', '13189679385', null);
INSERT INTO `user` VALUES ('8', '伟健', '123', '这个用户是仅供测试的', '这是定时手动生成的用户', '1', '2018-01-10 22:54:08', '1', '2018-01-10 21:59:58', null, '123', null);
INSERT INTO `user` VALUES ('9', '文浩', '123', '这个用户是仅供测试的', '这是定时手动生成的用户', '1', '2018-01-17 23:33:32', '2', '2018-01-10 22:00:00', null, '123', null);
INSERT INTO `user` VALUES ('D454B9E7D73B460894BC2DD2EA3BF11C', 'Thu Jan 18 16:00:00 CST 2018', '123456', '这个用户是仅供测试的', '这是定时自动生成的用户', null, '2018-01-18 16:00:00', null, null, null, null, null);
INSERT INTO `user` VALUES ('D94918840C0F44B2814E0C7CAD660B7E', 'Fri Jan 19 16:00:00 CST 2018', '123456', '这个用户是仅供测试的', '这是定时自动生成的用户', null, '2018-01-19 16:00:00', null, null, null, null, null);

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
  CONSTRAINT `FK_auths_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_iden_type_dic_id` FOREIGN KEY (`identity_type`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  CONSTRAINT `weather_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weather
-- ----------------------------
