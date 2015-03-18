-- MySQL dump 10.10
--
-- Host: localhost    Database: ProjetPOO_Adapt
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE `etudiant` (
  `EtudiantID` int(11) NOT NULL AUTO_INCREMENT,
  `Matricule` varchar(30) DEFAULT NULL,
  `Nom` varchar(30) DEFAULT NULL,
  `Prenom` varchar(30) DEFAULT NULL,
  `Date_Naissance` varchar(30) DEFAULT NULL,
  `Pays` varchar(30) DEFAULT NULL,
  `Lieu` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`EtudiantID`),
  UNIQUE KEY `Matricule` (`Matricule`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etudiant`
--


/*!40000 ALTER TABLE `etudiant` DISABLE KEYS */;
LOCK TABLES `etudiant` WRITE;
INSERT INTO `etudiant` VALUES (8,'11P321','Sammy','Youssef','22 Avril 2005','Marshall','Losten'),(10,'11P031','Porchin','Johnson','6 Juin 1954','Afghanistan','Lang'),(11,'11P934','Zafack','Billy','8 Juillet 1962','Afghanistan','Long Pan'),(13,'11P999','Ponytail','Hawkings','26 Avril 1995','Tchad','Longpan'),(14,'11P121','Samson','Preston','30 Juin 2009','les Émirats arabes unis','Sardoe'),(15,'11P909','Donna','Thomas','12 Juin 1983',' Birmanie','Bimusa'),(16,'11P034','Loki','Jesse','31 Janvier 1988','Ghana','Losena'),(18,'11P090','Alonso','Peres','7 Mai 1977',' Angola','Lynfes'),(19,'11P985','Samkung','Paula','28 Mars 1980',' Antigua-et-Barbuda ','Oril'),(20,'11P005','Dames','Peter','8 Octobre 1906',' Angola','Loping'),(21,'11P940','Lucky','Thompson','4 Mai 1902',' Allemagne','Nisac'),(22,'11P032','Poppy','Lynsha','8 Mars 1903','Guyana','Loaf'),(23,'11P233','Fountain','Jack','1 Avril 1970',' Afrique du Sud','Sultan'),(24,'11P322','Marshall','John','1 Janvier 1900',' Allemagne','Outsain'),(25,'11P323','Sawang','Nde','18 Avril 1989',' Angola','Longoo'),(26,'11P888','Angran','Hamid','6 Juillet 1906',' Angola','Golon'),(27,'11P231','Lop','Des','1 Mars 1900','Afghanistan','Okil'),(28,'11P234','sdfsdf','ffdf','1 Aout 1900','Afghanistan','saqqq'),(29,'11P543','Longus','Paul','5 Aout 1947',' Allemagne','Killen'),(30,'11P311','Alasko','Jean','1 Juin 1932',' Andorre ','Olore'),(31,'11P275','Petty','Jones','1 Avril 1998','Danemark','Jory'),(32,'11P349','Kolly','Unix','1 Avril 1900',' Allemagne','Kifs'),(33,'11P932','Ouli','Dest','1 Janvier 1900',' Algérie','dug'),(34,'11P352','Ules','Deon','1 Janvier 1900','Afghanistan','dsda'),(35,'11P181','Rexin','youn','1 Janvier 1900','Afghanistan','gg'),(36,'11P827','Sawaki','Tony','14 Mars 1971',' Algérie','Massa'),(37,'11P432','Follin','Darrelle','1 Fevrier 1904',' Allemagne','Salk'),(38,'11P150','Jones','Geoffrey','8 Juin 1981',' Allemagne','Junid');
UNLOCK TABLES;
/*!40000 ALTER TABLE `etudiant` ENABLE KEYS */;

--
-- Table structure for table `etudiantuv`
--

DROP TABLE IF EXISTS `etudiantuv`;
CREATE TABLE `etudiantuv` (
  `EtudiantUVID` int(11) NOT NULL AUTO_INCREMENT,
  `EtudiantID` int(11) DEFAULT NULL,
  `UVID` int(11) DEFAULT NULL,
  PRIMARY KEY (`EtudiantUVID`),
  KEY `EtudiantID` (`EtudiantID`),
  KEY `UVID` (`UVID`),
  CONSTRAINT `etudiantuv_ibfk_1` FOREIGN KEY (`EtudiantID`) REFERENCES `etudiant` (`EtudiantID`),
  CONSTRAINT `etudiantuv_ibfk_2` FOREIGN KEY (`UVID`) REFERENCES `uv` (`UVID`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etudiantuv`
--


/*!40000 ALTER TABLE `etudiantuv` DISABLE KEYS */;
LOCK TABLES `etudiantuv` WRITE;
INSERT INTO `etudiantuv` VALUES (17,20,3),(18,20,5),(19,21,3),(20,21,5),(21,22,2),(22,22,4),(23,23,13),(24,23,1),(25,24,4),(26,24,7),(27,25,4),(28,25,7),(29,26,4),(30,26,6),(31,26,8),(32,27,5),(33,28,1),(34,28,13),(68,10,3),(69,10,19),(70,10,21),(78,36,3),(79,36,10),(80,37,2),(81,37,7),(82,37,1),(83,37,4),(84,38,2),(85,38,5),(86,38,1),(102,8,3),(103,8,7),(104,8,5);
UNLOCK TABLES;
/*!40000 ALTER TABLE `etudiantuv` ENABLE KEYS */;

--
-- Table structure for table `uv`
--

DROP TABLE IF EXISTS `uv`;
CREATE TABLE `uv` (
  `UVID` int(11) NOT NULL AUTO_INCREMENT,
  `Code_UV` varchar(30) DEFAULT NULL,
  `Intitule_UV` varchar(60) DEFAULT NULL,
  `Nombre_Credits` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`UVID`),
  UNIQUE KEY `Code_UV` (`Code_UV`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `uv`
--


/*!40000 ALTER TABLE `uv` DISABLE KEYS */;
LOCK TABLES `uv` WRITE;
INSERT INTO `uv` VALUES (1,'HUM 313','Anglais','3'),(2,'GIF 315','Architecture Des Ordinateurs','4'),(3,'GIF 319','Base De Données Relationnelles','4'),(4,'HUM 311','Fondements De Management','3'),(5,'MAT 325','Mathematiques De Base','3'),(6,'GIF 317','Outils De Mathematiques','2'),(7,'GIF 323','Programmation Orientee Objet','3'),(8,'MAT 327','Probabilites et Statistiques','3'),(9,'GIF 321','Science De L\'information','2'),(10,'GIF 329','Systemes D\'exploitation','2'),(11,'MAT 330','Analyse Numerique','3'),(13,'GIF 332','Conception De Bases De Données','3'),(14,'GIF 336','Management II','3'),(15,'GIF 337','Programmation Orientee Objet II','3'),(17,'GIF 339','Programmation Web','3'),(18,'GIF 340','Systemes Formels','3'),(19,'HUM 341','Techniques De Communication','3'),(20,'GIF001','Mathematiques','2'),(21,'GIF545','Politique','2');
UNLOCK TABLES;
/*!40000 ALTER TABLE `uv` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

