CREATE DATABASE  IF NOT EXISTS `testjavadb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `testjavadb`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: testjavadb
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `workflow_id` bigint NOT NULL,
  `workflow_category_id` bigint NOT NULL,
  KEY `FK94bv46uu9ak77okjy86xstq9r` (`workflow_category_id`),
  KEY `FKoqkhicp91yehcqlm396airpfq` (`workflow_id`),
  CONSTRAINT `FK94bv46uu9ak77okjy86xstq9r` FOREIGN KEY (`workflow_category_id`) REFERENCES `workflow_category` (`id_category`),
  CONSTRAINT `FKoqkhicp91yehcqlm396airpfq` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`id_workflow`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,2);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow`
--

DROP TABLE IF EXISTS `workflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workflow` (
  `id_workflow` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id_workflow`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow`
--

LOCK TABLES `workflow` WRITE;
/*!40000 ALTER TABLE `workflow` DISABLE KEYS */;
INSERT INTO `workflow` VALUES (1,'FirstWorkFlow','WF1',2),(2,'SecondWorkFlow','WF2',5),(3,'Test ','Me',2);
/*!40000 ALTER TABLE `workflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow_category`
--

DROP TABLE IF EXISTS `workflow_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workflow_category` (
  `id_category` bigint NOT NULL AUTO_INCREMENT,
  `create_at` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `parent_category` bigint DEFAULT NULL,
  PRIMARY KEY (`id_category`),
  KEY `FKe5gqt6878rcce6pmagywq7rr4` (`parent_category`),
  CONSTRAINT `FKe5gqt6878rcce6pmagywq7rr4` FOREIGN KEY (`parent_category`) REFERENCES `workflow_category` (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow_category`
--

LOCK TABLES `workflow_category` WRITE;
/*!40000 ALTER TABLE `workflow_category` DISABLE KEYS */;
INSERT INTO `workflow_category` VALUES (1,NULL,'First Parent WorkFlow Category',NULL,'WFC1',1,NULL,NULL),(2,NULL,'First Child workflowCategory',NULL,'WFC2',5,NULL,1);
/*!40000 ALTER TABLE `workflow_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workflow_variants`
--

DROP TABLE IF EXISTS `workflow_variants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workflow_variants` (
  `other_workflows_id_workflow` bigint NOT NULL,
  `variants_id_workflow` bigint NOT NULL,
  KEY `FKpnn412ao46pqk1lyhyx0jmteb` (`variants_id_workflow`),
  KEY `FKeydnhfu9nw2ua66oxiabk5mt` (`other_workflows_id_workflow`),
  CONSTRAINT `FKeydnhfu9nw2ua66oxiabk5mt` FOREIGN KEY (`other_workflows_id_workflow`) REFERENCES `workflow` (`id_workflow`),
  CONSTRAINT `FKpnn412ao46pqk1lyhyx0jmteb` FOREIGN KEY (`variants_id_workflow`) REFERENCES `workflow` (`id_workflow`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workflow_variants`
--

LOCK TABLES `workflow_variants` WRITE;
/*!40000 ALTER TABLE `workflow_variants` DISABLE KEYS */;
INSERT INTO `workflow_variants` VALUES (2,1);
/*!40000 ALTER TABLE `workflow_variants` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-18 23:15:14
