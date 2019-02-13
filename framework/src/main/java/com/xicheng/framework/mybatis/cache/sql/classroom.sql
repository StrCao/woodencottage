--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	5.7.15

--
-- Table structure for table `classroom`
--
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Create some simulated data
--
LOCK TABLES `classroom` WRITE;
INSERT INTO `classroom` (`id`, `class_id`, `student_id`) VALUES (1,1,1),(2,1,2),(3,2,3),(4,2,4);
UNLOCK TABLES;

