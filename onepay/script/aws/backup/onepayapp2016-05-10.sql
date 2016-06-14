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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountlogs`
--

LOCK TABLES `accountlogs` WRITE;
/*!40000 ALTER TABLE `accountlogs` DISABLE KEYS */;
INSERT INTO `accountlogs` VALUES (1,1,10,90,4,' minus for [rainasmoon@126.com] amount is [10]','2016-05-06 14:52:58'),(2,5,-10,90,4,'market transfer from [admin] to [rainasmoon@126.com] amount is [10]','2016-05-09 01:31:44'),(3,2,-12,90,3,'transfer from [15811015803] to [旧欢] amount is [12]','2016-05-10 06:47:53'),(4,1,12,105,3,'transfer from [15811015803] to [旧欢] amount is [12]','2016-05-10 06:47:53'),(5,2,-10,80,3,'transfer from [15811015803] to [15011527520] amount is [10]','2016-05-10 06:48:05'),(6,3,10,111,3,'transfer from [15811015803] to [15011527520] amount is [10]','2016-05-10 06:48:05');
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bidlogs`
--

LOCK TABLES `bidlogs` WRITE;
/*!40000 ALTER TABLE `bidlogs` DISABLE KEYS */;
INSERT INTO `bidlogs` VALUES (1,3,3,2,'2016-05-06 15:14:03'),(2,3,3,3,'2016-05-06 15:14:14'),(3,3,3,13,'2016-05-06 15:14:16'),(4,3,3,23,'2016-05-06 15:14:18'),(5,2,4,10,'2016-05-06 15:17:13'),(6,2,1,2,'2016-05-06 15:57:16'),(7,2,1,12,'2016-05-06 15:57:22'),(8,6,3,24,'2016-05-07 00:44:42'),(9,6,3,25,'2016-05-07 00:44:43');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,3,2,4,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,'2016-05-06 15:17:13'),(2,1,6,3,25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,'2016-05-10 00:00:00'),(3,1,2,1,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,'2016-05-10 00:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictures`
--

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
INSERT INTO `pictures` VALUES (1,1,'p_1_1462546546254_6026','2016-05-06 14:55:46'),(2,2,'p_2_1462546633214_2232','2016-05-06 14:57:13'),(3,3,'p_3_1462546750991_8204','2016-05-06 14:59:10'),(4,4,'p_4_1462547563645_6228','2016-05-06 15:12:43'),(5,5,'p_5_1462688855619_2082','2016-05-08 06:27:35'),(6,6,'p_6_1462691243468_7510','2016-05-08 07:07:23');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'烟一只',1,12,1,2,1,2,'2016-05-06 14:55:46',NULL,'','2016-05-06 14:55:46'),(2,'打火机一个',3,3,1,1,3,1,'2016-05-06 14:57:13',NULL,'','2016-05-06 14:57:13'),(3,'kitty糖一盒',1,25,1,6,2,2,'2016-05-09 14:59:10',NULL,'','2016-05-06 14:59:10'),(4,'洗衣机',1,10,3,2,3,2,'2016-05-06 15:12:43',1,'洗衣机一个','2016-05-06 15:12:43'),(5,'手动天然防水游泳计数器',1,1,2,2,1,1,'2016-05-08 06:27:35',10,'纯手动纯天然无动力无公害流线型防水游泳计数器','2016-05-08 06:27:35'),(6,'便宜书签',1,1,2,2,1,1,'2016-05-08 07:07:23',10,'粘性适中，小巧轻便','2016-05-08 07:07:23');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES (1,5,'手动',2,'2016-05-08 06:27:35'),(2,5,'天然',2,'2016-05-08 06:27:35'),(3,5,'防水',2,'2016-05-08 06:27:35'),(4,6,'书签',2,'2016-05-08 07:07:23'),(5,5,'system',1,'2016-05-09 01:34:08'),(6,5,'root',1,'2016-05-09 01:34:34'),(7,5,'admin',1,'2016-05-09 01:34:41'),(8,1,'80后',1,'2016-05-09 03:17:18'),(9,1,'不靠谱',1,'2016-05-09 03:17:25');
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`),
  KEY `email_2` (`email`),
  KEY `phone_2` (`phone`),
  KEY `total_amount` (`total_amount`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'rainasmoon@126.com',NULL,'glen','旧欢',0,0,0,105,10,0,0,'2016-05-06 14:51:46'),(2,NULL,'15811015803','glen',NULL,0,0,0,80,0,0,0,'2016-05-06 15:01:48'),(3,NULL,'15011527520','123456',NULL,0,0,0,111,0,0,0,'2016-05-06 15:10:45'),(4,'pay1all@126.com',NULL,'glen',NULL,0,0,0,100,0,0,0,'2016-05-06 15:54:23'),(5,'sys000@outlook.com','admin','123456','root',0,0,0,90,0,0,0,'2016-05-06 19:42:32'),(6,'402766663@qq.com',NULL,'123456',NULL,0,0,0,100,0,0,0,'2016-05-07 00:44:04'),(7,NULL,'18842343357','123456',NULL,0,0,0,100,0,0,0,'2016-05-07 06:15:51'),(8,NULL,'13699123427','820316life',NULL,0,0,0,100,0,0,0,'2016-05-07 15:20:35'),(9,NULL,'1','1',NULL,0,0,0,100,0,0,0,'2016-05-08 02:35:30');
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

-- Dump completed on 2016-05-10 10:55:23
