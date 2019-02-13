--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	5.7.15

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Create some simulated data
--

LOCK TABLES `class` WRITE;
INSERT INTO `class` (`id`, `name`) VALUES (1,'一班'),(2,'二班');
UNLOCK TABLES;
