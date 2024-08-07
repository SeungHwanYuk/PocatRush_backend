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
-- Table structure for table `게시판`
--

DROP TABLE IF EXISTS `게시판`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `게시판` (
  `게시판번호` bigint(20) NOT NULL,
  `게시판이름` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`게시판번호`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `게시판`
--

LOCK TABLES `게시판` WRITE;
/*!40000 ALTER TABLE `게시판` DISABLE KEYS */;
/*!40000 ALTER TABLE `게시판` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `권한`
--

DROP TABLE IF EXISTS `권한`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `권한` (
  `권한명` varchar(255) NOT NULL,
  PRIMARY KEY (`권한명`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `권한`
--

LOCK TABLES `권한` WRITE;
/*!40000 ALTER TABLE `권한` DISABLE KEYS */;
/*!40000 ALTER TABLE `권한` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `댓글`
--

DROP TABLE IF EXISTS `댓글`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `댓글` (
  `댓글번호` bigint(20) NOT NULL AUTO_INCREMENT,
  `댓글등록일` date DEFAULT NULL,
  `댓글내용` varchar(255) DEFAULT NULL,
  `게시글번호` bigint(20) DEFAULT NULL,
  `사용자아이디` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`댓글번호`),
  KEY `FKcbbp5bkk4q8ny9l1x1tvx6c5p` (`게시글번호`),
  KEY `FKc9qulq3uk744owm8vmeidfps5` (`사용자아이디`),
  CONSTRAINT `FKc9qulq3uk744owm8vmeidfps5` FOREIGN KEY (`사용자아이디`) REFERENCES `사용자` (`사용자아이디`),
  CONSTRAINT `FKcbbp5bkk4q8ny9l1x1tvx6c5p` FOREIGN KEY (`게시글번호`) REFERENCES `자유게시판` (`게시글번호`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `댓글`
--

LOCK TABLES `댓글` WRITE;
/*!40000 ALTER TABLE `댓글` DISABLE KEYS */;
/*!40000 ALTER TABLE `댓글` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `디바이스데이터`
--

DROP TABLE IF EXISTS `디바이스데이터`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `디바이스데이터` (
  `디바이스번호` varchar(255) NOT NULL,
  `kg` varchar(255) DEFAULT NULL,
  `km` varchar(255) DEFAULT NULL,
  `min` varchar(255) DEFAULT NULL,
  `사용자아이디` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`디바이스번호`),
  KEY `FK7htmy2w7a4jibd4n8cn96ogjs` (`사용자아이디`),
  CONSTRAINT `FK7htmy2w7a4jibd4n8cn96ogjs` FOREIGN KEY (`사용자아이디`) REFERENCES `사용자` (`사용자아이디`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `디바이스데이터`
--

LOCK TABLES `디바이스데이터` WRITE;
/*!40000 ALTER TABLE `디바이스데이터` DISABLE KEYS */;
/*!40000 ALTER TABLE `디바이스데이터` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `사용자`
--

DROP TABLE IF EXISTS `사용자`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `사용자` (
  `사용자아이디` varchar(255) NOT NULL,
  `계정생성날짜` datetime(6) DEFAULT NULL,
  `이메일` varchar(255) DEFAULT NULL,
  `성별` varchar(255) DEFAULT NULL,
  `비밀번호` varchar(255) DEFAULT NULL,
  `사용자이름` varchar(255) DEFAULT NULL,
  `권한명` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`사용자아이디`),
  KEY `FKe2762p88f733b1yk7qk2gi712` (`권한명`),
  CONSTRAINT `FKe2762p88f733b1yk7qk2gi712` FOREIGN KEY (`권한명`) REFERENCES `권한` (`권한명`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `사용자`
--

LOCK TABLES `사용자` WRITE;
/*!40000 ALTER TABLE `사용자` DISABLE KEYS */;
/*!40000 ALTER TABLE `사용자` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `자유게시판`
--

DROP TABLE IF EXISTS `자유게시판`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `자유게시판` (
  `게시글번호` bigint(20) NOT NULL AUTO_INCREMENT,
  `등록일자` date DEFAULT NULL,
  `이미지` varchar(255) DEFAULT NULL,
  `글내용` varchar(255) DEFAULT NULL,
  `글제목` varchar(255) DEFAULT NULL,
  `게시판번호` bigint(20) DEFAULT NULL,
  `사용자아이디` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`게시글번호`),
  KEY `FKgew26ixnofd1t2a6ari2n1no4` (`게시판번호`),
  KEY `FK2oh0ybeg2h5cpx1rdr0nhd84r` (`사용자아이디`),
  CONSTRAINT `FK2oh0ybeg2h5cpx1rdr0nhd84r` FOREIGN KEY (`사용자아이디`) REFERENCES `사용자` (`사용자아이디`),
  CONSTRAINT `FKgew26ixnofd1t2a6ari2n1no4` FOREIGN KEY (`게시판번호`) REFERENCES `게시판` (`게시판번호`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `자유게시판`
--

LOCK TABLES `자유게시판` WRITE;
/*!40000 ALTER TABLE `자유게시판` DISABLE KEYS */;
/*!40000 ALTER TABLE `자유게시판` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pocat_rushdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-06 17:18:01
