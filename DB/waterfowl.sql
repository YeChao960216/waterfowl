/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : waterfowl

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2017-11-20 21:35:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for affiliation
-- ----------------------------
DROP TABLE IF EXISTS `affiliation`;
CREATE TABLE `affiliation` (
  `id` varchar(45) NOT NULL COMMENT '所属大禽舍编号',
  `type` varchar(45) DEFAULT NULL COMMENT '养殖类型',
  `position` varchar(45) DEFAULT NULL COMMENT '方位',
  `size` varchar(45) DEFAULT NULL COMMENT '规格',
  `status` varchar(45) DEFAULT NULL COMMENT '是否满员',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`),
  KEY `FK_affi_dic_type` (`type`),
  KEY `FK_affi_dic_position` (`position`),
  KEY `FK_affi_dic_size` (`size`),
  KEY `FK_affi_dic_status` (`status`),
  KEY `FK_affi_user_record` (`id_record`),
  KEY `FK_affi_user_charge` (`id_charge`),
  CONSTRAINT `FK_affi_user_charge` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_affi_dic_position` FOREIGN KEY (`position`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_affi_dic_size` FOREIGN KEY (`size`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_affi_dic_status` FOREIGN KEY (`status`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_affi_dic_type` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_affi_user_record` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of affiliation
-- ----------------------------
INSERT INTO `affiliation` VALUES ('1', '0', '0', '0', '0', '1', '1');

-- ----------------------------
-- Table structure for aquaculture
-- ----------------------------
DROP TABLE IF EXISTS `aquaculture`;
CREATE TABLE `aquaculture` (
  `id` varchar(45) NOT NULL COMMENT '养殖记录表',
  `name` varchar(45) DEFAULT NULL COMMENT '禽舍类型',
  `id_fowlery` varchar(45) DEFAULT NULL COMMENT '禽舍表编号',
  `id_patch` varchar(45) DEFAULT NULL COMMENT '养殖批次',
  `record_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `num_total` int(11) DEFAULT NULL COMMENT '当前个体总数',
  `feed_type` varchar(45) DEFAULT NULL COMMENT '饲料种类',
  `feed_weight` float DEFAULT NULL COMMENT '饲料重量：单位为千克',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id_outstorage` varchar(45) DEFAULT NULL COMMENT '出库编号',
  `status` varchar(45) DEFAULT NULL COMMENT '禽类的阶段标识',
  PRIMARY KEY (`id`),
  KEY `fk_aquaculture_user1_idx` (`id_recorder`),
  KEY `fk_aquaculture_user2_idx` (`id_charge`),
  KEY `fk_aquaculture_fowlery1_idx` (`id_fowlery`),
  KEY `fk_aquaculture_outstorage1_idx` (`id_outstorage`),
  KEY `fk_aquaculture_outstorage1_idx1` (`id_outstorage`),
  KEY `type_dictionary_id` (`name`),
  KEY `status_dictionary_id` (`status`),
  KEY `FK_aqua_patch_id` (`id_patch`),
  CONSTRAINT `FK_aqua_patch_id` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aquaculture_ibfk_3` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aquaculture_ibfk_4` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aquaculture_outstorage1` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `status_dictionary_id` FOREIGN KEY (`status`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `type_dic_id` FOREIGN KEY (`name`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aquaculture
-- ----------------------------
INSERT INTO `aquaculture` VALUES ('1', '0', '1', '1', '2017-11-17 23:43:10', '1', '1', '1', '1', '1', '1', null, '0');

-- ----------------------------
-- Table structure for ddl
-- ----------------------------
DROP TABLE IF EXISTS `ddl`;
CREATE TABLE `ddl` (
  `id` varchar(45) NOT NULL COMMENT '病、死、淘汰记录表编号',
  `id_patch` varchar(45) NOT NULL COMMENT '养殖禽舍编号',
  `record_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `num_processed` int(11) NOT NULL COMMENT '需处理个体数量',
  `processing_mode` varchar(45) NOT NULL COMMENT '处理方式',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  `flag` int(11) NOT NULL DEFAULT '0' COMMENT '提交状态   0表示未提交，1表示提交',
  PRIMARY KEY (`id`),
  KEY `fk_ddl_poultry1_idx` (`id_patch`),
  KEY `fk_ddl_user1_idx` (`id_recorder`),
  KEY `fk_ddl_user2_idx` (`id_charge`),
  CONSTRAINT `FK_ddl_patch_id` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ddl_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ddl_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `ddl`(`id`,`id_patch`,`record_date`,`num_processed`,`processing_mode`,`remark`,`id_recorder`,`id_charge`,`flag`) values ('0','0','2017-11-19 13:36:12',19,'121','11','0','0',0),('01669E7FBDA04B9C9A791395B78A2EA0','0','2017-08-08 00:00:00',100,'10','idea修改','1','1',1),('02045FECDAB6461EAE156C7BE00B22BD','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('0567750763564BF38FD9E097A7760586','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('056EA6500F17452EAA89330EDFA68440','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('0708F52AC275466F8174647A049E1C29','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('09AEBAFF93D64AE7B719A6774FAF7359','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('0BB39B02B549494782BDA2DFCCF8DE02','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('1369EFB8E3DD495D80330EA3589264B6','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('1FC20A77898348BBB2797432E5C9DC1A','0','2017-08-08 00:00:00',100,'10','idea修改','1','1',1),('24E2CE75653D4F20918EFE8BB7048343','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('2562CCD6846A429193618C8390FF4C07','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('26B55A5592D64C7F9A6C075850DD5DF5','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('3323AED39FA8452A8FB0842B6F8C7C39','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('36ACBF3F2F274D8C8CA8C491E7D55F44','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('42F7EB51837441F49F8D14684A1605A9','0','2017-11-19 20:15:06',100,'10','idea增加','1','1',1),('4AB681A608404861BD6F9D314E177DAF','0','2017-11-19 20:15:06',100,'10','idea增加','1','1',1),('4D3A3CAB92334525B0C3CC993974EED1','0','2017-11-19 20:15:06',100,'10','idea增加','1','1',1),('5BE34D9C345E488EB29DF58444C4DCB1','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('5E09F7C0021A46449C16B3A9CFF43220','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('61F2ADDFE9F14A108C8337AE253B8827','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('64C18A408CEA4132A146B9B661B8B349','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('65F523D1CEC54B829625ECE3BBD81402','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('67D67D1B140F4DF3B83329AD25CEFE07','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('6AEFA7A284024AAFB2B1BFB061474D82','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('743FDBFDF74C424AAEF8FEBC4D8803D3','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('78FBD3131BB34EBC9140806F11CC5078','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('794B6334AB3C486A9C59358B4114EC3C','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('795DB90FD0BE4682858CA9E8A9A11802','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('7BCC97E30A5A47E2AF50DAD512A7508E','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('7BF2DD0FEE6C47E5BB0D8E833EBBB138','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('7C6AFAE4C097447CBD057D82384FDD95','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('7D42AA59E06944C385824646B5D59C8B','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('7EAECA4721044720A5BD9D61BBFE4D40','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('854BF73F794A49D184333CB28EBE0670','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('871F7AC12B4A4018B85A632620979455','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('8C48AFE9D6F7415B889C6C50C8D04425','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('8DB1F7CBE453430290DD75430D877236','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('8FC95A5BD5CD4142B12967766DD1B70F','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('8FEF4D1B4ED14ABAA240AF7051B7B1F3','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('8FF96043C27248E8B071B05BE76EFF41','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('9156DF4385B64F01A0E910E4C22BAB2D','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('92B3046E948C428E9356E40A6E431DB1','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('9840658B3EBF4DF5A7337CCD1BBA9745','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('994BB7E4C69D489A8E4C7452CA8727E0','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('9B5570DC0AC842F981B1F8DD163BEA3B','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('A1561D3AD28449E689F5EAD2D40F152C','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('A1645D9FA92741619368862E9ECB370C','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('AC5CCDD8028A4232820A32F070025982','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('AD2A14B7E6FD464A8A1C603B00857D8F','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('C1C8304F44604544A7041A8498DC2A8F','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('C4336EDF87FE479B91420E893FD31DDB','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('D797BC917F2247B89BEB7E84F76AAEBE','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('D7B355995C56411C962AB3AE40280EED','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('D82A3020D0D845709EFDE7CE90680114','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('DB595456F51F4644A2276862EE1A3400','0','2017-08-08 00:00:00',100,'10','idea增加','1','1',0),('E54A1CE4061147909E8E099F10867096','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('EDA0B3950DB145298CE3785CABFF7A29','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('F2F3BBDC597145AEBD3DFFE961793367','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('F644E4999B6744A0990767799B7255D3','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0),('FA0620C28FE44E05BBCBA9F9EBF8AC0D','0','2017-08-08 00:00:00',100,'10','idea修改测试','1','1',0);

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
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('0', '测试', '0', 'test');
INSERT INTO `dictionary` VALUES ('1000', '禽舍状态', '0', 'status');
INSERT INTO `dictionary` VALUES ('10000', '导航栏', '0', 'navigation');
INSERT INTO `dictionary` VALUES ('10001', '物资管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10002', '禽舍管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10003', '基础信息管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10004', '养殖管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10005', '疫病防治管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10006', '人员管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('10007', '字典管理', '10000', '0');
INSERT INTO `dictionary` VALUES ('1001', '可使用', '1000', '0');
INSERT INTO `dictionary` VALUES ('1002', '不可使用', '1000', '1');
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
INSERT INTO `dictionary` VALUES ('2000', '存储方式', '0', 'mode');
INSERT INTO `dictionary` VALUES ('20000', '国际单位', '0', 'unit');
INSERT INTO `dictionary` VALUES ('20001', '千克', '20000', 'kg');
INSERT INTO `dictionary` VALUES ('2001', '冷藏', '2000', null);
INSERT INTO `dictionary` VALUES ('3000', '剂量单位', '0', 'dose_unit');
INSERT INTO `dictionary` VALUES ('30000', '家禽养殖阶段', '0', 'status');
INSERT INTO `dictionary` VALUES ('30001', '幼鸡', '30000', null);
INSERT INTO `dictionary` VALUES ('50000', '权限', '0', null);
INSERT INTO `dictionary` VALUES ('60000', '家禽种类(禽舍类型)', '0', 'type');
INSERT INTO `dictionary` VALUES ('60001', '鹅', '60000', null);
INSERT INTO `dictionary` VALUES ('60002', '鸭', '60000', null);
INSERT INTO `dictionary` VALUES ('60003', '鸡', '60000', null);
INSERT INTO `dictionary` VALUES ('70000', '方位', '0', 'position');
INSERT INTO `dictionary` VALUES ('70001', '南', '70000', null);
INSERT INTO `dictionary` VALUES ('80000', '规格', '0', 'size');
INSERT INTO `dictionary` VALUES ('90000', '登陆类型', '0', 'identity_type');
INSERT INTO `dictionary` VALUES ('90001', '微信', '90000', 'wechat');

-- ----------------------------
-- Table structure for epidemic
-- ----------------------------
DROP TABLE IF EXISTS `epidemic`;
CREATE TABLE `epidemic` (
  `id_patch` varchar(45) DEFAULT NULL COMMENT '批次编号',
  `name` varchar(45) DEFAULT NULL COMMENT '药品名称',
  `id_outstorage` varchar(45) DEFAULT NULL,
  `record_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date日期',
  `sign` varchar(45) DEFAULT NULL COMMENT '免疫、疫病标志',
  `diseaes` varchar(45) DEFAULT NULL COMMENT '疾病',
  `num_infected` int(11) DEFAULT NULL COMMENT '染病个体数',
  `processing_mode` varchar(45) DEFAULT NULL COMMENT '处理方式',
  `medication_mode` varchar(45) DEFAULT NULL COMMENT '给药方式',
  `dose` float DEFAULT NULL COMMENT '剂量',
  `dose_unit` varchar(45) DEFAULT NULL COMMENT '剂量对应单位',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `flag` int(11) DEFAULT '0' COMMENT '提交状态   0表示未提交，1表示提交',
  `id` varchar(45) NOT NULL COMMENT '疫情记录编号',
  PRIMARY KEY (`id`),
  KEY `fk_epidemic_fowlery1_idx` (`id_patch`),
  KEY `fk_epidemic_user1_idx` (`id_recorder`),
  KEY `fk_epidemic_user2_idx` (`id_charge`),
  KEY `epidemic_unit_dictionary_id` (`dose_unit`),
  KEY `epid_outstorage_id_storage` (`id_outstorage`),
  CONSTRAINT `epid_outstorage_id_storage` FOREIGN KEY (`id_outstorage`) REFERENCES `outstorage` (`id_outstorage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_2` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_4` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_5` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_unit_dictionary_id` FOREIGN KEY (`dose_unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `epidemic`(`id_patch`,`name`,`id_outstorage`,`record_date`,`sign`,`diseaes`,`num_infected`,`processing_mode`,`medication_mode`,`dose`,`dose_unit`,`remark`,`id_recorder`,`id_charge`,`flag`,`id`) values ('0','0','0','2017-11-19 20:18:03',NULL,NULL,NULL,NULL,NULL,NULL,'0',NULL,'0','0',0,''),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'03DB1E61E95A4339983E3FB090ABE508'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'0507A5BF3E744C2985CB8FC75FD5B48D'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'06A225B7F8004B7D9646A49FC0307DD3'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'0CAEA6C9F3484FE19A16EE0DAC2DB124'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'143BCF1DFFD149619A983CB36A594BA4'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'1C35C8C6B58D4A49AE2EFF0DCEDC358A'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'2699D14668054D73BFD25D4B06D42879'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'28960779CC2A47B7B85CDAE6D473033E'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'2EF30DAC4479490F9F828E2BACC36123'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'34AD10545CA44614A6C836BF57111C60'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'34C0827A9A9B4C6D8541B3E3A201B8E2'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'3DBB547F445F4FDCB510363CB5A5D651'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'48606ABF9C114591AB0C2BC097D66820'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'490712F937C249D7B6ABF1044CD3DC17'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'4F88B53ECF54405CA4DFB7905BF66D9C'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'5FD876C9EA1E43F6B035D0BB6785A961'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'76EEA2F2C6ED43159A91A06945A93FCF'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'77708688414846FABCF0651FCE25B55D'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'7B8C0CA7D2FB423197A6D10D99B86735'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'836C4B8EF1D9422BAC95928ECA1D1DCD'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'8BB665868CC84F55A43509124899D24D'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'8C24412A56AB4A1FBAB8CE7335630B80'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'A748F64CB62E434EA04154C8BDC7039A'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'A7DA205313BC460493319B2031F77EA6'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'B8942967FF7E4B659E8659731B71A085'),('0',NULL,NULL,'2017-08-08 00:00:00','疾病',NULL,NULL,'10',NULL,NULL,NULL,'idea增加','1','1',0,'C3DC12D76BBF43ECA9DF6054D9454A29'),('0',NULL,'0','2017-11-20 20:12:13','疾病','禽流感',10,'10','',NULL,'0','idea多条件查询','1','1',0,'CCA102DEE37C4DEDA32223891827C9A2'),('0',NULL,'0','2017-11-01 00:00:00','疾病','0',1,'10','1',1,'0','网页修改测试','1','1',0,'FFE16603571A4AE6A4D52ECC22D29F6F');
-- ----------------------------
-- Records of epidemic
-- ----------------------------

-- ----------------------------
-- Table structure for fowlery
-- ----------------------------
DROP TABLE IF EXISTS `fowlery`;
CREATE TABLE `fowlery` (
  `id` varchar(45) NOT NULL COMMENT '禽舍编号',
  `size` varchar(45) DEFAULT NULL COMMENT '规格',
  `status` varchar(45) DEFAULT NULL COMMENT '使用状态',
  `affiliation` varchar(45) DEFAULT NULL COMMENT '归属的大禽舍',
  `id_record` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人',
  PRIMARY KEY (`id`),
  KEY `FK_fowlery_affili_id` (`affiliation`),
  KEY `FK_fowlery_dic_size` (`size`),
  KEY `FK_fowlery_dic_status` (`status`),
  KEY `FK_fowlery_user_charge` (`id_charge`),
  KEY `FK_fowlery_user_record` (`id_record`),
  CONSTRAINT `FK_fowlery_user_record` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_fowlery_affili_id` FOREIGN KEY (`affiliation`) REFERENCES `affiliation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_fowlery_dic_size` FOREIGN KEY (`size`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_fowlery_dic_status` FOREIGN KEY (`status`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_fowlery_user_charge` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fowlery
-- ----------------------------
INSERT INTO `fowlery` VALUES ('1', '0', '0', '1', '1', '1');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id_storage` varchar(45) NOT NULL COMMENT '库存表',
  `date` datetime DEFAULT NULL COMMENT '进厂时间',
  `name` varchar(45) DEFAULT NULL COMMENT '材料名称',
  `expiration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '产品有效期——用户填写',
  `associated_firm` varchar(45) DEFAULT NULL COMMENT '关联厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `type` varchar(45) DEFAULT NULL COMMENT '物资类型',
  `quantity` varchar(45) DEFAULT NULL COMMENT '库存材料数量',
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
  CONSTRAINT `material_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `material_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storage_mode_dic_id` FOREIGN KEY (`mode`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storage_storage_unit_dic_id` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', '2017-11-19 21:59:11', '1', '2017-11-19 21:59:14', '1', '1', '1', '1', '0', '1', '0', '1', '1', '1');

-- ----------------------------
-- Table structure for outstorage
-- ----------------------------
DROP TABLE IF EXISTS `outstorage`;
CREATE TABLE `outstorage` (
  `id_outstorage` varchar(45) NOT NULL COMMENT '物资使用表——自动生成用户不填',
  `name` varchar(45) DEFAULT NULL COMMENT '材料名称——name发送到storage获取库存数据，供用户下拉框选择我',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_storage` varchar(45) DEFAULT NULL,
  `record_date` timestamp NULL DEFAULT NULL,
  `quantity` varchar(45) DEFAULT NULL COMMENT '材料数量.用药总量，包含实际总使用量和损耗丢弃量。',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id_outstorage`),
  KEY `fk_storage_user1_idx` (`id_recorder`),
  KEY `fk_storage_user2_idx` (`id_charge`),
  KEY `fk_outstorage_storage1_idx` (`id_storage`),
  KEY `outst_unit_dic_id` (`unit`),
  CONSTRAINT `fk_outstorage_storage1` FOREIGN KEY (`id_storage`) REFERENCES `material` (`id_storage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `outst_unit_dic_id` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storage_ibfk_10` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storage_ibfk_20` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outstorage
-- ----------------------------
INSERT INTO `outstorage` VALUES ('1', '1', '1', '1', '2017-11-19 22:00:12', '1', '0', '1', '1');

-- ----------------------------
-- Table structure for out_poultry
-- ----------------------------
DROP TABLE IF EXISTS `out_poultry`;
CREATE TABLE `out_poultry` (
  `id` varchar(45) NOT NULL COMMENT '出厂编号',
  `record_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `type` varchar(45) DEFAULT NULL COMMENT '类型',
  `quantity` varchar(45) DEFAULT NULL COMMENT '本批次数量',
  `unit` varchar(45) DEFAULT NULL COMMENT '单位',
  `id_patch` varchar(45) DEFAULT NULL COMMENT '出厂批次',
  `firm` varchar(45) DEFAULT NULL COMMENT '出厂商',
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
  CONSTRAINT `FK_out_poul_patch_id` FOREIGN KEY (`id_patch`) REFERENCES `patch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_out_poultry_user_charge` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_out_poultry_user_record` FOREIGN KEY (`id_record`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_out_poul_aqua_patch` FOREIGN KEY (`id_patch`) REFERENCES `aquaculture` (`id_patch`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_out_poul_dic_type` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_out_poul_dic_unit` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of out_poultry
-- ----------------------------
INSERT INTO `out_poultry` VALUES ('1', '2017-11-17 23:37:33', '0', '1', '0', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for patch
-- ----------------------------
DROP TABLE IF EXISTS `patch`;
CREATE TABLE `patch` (
  `id_poultry` varchar(45) DEFAULT NULL COMMENT '入厂批次',
  `type` varchar(45) DEFAULT NULL COMMENT '类型',
  `position` varchar(45) DEFAULT NULL COMMENT '方位',
  `size` varchar(45) DEFAULT NULL COMMENT '规格',
  `id_affilation` varchar(45) DEFAULT NULL COMMENT '所属大禽舍',
  `id_fowlery` varchar(45) DEFAULT NULL COMMENT '禽舍编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  `id` varchar(45) NOT NULL COMMENT '禽舍管理表',
  `num_total` int(11) DEFAULT NULL COMMENT '当前个体总数',
  PRIMARY KEY (`id`),
  KEY `fk_fowlery_user1_idx` (`id_recorder`),
  KEY `fk_fowlery_user2_idx` (`id_charge`),
  KEY `FK_fowlery_dic_id` (`id_fowlery`),
  KEY `FK_fowlery_poultry` (`id_poultry`),
  KEY `FK_patch_affil_id` (`id_affilation`),
  KEY `FK_patch_dic_type` (`type`),
  KEY `FK_patch_dic_position` (`position`),
  KEY `FK_patch_dic_size` (`size`),
  CONSTRAINT `FK_fowlery_fowl_id` FOREIGN KEY (`id_fowlery`) REFERENCES `fowlery` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_fowlery_poultry` FOREIGN KEY (`id_poultry`) REFERENCES `poultry` (`id_poultry`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_patch_affil_id` FOREIGN KEY (`id_affilation`) REFERENCES `affiliation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_patch_dic_position` FOREIGN KEY (`position`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_patch_dic_size` FOREIGN KEY (`size`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_patch_dic_type` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patch_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patch_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patch
-- ----------------------------
INSERT INTO `patch` VALUES ('1', '0', '0', '0', '1', '1', '1', '1', '2017-11-17 23:37:33', '1', '1');

-- ----------------------------
-- Table structure for poultry
-- ----------------------------
DROP TABLE IF EXISTS `poultry`;
CREATE TABLE `poultry` (
  `id_poultry` varchar(45) NOT NULL COMMENT '家禽批次记录表',
  `record_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `type` varchar(45) DEFAULT NULL COMMENT '家禽类型',
  `quantity` varchar(45) DEFAULT NULL COMMENT '本批个体数',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位',
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
  CONSTRAINT `FK_poultry_dic_unit` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `material_ibfk_20` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `material_ibfk_30` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `poultry_name_dictionary_id` FOREIGN KEY (`type`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poultry
-- ----------------------------
INSERT INTO `poultry` VALUES ('1', '2017-11-17 23:37:33', '0', '1', '0', '1', '1', '1', '1', '1');

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
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
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
INSERT INTO `user` VALUES ('1', '叶超', '123', null, null, null, '2017-11-17 23:34:39', null, '2017-11-17 23:34:42', null, null);
INSERT INTO `user` VALUES ('CEDF4020E44F4109A99534E7173CC566', 'Sun Nov 19 16:00:00 CST 2017', '123456', '这个用户是仅供测试的', '这是定时自动生成的用户', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for user_auths
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
  CONSTRAINT `FK_iden_type_dic_id` FOREIGN KEY (`identity_type`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_auths_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_auths
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
  `id_recorder` varchar(45) DEFAULT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) DEFAULT NULL COMMENT '负责人编号',
  `unit` varchar(45) DEFAULT NULL COMMENT '计数单位',
  PRIMARY KEY (`id`),
  KEY `fk_weather_fowlery1_idx` (`id_fowlery`),
  KEY `fk_weather_user1_idx` (`id_recorder`),
  KEY `fk_weather_user2_idx` (`id_charge`),
  KEY `weath_unit_dic_id` (`unit`),
  CONSTRAINT `weather_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `weather_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `weath_fowlery_id_dic_id` FOREIGN KEY (`id_fowlery`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `weath_unit_dic_id` FOREIGN KEY (`unit`) REFERENCES `dictionary` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weather
-- ----------------------------
