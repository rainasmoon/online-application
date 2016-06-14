-- MySQL dump 10.13  Distrib 5.5.46, for Linux (x86_64)
--
-- Host: localhost    Database: onepayapp
-- ------------------------------------------------------
-- Server version	5.5.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accountlogs`
--

DROP TABLE IF EXISTS `accountlogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accountlogs` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(8) unsigned DEFAULT NULL,
  `change_amount` int(8) DEFAULT NULL,
  `balance` int(8) DEFAULT NULL,
  `account_log_type` tinyint(3) unsigned DEFAULT NULL,
  `description` varchar(600) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountlogs`
--

LOCK TABLES `accountlogs` WRITE;
/*!40000 ALTER TABLE `accountlogs` DISABLE KEYS */;
INSERT INTO `accountlogs` VALUES (1,1,10,90,4,' minus for [rainasmoon@126.com] amount is [10]','2016-05-06 14:52:58'),(2,5,-10,90,4,'market transfer from [admin] to [rainasmoon@126.com] amount is [10]','2016-05-09 01:31:44'),(3,2,-12,90,3,'transfer from [15811015803] to [旧欢] amount is [12]','2016-05-10 06:47:53'),(4,1,12,105,3,'transfer from [15811015803] to [旧欢] amount is [12]','2016-05-10 06:47:53'),(5,2,-10,80,3,'transfer from [15811015803] to [15011527520] amount is [10]','2016-05-10 06:48:05'),(6,3,10,111,3,'transfer from [15811015803] to [15011527520] amount is [10]','2016-05-10 06:48:05'),(7,10,-10,92,3,'transfer from [15901099691] to [anxuanlang@163.com] amount is [10]','2016-05-12 15:25:03'),(8,12,10,112,3,'transfer from [15901099691] to [anxuanlang@163.com] amount is [10]','2016-05-12 15:25:03'),(9,10,-10,82,3,'transfer from [15901099691] to [anxuanlang@163.com] amount is [10]','2016-05-12 15:25:13'),(10,12,10,122,3,'transfer from [15901099691] to [anxuanlang@163.com] amount is [10]','2016-05-12 15:25:13'),(11,2,-2,84,3,'transfer from [15811015803] to [15901099691] amount is [2]','2016-05-27 02:49:20'),(12,10,2,84,3,'transfer from [15811015803] to [15901099691] amount is [2]','2016-05-27 02:49:20'),(13,2,-13,71,3,'transfer from [15811015803] to [chentao3421@163.com] amount is [13]','2016-05-27 02:49:43'),(14,15,13,114,3,'transfer from [15811015803] to [chentao3421@163.com] amount is [13]','2016-05-27 02:49:43'),(15,2,-2,71,3,'transfer from [15811015803] to [15811015803] amount is [2]','2016-05-27 02:50:25'),(16,2,2,71,3,'transfer from [15811015803] to [15811015803] amount is [2]','2016-05-27 02:50:25');
/*!40000 ALTER TABLE `accountlogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bidlogs`
--

DROP TABLE IF EXISTS `bidlogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bidlogs` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(8) unsigned DEFAULT NULL,
  `product_id` int(8) unsigned DEFAULT NULL,
  `price` int(8) unsigned DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bidlogs`
--

LOCK TABLES `bidlogs` WRITE;
/*!40000 ALTER TABLE `bidlogs` DISABLE KEYS */;
INSERT INTO `bidlogs` VALUES (1,3,3,2,'2016-05-06 15:14:03'),(2,3,3,3,'2016-05-06 15:14:14'),(3,3,3,13,'2016-05-06 15:14:16'),(4,3,3,23,'2016-05-06 15:14:18'),(5,2,4,10,'2016-05-06 15:17:13'),(6,2,1,2,'2016-05-06 15:57:16'),(7,2,1,12,'2016-05-06 15:57:22'),(8,6,3,24,'2016-05-07 00:44:42'),(9,6,3,25,'2016-05-07 00:44:43'),(10,10,6,2,'2016-05-10 13:54:01'),(11,10,6,3,'2016-05-10 13:54:10'),(12,2,2,3,'2016-05-11 13:09:30'),(13,2,7,2,'2016-05-11 13:10:00'),(14,2,7,12,'2016-05-11 13:10:01'),(15,2,7,112,'2016-05-11 13:10:02'),(16,2,7,212,'2016-05-11 13:10:05'),(17,2,7,222,'2016-05-11 13:10:06'),(18,2,7,223,'2016-05-11 13:10:07'),(19,2,7,323,'2016-05-11 13:10:12'),(20,2,7,333,'2016-05-11 13:10:13'),(21,2,7,334,'2016-05-11 13:10:14'),(22,2,7,434,'2016-05-11 13:10:15'),(23,2,7,435,'2016-05-11 14:37:42'),(24,2,7,436,'2016-05-11 14:37:45'),(25,2,7,446,'2016-05-11 14:37:46'),(26,2,7,546,'2016-05-11 14:37:48'),(27,2,7,547,'2016-05-11 14:37:56'),(28,2,7,548,'2016-05-11 14:37:57'),(29,2,7,558,'2016-05-11 14:37:58'),(30,2,7,559,'2016-05-11 14:59:04'),(31,2,7,569,'2016-05-11 14:59:05'),(32,2,7,570,'2016-05-11 14:59:07'),(33,2,7,571,'2016-05-11 22:10:45'),(34,2,7,671,'2016-05-11 22:10:47'),(35,2,7,681,'2016-05-11 22:10:49'),(36,2,11,2,'2016-05-12 13:41:33'),(37,10,15,10,'2016-05-12 15:24:05'),(38,14,10,101,'2016-05-13 00:03:50'),(39,15,13,2,'2016-05-13 00:07:02'),(40,8,10,201,'2016-05-13 07:06:20'),(41,17,18,2,'2016-05-13 20:39:14'),(42,17,18,2,'2016-05-13 20:40:15'),(43,2,17,2,'2016-05-21 13:25:27'),(44,2,17,12,'2016-05-21 13:25:33'),(45,2,19,2,'2016-05-21 13:40:04'),(46,2,17,13,'2016-05-23 04:31:15'),(47,12,20,101,'2016-06-01 14:02:14'),(48,12,20,201,'2016-06-01 14:02:16'),(49,12,20,301,'2016-06-01 14:02:17'),(50,12,20,302,'2016-06-01 14:02:21'),(51,12,20,402,'2016-06-01 14:02:24'),(52,12,20,502,'2016-06-01 14:02:27');
/*!40000 ALTER TABLE `bidlogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `saler_id` int(8) unsigned DEFAULT NULL,
  `buyer_id` int(8) unsigned DEFAULT NULL,
  `product_id` int(8) unsigned DEFAULT NULL,
  `price` int(8) unsigned DEFAULT NULL,
  `sender_name` varchar(100) DEFAULT NULL,
  `sender_phone` varchar(100) DEFAULT NULL,
  `sender_address` varchar(200) DEFAULT NULL,
  `sender_postcode` varchar(100) DEFAULT NULL,
  `receiver_name` varchar(100) DEFAULT NULL,
  `receiver_phone` varchar(100) DEFAULT NULL,
  `receiver_address` varchar(200) DEFAULT NULL,
  `receiver_postcode` varchar(100) DEFAULT NULL,
  `sender_stars` tinyint(3) unsigned DEFAULT NULL,
  `receiver_stars` tinyint(3) unsigned DEFAULT NULL,
  `status` tinyint(3) unsigned DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,3,2,4,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,'2016-05-06 15:17:13'),(2,1,6,3,25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,'2016-05-10 00:00:00'),(3,1,2,1,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,'2016-05-10 00:00:00'),(4,12,10,15,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,'2016-05-12 15:24:05'),(5,1,17,18,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,'2016-05-13 20:39:10'),(6,1,17,18,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,'2016-05-13 20:39:14'),(7,2,10,6,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,'2016-05-14 00:00:00'),(8,2,2,7,681,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,'2016-05-15 00:00:00'),(9,10,2,11,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,'2016-05-16 00:00:00'),(10,8,8,10,201,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,'2016-05-17 00:00:00'),(11,12,15,13,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,'2016-05-17 00:00:00'),(12,2,2,19,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,'2016-05-25 00:00:00'),(13,15,2,17,13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,'2016-05-27 00:00:00');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pictures`
--

DROP TABLE IF EXISTS `pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pictures` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(8) unsigned DEFAULT NULL,
  `pic_path` varchar(100) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictures`
--

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
INSERT INTO `pictures` VALUES (1,1,'p_1_1462546546254_6026','2016-05-06 14:55:46'),(2,2,'p_2_1462546633214_2232','2016-05-06 14:57:13'),(3,3,'p_3_1462546750991_8204','2016-05-06 14:59:10'),(4,4,'p_4_1462547563645_6228','2016-05-06 15:12:43'),(5,5,'p_5_1462688855619_2082','2016-05-08 06:27:35'),(6,6,'p_6_1462691243468_7510','2016-05-08 07:07:23'),(7,7,'p_7_1462934487492_7207','2016-05-11 02:41:27'),(8,8,'p_8_1462944382197_9808','2016-05-11 05:26:22'),(9,9,'p_9_1462944546544_1287','2016-05-11 05:29:06'),(10,10,'p_10_1463031185218_1087','2016-05-12 05:33:05'),(11,12,'p_12_1463058595058_6329','2016-05-12 13:09:55'),(12,13,'p_13_1463059207273_4224','2016-05-12 13:20:07'),(13,14,'p_14_1463059818926_9556','2016-05-12 13:30:18'),(14,15,'p_15_1463060355078_4583','2016-05-12 13:39:15'),(15,16,'p_16_1463060436208_9633','2016-05-12 13:40:36'),(16,17,'p_17_1463132576823_6384','2016-05-13 09:42:56'),(17,18,'p_18_1463171878390_1717','2016-05-13 20:37:58'),(18,19,'p_19_1463837983030_8422','2016-05-21 13:39:43'),(19,20,'p_20_1464694488264_2487','2016-05-31 11:34:48'),(20,21,'p_21_1464786299909_6211','2016-06-01 13:04:59');
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `original_price` int(8) unsigned DEFAULT NULL,
  `price` int(8) unsigned DEFAULT NULL,
  `owner_id` int(8) unsigned DEFAULT NULL,
  `current_bider_id` int(8) unsigned DEFAULT NULL,
  `sale_model` tinyint(3) unsigned DEFAULT NULL,
  `status` tinyint(3) unsigned DEFAULT NULL,
  `end_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `aging` tinyint(3) unsigned DEFAULT NULL,
  `description` varchar(600) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'烟一只',1,12,1,2,1,2,'2016-05-06 14:55:46',NULL,'','2016-05-06 14:55:46'),(2,'打火机一个',3,3,1,1,3,1,'2016-05-06 14:57:13',NULL,'','2016-05-06 14:57:13'),(3,'kitty糖一盒',1,25,1,6,2,2,'2016-05-09 14:59:10',NULL,'','2016-05-06 14:59:10'),(4,'洗衣机',1,10,3,2,3,2,'2016-05-06 15:12:43',1,'洗衣机一个','2016-05-06 15:12:43'),(5,'手动天然防水游泳计数器',1,1,2,2,1,1,'2016-05-08 06:27:35',10,'纯手动纯天然无动力无公害流线型防水游泳计数器','2016-05-08 06:27:35'),(6,'便宜书签',1,3,2,10,1,2,'2016-05-08 07:07:23',10,'粘性适中，小巧轻便','2016-05-08 07:07:23'),(7,'小米1s',1,681,2,2,1,2,'2016-05-11 02:41:27',NULL,'','2016-05-11 02:41:27'),(8,'花印 保湿',1,1,2,2,1,1,'2016-05-11 05:26:22',NULL,'','2016-05-11 05:26:22'),(9,'冬古力照片夹',1,1,2,2,1,1,'2016-05-11 05:29:06',NULL,'','2016-05-11 05:29:06'),(10,'苹果鼠标',1,201,8,8,1,2,'2016-05-12 05:33:05',7,'买完之后一直放在书包里没怎么用，所以略有细小划痕','2016-05-12 05:33:05'),(11,'',1,2,10,2,1,2,'2016-05-12 12:48:30',NULL,'','2016-05-12 12:48:30'),(12,'纯棉T恤全新',28,28,10,10,3,1,'2016-05-12 13:09:55',9,'精美镂空绣花，适合娇小体型','2016-05-12 13:09:55'),(13,'全新自动铅笔',1,2,12,15,1,2,'2016-05-12 13:20:07',10,'笔下铅华，跃然纸上','2016-05-12 13:20:07'),(14,'熊本熊贴纸',1,1,2,2,1,1,'2016-05-12 13:30:18',NULL,'','2016-05-12 13:30:18'),(15,'优质木梳',1,10,12,10,3,2,'2016-05-12 13:39:15',9,'高髻袅娜月下生，丝缕误秋风；椅栏凝花寄归人，任的飞燕得梳去，凭相思；两风相通纱近容，青苔催浓…','2016-05-12 13:39:15'),(16,'日本原装蒸汽眼罩',1,1,2,2,1,1,'2016-05-12 13:40:36',NULL,'','2016-05-12 13:40:36'),(17,'魔方',1,13,15,2,1,2,'2016-05-13 09:42:56',6,'','2016-05-13 09:42:56'),(18,'这是一个测试商品',1,2,1,17,3,2,'2016-05-13 20:37:58',NULL,'','2016-05-13 20:37:58'),(19,'唐山',1,2,2,2,1,2,'2016-05-21 13:39:43',NULL,'','2016-05-21 13:39:43'),(20,'耳机',1,502,2,12,1,1,'2016-05-31 11:34:48',10,'全新未用','2016-05-31 11:34:48'),(21,'三联书签两枚',1,1,2,2,1,1,'2016-06-01 13:04:59',NULL,'','2016-06-01 13:04:59');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reset_password_applications`
--

DROP TABLE IF EXISTS `reset_password_applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reset_password_applications` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `login_account` varchar(100) DEFAULT NULL,
  `description` varchar(600) DEFAULT NULL,
  `password1` varchar(100) DEFAULT NULL,
  `password2` varchar(100) DEFAULT NULL,
  `password3` varchar(100) DEFAULT NULL,
  `receive_reset_email` varchar(100) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reset_password_applications`
--

LOCK TABLES `reset_password_applications` WRITE;
/*!40000 ALTER TABLE `reset_password_applications` DISABLE KEYS */;
/*!40000 ALTER TABLE `reset_password_applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tags` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `obj_id` int(8) unsigned DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `tag_type` tinyint(3) unsigned DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES (1,5,'手动',2,'2016-05-08 06:27:35'),(2,5,'天然',2,'2016-05-08 06:27:35'),(3,5,'防水',2,'2016-05-08 06:27:35'),(4,6,'书签',2,'2016-05-08 07:07:23'),(5,5,'system',1,'2016-05-09 01:34:08'),(6,5,'root',1,'2016-05-09 01:34:34'),(7,5,'admin',1,'2016-05-09 01:34:41'),(8,1,'80后',1,'2016-05-09 03:17:18'),(9,1,'不靠谱',1,'2016-05-09 03:17:25'),(10,10,'数码',2,'2016-05-12 05:33:05'),(11,10,'鼠标',2,'2016-05-12 05:33:05'),(12,9,'IT',1,'2016-05-12 13:55:21'),(13,9,'宅',1,'2016-05-12 13:55:39'),(14,20,'全新',2,'2016-05-31 11:34:48');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `nick_name` varchar(100) DEFAULT NULL,
  `sell_amount` int(8) DEFAULT NULL,
  `buy_amount` int(8) DEFAULT NULL,
  `total_amount` int(8) DEFAULT NULL,
  `account` int(8) DEFAULT NULL,
  `freeze_account` int(8) DEFAULT NULL,
  `level` tinyint(3) unsigned DEFAULT NULL,
  `credit` int(8) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_email_confirmed` tinyint(1) DEFAULT NULL,
  `is_phone_confirmed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`),
  KEY `email_2` (`email`),
  KEY `phone_2` (`phone`),
  KEY `total_amount` (`total_amount`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'rainasmoon@126.com','110','glen','旧欢',0,0,0,106,10,0,0,'2016-05-06 14:51:46',1,NULL),(2,'W040@cic.cn','15811015803','glen',NULL,0,0,0,73,0,0,0,'2016-05-06 15:01:48',1,1),(3,NULL,'15011527520','123456',NULL,0,0,0,111,0,0,0,'2016-05-06 15:10:45',1,NULL),(4,'pay1all@126.com',NULL,'glen',NULL,0,0,0,100,0,0,0,'2016-05-06 15:54:23',NULL,NULL),(5,'sys000@outlook.com','admin','123456','root',0,0,0,90,0,0,0,'2016-05-06 19:42:32',NULL,NULL),(6,'402766663@qq.com',NULL,'123456',NULL,0,0,0,100,0,0,0,'2016-05-07 00:44:04',NULL,NULL),(7,NULL,'18842343357','123456',NULL,0,0,0,100,0,0,0,'2016-05-07 06:15:51',NULL,NULL),(8,NULL,'13699123427','820316life',NULL,0,0,0,101,0,0,0,'2016-05-07 15:20:35',NULL,NULL),(9,'earnfree@126.com','1','1','悟空悟不空',0,0,0,100,0,0,0,'2016-05-08 02:35:30',NULL,NULL),(10,NULL,'15901099691','951753',NULL,0,0,0,84,0,0,0,'2016-05-10 13:53:07',NULL,NULL),(11,NULL,'18601124527','19920102',NULL,0,0,0,100,0,0,0,'2016-05-11 12:48:10',NULL,NULL),(12,'anxuanlang@163.com',NULL,'sz3093028',NULL,0,0,0,122,0,0,0,'2016-05-11 13:59:23',NULL,NULL),(13,NULL,'18500203255','123456',NULL,0,0,0,100,0,0,0,'2016-05-12 14:31:39',NULL,NULL),(14,'15336922657@163.com',NULL,'psm1234',NULL,0,0,0,100,0,0,0,'2016-05-13 00:03:34',NULL,NULL),(15,'chentao3421@163.com',NULL,'123321',NULL,0,0,0,114,0,0,0,'2016-05-13 00:05:46',NULL,NULL),(16,'tiantianqiyu@sina.com',NULL,'813871029',NULL,0,0,0,100,0,0,0,'2016-05-13 02:02:31',NULL,NULL),(17,'help@rainasmoon.com','13691300925','1',NULL,0,0,0,100,0,0,0,'2016-05-13 20:38:51',NULL,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yunorders`
--

DROP TABLE IF EXISTS `yunorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yunorders` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(8) unsigned DEFAULT NULL,
  `dealer_id` int(8) unsigned DEFAULT NULL,
  `model` tinyint(3) unsigned DEFAULT NULL,
  `trade_way` tinyint(3) unsigned DEFAULT NULL,
  `amount` int(8) unsigned DEFAULT NULL,
  `price` int(8) unsigned DEFAULT NULL,
  `status` tinyint(3) unsigned DEFAULT NULL,
  `verify_code` varchar(100) DEFAULT NULL,
  `description` varchar(600) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yunorders`
--

LOCK TABLES `yunorders` WRITE;
/*!40000 ALTER TABLE `yunorders` DISABLE KEYS */;
INSERT INTO `yunorders` VALUES (1,1,5,1,NULL,10,10,4,NULL,'','2016-05-06 14:52:38'),(2,1,NULL,2,NULL,10,10,2,NULL,'','2016-05-06 14:52:57'),(3,2,NULL,1,NULL,10,10,2,NULL,'','2016-05-10 06:49:10');
/*!40000 ALTER TABLE `yunorders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-01 14:40:32
