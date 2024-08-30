-- MariaDB dump 10.19  Distrib 10.11.7-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: pocat_rushdb
-- ------------------------------------------------------
-- Server version	10.11.7-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `레벨`
--

DROP TABLE IF EXISTS `레벨`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `레벨` (
  `레벨명` varchar(255) NOT NULL,
  `레벨업필요경험치상한선` bigint(20) DEFAULT NULL,
  `레벨업필요경험치하한선` bigint(20) DEFAULT NULL,
  `메달이미지` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`레벨명`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `레벨`
--

LOCK TABLES `레벨` WRITE;
/*!40000 ALTER TABLE `레벨` DISABLE KEYS */;
INSERT INTO `레벨` VALUES
('고양이',300,2,'https://i.ibb.co/vQR4X5n/1-medal.png'),
('유니콘',2000,1001,'https://i.ibb.co/f2hrpN6/3-medal.png'),
('인간',1,0,'https://i.ibb.co/8gdZmGH/4-medal.png'),
('호랑이',1000,301,'https://i.ibb.co/VQt6GHH/2-medal.png');
/*!40000 ALTER TABLE `레벨` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-30 15:32:14
