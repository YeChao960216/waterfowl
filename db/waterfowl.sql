/*
Navicat MySQL Data Transfer

Source Server         : waterfowl
Source Server Version : 50720
Source Host           : 120.77.250.250:3306
Source Database       : waterfowl

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-08 10:16:57
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
INSERT INTO `affiliation` VALUES ('10B8592A01F444C2A52790D6E8638268', '60001', '70003', '3000', '满员', '3', '3', '6');
INSERT INTO `affiliation` VALUES ('28DF263771784266B17279FD3B13BB3E', '60001', '70002', '1000', '满员', '3', '3', '7');
INSERT INTO `affiliation` VALUES ('4C875396D1DB46F1A1693AE695D524DA', '60001', '70001', '300', '满员', null, '3', '6');
INSERT INTO `affiliation` VALUES ('516A0FF55E7D422D95B5395989FBF82C', '60001', '70004', '2000', '满员', '3', '3', 'E101');

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
INSERT INTO `aqua_stor` VALUES ('D4AAF056FD2B4EE6AE2FF3E2C012EDAD', '52435C3858EE4EC0B125A4A45F873468', '19508C3D6A9F4C48BE277C00E17A1D39');
INSERT INTO `aqua_stor` VALUES ('D4AAF056FD2B4EE6AE2FF3E2C012EDAD', '0C74B5C1673140C18DA78DAA921F1300', '2FE00BAD0ED2439BAE2B1699644FAED7');
INSERT INTO `aqua_stor` VALUES ('D4AAF056FD2B4EE6AE2FF3E2C012EDAD', 'FA4C6C56D72C4979B4E0245D5DAB71F9', '59B43737EC5C4E43AC22370647B573A2');
INSERT INTO `aqua_stor` VALUES ('D4AAF056FD2B4EE6AE2FF3E2C012EDAD', '43090DAE422F4FC788793D1C9E9FC99D', '5A4DDFEB4A8243D4934828C9F7D16A92');
INSERT INTO `aqua_stor` VALUES ('D4AAF056FD2B4EE6AE2FF3E2C012EDAD', 'C6C05AFB444243A0BA5B214F1B02FC14', '5B854E1E9BAE41F695BA551D0EDDBF4E');
INSERT INTO `aqua_stor` VALUES ('D4AAF056FD2B4EE6AE2FF3E2C012EDAD', '6F5A4607FB044294A9AC087DCF5266E6', '94B5C70660F54B708EC84379CEF1A027');
INSERT INTO `aqua_stor` VALUES ('D4AAF056FD2B4EE6AE2FF3E2C012EDAD', '918D42F55CC5489695162BC9C1FB90B1', 'A3AD41CD68AD48D5B5644D3B3AE0B6FA');

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
INSERT INTO `aquaculture` VALUES ('0C74B5C1673140C18DA78DAA921F1300', '6', '707', '75002770720180207', '2018-02-07 20:06:19', '15', '稻谷', '10', '阿里健健供应商', '3', '3', null, '30002', '22');
INSERT INTO `aquaculture` VALUES ('0F8696A796894FF380D6725E02C74731', '1', '707', '75002770720180207', '2018-02-07 19:56:09', '20', '稻谷', '10', '阿里健健供应商', '3', '3', null, '30002', '10');
INSERT INTO `aquaculture` VALUES ('20E9F000DA924033A1389336FEB33E0A', '2', '707', '75002770720180207', '2018-02-07 19:56:28', '20', '稻谷', '11', '阿里健健供应商', '3', '3', null, '30002', '10.8');
INSERT INTO `aquaculture` VALUES ('43090DAE422F4FC788793D1C9E9FC99D', '8', '707', '75002770720180207', '2018-02-07 20:07:14', '15', '稻谷', '15', '阿里健健供应商', '3', '3', null, '30002', '28');
INSERT INTO `aquaculture` VALUES ('4F0D643295874A7A924C450B0853F015', '3', '707', '75002770720180207', '2018-02-07 19:56:54', '20', '稻谷', '11', '阿里健健供应商', '3', '3', null, '30002', '12');
INSERT INTO `aquaculture` VALUES ('52435C3858EE4EC0B125A4A45F873468', '7', '707', '75002770720180207', '2018-02-07 20:06:39', '15', '稻谷', '17', '阿里健健供应商', '3', '3', null, '30002', '25');
INSERT INTO `aquaculture` VALUES ('6F5A4607FB044294A9AC087DCF5266E6', '10', '707', '75002770720180207', '2018-02-07 20:08:08', '15', '稻谷', '10', '阿里健健供应商', '3', '3', null, '30002', '32');
INSERT INTO `aquaculture` VALUES ('855D309A6A05477AA60004D293DFE76C', '3', '100', '75002710020180203', '2018-02-03 21:17:33', '10', '超级水稻', '0', '阿里龙空供应商', '3', '3', null, '30003', '6');
INSERT INTO `aquaculture` VALUES ('87622C53068C4159B98C84ED046A7A5C', '4', '707', '75002770720180207', '2018-02-07 19:57:17', '20', '稻谷', '13', '阿里健健供应商', '3', '3', null, '30002', '15');
INSERT INTO `aquaculture` VALUES ('918D42F55CC5489695162BC9C1FB90B1', '11', '707', '75002770720180207', '2018-02-07 20:12:54', '15', '稻谷', '0', '阿里健健供应商', '3', '3', null, '30003', '33');
INSERT INTO `aquaculture` VALUES ('B7660B5DA64944FBABBB9A3E72ECEF7A', '5', '606', '75002660620180203', '2018-02-03 16:24:26', '47', '超级水稻', '0', '阿里龙空供应商', '3', '3', null, '30003', '36');
INSERT INTO `aquaculture` VALUES ('BE8F5BE9DBB544E89AC07B0DE968E840', '5', '707', '75002770720180207', '2018-02-07 19:58:03', '20', '稻谷', '18', '阿里健健供应商', '3', '3', null, '30002', '20');
INSERT INTO `aquaculture` VALUES ('C6C05AFB444243A0BA5B214F1B02FC14', '12', '707', '75002770720180207', '2018-02-07 20:15:43', '15', '稻谷', '0', '阿里健健供应商', '3', '3', null, '30003', '35');
INSERT INTO `aquaculture` VALUES ('D028914124DE44E3A0E67E9C5D808836', '5', '707', '75002770720180207', '2018-02-07 19:57:43', '20', '稻谷', '14', '阿里健健供应商', '3', '3', null, '30002', '17');
INSERT INTO `aquaculture` VALUES ('DBD17D254F054BFC8523B8E3839718B8', '1', '606', '75002E10160620180203', '2018-02-03 21:42:04', '30', '超级水稻', '0', '阿里龙空供应商', '3', '3', null, '30003', '25');
INSERT INTO `aquaculture` VALUES ('FA4C6C56D72C4979B4E0245D5DAB71F9', '9', '707', '75002770720180207', '2018-02-07 20:07:45', '15', '稻谷', '18', '阿里健健供应商', '3', '3', null, '30002', '30');

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
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` varchar(45) NOT NULL COMMENT '导航栏编号',
  `name` varchar(45) DEFAULT NULL COMMENT '栏目名称',
  `pid` varchar(45) NOT NULL COMMENT '上一级导航栏编号',
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
INSERT INTO `dictionary` VALUES ('30005', '在本厂待加工阶段', '30000', null);
INSERT INTO `dictionary` VALUES ('30006', '加工阶段', '30000', '');
INSERT INTO `dictionary` VALUES ('30007', '待运输阶段', '30000', '');
INSERT INTO `dictionary` VALUES ('30008', '运输阶段', '30000', null);
INSERT INTO `dictionary` VALUES ('30009', '待运输待加工', '30000', '出库后正常要他马上填一张运输表的但是如果他中途取消不填就是这个状态');
INSERT INTO `dictionary` VALUES ('30010', '在运输待加工', '30000', '出库后送去其他加工公司');
INSERT INTO `dictionary` VALUES ('30011', '已运输加工中', '30000', '到了加工厂加工中');
INSERT INTO `dictionary` VALUES ('30012', '已运输已加工', '30000', '到了加工厂加工完');
INSERT INTO `dictionary` VALUES ('30013', '已全部出厂', '30000', null);
INSERT INTO `dictionary` VALUES ('30014', '完成', '30000', null);
INSERT INTO `dictionary` VALUES ('50000', '权限', '0', null);
INSERT INTO `dictionary` VALUES ('50001', '删除用户', '50000', null);
INSERT INTO `dictionary` VALUES ('50002', '增加用户', '50000', null);
INSERT INTO `dictionary` VALUES ('60000', '规格', '0', 'type');
INSERT INTO `dictionary` VALUES ('60001', '大型', '60000', null);
INSERT INTO `dictionary` VALUES ('60002', '中型', '60000', null);
INSERT INTO `dictionary` VALUES ('60003', '小型', '60000', null);
INSERT INTO `dictionary` VALUES ('65000', '物资类型', '0', null);
INSERT INTO `dictionary` VALUES ('70000', '方位', '0', 'position');
INSERT INTO `dictionary` VALUES ('70001', '南', '70000', null);
INSERT INTO `dictionary` VALUES ('70002', '北', '70000', null);
INSERT INTO `dictionary` VALUES ('70003', '西', '70000', null);
INSERT INTO `dictionary` VALUES ('70004', '东', '70000', null);
INSERT INTO `dictionary` VALUES ('75000', '厂家名称', '0', 'firm');
INSERT INTO `dictionary` VALUES ('75002', '猪猪养鸭场', '75000', null);
INSERT INTO `dictionary` VALUES ('80000', '养殖类型', '0', null);
INSERT INTO `dictionary` VALUES ('80002', '鸭', '80000', null);
INSERT INTO `dictionary` VALUES ('80003', '鹅', '80000', null);
INSERT INTO `dictionary` VALUES ('85000', '疾病名称', '0', null);
INSERT INTO `dictionary` VALUES ('85001', '流感', '85000', null);
INSERT INTO `dictionary` VALUES ('85002', '发烧', '85000', null);
INSERT INTO `dictionary` VALUES ('85003', '猝死', '85000', null);
INSERT INTO `dictionary` VALUES ('90000', '登陆类型', '0', 'identity_type');

-- ----------------------------
-- Table structure for `epi_stor`
-- ----------------------------
DROP TABLE IF EXISTS `epi_stor`;
CREATE TABLE `epi_stor` (
  `id_outstorage` varchar(45) NOT NULL COMMENT '物资编号',
  `id` varchar(45) NOT NULL COMMENT '免疫编号',
  `eid` varchar(45) NOT NULL COMMENT '主键',
  PRIMARY KEY (`eid`),
  KEY `FK_epi_outstor_id` (`id`) USING BTREE,
  KEY `FK_outstorage_id` (`id_outstorage`) USING BTREE,
  CONSTRAINT `epi_stor_ibfk_1` FOREIGN KEY (`id`) REFERENCES `epidemic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `epi_stor_ibfk_2` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epi_stor
-- ----------------------------
INSERT INTO `epi_stor` VALUES ('AAADE922FF7148A18429DDADBD14435F', '7B7DE08D345B4D8CAE56660714D9B8C6', '2D6E594BC2BC4297B46DBEFA758F6D8D');
INSERT INTO `epi_stor` VALUES ('9CCA41371F0043ABA0CDFEBDF24B4969', '245F9368504E490DAB11406CDAA2BA73', '7357E1A738404DF9BBBE498E3D0FDD39');

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
  KEY `fk_epidemic_fowlery1_idx` (`id_patch`) USING BTREE,
  KEY `fk_epidemic_user1_idx` (`id_recorder`) USING BTREE,
  KEY `fk_epidemic_user2_idx` (`id_charge`) USING BTREE,
  KEY `epidemic_unit_dictionary_id` (`dose_unit`) USING BTREE,
  KEY `epid_outstorage_id_storage` (`id_outstorage`) USING BTREE,
  CONSTRAINT `epidemic_ibfk_1` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `epidemic_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `epidemic_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `epidemic_ibfk_4` FOREIGN KEY (`dose_unit`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `epidemic_ibfk_5` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of epidemic
-- ----------------------------
INSERT INTO `epidemic` VALUES ('75002770720180207', '消感一号', null, null, null, '85001', '15', '', '25001', '1', '14001', '阿里健健供应商', '3', '3', '245F9368504E490DAB11406CDAA2BA73');
INSERT INTO `epidemic` VALUES ('75002770720180207', '退烧灵', null, null, null, '85002', '15', '', '25001', '2', '14002', '阿里健健供应商', '3', '3', '7B7DE08D345B4D8CAE56660714D9B8C6');

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
  KEY `FK_fowlery_affili_id` (`affiliation`) USING BTREE,
  KEY `FK_fowlery_dic_size` (`size`) USING BTREE,
  KEY `FK_fowlery_dic_status` (`status`) USING BTREE,
  KEY `FK_fowlery_user_charge` (`id_charge`) USING BTREE,
  KEY `FK_fowlery_user_record` (`id_record`) USING BTREE,
  KEY `name` (`name`) USING BTREE,
  CONSTRAINT `fowlery_ibfk_1` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fowlery_ibfk_2` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fowlery
-- ----------------------------
INSERT INTO `fowlery` VALUES ('05805E2D4F854608A39B5974EE2F8B2E', '60', '可使用', '6', null, '3', '606');
INSERT INTO `fowlery` VALUES ('4F145F938A3C47428F8AD5C3C2B79CA5', '300', '可使用', '7', '3', '3', '100');
INSERT INTO `fowlery` VALUES ('B072D75A112C4914AB73857335D7CC23', '300', '可使用', 'E101', '3', '3', '606');

-- ----------------------------
-- Table structure for `germchit`
-- ----------------------------
DROP TABLE IF EXISTS `germchit`;
CREATE TABLE `germchit` (
  `id` varchar(45) NOT NULL COMMENT '种苗溯源编号',
  `incubation_date` timestamp NULL DEFAULT NULL COMMENT '种蛋上孵日期',
  `collect_date` timestamp NULL DEFAULT NULL COMMENT '种蛋收集日期',
  `incubation_plant` varchar(45) DEFAULT NULL COMMENT '孵化场编号',
  `incubator` varchar(45) DEFAULT NULL COMMENT '孵化器编号',
  `chick_discharger` varchar(45) DEFAULT NULL COMMENT '出雏器编号',
  `id_breeding` varchar(45) DEFAULT NULL COMMENT '种鸡溯源码',
  `num_total` int(11) DEFAULT NULL COMMENT '当前个体总数',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of germchit
-- ----------------------------
INSERT INTO `germchit` VALUES ('8888666D59178e8405df43b4a08ee60436f79543', '2018-01-03 00:00:00', '2018-01-15 00:00:00', '75002', '606', '606606', '8888666', '300', null, '3');

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
  `record_date` timestamp NULL DEFAULT NULL COMMENT '加工日期',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '加工负责人',
  `id_patch` varchar(45) DEFAULT NULL COMMENT '加工的批次',
  `quantity` int(45) DEFAULT NULL COMMENT '加工该批次的数量',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_trans_patch` (`id_patch`) USING BTREE,
  CONSTRAINT `manufacture_ibfk_1` FOREIGN KEY (`id_patch`) REFERENCES `out_poultry` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manufacture
-- ----------------------------
INSERT INTO `manufacture` VALUES ('A056DD184A6D4F0293EC37570A23BFC2', 'AD5267D98F634C0EB438FC054E6C9CE4', '广州市海珠区仲恺农业工程学院海珠校区', '15002', null, '2018-02-03 21:37:56', '3', '50C5D82957474C4DB59EE1A7056B2CD2', '10', '');

-- ----------------------------
-- Table structure for `material`
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id_storage` varchar(45) NOT NULL COMMENT '库存表',
  `date` timestamp NULL DEFAULT NULL COMMENT '进厂时间',
  `name` varchar(45) DEFAULT NULL COMMENT '材料名称',
  `expiration_date` timestamp NULL DEFAULT NULL COMMENT '产品有效期——用户填写',
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
  KEY `fk_storage_user1_idx` (`id_recorder`) USING BTREE,
  KEY `fk_storage_user2_idx` (`id_charge`) USING BTREE,
  KEY `storage_storage_unit_dic_id` (`unit`) USING BTREE,
  KEY `storage_mode_dic_id` (`mode`) USING BTREE,
  CONSTRAINT `material_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `material_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `material_ibfk_3` FOREIGN KEY (`mode`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `material_ibfk_4` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', '2017-11-19 21:59:11', '84消毒液', '2018-01-13 11:44:23', '叶超养鸡场', '123', '100', '20003', '仲恺709', '2001', '', '1', '1');
INSERT INTO `material` VALUES ('10', '2018-01-10 21:25:48', '84消毒液', '2018-01-13 11:43:52', '叶超养鸡场', '123', '152', '20003', '仲恺709', '2001', null, '1', '1');
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
-- Table structure for `out_poultry`
-- ----------------------------
DROP TABLE IF EXISTS `out_poultry`;
CREATE TABLE `out_poultry` (
  `id` varchar(45) NOT NULL COMMENT '出厂编号',
  `record_date` timestamp NULL DEFAULT NULL COMMENT '记录日期',
  `quantity` int(11) DEFAULT NULL COMMENT '本批次数量售出数量',
  `id_patch` varchar(45) DEFAULT NULL COMMENT '出厂批次',
  `firm` varchar(45) NOT NULL COMMENT '出厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人',
  `next_process` varchar(45) NOT NULL COMMENT '下一环节',
  `status` varchar(45) DEFAULT NULL COMMENT '当前状态',
  PRIMARY KEY (`id`),
  KEY `FK_out_poultry_user_charge` (`id_charge`) USING BTREE,
  KEY `FK_out_poultry_user_record` (`id_record`) USING BTREE,
  KEY `FK_out_aqua_fowlery_id` (`id_patch`) USING BTREE,
  KEY `FK_status_dic_id` (`status`) USING BTREE,
  CONSTRAINT `out_poultry_ibfk_1` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `out_poultry_ibfk_2` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `out_poultry_ibfk_3` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `out_poultry_ibfk_4` FOREIGN KEY (`status`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of out_poultry
-- ----------------------------
INSERT INTO `out_poultry` VALUES ('50C5D82957474C4DB59EE1A7056B2CD2', null, '10', '75002710020180203', 'AD5267D98F634C0EB438FC054E6C9CE4', null, '', '3', '3', '16001', '30005');
INSERT INTO `out_poultry` VALUES ('55408680E0DE4C49982F9C875273D7B6', '2018-02-03 21:22:10', '47', '75002660620180203', 'AD5267D98F634C0EB438FC054E6C9CE4', null, '', '3', '3', '16001', '30005');
INSERT INTO `out_poultry` VALUES ('FF8ACA43974743AA879D128FF43E8B5E', '2018-02-04 20:08:51', '30', '75002E10160620180203', 'AD5267D98F634C0EB438FC054E6C9CE4', null, '', '3', '3', '16003', '30008');

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
  KEY `fk_storage_user1_idx` (`id_recorder`) USING BTREE,
  KEY `fk_storage_user2_idx` (`id_charge`) USING BTREE,
  KEY `outst_unit_dic_id` (`unit`) USING BTREE,
  KEY `FK_dic_type` (`type`) USING BTREE,
  CONSTRAINT `outstorage_ibfk_1` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outstorage_ibfk_2` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `outstorage_ibfk_3` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `outstorage_ibfk_4` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outstorage
-- ----------------------------
INSERT INTO `outstorage` VALUES ('9CCA41371F0043ABA0CDFEBDF24B4969', '消感一号', '啊里超超制药厂', '2018-01-22 19:38:03', '100', '20003', null, '3', '阿里健健供应商', '65003', '2018-05-30 00:00:00', '94', '13189679384', '未过期', null, null, null);
INSERT INTO `outstorage` VALUES ('AAADE922FF7148A18429DDADBD14435F', '退烧灵', '阿里超超制药厂', '2018-01-22 19:40:32', '10', '20003', null, '3', '阿里健健供应商', '65003', '2018-03-29 00:00:00', '6', '13189679385', '未过期', null, null, null);
INSERT INTO `outstorage` VALUES ('D4AAF056FD2B4EE6AE2FF3E2C012EDAD', '稻谷', '阿里旺旺集团', '2018-02-07 20:06:00', '1000', '20001', '3', '3', '阿里健健供应商', '65001', '2018-02-07 00:00:00', '930', '13189679384', '未过期', null, null, null);

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
  KEY `fk_fowlery_user1_idx` (`id_recorder`) USING BTREE,
  KEY `fk_fowlery_user2_idx` (`id_charge`) USING BTREE,
  KEY `FK_fowlery_dic_id` (`id_fowlery`) USING BTREE,
  KEY `FK_fowlery_poultry` (`id_poultry`) USING BTREE,
  KEY `FK_patch_affil_id` (`id_affilation`) USING BTREE,
  KEY `FK_patch_dic_type` (`type`) USING BTREE,
  KEY `FK_patch_dic_position` (`position`) USING BTREE,
  KEY `FK_patch_dic_size` (`size`) USING BTREE,
  KEY `FK_patch_dic_status` (`status`) USING BTREE,
  CONSTRAINT `patch_ibfk_1` FOREIGN KEY (`id_affilation`) REFERENCES `affiliation` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_2` FOREIGN KEY (`id_fowlery`) REFERENCES `fowlery` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_3` FOREIGN KEY (`id_poultry`) REFERENCES `poultry` (`id_poultry`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_4` FOREIGN KEY (`position`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_5` FOREIGN KEY (`status`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_6` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_7` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `patch_ibfk_8` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patch
-- ----------------------------
INSERT INTO `patch` VALUES ('5F2D4327D2A44632869538B0BDB4A1DB', '60001', '70001', '0', '6', '606', '3', '3', '2018-02-03 20:36:34', '75002660620180203', '50', '30013');
INSERT INTO `patch` VALUES ('5F2D4327D2A44632869538B0BDB4A1DB', '60001', '70002', '0', '7', '100', '3', '3', '2018-02-03 21:34:13', '75002710020180203', '10', '30013');
INSERT INTO `patch` VALUES ('5F2D4327D2A44632869538B0BDB4A1DB', '60001', '70004', '0', 'E101', '606', '3', '3', '2018-02-03 22:44:21', '75002E10160620180203', '30', '30013');

-- ----------------------------
-- Table structure for `poultry`
-- ----------------------------
DROP TABLE IF EXISTS `poultry`;
CREATE TABLE `poultry` (
  `id_poultry` varchar(45) NOT NULL COMMENT '家禽批次记录表',
  `record_date` timestamp NULL DEFAULT NULL COMMENT '记录日期',
  `type` varchar(45) DEFAULT NULL COMMENT '家禽类型',
  `quantity` varchar(45) DEFAULT NULL COMMENT '本批个体数',
  `unit` varchar(45) DEFAULT '只' COMMENT '计数单位',
  `associated_firm` varchar(45) DEFAULT NULL COMMENT '关联厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '关联厂商电话',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id_germchit` varchar(45) DEFAULT NULL COMMENT '种苗溯源编号',
  PRIMARY KEY (`id_poultry`),
  UNIQUE KEY `Id_UNIQUE` (`id_poultry`) USING BTREE,
  KEY `fk_material_user1_idx` (`id_recorder`) USING BTREE,
  KEY `fk_material_user2_idx` (`id_charge`) USING BTREE,
  KEY `poultry_name_dictionary_id` (`type`) USING BTREE,
  KEY `FK_poultry_dic_unit` (`unit`) USING BTREE,
  KEY `dic_id_firm` (`associated_firm`) USING BTREE,
  KEY `germchit_id` (`id_germchit`) USING BTREE,
  CONSTRAINT `poultry_ibfk_1` FOREIGN KEY (`associated_firm`) REFERENCES `dictionary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `poultry_ibfk_2` FOREIGN KEY (`id_germchit`) REFERENCES `germchit` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `poultry_ibfk_3` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `poultry_ibfk_4` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poultry
-- ----------------------------
INSERT INTO `poultry` VALUES ('5F2D4327D2A44632869538B0BDB4A1DB', '2018-02-03 16:20:44', '80001', '300', null, '75002', '13189679384', '', '3', '3', '8888666D59178e8405df43b4a08ee60436f79543');
INSERT INTO `poultry` VALUES ('E496C6DC47D44316BD9D3EFB1069E335', '2018-02-07 19:22:44', '80003', '300', null, '75002', '13189679384', '', '3', '3', '8888666Dd377b5957b034725b1db54c2f71ec055');

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
  `type` varchar(45) DEFAULT NULL COMMENT '公司类型',
  `lng` float NOT NULL COMMENT '经度',
  `lat` float NOT NULL COMMENT '纬度',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transcompany
-- ----------------------------
INSERT INTO `transcompany` VALUES ('2C282C84643E49A4BE0C33ECE87BAA5A', '广州市海珠区顺丰速运', '13189679380', null, null, '', '17002', '113.281', '23.0924');
INSERT INTO `transcompany` VALUES ('6F8E7CBDD6264AD49FA3089C36CE3C9A', '广州市海珠区食品加工场', '13189679389', null, null, '', '17001', '113.327', '23.0618');
INSERT INTO `transcompany` VALUES ('9B304DC7C8F5431A93BEF0FAD0A0D648', '广州市白云区嘉禾农贸市场', '13189679381', null, null, '', '17003', '113.282', '23.237');
INSERT INTO `transcompany` VALUES ('AD5267D98F634C0EB438FC054E6C9CE4', '广州市海珠区仲恺农业工程学院海珠校区', '13189679384', null, null, '', '17004', '113.288', '23.1133');

-- ----------------------------
-- Table structure for `transportation`
-- ----------------------------
DROP TABLE IF EXISTS `transportation`;
CREATE TABLE `transportation` (
  `id` varchar(45) NOT NULL COMMENT '运输编号',
  `cid` varchar(45) DEFAULT NULL COMMENT '顾客id',
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
  CONSTRAINT `FK_trans_customer_cid` FOREIGN KEY (`cid`) REFERENCES `transcompany` (`tid`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_trans_outpoul_patch` FOREIGN KEY (`id_patch`) REFERENCES `out_poultry` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_trans_transCompany_tid` FOREIGN KEY (`tid`) REFERENCES `transcompany` (`tid`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transportation
-- ----------------------------
INSERT INTO `transportation` VALUES ('044EB98B9D0D45A1A07B323228727591', '9B304DC7C8F5431A93BEF0FAD0A0D648', '2C282C84643E49A4BE0C33ECE87BAA5A', 'A3A111CB2C874A6AA1C796E5A8D7ED2E', '10', '113.354', '23.143', '2018-02-07 22:03:08', '天天', '13189679384', '广州市天河区华南师范大学(石牌校区)');
INSERT INTO `transportation` VALUES ('50C441211C6B49E5B079951072596654', '9B304DC7C8F5431A93BEF0FAD0A0D648', '2C282C84643E49A4BE0C33ECE87BAA5A', 'FF8ACA43974743AA879D128FF43E8B5E', '30', '113.349', '23.1768', '2018-02-04 23:26:39', '龙龙', '13189679384', '广州市天河区广州天河汽车客运站');
INSERT INTO `transportation` VALUES ('8D11EEF477DD44A6B93A602C08E9DC9B', '9B304DC7C8F5431A93BEF0FAD0A0D648', '2C282C84643E49A4BE0C33ECE87BAA5A', 'FF8ACA43974743AA879D128FF43E8B5E', '30', '113.281', '23.0924', '2018-02-03 22:45:05', '天天', '13189679384', '广州市海珠区顺丰速运');
INSERT INTO `transportation` VALUES ('8D666101AF904D21AD5F8812A306A540', '9B304DC7C8F5431A93BEF0FAD0A0D648', '2C282C84643E49A4BE0C33ECE87BAA5A', 'A3A111CB2C874A6AA1C796E5A8D7ED2E', '10', '113.288', '23.1133', '2018-02-07 21:58:39', '天天', '13189679384', '广州市海珠区仲恺农业工程学院海珠校区');
INSERT INTO `transportation` VALUES ('B77E887C804446A5A42DABE9A22DCA77', '9B304DC7C8F5431A93BEF0FAD0A0D648', '2C282C84643E49A4BE0C33ECE87BAA5A', 'A3A111CB2C874A6AA1C796E5A8D7ED2E', '10', '113.294', '23.2061', '2018-02-07 22:04:02', '龙龙', '13189679384', '广州市白云区黄石东路-道路');
INSERT INTO `transportation` VALUES ('DDC216CC85854218841C6EA4DCDE044D', '9B304DC7C8F5431A93BEF0FAD0A0D648', '2C282C84643E49A4BE0C33ECE87BAA5A', 'A3A111CB2C874A6AA1C796E5A8D7ED2E', '10', '113.239', '23.1992', '2018-02-07 22:03:41', '龙龙', '13189679384', '广州市白云区石井镇');
INSERT INTO `transportation` VALUES ('EAAB188AF168479F9826C35723DDA8C9', '9B304DC7C8F5431A93BEF0FAD0A0D648', '2C282C84643E49A4BE0C33ECE87BAA5A', 'A3A111CB2C874A6AA1C796E5A8D7ED2E', '10', '113.275', '23.2301', '2018-02-07 22:04:36', '猪猪', '13189679384', '广州市白云区鹤边员村-公交车站');
INSERT INTO `transportation` VALUES ('F32A5D8A38744BD7B8112F7F026637F9', '9B304DC7C8F5431A93BEF0FAD0A0D648', '2C282C84643E49A4BE0C33ECE87BAA5A', 'FF8ACA43974743AA879D128FF43E8B5E', '30', '113.309', '23.2323', '2018-02-05 15:33:36', '猪猪', '13189679385', '广州市白云区永平街道');

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
INSERT INTO `user` VALUES ('3', 'willon', '1fedcd4763b552f95ad499170ba78ae6', null, 'willon', null, '2018-04-07 23:36:30', '3', null, null, '13189679385', null);
INSERT INTO `user` VALUES ('9ACF40F64DCC418EBFC1E7A2E5BCC1B4', null, null, '职务', '真实姓名', '3', null, '3', '2018-04-07 18:40:56', '备注', null, null);

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
