-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: churchsys
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Dumping data for table `ability`
--

LOCK TABLES `ability` WRITE;
/*!40000 ALTER TABLE `ability` DISABLE KEYS */;
INSERT INTO `ability` VALUES (1,3,1),(2,3,2),(3,3,3),(4,3,6),(5,3,7),(6,3,8),(7,3,9),(8,3,10),(9,3,11),(10,3,12),(11,3,13),(12,3,27),(13,3,28),(14,3,29),(15,3,30),(16,3,31),(17,3,32),(18,3,33),(19,3,34),(20,3,35),(21,3,36),(22,3,37),(23,3,38),(24,3,39),(25,3,40),(26,3,41),(27,3,42),(28,3,43),(29,3,44),(30,3,45),(31,3,51),(32,3,52),(33,4,1),(34,4,2),(35,4,3),(36,4,6),(37,4,7),(38,4,8),(39,4,9),(40,4,10),(41,4,11),(42,4,12),(43,4,13),(44,4,27),(45,4,28),(46,4,29),(47,4,30),(48,4,31),(49,4,32),(50,4,33),(51,4,34),(52,4,35),(53,4,36),(54,4,37),(55,4,38),(56,4,39),(57,4,40),(58,4,41),(59,4,42),(60,4,43),(61,4,44),(62,4,45),(63,4,51),(64,4,52),(65,5,1),(66,5,2),(67,5,3),(68,5,6),(69,5,7),(70,5,8),(71,5,9),(72,5,10),(73,5,11),(74,5,12),(75,5,13),(76,5,27),(77,5,28),(78,5,29),(79,5,30),(80,5,31),(81,5,32),(82,5,33),(83,5,34),(84,5,35),(85,5,36),(86,5,37),(87,5,38),(88,5,39),(89,5,40),(90,5,41),(91,5,42),(92,5,43),(93,5,44),(94,5,45),(95,5,51),(96,5,52),(97,11,1),(98,11,2),(99,11,3),(100,11,6),(101,11,7),(102,11,8),(103,11,9),(104,11,10),(105,11,11),(106,11,12),(107,11,13),(108,11,27),(109,11,28),(110,11,29),(111,11,30),(112,11,31),(113,11,32),(114,11,33),(115,11,34),(116,11,35),(117,11,36),(118,11,37),(119,11,38),(120,11,39),(121,11,40),(122,11,41),(123,11,42),(124,11,43),(125,11,44),(126,11,45),(127,12,1),(128,12,2),(129,12,3),(130,12,6),(131,12,7),(132,12,8),(133,12,9),(134,12,10),(135,12,11),(136,12,12),(137,12,13),(138,12,27),(139,12,28),(140,12,29),(141,12,30),(142,12,31),(143,12,32),(144,12,33),(145,12,34),(146,12,35),(147,12,36),(148,12,37),(149,12,38),(150,12,39),(151,12,40),(152,12,41),(153,12,42),(154,12,43),(155,12,44),(156,12,45),(157,13,1),(158,13,2),(159,13,3),(160,13,6),(161,13,7),(162,13,8),(163,13,9),(164,13,10),(165,13,11),(166,13,12),(167,13,13),(168,13,27),(169,13,28),(170,13,29),(171,13,30),(172,13,31),(173,13,32),(174,13,33),(175,13,34),(176,13,35),(177,13,36),(178,13,37),(179,13,38),(180,13,39),(181,13,40),(182,13,41),(183,13,42),(184,13,43),(185,13,44),(186,13,45),(187,14,4),(188,14,5),(189,14,20),(190,14,21),(191,14,22),(192,14,23),(193,14,24),(194,14,25),(195,14,26),(196,15,4),(197,15,5),(198,15,20),(199,15,21),(200,15,22),(201,15,23),(202,15,24),(203,15,25),(204,15,26),(205,16,1),(206,16,2),(207,16,3),(208,16,6),(209,16,7),(210,16,8),(211,16,9),(212,16,10),(213,16,11),(214,16,12),(215,16,13),(216,16,27),(217,16,28),(218,16,29),(219,16,30),(220,16,31),(221,16,32),(222,16,33),(223,16,34),(224,16,35),(225,16,36),(226,16,37),(227,16,38),(228,16,39),(229,16,40),(230,16,41),(231,16,42),(232,16,43),(233,16,44),(234,16,45),(235,17,1),(236,17,2),(237,17,3),(238,17,6),(239,17,7),(240,17,8),(241,17,9),(242,17,10),(243,17,11),(244,17,12),(245,17,13),(246,17,27),(247,17,28),(248,17,29),(249,17,30),(250,17,31),(251,17,32),(252,17,33),(253,17,34),(254,17,35),(255,17,36),(256,17,37),(257,17,38),(258,17,39),(259,17,40),(260,17,41),(261,17,42),(262,17,43),(263,17,44),(264,17,45),(265,18,1),(266,18,2),(267,18,3),(268,18,27),(269,18,28),(270,18,29),(271,18,30),(272,18,31),(273,18,32),(274,18,33),(275,18,34),(276,18,35),(277,18,36),(278,18,37),(279,18,38),(280,18,39),(281,18,40),(282,18,41),(283,18,42),(284,18,43),(285,18,44),(286,18,45),(287,19,4),(288,19,5),(289,19,20),(290,19,21),(291,19,22),(292,19,23),(293,19,24),(294,19,25),(295,19,26),(296,20,4),(297,20,5),(298,20,20),(299,20,21),(300,20,22),(301,20,23),(302,20,24),(303,20,25),(304,20,26),(305,21,1),(306,21,2),(307,21,3),(308,21,6),(309,21,7),(310,21,8),(311,21,9),(312,21,10),(313,21,11),(314,21,12),(315,21,13),(316,21,27),(317,21,28),(318,21,29),(319,21,30),(320,21,31),(321,21,32),(322,21,33),(323,21,34),(324,21,35),(325,21,36),(326,21,37),(327,21,38),(328,21,39),(329,21,40),(330,21,41),(331,21,42),(332,21,43),(333,21,44),(334,21,45),(335,22,1),(336,22,2),(337,22,3),(338,22,6),(339,22,7),(340,22,8),(341,22,9),(342,22,10),(343,22,11),(344,22,12),(345,22,13),(346,22,27),(347,22,28),(348,22,29),(349,22,30),(350,22,31),(351,22,32),(352,22,33),(353,22,34),(354,22,35),(355,22,36),(356,22,37),(357,22,38),(358,22,39),(359,22,40),(360,22,41),(361,22,42),(362,22,43),(363,22,44),(364,22,45),(365,23,1),(366,23,2),(367,23,3),(368,23,6),(369,23,7),(370,23,8),(371,23,9),(372,23,10),(373,23,11),(374,23,12),(375,23,13),(376,23,27),(377,23,28),(378,23,29),(379,23,30),(380,23,31),(381,23,32),(382,23,33),(383,23,34),(384,23,35),(385,23,36),(386,23,37),(387,23,38),(388,23,39),(389,23,40),(390,23,41),(391,23,42),(392,23,43),(393,23,44),(394,23,45),(395,24,4),(396,24,5),(397,24,20),(398,24,21),(399,24,22),(400,24,23),(401,24,24),(402,24,25),(403,24,26),(404,25,4),(405,25,5),(406,25,20),(407,25,21),(408,25,22),(409,25,23),(410,25,24),(411,25,25),(412,25,26);
/*!40000 ALTER TABLE `ability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Phụng Vụ'),(2,'Ngày lễ'),(3,'Thông báo'),(4,'Sinh hoạt'),(5,'Hoạt động'),(6,'Giáo lý người lớn'),(7,'Giáo lý dự ấu'),(8,'Giáo lí ấu nhi'),(9,'Giáo lí thiếu nhi'),(10,'Giáo lí nghĩa sĩ'),(11,'Giáo lí dự trưởng'),(12,'Liên hệ');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `church`
--

LOCK TABLES `church` WRITE;
/*!40000 ALTER TABLE `church` DISABLE KEYS */;
INSERT INTO `church` VALUES (1,'Nhà Thờ Hòa Khánh',108.152014,16.073826,'+84 236 3842 255',' 50 Nguyễn Lương Bằng, Hòa Khánh Bắc, Liên Chiểu, Đà Nẵng','giaoxuhoakhanh@gmail.com','04:00:00','21:00:00',NULL,'Tổng số tín hữu là 4.298 người, trong đó có 332 người là di dân đã đăng ký sinh hoạt cùng Giáo xứ, chưa tính hơn 50 hộ thuộc khu vực Hòa Minh chưa nhập xứ. Hiện nay, Nhà Nước đã cấp 1.300m2 đất thuộc khu vực Hòa Minh để làm ngôi nhà nguyện cho giáo dân thuộc giáo khóm 16-17-18 thuận tiện việc sinh hoạt đời sống đạo.','',''),(2,'Nhà Thờ Hòa Minh',108.171837,16.070841,'+84 236 3855 039','Phú Lộc 18, Hòa Minh, Liên Chiểu, Đà Nẵng','phucdongten@gmail.com','04:00:00','21:00:00',NULL,'Năm 2009 Cha thuyên chuyển vào Giáo xứ Tam Kỳ , Cha Fr Assisi Lưu Văn Hoàng kế nhiệm đã phát động cộng đoàn Giáo dân Hòa khánh làm hộp tiết kiệm xây dựng nhà Chúa tại Hòa Minh. Ngày 3/12/2013 lễ Thánh Phanxico Xavie , sau khi hoàn thành các thủ tục pháp lý và thiết kế lại cho phù hợp với khả năng tài chính của Giáo xứ, Cha Giuse Nguyễn Thanh Sơn ( kế nhiệm Cha Fr Assisi) đã tổ chức Lễ Khởi Công, Đức Giám Mục Giáo phận và hơn 30 Linh Mục cùng đồng tế trong Thánh lễ đặt viên đá đầu tiên.','',''),(3,'Nhà Thờ Chánh Tòa Đà Nẵng',108.223317,16.066979,'+84 236 3825 285','156 Trần Phú, Hải Châu 1, Q. Hải Châu, Đà Nẵng','chanhtoadanang@gmail.com','04:00:00','21:00:00',NULL,'Nhà thờ chính tòa Đà Nẵng là nhà thờ chính tòa của Giáo phận Đà Nẵng ở miền Trung Việt Nam, tọa lạc tại 156 đường Trần Phú, phường Hải Châu I, quận Hải Châu, thành phố Đà Nẵng. Đây là nhà thờ duy nhất được xây dựng tại Đà Nẵng thời Pháp thuộc.','','');
/*!40000 ALTER TABLE `church` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `contribution`
--

LOCK TABLES `contribution` WRITE;
/*!40000 ALTER TABLE `contribution` DISABLE KEYS */;
/*!40000 ALTER TABLE `contribution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `grave`
--

LOCK TABLES `grave` WRITE;
/*!40000 ALTER TABLE `grave` DISABLE KEYS */;
/*!40000 ALTER TABLE `grave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `graveyard`
--

LOCK TABLES `graveyard` WRITE;
/*!40000 ALTER TABLE `graveyard` DISABLE KEYS */;
/*!40000 ALTER TABLE `graveyard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `inclusion`
--

LOCK TABLES `inclusion` WRITE;
/*!40000 ALTER TABLE `inclusion` DISABLE KEYS */;
/*!40000 ALTER TABLE `inclusion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `interaction`
--

LOCK TABLES `interaction` WRITE;
/*!40000 ALTER TABLE `interaction` DISABLE KEYS */;
INSERT INTO `interaction` VALUES (1,1,3,''),(2,2,4,''),(3,3,5,''),(4,1,11,''),(5,1,12,''),(6,1,13,''),(7,1,14,''),(8,1,15,''),(9,2,16,''),(10,2,17,''),(11,2,18,''),(12,2,19,''),(13,2,20,''),(14,3,21,''),(15,3,22,''),(16,3,23,''),(17,3,24,''),(18,3,25,'');
/*!40000 ALTER TABLE `interaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'Thánh đường',1,1),(2,'Hội trường',1,1),(3,'Nhà nguyện',1,1),(4,'Phòng hài cốt',1,1),(5,'Phòng cha',1,1),(6,'101',1,1),(7,'102',1,1),(8,'103',1,1),(9,'104',1,1),(10,'105',1,1),(11,'Thánh đường',2,1),(12,'Hội trường',2,1),(13,'Nhà nguyện',2,1),(14,'Phòng hài cốt',2,1),(15,'Phòng cha',2,1),(16,'101',2,1),(17,'102',2,1),(18,'103',2,1),(19,'104',2,1),(20,'105',2,1),(21,'Thánh đường',3,1),(22,'Hội trường',3,1),(23,'Nhà nguyện',3,1),(24,'Phòng hài cốt',3,1),(25,'Phòng cha',3,1),(26,'101',3,1),(27,'102',3,1),(28,'103',3,1),(29,'104',3,1),(30,'105',3,1);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roomcapable`
--

LOCK TABLES `roomcapable` WRITE;
/*!40000 ALTER TABLE `roomcapable` DISABLE KEYS */;
INSERT INTO `roomcapable` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,5),(5,1,6),(6,1,7),(7,1,8),(8,1,9),(9,1,10),(10,1,11),(11,1,12),(12,1,13),(13,2,20),(14,2,21),(15,2,22),(16,2,23),(17,2,24),(18,2,25),(19,2,26),(20,3,2),(21,3,5),(22,4,4),(23,5,3),(24,6,20),(25,6,21),(26,6,22),(27,6,23),(28,6,24),(29,6,25),(30,6,26),(31,6,30),(32,6,31),(33,6,32),(34,6,33),(35,6,34),(36,6,35),(37,6,36),(38,6,37),(39,6,38),(40,6,39),(41,6,40),(42,6,41),(43,6,42),(44,6,43),(45,6,44),(46,6,45),(47,7,20),(48,7,21),(49,7,22),(50,7,23),(51,7,24),(52,7,25),(53,7,26),(54,7,30),(55,7,31),(56,7,32),(57,7,33),(58,7,34),(59,7,35),(60,7,36),(61,7,37),(62,7,38),(63,7,39),(64,7,40),(65,7,41),(66,7,42),(67,7,43),(68,7,44),(69,7,45),(70,8,20),(71,8,21),(72,8,22),(73,8,23),(74,8,24),(75,8,25),(76,8,26),(77,8,30),(78,8,31),(79,8,32),(80,8,33),(81,8,34),(82,8,35),(83,8,36),(84,8,37),(85,8,38),(86,8,39),(87,8,40),(88,8,41),(89,8,42),(90,8,43),(91,8,44),(92,8,45),(93,9,20),(94,9,21),(95,9,22),(96,9,23),(97,9,24),(98,9,25),(99,9,26),(100,9,30),(101,9,31),(102,9,32),(103,9,33),(104,9,34),(105,9,35),(106,9,36),(107,9,37),(108,9,38),(109,9,39),(110,9,40),(111,9,41),(112,9,42),(113,9,43),(114,9,44),(115,9,45),(116,10,20),(117,10,21),(118,10,22),(119,10,23),(120,10,24),(121,10,25),(122,10,26),(123,10,30),(124,10,31),(125,10,32),(126,10,33),(127,10,34),(128,10,35),(129,10,36),(130,10,37),(131,10,38),(132,10,39),(133,10,40),(134,10,41),(135,10,42),(136,10,43),(137,10,44),(138,10,45),(139,11,1),(140,11,2),(141,11,3),(142,11,5),(143,11,6),(144,11,7),(145,11,8),(146,11,9),(147,11,10),(148,11,11),(149,11,12),(150,11,13),(151,11,27),(152,11,28),(153,11,29),(154,12,20),(155,12,21),(156,12,22),(157,12,23),(158,12,24),(159,12,25),(160,12,26),(161,13,2),(162,13,5),(163,14,4),(164,15,3),(165,16,20),(166,16,21),(167,16,22),(168,16,23),(169,16,24),(170,16,25),(171,16,26),(172,16,30),(173,16,31),(174,16,32),(175,16,33),(176,16,34),(177,16,35),(178,16,36),(179,16,37),(180,16,38),(181,16,39),(182,16,40),(183,16,41),(184,16,42),(185,16,43),(186,16,44),(187,16,45),(188,17,20),(189,17,21),(190,17,22),(191,17,23),(192,17,24),(193,17,25),(194,17,26),(195,17,30),(196,17,31),(197,17,32),(198,17,33),(199,17,34),(200,17,35),(201,17,36),(202,17,37),(203,17,38),(204,17,39),(205,17,40),(206,17,41),(207,17,42),(208,17,43),(209,17,44),(210,17,45),(211,18,20),(212,18,21),(213,18,22),(214,18,23),(215,18,24),(216,18,25),(217,18,26),(218,18,30),(219,18,31),(220,18,32),(221,18,33),(222,18,34),(223,18,35),(224,18,36),(225,18,37),(226,18,38),(227,18,39),(228,18,40),(229,18,41),(230,18,42),(231,18,43),(232,18,44),(233,18,45),(234,19,20),(235,19,21),(236,19,22),(237,19,23),(238,19,24),(239,19,25),(240,19,26),(241,19,30),(242,19,31),(243,19,32),(244,19,33),(245,19,34),(246,19,35),(247,19,36),(248,19,37),(249,19,38),(250,19,39),(251,19,40),(252,19,41),(253,19,42),(254,19,43),(255,19,44),(256,19,45),(257,20,20),(258,20,21),(259,20,22),(260,20,23),(261,20,24),(262,20,25),(263,20,26),(264,20,30),(265,20,31),(266,20,32),(267,20,33),(268,20,34),(269,20,35),(270,20,36),(271,20,37),(272,20,38),(273,20,39),(274,20,40),(275,20,41),(276,20,42),(277,20,43),(278,20,44),(279,20,45),(280,21,1),(281,21,2),(282,21,3),(283,21,5),(284,21,6),(285,21,7),(286,21,8),(287,21,9),(288,21,10),(289,21,11),(290,21,12),(291,21,13),(292,21,27),(293,21,28),(294,21,29),(295,22,20),(296,22,21),(297,22,22),(298,22,23),(299,22,24),(300,22,25),(301,22,26),(302,23,2),(303,23,5),(304,24,4),(305,25,3),(306,26,20),(307,26,21),(308,26,22),(309,26,23),(310,26,24),(311,26,25),(312,26,26),(313,26,30),(314,26,31),(315,26,32),(316,26,33),(317,26,34),(318,26,35),(319,26,36),(320,26,37),(321,26,38),(322,26,39),(323,26,40),(324,26,41),(325,26,42),(326,26,43),(327,26,44),(328,26,45),(329,27,20),(330,27,21),(331,27,22),(332,27,23),(333,27,24),(334,27,25),(335,27,26),(336,27,30),(337,27,31),(338,27,32),(339,27,33),(340,27,34),(341,27,35),(342,27,36),(343,27,37),(344,27,38),(345,27,39),(346,27,40),(347,27,41),(348,27,42),(349,27,43),(350,27,44),(351,27,45),(352,28,20),(353,28,21),(354,28,22),(355,28,23),(356,28,24),(357,28,25),(358,28,26),(359,28,30),(360,28,31),(361,28,32),(362,28,33),(363,28,34),(364,28,35),(365,28,36),(366,28,37),(367,28,38),(368,28,39),(369,28,40),(370,28,41),(371,28,42),(372,28,43),(373,28,44),(374,28,45),(375,29,20),(376,29,21),(377,29,22),(378,29,23),(379,29,24),(380,29,25),(381,29,26),(382,29,30),(383,29,31),(384,29,32),(385,29,33),(386,29,34),(387,29,35),(388,29,36),(389,29,37),(390,29,38),(391,29,39),(392,29,40),(393,29,41),(394,29,42),(395,29,43),(396,29,44),(397,29,45),(398,30,20),(399,30,21),(400,30,22),(401,30,23),(402,30,24),(403,30,25),(404,30,26),(405,30,30),(406,30,31),(407,30,32),(408,30,33),(409,30,34),(410,30,35),(411,30,36),(412,30,37),(413,30,38),(414,30,39),(415,30,40),(416,30,41),(417,30,42),(418,30,43),(419,30,44),(420,30,45);
/*!40000 ALTER TABLE `roomcapable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `setting`
--

LOCK TABLES `setting` WRITE;
/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
INSERT INTO `setting` VALUES (4,1,0,0),(5,2,0,0),(6,3,0,0);
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `slot`
--

LOCK TABLES `slot` WRITE;
/*!40000 ALTER TABLE `slot` DISABLE KEYS */;
/*!40000 ALTER TABLE `slot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `slothour`
--

LOCK TABLES `slothour` WRITE;
/*!40000 ALTER TABLE `slothour` DISABLE KEYS */;
INSERT INTO `slothour` VALUES (1,'Slot 1','04:30:00','06:00:00'),(2,'Slot 2','06:00:00','07:30:00'),(3,'Slot 3','07:30:00','09:00:00'),(4,'Slot 4','09:00:00','10:30:00'),(5,'Slot 5','10:30:00','12:00:00'),(6,'Slot 6','12:00:00','13:30:00'),(7,'Slot 7','13:30:00','15:00:00'),(8,'Slot 8','15:00:00','16:30:00'),(9,'Slot 9','16:30:00','18:00:00'),(10,'Slot 10','18:00:00','19:30:00'),(11,'Slot 11','19:30:00','21:00:00');
/*!40000 ALTER TABLE `slothour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Thánh lễ',1),(2,'Chầu',1),(3,'Giải tội',1),(4,'Viếng mồ',1),(5,'Đọc kinh',1),(6,'Lễ Đức Mẹ Lên Trời',2),(7,'Tết Trung Thu',2),(8,'Lễ Các Thánh',2),(9,'Lễ Các Thánh Tử Đạo VN',2),(10,'Lễ Chúa Kitô Vua ',2),(11,'Lễ Đức Mẹ Vô Nhiễm Nguyên Tội ',2),(12,'Lễ Chúa Giáng Sinh',2),(13,'Lễ Thánh Gia',2),(14,'Dâng hoa',3),(15,'Từ thiện',3),(16,'Thăm viếng',3),(17,'Hành hương',3),(18,'Tiếp sức mùa thi',3),(19,'Cắm trại',3),(20,'Tập huấn kiến thức xã hội',4),(21,'Hiến máu',4),(22,'Khám chữa bệnh',4),(23,'Thuyết giảng',4),(24,'Tổ chức lễ hội',4),(25,'Hát lễ',4),(26,'Họp mặt',4),(27,'Rửa Tội',5),(28,'Hôn Phối',5),(29,'An táng',5),(30,'Hôn Nhân',6),(31,'Dự Tòng',6),(32,'Dự Ấu 1',7),(33,'Dự Ấu 2',7),(34,'Ấu Nhi 1',8),(35,'Ấu Nhi 2',8),(36,'Ấu Nhi 3',8),(37,'Thiếu Nhi 1',9),(38,'Thiếu Nhi 2',9),(39,'Thiếu Nhi 3',9),(40,'Nghĩa Sĩ 1',10),(41,'Nghĩa Sĩ 2',10),(42,'Nghĩa Sĩ 3',10),(43,'Dự Trưởng 1',11),(44,'Dự Trưởng 2',11),(45,'Dự Trưởng 3',11),(46,'Phó thác linh hồn',12),(47,'Xức Dầu',12),(48,'Trừ quỷ',12),(49,'Xin khấn',12),(50,'Xin tạ ơn',12),(51,'Liên hệ gặp cha',12),(52,'Liên hệ đóng góp',12);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'NonRepeat');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'kietta_admin','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Trần Anh Kiệt','ROLE_ADMIN','01234585756','','','','kietta@gmail.com'),(2,'hungmc_admin','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Mai Công Hưng','ROLE_ADMIN','01234585756','','','','hungmc@gmail.com'),(3,'hungmc_manager_hoakhanh','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Mai Công Hưng','ROLE_MANAGER','01234585756','Cha xứ','123 456 789','','hungmc@gmail.com'),(4,'kietta_manager_hoaminh','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Trần Anh Kiệt','ROLE_MANAGER','01234585756','Cha xứ','123 456 789','','kietta@gmail.com'),(5,'hientm_manager_chanhtoa','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Tạ Minh Hiển','ROLE_MANAGER','01234585756','Cha xứ','123 456 789','','hientm@gmail.com'),(6,'kietta_user','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Trần Anh Kiệt','ROLE_USER','01234585756','','','','kietta@gmail.com'),(7,'hungmc_user','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Mai Công Hưng','ROLE_USER','01234585756','','','','hungmc@gmail.com'),(8,'hientm_user','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Tạ Minh Hiển','ROLE_USER','01234585756','','','','hientm@gmail.com'),(9,'vongnlh_user','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Nguyễn Lê Hoài Vọng','ROLE_USER','01234585756','','','','vongnlh@gmail.com'),(10,'trungtq_user','$2a$06$C7aBJubxIU7VsZ4iu4THmeoWyAyyubcxSn1uS7P.M/p70NfR11fC2','Trần Quang Trung','ROLE_USER','01234585756','','','','trungtq@gmail.com'),(11,'kietta_priest_hoakhanh','$2a$10$4ldBApIwZWvUZ7l.VPjO/.2yyZe0.C8yQolgDQYSiJ9gNxHq.9ukO','Trần Anh Kiệt','ROLE_PRIEST','01234585756','Linh Mục','','','kietta@gmail.com'),(12,'huytg_priest_hoakhanh','$2a$10$WjJPiy3y/Q3LMzsD67q2..9A46a55qxq60O8O2CEb6l8pAImbewcO','Trần Gia Huy','ROLE_PRIEST','01234585756','Linh Mục','','','huytg@gmail.com'),(13,'hientm_priest_hoakhanh','$2a$10$y72RZM/nkqUYK/kBWvFtDefsagkQj3Cj8/YsG0mCAdRRvl4jCZFzC','Tạ Minh Hiển','ROLE_PRIEST','01234585756','Linh Mục','','','hientm@gmail.com'),(14,'vongnlh_priest_hoakhanh','$2a$10$.cw8FepX5lMuYxWv3SDdEeryYDlhGZYA0oPPY3kP7pUCOjoqqPjTO','Nguyễn Lê Hoài Vọng','ROLE_PRIEST','01234585756','Hội đoàn 1','','','vongnlh@gmail.com'),(15,'trungtq_priest_hoakhanh','$2a$10$OdbKd7YRXCSKaMmd2foqnejIfJN1AjX8hFbzFLEHmr7cGOxS6RcOG','Trần Quang Trung','ROLE_PRIEST','01234585756','Hội đoàn 2','','','trungtq@gmail.com'),(16,'kietta_priest_hoaminh','$2a$10$pqjMKQ3XTxvRfry1HjmEN.IiExbL2sbcQUMMHGct7LNLENo8IGOeC','Trần Anh Kiệt','ROLE_PRIEST','01234585756','Linh Mục','','','kietta@gmail.com'),(17,'hungmc_priest_hoaminh','$2a$10$MGs7n764gNa9M5NdpNhWceKj4GJecjGQcT7b0.GNUWMxQ5Vd2I8Sm','Mai Công Hưng','ROLE_PRIEST','01234585756','Linh Mục','','','hungmc@gmail.com'),(18,'hientm_priest_hoaminh','$2a$10$GR.zDJ0cHHEoQPvuA64q3Oo2lgHZMRY8TtaBS5H1ddnnch5q5/0YS','Tạ Minh Hiển','ROLE_PRIEST','01234585756','Linh Mục','','','hientm@gmail.com'),(19,'vongnlh_priest_hoaminh','$2a$10$lEYuG6XDSrE2cHC10QmjWeQmzHMUZ2FpfoplWeVed5HcEMVCbNjWS','Nguyễn Lê Hoài Vọng','ROLE_PRIEST','01234585756','Hội đoàn 1','','','vongnlh@gmail.com'),(20,'trungtq_priest_hoaminh','$2a$10$ImtadXfgkhklAgfKJJtt9e5cIDAhbi8vRPjMpLiomw1PxyBxq/F5a','Trần Quang Trung','ROLE_PRIEST','01234585756','Hội đoàn 2','','','trungtq@gmail.com'),(21,'ducdc_priest_chanhtoa','$2a$10$yvf9/nh8r2ZnEnEynsFba.z.4kBS/8hTKLGydTIWUtWx7CgPH5IjW','Đinh Công Đức','ROLE_PRIEST','01234585756','Linh Mục','','','ducdc@gmail.com'),(22,'hungmc_priest_chanhtoa','$2a$10$p8mkK5ZKFBVh5s/cfhgjauAInxBmPuH50JPVvJrEwr9wH0V/OoSqG','Mai Công Hưng','ROLE_PRIEST','01234585756','Linh Mục','','','hungmc@gmail.com'),(23,'tungmq_priest_chanhtoa','$2a$10$hrcPrX08xFiQ7PfiXN.smeMPdTAaRVSZKbuonNDsCWuysL8hocbKK','Mai Quế Tùng','ROLE_PRIEST','01234585756','Linh Mục','','','tungmq@gmail.com'),(24,'vongnlh_priest_chanhtoa','$2a$10$b2Rt0s7yE104FsRIUuQ/OeDKpAJvy2uEyuyaen.GytgtizeqfnpEW','Nguyễn Lê Hoài Vọng','ROLE_PRIEST','01234585756','Hội đoàn 1','','','vongnlh@gmail.com'),(25,'trungtq_priest_chanhtoa','$2a$10$.rKrXkzDHjI6lK30Y1oVYuUdFmlTHS37/Pdaz8CAmq0NF3H8.Z4c6','Trần Quang Trung','ROLE_PRIEST','01234585756','hội đoàn 2','','','trungtq@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-14  0:35:38
