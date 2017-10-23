/*
SQLyog v10.2 
MySQL - 5.5.28 : Database - waterfowl
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`waterfowl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `waterfowl`;

/*Table structure for table `aquaculture` */

DROP TABLE IF EXISTS `aquaculture`;

CREATE TABLE `aquaculture` (
  `id` varchar(45) NOT NULL COMMENT '养殖记录编号',
  `inventory_id` varchar(45) NOT NULL COMMENT '库存表编号',
  `fowlery_id` varchar(45) NOT NULL COMMENT '禽舍表编号',
  `record_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `num_total` int(11) NOT NULL COMMENT '当前个体总数',
  `feed_type` varchar(45) NOT NULL COMMENT '饲料种类',
  `feed_weight` float NOT NULL COMMENT '饲料重量：单位为千克',
  `rice_weight` float NOT NULL COMMENT '稻谷重量：单位为千克',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  `id_batch` varchar(45) NOT NULL COMMENT '批次号',
  PRIMARY KEY (`id`),
  KEY `fk_aquaculture_inventory1_idx` (`inventory_id`),
  KEY `fk_aquaculture_user1_idx` (`id_recorder`),
  KEY `fk_aquaculture_user2_idx` (`id_charge`),
  KEY `fk_aquaculture_fowlery1_idx` (`fowlery_id`),
  KEY `fk_aquaculture_warehouse1_idx` (`id_batch`),
  CONSTRAINT `aquaculture_ibfk_1` FOREIGN KEY (`fowlery_id`) REFERENCES `fowlery` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aquaculture_ibfk_2` FOREIGN KEY (`inventory_id`) REFERENCES `inventory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aquaculture_ibfk_3` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aquaculture_ibfk_4` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aquaculture_ibfk_5` FOREIGN KEY (`id_batch`) REFERENCES `warehouse` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `aquaculture` */

insert  into `aquaculture`(`id`,`inventory_id`,`fowlery_id`,`record_date`,`num_total`,`feed_type`,`feed_weight`,`rice_weight`,`remark`,`id_recorder`,`id_charge`,`id_batch`) values ('0','3','0','2017-10-23 19:13:14',100,'豆粉',10,100,NULL,'0','0','0');

/*Table structure for table `ddl` */

DROP TABLE IF EXISTS `ddl`;

CREATE TABLE `ddl` (
  `id` varchar(45) NOT NULL COMMENT '病、死、淘汰记录表编号',
  `epidemic_id` varchar(45) NOT NULL COMMENT '疫病情况表编号',
  `record_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `num_processed` int(11) NOT NULL COMMENT '需处理个体数量',
  `processing_mode` varchar(45) NOT NULL COMMENT '处理方式',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id`),
  KEY `fk_ddl_epidemic1_idx` (`epidemic_id`),
  KEY `fk_ddl_user1_idx` (`id_recorder`),
  KEY `fk_ddl_user2_idx` (`id_charge`),
  CONSTRAINT `ddl_ibfk_1` FOREIGN KEY (`epidemic_id`) REFERENCES `epidemic` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ddl_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ddl_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ddl` */

insert  into `ddl`(`id`,`epidemic_id`,`record_date`,`num_processed`,`processing_mode`,`remark`,`id_recorder`,`id_charge`) values ('0','0','2017-10-23 19:13:14',50,'掩埋',NULL,'0','0');

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL COMMENT '导航栏编号',
  `name` varchar(45) NOT NULL COMMENT '栏目名称',
  `pid` int(11) NOT NULL COMMENT '上一级导航栏编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dictionary` */

insert  into `dictionary`(`id`,`name`,`pid`) values (0,'root',0),(10,'养殖溯源系统',0),(20,'出入情况',10),(26,'角色管理',1),(27,'新增角色',26),(28,'删改角色',26),(30,'入库记录',20),(40,'出库记录',20),(50,'新增入库',20),(60,'新增出库',20),(70,'库存情况',10),(80,'物资记录',70),(90,'误录更改',70),(100,'禽舍情况',10),(110,'新增禽舍',100),(120,'信息变更',100),(130,'弃用禽舍',100),(140,'天气情况',10),(150,'录入信息',130),(160,'误录修改',130),(170,'养殖情况',10),(180,'新增记录',170),(190,'误录修改',170),(200,'疫病情况',10),(210,'新增记录',200),(220,'误录修改',200),(230,'人员管理',10),(240,'新增人员',230),(250,'修改信息',230);

/*Table structure for table `epidemic` */

DROP TABLE IF EXISTS `epidemic`;

CREATE TABLE `epidemic` (
  `id` varchar(45) NOT NULL COMMENT '疫情记录编号',
  `fowlery_id` varchar(45) NOT NULL COMMENT '禽舍编号',
  `inventory_id` varchar(45) DEFAULT NULL COMMENT '库存表编号',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date日期',
  `sign` varchar(45) NOT NULL COMMENT '免疫、疫病标志',
  `diseaes` varchar(45) NOT NULL COMMENT '疾病',
  `num_total` int(11) NOT NULL COMMENT '个体总数',
  `num_infected` int(11) NOT NULL COMMENT '染病个体数',
  `processing_mode` varchar(45) NOT NULL COMMENT '处理方式',
  `medication_mode` varchar(45) NOT NULL COMMENT '给药方式',
  `dose` float NOT NULL COMMENT '剂量',
  `dose_unit` varchar(45) NOT NULL COMMENT '剂量对应单位，例：ml、g',
  `medication_amount` float NOT NULL COMMENT '用药总量，包含实际总使用量和损耗丢弃量。单位以对应消耗品在inv库存表中的unit属性为准，可以是：盒、ml、kg等',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  `id_batch` varchar(45) NOT NULL COMMENT '养殖批次',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  KEY `fk_epidemic_inventory1_idx` (`inventory_id`),
  KEY `fk_epidemic_fowlery1_idx` (`fowlery_id`),
  KEY `fk_epidemic_user1_idx` (`id_recorder`),
  KEY `fk_epidemic_user2_idx` (`id_charge`),
  KEY `fk_epidemic_aquaculture1` (`id_batch`),
  CONSTRAINT `epidemic_ibfk_1` FOREIGN KEY (`id_batch`) REFERENCES `aquaculture` (`id_batch`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_2` FOREIGN KEY (`fowlery_id`) REFERENCES `fowlery` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_3` FOREIGN KEY (`inventory_id`) REFERENCES `inventory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_4` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `epidemic_ibfk_5` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `epidemic` */

insert  into `epidemic`(`id`,`fowlery_id`,`inventory_id`,`date`,`sign`,`diseaes`,`num_total`,`num_infected`,`processing_mode`,`medication_mode`,`dose`,`dose_unit`,`medication_amount`,`remark`,`id_recorder`,`id_charge`,`id_batch`) values ('0','0','10000','2017-10-23 19:13:14','免疫','注射疫苗A',100,0,'注射疫苗A','肌肉注射',1,'ml',2,NULL,'0','0','0');

/*Table structure for table `fowlery` */

DROP TABLE IF EXISTS `fowlery`;

CREATE TABLE `fowlery` (
  `id` varchar(45) NOT NULL COMMENT '禽舍管理编号',
  `date_establish` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '建立日期',
  `address` varchar(45) NOT NULL COMMENT '地址',
  `num_max` int(11) NOT NULL COMMENT '最大纳员数量',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id`),
  KEY `fk_fowlery_user1_idx` (`id_recorder`),
  KEY `fk_fowlery_user2_idx` (`id_charge`),
  CONSTRAINT `fowlery_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fowlery_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fowlery` */

insert  into `fowlery`(`id`,`date_establish`,`address`,`num_max`,`remark`,`id_recorder`,`id_charge`) values ('0','2017-01-01 00:30:00','仲恺养鸡场1舍',500,NULL,'0','0');

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `id` varchar(45) NOT NULL COMMENT '库存记录编号',
  `expiration_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '产品有效期',
  `name` varchar(45) NOT NULL COMMENT '材料名称',
  `quantity` float NOT NULL COMMENT '材料数量',
  `unit` varchar(45) NOT NULL COMMENT '计数单位',
  `storage_site` varchar(45) NOT NULL COMMENT '储存地点',
  `storage_mode` varchar(45) NOT NULL COMMENT '储存方式',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_inventory_user1_idx` (`id_recorder`),
  KEY `fk_inventory_user2_idx` (`id_charge`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `inventory` */

insert  into `inventory`(`id`,`expiration_date`,`name`,`quantity`,`unit`,`storage_site`,`storage_mode`,`remark`,`id_recorder`,`id_charge`) values ('0','2017-01-01 12:30:00','稻谷',1000,'公斤','1号仓库','干燥通风',NULL,'0','0'),('10000','2017-01-01 13:30:00','疫苗A',1000,'盒','2号仓库','37摄氏度恒温','每盒60ml','0','0');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` varchar(45) NOT NULL COMMENT '权限编号',
  `permission_name` varchar(45) NOT NULL COMMENT '权限名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`id`,`permission_name`) values ('0','root'),('1','dictionary'),('10','fowlery'),('100','null'),('11','weather'),('2','user'),('3','permissio'),('4','role'),('5','warehouse'),('6','inventory'),('7','aquaculture'),('8','epidemic'),('9','ddl');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(45) NOT NULL COMMENT 'Permission table角色表',
  `name` varchar(45) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values ('0','admin');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `role_id` varchar(45) NOT NULL COMMENT '角色编号',
  `permission_id` varchar(45) NOT NULL COMMENT '权限编号',
  KEY `fk_role_role_permission` (`role_id`),
  KEY `fk_role_permission_permission` (`permission_id`),
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_permission` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(45) NOT NULL COMMENT '人员管理表编号',
  `username` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(45) NOT NULL COMMENT '登录密码',
  `duty` varchar(45) DEFAULT NULL COMMENT '员工职责',
  `name` varchar(45) NOT NULL COMMENT '员工姓名',
  `gender` tinyint(4) NOT NULL COMMENT '性别',
  `entry` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '入职时间',
  `sign` varchar(45) NOT NULL COMMENT '入职状态标记:在职1,离职0',
  `turnover` timestamp NULL DEFAULT NULL COMMENT '离职时间',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `role_id` varchar(45) NOT NULL COMMENT '角色编号',
  `phone` varchar(45) DEFAULT NULL COMMENT '人员联系电话',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_user_role1_idx` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`duty`,`name`,`gender`,`entry`,`sign`,`turnover`,`remark`,`role_id`,`phone`) values ('0','zhanjia','12345',NULL,'展佳',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('1','yingqi','12345',NULL,'莹祺',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('10','wenzhi','12345',NULL,'文智',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('11','test','12345',NULL,'离职员工',100,'2017-10-23 19:13:14','离职',NULL,NULL,'0','12345678'),('2','yechao','12345',NULL,'叶超',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('3','chengjun','12345',NULL,'成君',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('4','hanqing','12345',NULL,'瀚清',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('5','jinman','12345',NULL,'锦曼',0,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('6','wenhao','12345',NULL,'文浩',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('7','weijia','12345',NULL,'伟佳',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('8','weijian','12345',NULL,'伟健',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678'),('9','weilong','12345',NULL,'伟龙',1,'2017-10-23 19:13:14','在职',NULL,NULL,'0','12345678');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  KEY `fk_user_has_permission_permission1_idx` (`role_id`),
  KEY `fk_user_has_permission_user1_idx` (`user_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

/*Table structure for table `warehouse` */

DROP TABLE IF EXISTS `warehouse`;

CREATE TABLE `warehouse` (
  `id` varchar(45) NOT NULL COMMENT '仓库记录表',
  `inventory_id` varchar(45) DEFAULT NULL COMMENT '库存表',
  `sign` tinyint(4) NOT NULL COMMENT '标记：0表示出库，1表示入库',
  `typesign` varchar(45) NOT NULL COMMENT '物料种类标志：消耗品,养殖对象',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录日期',
  `name` varchar(45) NOT NULL COMMENT '材料名称',
  `quantity` varchar(45) NOT NULL COMMENT '材料数量:当为养殖对象时作为本批次个体数',
  `unit` varchar(45) NOT NULL COMMENT '计数单位',
  `associated_firm` varchar(45) DEFAULT NULL COMMENT '关联厂商',
  `phone` varchar(45) DEFAULT NULL COMMENT '关联厂商电话',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  KEY `fk_warehouse_inventory1_idx` (`inventory_id`),
  KEY `fk_warehouse_user1_idx` (`id_recorder`),
  KEY `fk_warehouse_user2_idx` (`id_charge`),
  CONSTRAINT `warehouse_ibfk_1` FOREIGN KEY (`inventory_id`) REFERENCES `inventory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `warehouse_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `warehouse_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `warehouse` */

insert  into `warehouse`(`id`,`inventory_id`,`sign`,`typesign`,`date`,`name`,`quantity`,`unit`,`associated_firm`,`phone`,`remark`,`id_recorder`,`id_charge`) values ('0','0',1,'消耗品','2017-10-23 19:13:14','稻谷','1000.0','kg',NULL,NULL,NULL,'0','0'),('1','10000',1,'消耗品','2017-10-23 19:13:14','疫苗A','100','盒',NULL,NULL,'每盒60ml','0','0'),('2',NULL,1,'养殖对象','2017-10-23 19:13:14','清远鸡','100.0','只',NULL,NULL,NULL,'0','0'),('3','1',1,'消耗品','2017-10-23 19:13:14','豆粉','500.0','kg',NULL,NULL,NULL,'0','0');

/*Table structure for table `weather` */

DROP TABLE IF EXISTS `weather`;

CREATE TABLE `weather` (
  `id` varchar(45) NOT NULL COMMENT '天气记录编号',
  `fowlery_id` varchar(45) NOT NULL COMMENT '禽舍表编号',
  `date` timestamp NULL DEFAULT NULL COMMENT '日期',
  `humidity_in` float DEFAULT NULL COMMENT '室内湿度：单位%',
  `humidity_out` varchar(45) DEFAULT NULL COMMENT '室外湿度：单位%',
  `co2` float DEFAULT NULL COMMENT '二氧化碳浓度:单位ppm',
  `temperature_out` varchar(45) DEFAULT NULL COMMENT '室外温度:单位摄氏度',
  `temperature_in` float DEFAULT NULL COMMENT '室内温度:单位摄氏度',
  `illuminance` float DEFAULT NULL COMMENT '光照度:单位勒克斯(lx)',
  `h2s` float DEFAULT NULL COMMENT '硫化氢浓度:单位ppm',
  `nh4` float DEFAULT NULL COMMENT '氨气浓度:单位ppm',
  `dust` float DEFAULT NULL COMMENT '粉尘浓度:单位mg/m3',
  `picture` varchar(45) DEFAULT NULL COMMENT '记录点视频图像截图存放位置',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  `id_recorder` varchar(45) NOT NULL COMMENT '记录者编号',
  `id_charge` varchar(45) NOT NULL COMMENT '负责人编号',
  PRIMARY KEY (`id`),
  KEY `fk_weather_fowlery1_idx` (`fowlery_id`),
  KEY `fk_weather_user1_idx` (`id_recorder`),
  KEY `fk_weather_user2_idx` (`id_charge`),
  CONSTRAINT `weather_ibfk_1` FOREIGN KEY (`fowlery_id`) REFERENCES `fowlery` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `weather_ibfk_2` FOREIGN KEY (`id_recorder`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `weather_ibfk_3` FOREIGN KEY (`id_charge`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `weather` */

insert  into `weather`(`id`,`fowlery_id`,`date`,`humidity_in`,`humidity_out`,`co2`,`temperature_out`,`temperature_in`,`illuminance`,`h2s`,`nh4`,`dust`,`picture`,`remark`,`id_recorder`,`id_charge`) values ('0','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
