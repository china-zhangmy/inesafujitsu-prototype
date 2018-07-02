/* SQL Manager for MySQL                              5.7.0.50823 */
/* -------------------------------------------------------------- */
/* Host     : localhost                                           */
/* Port     : 3306                                                */
/* Database : prototype                                           */


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES 'utf8mb4' */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `prototype`;

CREATE DATABASE `prototype`
    CHARACTER SET 'utf8mb4'
    COLLATE 'utf8mb4_0900_ai_ci';

USE `prototype`;

/* Structure for the `biz_mask` table : */

CREATE TABLE `biz_mask` (
  `id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `curr_idx` INTEGER(11) DEFAULT NULL,
  `create_date` DATETIME DEFAULT NULL,
  `create_user` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `update_date` DATETIME DEFAULT NULL,
  `update_user` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lock_date` DATETIME DEFAULT NULL,
  `lock_user` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `transport_box_rf_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `biz_mask_h` table : */

CREATE TABLE `biz_mask_h` (
  `id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `master_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `idx` INTEGER(11) DEFAULT NULL,
  `create_date` DATETIME DEFAULT NULL,
  `create_user` CHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `note` VARCHAR(200) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `biz_relation` table : */

CREATE TABLE `biz_relation` (
  `x_table_name` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `x_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `y_table_name` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `y_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY USING BTREE (`x_table_name`, `x_id`, `y_table_name`, `y_id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `biz_transport_box` table : */

CREATE TABLE `biz_transport_box` (
  `id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `curr_idx` INTEGER(11) DEFAULT NULL,
  `create_date` DATETIME DEFAULT NULL,
  `create_user` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `update_date` DATETIME DEFAULT NULL,
  `update_user` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `lock_date` DATETIME DEFAULT NULL,
  `lock_user` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `rf_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `biz_transport_box_h` table : */

CREATE TABLE `biz_transport_box_h` (
  `id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `master_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `idx` INTEGER(11) DEFAULT NULL,
  `create_date` DATETIME DEFAULT NULL,
  `create_user` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `note` VARCHAR(200) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `databasechangelog` table : */

CREATE TABLE `databasechangelog` (
  `ID` VARCHAR(255) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `AUTHOR` VARCHAR(255) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `FILENAME` VARCHAR(255) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DATEEXECUTED` DATETIME NOT NULL,
  `ORDEREXECUTED` INTEGER(11) NOT NULL,
  `EXECTYPE` VARCHAR(10) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `MD5SUM` VARCHAR(35) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DESCRIPTION` VARCHAR(255) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `COMMENTS` VARCHAR(255) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TAG` VARCHAR(255) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LIQUIBASE` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `CONTEXTS` VARCHAR(255) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `LABELS` VARCHAR(255) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DEPLOYMENT_ID` VARCHAR(10) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `databasechangeloglock` table : */

CREATE TABLE `databasechangeloglock` (
  `ID` INTEGER(11) NOT NULL,
  `LOCKED` BIT(1) NOT NULL,
  `LOCKGRANTED` DATETIME DEFAULT NULL,
  `LOCKEDBY` VARCHAR(255) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`ID`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `def_component` table : */

CREATE TABLE `def_component` (
  `id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `component_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `label` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `title` VARCHAR(45) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `width` TINYINT(4) DEFAULT NULL,
  `height` TINYINT(4) DEFAULT NULL,
  `comment` VARCHAR(200) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sql` VARCHAR(200) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id`),
  UNIQUE KEY `uk_component_id` USING BTREE (`component_id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `def_form` table : */

CREATE TABLE `def_form` (
  `id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `form_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `comment` VARCHAR(200) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `visible` TINYINT(1) NOT NULL,
  PRIMARY KEY USING BTREE (`id`),
  UNIQUE KEY `UK_FORM_ID` USING BTREE (`form_id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `def_ref_form_component` table : */

CREATE TABLE `def_ref_form_component` (
  `form_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `component_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `index` TINYINT(2) NOT NULL,
  `visible` TINYINT(1) DEFAULT NULL,
  PRIMARY KEY USING BTREE (`form_id`, `component_id`, `index`),
  KEY `idx_by_fk_component_id` USING BTREE (`component_id`),
  KEY `idx_by_fk_form_id` USING BTREE (`form_id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `sys_org` table : */

CREATE TABLE `sys_org` (
  `id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `descr` VARCHAR(45) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type_code` VARCHAR(3) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `parent_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `level` TINYINT(4) DEFAULT NULL,
  `uri` VARCHAR(200) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `sys_org_type` table : */

CREATE TABLE `sys_org_type` (
  `code` VARCHAR(3) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `descr` VARCHAR(45) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `parent_code` VARCHAR(3) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `invalid` TINYINT(1) DEFAULT NULL,
  PRIMARY KEY USING BTREE (`code`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `sys_privilege` table : */

CREATE TABLE `sys_privilege` (
  `code` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `descr` VARCHAR(45) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type_code` VARCHAR(3) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `composite_codes` VARCHAR(500) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`code`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `sys_user` table : */

CREATE TABLE `sys_user` (
  `id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'User ID',
  `name` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'User Name',
  `age` INTEGER(3) DEFAULT NULL COMMENT 'User Age',
  `email` VARCHAR(45) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'User Email(unique)',
  `gender` VARCHAR(3) COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT 'User Gender(M: male; F: female)',
  `password` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `org_uri` VARCHAR(200) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `group_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `superior_id` CHAR(32) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`),
  UNIQUE KEY `UK_EMAIL` USING BTREE (`email`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Structure for the `sys_user_group` table : */

CREATE TABLE `sys_user_group` (
  `id` CHAR(32) COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` VARCHAR(20) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `descr` VARCHAR(45) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `org_uri` VARCHAR(200) COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE=InnoDB
ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci'
;

/* Data for the `biz_mask` table  (LIMIT 0,500) */

INSERT INTO `biz_mask` (`id`, `name`, `curr_idx`, `create_date`, `create_user`, `update_date`, `update_user`, `lock_date`, `lock_user`, `transport_box_rf_id`) VALUES
  ('02c9cfd0d4054b6f8524e2ee683140fa',NULL,1,'2018-05-29 18:33:25','dummy_create_user','2018-05-29 18:33:25','dummy_update_user',NULL,NULL,'3333333'),
  ('111',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
  ('112296dee60747c6b20bb5a28e13c30c',NULL,1,'2018-05-31 15:05:20','dummy_create_user',NULL,NULL,NULL,NULL,NULL),
  ('123','123',1,NULL,NULL,NULL,NULL,NULL,NULL,'123'),
  ('26bc3f7a486d4353a69547e3e414defe',NULL,1,'2018-05-31 15:37:39','dummy_create_user',NULL,NULL,NULL,NULL,NULL),
  ('39bec0aefee44b3fb9458fed48ef6c32',NULL,3,'2018-05-29 17:51:32','dummy_create_user','2018-06-01 18:00:21','dummy_update_user',NULL,NULL,'66666666'),
  ('3d1ece9d06dd49839cd02b7f398b2cbb',NULL,1,'2018-05-31 18:28:30','dummy_create_user',NULL,NULL,NULL,NULL,'3333333'),
  ('68c2002fb8b048c08ff23774ebc157fc',NULL,1,'2018-05-31 15:40:04','dummy_create_user',NULL,NULL,NULL,NULL,'3333333'),
  ('72f976d232904f918e06518669729d3d',NULL,1,'2018-05-31 18:29:02','dummy_create_user',NULL,NULL,NULL,NULL,'44444444444444'),
  ('7d0fbeb1354e424390e2080a3d7596bd',NULL,1,'2018-05-31 15:05:08','dummy_create_user',NULL,NULL,NULL,NULL,NULL),
  ('ae5d5ea6a6fe42ccbf8aa717ac8d6936',NULL,1,'2018-05-29 17:03:21','dummy_create_user','2018-05-29 17:03:21','dummy_update_user',NULL,NULL,NULL),
  ('b7626b817c464c7b85afe97aff45633a',NULL,1,'2018-05-31 16:38:59','dummy_create_user',NULL,NULL,NULL,NULL,'3333333'),
  ('d2fa84e75df142df9ac74f1d7a2b3ebd',NULL,1,'2018-05-29 17:11:59','dummy_create_user','2018-05-29 17:11:59','dummy_update_user',NULL,NULL,'222222222'),
  ('f56f744b35584a7c887a5fc46db00d74',NULL,1,'2018-05-31 15:33:37','dummy_create_user',NULL,NULL,NULL,NULL,NULL),
  ('feb23e65b19149c8a98a032ba62ffe8f',NULL,1,'2018-06-01 18:05:50','dummy_create_user',NULL,NULL,NULL,NULL,'77777777');
COMMIT;

/* Data for the `biz_mask_h` table  (LIMIT 0,500) */

INSERT INTO `biz_mask_h` (`id`, `master_id`, `idx`, `create_date`, `create_user`, `note`) VALUES
  ('234','123',1,NULL,NULL,NULL),
  ('32ce3bc4879647d0a13039f4a77a3677','72f976d232904f918e06518669729d3d',1,'2018-05-31 18:29:02','dummy_create_user',NULL),
  ('345','123',2,NULL,NULL,NULL),
  ('39cd708ad5834d62a69faa12f265287a','26bc3f7a486d4353a69547e3e414defe',1,'2018-05-31 15:37:39','dummy_create_user',NULL),
  ('5f273c8dfea14e939c385b19c50ca473','f56f744b35584a7c887a5fc46db00d74',1,'2018-05-31 15:33:37','dummy_create_user',NULL),
  ('699d437ad0864a58b425c42dcae4f02b','39bec0aefee44b3fb9458fed48ef6c32',2,'2018-06-01 17:36:13','dummy_update_user','Update'),
  ('78b974cd65f941fa98861bd7076a64cd','02c9cfd0d4054b6f8524e2ee683140fa',1,'2018-05-29 18:33:25','dummy_create_user',NULL),
  ('a7a4a0a8ac694a3bb70293342929cbac','39bec0aefee44b3fb9458fed48ef6c32',1,'2018-05-29 17:51:32','dummy_create_user',NULL),
  ('be6baa7fd825425d90d1615120e1547a','39bec0aefee44b3fb9458fed48ef6c32',3,'2018-06-01 18:00:21','dummy_update_user','Update'),
  ('dbcfd298dca44e23b180505f0760cb04','3d1ece9d06dd49839cd02b7f398b2cbb',1,'2018-05-31 18:28:30','dummy_create_user',NULL),
  ('dcb9c7f06f114601a3ef4a442862e21e','39bec0aefee44b3fb9458fed48ef6c32',2,'2018-06-01 17:41:22','dummy_update_user','Update'),
  ('dd9768fdcfdf467b948456565283cfa0','68c2002fb8b048c08ff23774ebc157fc',1,'2018-05-31 15:40:04','dummy_create_user',NULL),
  ('e00c4bf09939492082617010247d1aff','b7626b817c464c7b85afe97aff45633a',1,'2018-05-31 16:38:59','dummy_create_user',NULL),
  ('fb0ee3e74f54450faa7d3f72a84f8504','feb23e65b19149c8a98a032ba62ffe8f',1,'2018-06-01 18:05:50','dummy_create_user','Create');
COMMIT;

/* Data for the `biz_transport_box` table  (LIMIT 0,500) */

INSERT INTO `biz_transport_box` (`id`, `name`, `curr_idx`, `create_date`, `create_user`, `update_date`, `update_user`, `lock_date`, `lock_user`, `rf_id`) VALUES
  ('cc27a55170be479f9699267562bb5b26',NULL,2,'2018-06-04 16:35:15','dummy_create_user','2018-06-04 16:36:09','dummy_update_user',NULL,NULL,'88888');
COMMIT;

/* Data for the `biz_transport_box_h` table  (LIMIT 0,500) */

INSERT INTO `biz_transport_box_h` (`id`, `master_id`, `idx`, `create_date`, `create_user`, `note`) VALUES
  ('6c07eafbf84f49c495a74131f5b12d7c','cc27a55170be479f9699267562bb5b26',1,'2018-06-04 16:35:15','dummy_create_user','Create'),
  ('cfab4c85799443cb9be10ec0c3876ec2','cc27a55170be479f9699267562bb5b26',2,'2018-06-04 16:36:09','dummy_update_user','Update');
COMMIT;

/* Data for the `databasechangeloglock` table  (LIMIT 0,500) */

INSERT INTO `databasechangeloglock` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
  (1,0,NULL,NULL);
COMMIT;

/* Data for the `sys_org` table  (LIMIT 0,500) */

INSERT INTO `sys_org` (`id`, `name`, `descr`, `type_code`, `parent_id`, `level`, `uri`) VALUES
  ('0589233752ec4eb3adafad798029b59f','CompanyB','Company B','C',NULL,1,'0589233752ec4eb3adafad798029b59f'),
  ('89fc02ca754244418693b9ebb35cf7bf','DeppartmentX','Department X, child of company B','D','eb1ddf3d125640968828034563a006d6',2,'eb1ddf3d125640968828034563a006d6/89fc02ca754244418693b9ebb35cf7bf'),
  ('eb1ddf3d125640968828034563a006d6','CompanyA','Company A','C',NULL,1,'eb1ddf3d125640968828034563a006d6');
COMMIT;

/* Data for the `sys_org_type` table  (LIMIT 0,500) */

INSERT INTO `sys_org_type` (`code`, `descr`, `parent_code`, `invalid`) VALUES
  ('C','Company',NULL,NULL),
  ('D','Department','C',NULL),
  ('G','Group','D',NULL);
COMMIT;

/* Data for the `sys_privilege` table  (LIMIT 0,500) */

INSERT INTO `sys_privilege` (`code`, `descr`, `type_code`, `composite_codes`) VALUES
  ('PRIVILEGE_001','This is the 1st trial privilege','P',NULL),
  ('PRIVILEGE_002','This is the 2nd trial privilege','P',NULL),
  ('PRIVILEGE_GROUP_001','A privilege group tester','PG',',PRIVILEGE_002,PRIVILEGE_001,');
COMMIT;

/* Data for the `sys_user` table  (LIMIT 0,500) */

INSERT INTO `sys_user` (`id`, `name`, `age`, `email`, `gender`, `password`, `org_uri`, `group_id`, `superior_id`) VALUES
  ('78142b89a6d446078a728def760c028e','UserA',23,'user-a@inesa.com','F','PwdA','eb1ddf3d125640968828034563a006d6/89fc02ca754244418693b9ebb35cf7bf','e9549c5068e54f78a9ddc4dd5e37f1f4',NULL),
  ('ec5e58a0960f49c8bf6c261e4266eaf1','UserB',21,'user.b@inesa.com','M','PwdB','eb1ddf3d125640968828034563a006d6/89fc02ca754244418693b9ebb35cf7bf','e9549c5068e54f78a9ddc4dd5e37f1f4','78142b89a6d446078a728def760c028e');
COMMIT;

/* Data for the `sys_user_group` table  (LIMIT 0,500) */

INSERT INTO `sys_user_group` (`id`, `name`, `descr`, `org_uri`) VALUES
  ('7f33cb6a92e94bd6934ce9464b722768','GroupB','Group B','eb1ddf3d125640968828034563a006d6'),
  ('e9549c5068e54f78a9ddc4dd5e37f1f4','GroupA','Group A(Updated)','eb1ddf3d125640968828034563a006d6/89fc02ca754244418693b9ebb35cf7bf');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;