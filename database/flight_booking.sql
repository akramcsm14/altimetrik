-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: flight_booking
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.16.04.1

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
-- Table structure for table `flight_info`
--

DROP TABLE IF EXISTS `flight_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_no` varchar(16) DEFAULT NULL,
  `airline_name` varchar(64) DEFAULT NULL,
  `src_city` varchar(32) DEFAULT NULL,
  `dep_time` varchar(128) DEFAULT NULL,
  `dest_city` varchar(32) DEFAULT NULL,
  `arr_time` varchar(128) DEFAULT NULL,
  `price` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_info`
--

LOCK TABLES `flight_info` WRITE;
/*!40000 ALTER TABLE `flight_info` DISABLE KEYS */;
INSERT INTO `flight_info` VALUES (1,'I-304','Indigo','BLR','06-08-2020 05:00:00 +0530','GAU','06-08-2020 08:00:00 +0530','5500'),(2,'I-344','Indigo','BLR','06-08-2020 06:00:00 +0530','GAU','06-08-2020 09:00:00 +0530','5200'),(3,'I-360','Indigo','BLR','06-08-2020 05:00:00 +0530','KOL','06-08-2020 07:30:00 +0530','4500'),(4,'I-360','Indigo','KOL','06-08-2020 09:00:00 +0530','GAU','06-08-2020 01:20:00 +0530','2000'),(5,'I-368','Indigo','GAU','09-08-2020 09:00:00 +0530','BLR','09-08-2020 12:00:00 +0530','6000'),(6,'I-368','Indigo','GAU','09-08-2020 05:00:00 +0530','KOL','09-08-2020 06:00:00 +0530','1000');
/*!40000 ALTER TABLE `flight_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-06 17:30:15
