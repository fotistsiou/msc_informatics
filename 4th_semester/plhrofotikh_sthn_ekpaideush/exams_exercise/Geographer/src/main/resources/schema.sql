-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: geographer
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `answer` int NOT NULL,
  `chapter` varchar(255) NOT NULL,
  `choice` int NOT NULL,
  `option_a` varchar(255) NOT NULL,
  `option_b` varchar(255) NOT NULL,
  `option_c` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,2,'proteuouses',-1,'Το Αγρίνιο','Το Μεσολόγγι','Η Ναύπακτος','Ποια είναι η πρωτεύουσα του νομού Αιτωλοακαρνανίας;'),(2,3,'proteuouses',-1,'Η Μεγαλόπολη','Η Σπάρτη','Η Τρίπολη','Ποια είναι η πρωτεύουσα του νομού Αρκαδίας;'),(3,2,'proteuouses',-1,'Η Νάουσα','Η Βέροια','Η Αλεξάνδρεια','Ποια είναι η πρωτεύουσα του νομού Ημαθίας;'),(4,3,'proteuouses',-1,'Η Λάρισα','Η Καρδίτσα','Ο Βόλος','Ποια είναι η πρωτεύουσα του νομού Μαγνησίας;'),(5,1,'proteuouses',-1,'Το Καρπενήσι','Η Λαμία','Η Άμφισσα','Ποια είναι η πρωτεύουσα του νομού Ευρυτανίας;'),(11,2,'diamerismata_perifereies',-1,'8','9','10','Πόσα είναι τα γεωγραφικά διαμερίσματα της Ελλάδας;'),(12,1,'diamerismata_perifereies',-1,'Μακεδονία','Νότιο Αιγαίο','Δυτική Ελλάδα','Ποιο από τα παρακάτω αποτελεί γεωγραφικό διαμέρισμα;'),(13,3,'diamerismata_perifereies',-1,'Θεσσαλία','Κρήτη','Βόρειο Αιγαίο','Ποιο από τα παρακάτω δεν αποτελεί γεωγραφικό διαμέρισμα;'),(14,2,'diamerismata_perifereies',-1,'Νησιά Αιγαίου Πελάγους','Ανατολική Μακεδονία και Θράκης','Στερεά Ελλάδα','Ποιο από τα παρακάτω αποτελεί περιφέρεια;'),(15,1,'diamerismata_perifereies',-1,'Θράκη','Ήπειρος','Πελοπόννησος','Ποιο από τα παρακάτω δεν αποτελεί περιφέρεια;'),(16,3,'thalasses',-1,'Αρτεμίου','Αλμυρό','Θρακικό','Ποιο από τα παρακάτω αποτελεί πέλαγος της Ελλάδας;'),(17,2,'thalasses',-1,'Κύμης','Κρητικό','Σουνίου','Ποιο από τα παρακάτω αποτελεί πέλαγος της Ελλάδας;'),(18,1,'thalasses',-1,'Ελλάδας- Τουρκίας','Ελλάδας - Αιγύπτου','Ελλάδας - Ιταλίας','Μεταξύ ποιων χωρών βρίσκεται το Αιγαίο πέλαγος;'),(19,1,'thalasses',-1,'Ελλάδας - Ιταλίας','Ελλάδας- Τουρκίας','Ελλάδας - Αιγύπτου','Μεταξύ ποιων χωρών βρίσκεται το Ιόνιο πέλαγος;'),(20,2,'thalasses',-1,'Ελλάδας - Ιταλίας','Ελλάδας - Αιγύπτου','Ελλάδας- Τουρκίας','Μεταξύ ποιων χωρών βρίσκεται το Λιβυκό πέλαγος;'),(21,3,'nhsia',-1,'3','4','5','Πόσα είναι τα νησιωτικά συμπλέγματα της Ελλάδας;'),(22,2,'nhsia',-1,'Αιγαίο','Δωδεκάνησα','Ιόνιο','Ποιο από τα παρακάτω αποτελεί νησιωτικό σύμπλεγμα;'),(23,1,'nhsia',-1,'Λιβυκό','Κυκλάδες','Σποράδες','Ποιο από τα παρακάτω δεν αποτελεί νησιωτικό σύμπλεγμα;'),(24,2,'nhsia',-1,'Κάρπαθος','Θάσος','Πάρος','Ποιο από τα παρακάτω αποτελεί νησί του Ανατολικού Αιγαίου;'),(25,1,'nhsia',-1,'Κέρκυρα','Σκόπελος','Άνδρος','Ποιο από τα παρακάτω αποτελεί νησί των Επτανήσων;'),(26,3,'vouna',-1,'Γκιώνα','Λευκά Όρη','Όλυμπος','Ποιο είναι το ψηλότερο βουνό της Ελλάδας;'),(27,1,'vouna',-1,'Σμόλικας','Γράμμος','Βαρδούσια','Ποιο είναι το δεύτερο ψηλότερο βουνό στην Ελλάδα;'),(28,1,'vouna',-1,'Κρήτη','Στερεά Ελλάδα','Ήπειρος','Σε ποιο γεωγραφικό διαμέρισμα βρίσκεται ο Ψηλορείτης;'),(29,2,'vouna',-1,'1.407','2.407','3.407','Τι ύψος έχει ο Ταΰγετος;'),(30,2,'vouna',-1,'Μακεδονία','Στερεά Ελλάδα','Πελοπόννησο','Σε ποιο γεωγραφικό διαμέρισμα βρίσκεται ο Παρνασσός;');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `chapter` varchar(255) NOT NULL,
  `total_correct` int NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpjjrrf0483ih2cvyfmx70a16b` (`user_id`),
  CONSTRAINT `FKpjjrrf0483ih2cvyfmx70a16b` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (1,'proteuouses',5,1),(2,'proteuouses',4,1),(3,'proteuouses',3,1),(4,'proteuouses',2,1),(5,'proteuouses',1,1),(6,'proteuouses',0,1),(24,'proteuouses',2,2),(25,'proteuouses',0,1),(26,'proteuouses',2,1),(27,'proteuouses',5,4),(30,'proteuouses',2,4),(31,'proteuouses',2,4),(32,'diamerismata_perifereies',2,4),(33,'thalasses',2,4),(34,'thalasses',5,4),(35,'diamerismata_perifereies',5,1),(36,'proteuouses',5,1),(37,'thalasses',5,1),(38,'nhsia',5,1),(39,'vouna',5,1),(40,'vouna',5,1),(41,'vouna',4,1),(42,'vouna',3,1),(43,'vouna',2,1),(44,'vouna',1,1),(45,'vouna',0,1);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_STUDENT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'fotis.tsioumas@outlook.com','Φώτης','Τσιούμας','$2a$10$I.V0oN7cslZEnAu1VbN4Z.8RySrFlcgdA74RSaYuTW7.Yek9scZRm'),(2,'aspa.sideri@outlook.com','Άσπα','Σιδέρη','$2a$10$I.V0oN7cslZEnAu1VbN4Z.8RySrFlcgdA74RSaYuTW7.Yek9scZRm'),(3,'rafahlia.tsioumas@outlook.com','Ραφαηλία','Τσιούμα','$2a$10$I.V0oN7cslZEnAu1VbN4Z.8RySrFlcgdA74RSaYuTW7.Yek9scZRm'),(4,'dhmhtrhs.tsioumas@outlook.com','Δημήτρης','Τσιούμας','$2a$10$jZYFwIad8dcNIypktwu1reky1kel.pGQsEiuxsid7MeMYdrIlJik.');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,1),(3,1),(4,1);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-30 22:07:00
