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
INSERT INTO `게시판` VALUES
(1,'자유게시판'),
(2,'공지사항');
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
INSERT INTO `권한` VALUES
('ROLE_ADMIN'),
('ROLE_USER');
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
  `디바이스아이디` varchar(20) NOT NULL,
  `동기화날짜` date DEFAULT NULL,
  `kg` int(11) DEFAULT NULL,
  `km` int(11) DEFAULT NULL,
  `min` int(11) DEFAULT NULL,
  `업데이트날짜` date DEFAULT NULL,
  `사용자아이디` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`디바이스아이디`),
  KEY `FK7htmy2w7a4jibd4n8cn96ogjs` (`사용자아이디`),
  CONSTRAINT `FK7htmy2w7a4jibd4n8cn96ogjs` FOREIGN KEY (`사용자아이디`) REFERENCES `사용자` (`사용자아이디`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `디바이스데이터`
--

LOCK TABLES `디바이스데이터` WRITE;
/*!40000 ALTER TABLE `디바이스데이터` DISABLE KEYS */;
INSERT INTO `디바이스데이터` VALUES
('DEV0142412957','2024-09-10',20,20,0,'2024-09-10','test2'),
('DEV0482005712','2024-09-10',0,0,0,'2024-09-12','test'),
('DEV0617570248','2024-09-10',4,0,4,'2024-09-10','dog'),
('DEV0785938029','2024-09-02',0,24,24,'2024-09-10','yami'),
('DEV0804190937','2024-09-10',0,0,0,'2024-09-10','asdasd'),
('DEV0963098947','2024-09-10',0,0,0,'2024-09-10','cat');
/*!40000 ALTER TABLE `디바이스데이터` ENABLE KEYS */;
UNLOCK TABLES;

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
('고양이',300,101,'https://i.ibb.co/vQR4X5n/1-medal.png'),
('길냥이',100,1,'https://i.ibb.co/8gdZmGH/4-medal.png'),
('유니콘',2000,1001,'https://i.ibb.co/f2hrpN6/3-medal.png'),
('인간',0,-1,'https://i.postimg.cc/LYQT420b/5-medal.png'),
('호랑이',1000,301,'https://i.ibb.co/VQt6GHH/2-medal.png');
/*!40000 ALTER TABLE `레벨` ENABLE KEYS */;
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
INSERT INTO `사용자` VALUES
('444','2024-09-02 16:29:25.923524','4444@gmail.com','여성','$2a$10$7..V2MRMKc6DKi4JDdGTDe7f7gmGpSR.l1D4PDgwUYwYeU/LnMxBe','44444','ROLE_USER'),
('admin','2024-09-06 11:02:47.645266','admin@gmail.com','여성','$2a$10$owckJxkIp7e6AddEZ9nZOeOQwTAAwSWhP4sXjCgrIwqFgFJqHaCpi','admin','ROLE_ADMIN'),
('asdasd','2024-09-10 12:47:11.100210','asd@nate.com','여성','$2a$10$47jREhM4UEXVmzKRgProqe8ygw6zCCw.zC5X7FHDv7Y9g2XfC9Biy','123','ROLE_USER'),
('asdasdasd','2024-09-10 12:48:16.399561','asd@hanmail.net','여성','$2a$10$z2VcfapnJtaA0u7LGxdk7uCHjQDnrKXroED5mPCuRFe/d8Fq6sjIi','asd','ROLE_USER'),
('cat','2024-09-10 14:17:07.185909','cat@gmail.com','여성','$2a$10$AgSnayrJMLtg/b9uufirgOXQNOEwOQfP/iKGVoH4LKYhM/SQ.7EoS','cat','ROLE_USER'),
('dog','2024-09-10 12:50:09.416971','dog@gmail.com','남성','$2a$10$abWqDF8DkA1NawuZKO.TUOYTHZ2H/p5o9MiILEM/Q6JSkf694Ugdu','dog','ROLE_USER'),
('test','2024-09-10 11:18:35.061224','test@gmail.com','여성','$2a$10$bKwbPq6gGgzcUb87k1YiAuYhg...LWNbGEY7zhDvdrAVx7TS1SQta','test','ROLE_USER'),
('test1','2024-08-30 19:13:55.901509','test1','남성','$2a$10$cdBpyrvQJmEXEPkdrN5BkerqZ06UJNcyNP/HoLYPcavgC256KJLBu','test1@gmail.com','ROLE_USER'),
('test2','2024-09-10 12:45:46.373474','test2@gmail.com','여성','$2a$10$kvqHd3HlpFUGAExXpNquwOaYsmtWBKPqBFpAWZ85DdhxDYkg9lJv2','test2','ROLE_USER'),
('test3','2024-09-02 14:27:37.360792','test3@gmail.com','남성','$2a$10$rKROptR4SIRTerWKe0b8LOuUIYxSgyrfTL5/YokU3wknmUAMpF6Xq','test3','ROLE_USER'),
('yami','2024-08-30 15:52:51.042845','야미','여성','$2a$10$6AScIoLmxmPRhSOalhiVUei/DbVfKyH71013xTiC9fQzdTq4m/vA2','yami@gmail.com','ROLE_USER'),
('테스트','2024-09-06 10:18:22.108227','테스트@gmail.com','남성','$2a$10$MCGkgYPhkvUryx0OWsAtXexDCIjGT0s0TgAuR/GmwG4wnLzwHPiee','테스트','ROLE_USER');
/*!40000 ALTER TABLE `사용자` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `사용자캐릭터`
--

DROP TABLE IF EXISTS `사용자캐릭터`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `사용자캐릭터` (
  `캐릭터닉네임` varchar(255) NOT NULL,
  `누적경험치` bigint(20) DEFAULT NULL,
  `유저체력` bigint(20) DEFAULT NULL,
  `생성날짜` date DEFAULT NULL,
  `프로필이미지` varchar(255) DEFAULT NULL,
  `보유포인트` bigint(20) DEFAULT NULL,
  `레벨명` varchar(255) DEFAULT NULL,
  `사용자아이디` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`캐릭터닉네임`),
  UNIQUE KEY `UK8hpokqlhohlnftyfwfjsj5x4e` (`사용자아이디`),
  KEY `FKpxqbd39rsfkejreya113l89w2` (`레벨명`),
  CONSTRAINT `FK3fd0hgajy1mdau0h8hm0vun2f` FOREIGN KEY (`사용자아이디`) REFERENCES `사용자` (`사용자아이디`),
  CONSTRAINT `FKpxqbd39rsfkejreya113l89w2` FOREIGN KEY (`레벨명`) REFERENCES `레벨` (`레벨명`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `사용자캐릭터`
--

LOCK TABLES `사용자캐릭터` WRITE;
/*!40000 ALTER TABLE `사용자캐릭터` DISABLE KEYS */;
INSERT INTO `사용자캐릭터` VALUES
('cat',1984,19,'2024-09-10','https://i.ibb.co/W3SfT3Y/human.png',100,'유니콘','cat'),
('yami',963,4,'2024-09-02','https://i.ibb.co/W3SfT3Y/human.png',100,'호랑이','yami'),
('개냥이',387,12,'2024-09-10','https://i.ibb.co/W3SfT3Y/human.png',100,'호랑이','dog'),
('야미',0,10,'2024-09-02','https://i.ibb.co/W3SfT3Y/human.png',100,'인간','test2'),
('테스트',100,9,'2024-09-10','https://i.ibb.co/W3SfT3Y/human.png',100,'길냥이','test');
/*!40000 ALTER TABLE `사용자캐릭터` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `아이템`
--

DROP TABLE IF EXISTS `아이템`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `아이템` (
  `아이템아이디` varchar(255) NOT NULL,
  `아이템설명` varchar(255) DEFAULT NULL,
  `아이템이름` varchar(255) DEFAULT NULL,
  `가격` int(11) DEFAULT NULL,
  PRIMARY KEY (`아이템아이디`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `아이템`
--

LOCK TABLES `아이템` WRITE;
/*!40000 ALTER TABLE `아이템` DISABLE KEYS */;
INSERT INTO `아이템` VALUES
('id_churu','츄르','Churu',10),
('id_gameShopCoin','게임샵코인','Coin',5);
/*!40000 ALTER TABLE `아이템` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `아이템소유정보`
--

DROP TABLE IF EXISTS `아이템소유정보`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `아이템소유정보` (
  `아이템소유번호` bigint(20) NOT NULL AUTO_INCREMENT,
  `개수` int(11) DEFAULT NULL,
  `캐릭터닉네임` varchar(255) DEFAULT NULL,
  `아이템아이디` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`아이템소유번호`),
  KEY `FK47cvcss18tbunj6b8aau2xx63` (`캐릭터닉네임`),
  KEY `FKp8utcxy72md88cwcc1hxhwsok` (`아이템아이디`),
  CONSTRAINT `FK47cvcss18tbunj6b8aau2xx63` FOREIGN KEY (`캐릭터닉네임`) REFERENCES `사용자캐릭터` (`캐릭터닉네임`),
  CONSTRAINT `FKp8utcxy72md88cwcc1hxhwsok` FOREIGN KEY (`아이템아이디`) REFERENCES `아이템` (`아이템아이디`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `아이템소유정보`
--

LOCK TABLES `아이템소유정보` WRITE;
/*!40000 ALTER TABLE `아이템소유정보` DISABLE KEYS */;
INSERT INTO `아이템소유정보` VALUES
(8,6,'야미','id_gameShopCoin'),
(9,7,'야미','id_churu'),
(12,3,'yami','id_churu'),
(13,3,'yami','id_gameShopCoin'),
(22,2,'테스트','id_churu'),
(23,23,'테스트','id_gameShopCoin'),
(24,20,'개냥이','id_churu'),
(25,3,'개냥이','id_gameShopCoin'),
(26,9,'cat','id_churu'),
(27,3,'cat','id_gameShopCoin');
/*!40000 ALTER TABLE `아이템소유정보` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `자유게시판`
--

LOCK TABLES `자유게시판` WRITE;
/*!40000 ALTER TABLE `자유게시판` DISABLE KEYS */;
INSERT INTO `자유게시판` VALUES
(1,'2024-09-03',NULL,'진짜 궁금함','야미가 누구에요?',1,'yami'),
(9,'2024-09-06','','운영자님 너무하신거 아닌가요? 빨리 업데이트 부탁드립니다.','NPC이름이 없는 것 같아요',1,'test'),
(12,'2024-09-06','','윙키 찾으신분?','윙키?',1,'yami'),
(14,'2024-09-06','','ㅋㅋ','오늘 ㅋㅋ 개더움 님들은 어떤가요',1,'dog'),
(15,'2024-09-06','','존맛탱','츄르 먹어보신분?',1,'dog'),
(16,'2024-09-06','','b','재밌네요 추천합니다',1,'dog'),
(17,'2024-09-06','','b','미니게임 빨리 업데이트 해주세요',1,'cat'),
(19,'2024-09-06','','선물함은 아직 구현 중 입니다','[ v0.1 ] 공지사항입니다',2,'admin'),
(20,'2024-09-06','','F입니다!','이 게임 상호작용 키가 뭔지 아세요',1,'test2'),
(21,'2024-09-06','','캐릭터 움직임 ㅋㅋ','가만히 있으면',1,'test2'),
(22,'2024-09-06','','캐릭터가 더욱 귀여워졌습니다!','[ v0.1 ] 업데이트 내용 알림',2,'admin'),
(23,'2024-09-06','','벤치프레스 모션 버그 수정했습니다!','[ v0.2 ] 업데이트 내용 알림',2,'admin'),
(24,'2024-09-06','','뭐가 업데이트 될까요? 맞춰보세요','[ v0.2 ] 공시사항 안내',2,'admin');
/*!40000 ALTER TABLE `자유게시판` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `추파test`
--

DROP TABLE IF EXISTS `추파test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `추파test` (
  `npc이름` varchar(255) NOT NULL,
  `갯수` int(11) DEFAULT NULL,
  PRIMARY KEY (`npc이름`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `추파test`
--

LOCK TABLES `추파test` WRITE;
/*!40000 ALTER TABLE `추파test` DISABLE KEYS */;
/*!40000 ALTER TABLE `추파test` ENABLE KEYS */;
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

-- Dump completed on 2024-09-12 15:10:31
