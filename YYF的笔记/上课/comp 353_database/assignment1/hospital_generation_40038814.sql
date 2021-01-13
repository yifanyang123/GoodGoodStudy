-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: comp353_assignment1
-- ------------------------------------------------------
-- Server version	8.0.21

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

-- -----------------------------------------------------
-- Schema comp353_assignment1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `comp353_assignment1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `comp353_assignment1` ;
--
-- Table structure for table `clinic`
--

DROP TABLE IF EXISTS `clinic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinic` (
  `cid` int NOT NULL,
  `cname` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic`
--

LOCK TABLES `clinic` WRITE;
/*!40000 ALTER TABLE `clinic` DISABLE KEYS */;
INSERT INTO `clinic` VALUES (1,'montreal_hospital','montreal'),(2,'LAVAL_HOSPITAL','laval'),(3,'toronto_hospital','toronto'),(4,'west_island_hospital','West Land');
/*!40000 ALTER TABLE `clinic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consult`
--

DROP TABLE IF EXISTS `consult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consult` (
  `Patient_pid` int NOT NULL,
  `Clinic_cid` int NOT NULL,
  `Doctor_did` int NOT NULL,
  `illness` text,
  `date` date NOT NULL,
  PRIMARY KEY (`Patient_pid`,`Clinic_cid`,`Doctor_did`,`date`),
  KEY `fk_Consult_Patient1_idx` (`Patient_pid`),
  KEY `fk_Consult_Clinic1_idx` (`Clinic_cid`),
  KEY `fk_Consult_Doctor1_idx` (`Doctor_did`),
  CONSTRAINT `fk_Consult_Clinic1` FOREIGN KEY (`Clinic_cid`) REFERENCES `clinic` (`cid`),
  CONSTRAINT `fk_Consult_Doctor1` FOREIGN KEY (`Doctor_did`) REFERENCES `doctor` (`did`),
  CONSTRAINT `fk_Consult_Patient1` FOREIGN KEY (`Patient_pid`) REFERENCES `patient` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consult`
--

LOCK TABLES `consult` WRITE;
/*!40000 ALTER TABLE `consult` DISABLE KEYS */;
INSERT INTO `consult` VALUES (1555,2,123,'High Fever','2020-02-02'),(1555,3,124,'haemorrhoids','2020-05-03'),(1556,1,23,'High Fever','2020-02-02'),(1556,1,23,'heartattack','2020-02-05'),(1556,1,123,'stomachache','2020-02-01'),(1557,3,123,'High Fever','2020-02-02'),(1557,3,124,'toothache','2020-05-01'),(1557,3,124,'constipation','2020-05-02');
/*!40000 ALTER TABLE `consult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `did` int NOT NULL,
  `dname` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (23,'tom','montreal'),(123,'bryan','toronto'),(124,'Roberto','laval');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `pid` int NOT NULL,
  `pname` varchar(45) NOT NULL,
  `age` int DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1555,'KURT',20,NULL),(1556,'ALICE',20,NULL),(1557,'SMITH',20,NULL);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialization`
--

DROP TABLE IF EXISTS `specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialization` (
  `Specialization` varchar(45) NOT NULL,
  `start_date_of_specialization` date DEFAULT NULL,
  `did` int NOT NULL,
  PRIMARY KEY (`Specialization`,`did`),
  KEY `fk_Specialization_Doctor1_idx` (`did`),
  CONSTRAINT `fk_Specialization_Doctor1` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialization`
--

LOCK TABLES `specialization` WRITE;
/*!40000 ALTER TABLE `specialization` DISABLE KEYS */;
INSERT INTO `specialization` VALUES ('Pediatrician',NULL,123),('Psychiatrist',NULL,23),('Surgeon',NULL,123);
/*!40000 ALTER TABLE `specialization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `works_in`
--

DROP TABLE IF EXISTS `works_in`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `works_in` (
  `Doctor_did` int NOT NULL,
  `Clinic_cid` int NOT NULL,
  `hours_per_week` float DEFAULT NULL,
  PRIMARY KEY (`Doctor_did`,`Clinic_cid`),
  KEY `fk_Doctor_has_Clinic_Clinic1_idx` (`Clinic_cid`),
  KEY `fk_Doctor_has_Clinic_Doctor_idx` (`Doctor_did`),
  CONSTRAINT `fk_Doctor_has_Clinic_Clinic1` FOREIGN KEY (`Clinic_cid`) REFERENCES `clinic` (`cid`),
  CONSTRAINT `fk_Doctor_has_Clinic_Doctor` FOREIGN KEY (`Doctor_did`) REFERENCES `doctor` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `works_in`
--

LOCK TABLES `works_in` WRITE;
/*!40000 ALTER TABLE `works_in` DISABLE KEYS */;
INSERT INTO `works_in` VALUES (23,1,25),(23,4,25),(123,2,30),(123,3,35),(124,2,35),(124,4,35);
/*!40000 ALTER TABLE `works_in` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-19 12:19:05
