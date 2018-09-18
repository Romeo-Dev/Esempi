-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: eramodb
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `lavora`
--

DROP TABLE IF EXISTS `lavora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lavora` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `mansione` varchar(500) NOT NULL DEFAULT 'Trascrittore trascrive quella pagina',
  `ID_pagna` int(11) NOT NULL,
  `ID_utente` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lavora`
--

LOCK TABLES `lavora` WRITE;
/*!40000 ALTER TABLE `lavora` DISABLE KEYS */;
/*!40000 ALTER TABLE `lavora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opera`
--

DROP TABLE IF EXISTS `opera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opera` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `titolo` varchar(50) NOT NULL,
  `autore` varchar(45) DEFAULT NULL,
  `anno` int(11) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `pagina_max` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opera`
--

LOCK TABLES `opera` WRITE;
/*!40000 ALTER TABLE `opera` DISABLE KEYS */;
INSERT INTO `opera` VALUES (1,'promessi sposi','Manzoni',1800,'commedia',2),(2,'divina commedia','Dante',1400,'romanzo',NULL),(3,'decamerone','boccaccio',1500,'novella',4);
/*!40000 ALTER TABLE `opera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagine`
--

DROP TABLE IF EXISTS `pagine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagine` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `numero_pagina` int(11) NOT NULL,
  `immagine` varchar(200) NOT NULL,
  `trascrizione` varchar(1000) DEFAULT NULL,
  `ID_opera` int(11) NOT NULL,
  `stato_immagine` varchar(10) NOT NULL DEFAULT 'sospeso',
  `stato_trascrizione` varchar(10) NOT NULL DEFAULT 'sospeso',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `immagine_UNIQUE` (`immagine`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagine`
--

LOCK TABLES `pagine` WRITE;
/*!40000 ALTER TABLE `pagine` DISABLE KEYS */;
INSERT INTO `pagine` VALUES (24,1,'C:\\Users\\loren\\Desktop\\Progetti Eclipse\\ProgettoEramo\\immagini\\promessisposi1.png','ciao',1,'accettata','sospeso'),(25,2,'C:\\Users\\loren\\Desktop\\Progetti Eclipse\\ProgettoEramo\\immagini\\promessisposi2.png','lorem ',1,'accettata','sospeso'),(26,3,'','lorem gyugyu',2,'rifiutato','accettata'),(27,4,'http\\uepunti','lorem gyugyu',2,'rifiutato','accettata'),(28,5,'http\\cicciobello','lorem gyugyu',2,'sospeso','accettata'),(29,4,'httpboccaccio','lorem gyugyu',3,'sospeso','accettata'),(30,1,'httpboccaccio\\2','lorem gyugyu',3,'sospeso','accettata'),(31,2,'http\\boccaccio\\3','lorem gyugyu',3,'sospeso','accettata'),(35,3,'http\\provatrigger','lorem gyugyu',3,'accettata','accettata'),(39,3,'C:\\Users\\loren\\Desktop\\Progetti Eclipse\\ProgettoEramo\\immagini\\promessisposi3.png',NULL,1,'sospeso','sospeso');
/*!40000 ALTER TABLE `pagine` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `checkStato_img` AFTER INSERT ON `pagine` FOR EACH ROW begin

declare _stato varchar(10);

select stato_immagine from pagine where ID=new.ID into _stato;

	if(_stato = 'sospeso') then
    insert into richiesta (descr,stato,ID_pagina) values ('immagine in sospeso','richiede validazione',new.ID);
    end if;
    if(_stato ='rifiutato') then
    insert into richiesta (descr,stato,ID_pagina) values ('immagine rifiutata','richiede revisione',new.ID);
    end if;
	
	
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `checkStato_tr` AFTER INSERT ON `pagine` FOR EACH ROW begin

declare _stato varchar(10);

select stato_trascrizione from pagine where ID=new.ID into _stato;

	if(_stato = 'sospeso') then
    insert into richiesta (descr,stato,ID_pagina) values ('trascrizione in sospeso','richiede validazione',new.ID);
    end if;
    if(_stato ='rifiutato') then
    insert into richiesta (descr,stato,ID_pagina) values ('trascrizione rifiutata','richiede revisione',new.ID);
    end if;
		
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `checkStato_imgup` AFTER UPDATE ON `pagine` FOR EACH ROW begin

declare _stato varchar(10);

select stato_immagine from pagine where ID=OLD.ID into _stato;

	if(_stato = 'sospeso') then
    insert into richiesta (descr,stato,ID_pagina) values ('immagine in sospeso','richiede validazione',OLD.ID);
    end if;
    if(_stato ='rifiutato') then
    insert into richiesta (descr,stato,ID_pagina) values ('immagine rifiutata','richiede revisione',OLD.ID);
    end if;
	
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ctrlTrascr` AFTER UPDATE ON `pagine` FOR EACH ROW begin
 
 declare _sttras varchar(10);
select stato_trascrizione from pagine where ID=OLD.ID into _sttras;

if(_sttras = 'sospeso') then
     insert into richiesta (descr,stato,ID_pagina) values ('trascrizione in sospeso','richiede validazione',OLD.ID);
    end if;
    if(_sttras ='rifiutato') then
    insert into richiesta (descr,stato,ID_pagina) values ('trascrizione  rifiutata','richiede validazione',OLD.ID);
    end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `richiesta`
--

DROP TABLE IF EXISTS `richiesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `richiesta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `descr` varchar(200) DEFAULT NULL,
  `ora_richiesta` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `stato` varchar(100) DEFAULT NULL,
  `ID_pagina` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `pagina_richiesta_idx` (`ID_pagina`),
  CONSTRAINT `pagina_richiesta` FOREIGN KEY (`ID_pagina`) REFERENCES `pagine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `richiesta`
--

LOCK TABLES `richiesta` WRITE;
/*!40000 ALTER TABLE `richiesta` DISABLE KEYS */;
INSERT INTO `richiesta` VALUES (3,'immagine in sospeso','2018-07-06 14:37:10','richiede validazione',30),(4,'immagine in sospeso','2018-07-06 14:37:46','richiede validazione',35),(5,'immagine in sospeso','2018-07-06 14:37:53','richiede validazione',31),(6,'immagine in sospeso','2018-07-06 14:41:34','richiede validazione',29),(7,'immagine in sospeso','2018-07-06 14:45:33','richiede validazione',31),(11,'immagine in sospeso','2018-07-06 14:53:29','richiede validazione',30),(19,'immagine rifiutata','2018-09-04 14:18:35','richiede revisione',26),(20,'immagine rifiutata','2018-09-04 14:18:35','richiede revisione',27),(21,'immagine in sospeso','2018-09-04 14:18:35','richiede validazione',28),(22,'immagine in sospeso','2018-09-04 14:18:35','richiede validazione',29),(23,'immagine in sospeso','2018-09-04 14:18:35','richiede validazione',30),(24,'immagine in sospeso','2018-09-04 14:18:35','richiede validazione',31),(26,'trascrizione in sospeso','2018-09-04 14:29:10','richiede validazione',24),(27,'trascrizione in sospeso','2018-09-04 14:29:10','richiede validazione',25),(28,'immagine rifiutata','2018-09-04 14:29:10','richiede revisione',26),(29,'trascrizione in sospeso','2018-09-04 14:29:10','richiede validazione',26),(30,'immagine rifiutata','2018-09-04 14:29:10','richiede revisione',27),(31,'trascrizione in sospeso','2018-09-04 14:29:10','richiede validazione',27),(32,'immagine in sospeso','2018-09-04 14:29:10','richiede validazione',28),(33,'trascrizione in sospeso','2018-09-04 14:29:10','richiede validazione',28),(34,'immagine in sospeso','2018-09-04 14:29:10','richiede validazione',29),(35,'trascrizione in sospeso','2018-09-04 14:29:10','richiede validazione',29),(36,'immagine in sospeso','2018-09-04 14:29:10','richiede validazione',30),(37,'trascrizione in sospeso','2018-09-04 14:29:10','richiede validazione',30),(38,'immagine in sospeso','2018-09-04 14:29:10','richiede validazione',31),(39,'trascrizione in sospeso','2018-09-04 14:29:10','richiede validazione',31),(40,'trascrizione in sospeso','2018-09-04 14:29:10','richiede validazione',35),(41,'immagine rifiutata','2018-09-04 14:31:06','richiede revisione',26),(42,'immagine rifiutata','2018-09-04 14:31:06','richiede revisione',27),(43,'immagine in sospeso','2018-09-04 14:31:06','richiede validazione',28),(44,'immagine in sospeso','2018-09-04 14:31:06','richiede validazione',29),(45,'immagine in sospeso','2018-09-04 14:31:06','richiede validazione',30),(46,'immagine in sospeso','2018-09-04 14:31:06','richiede validazione',31),(47,'trascrizione in sospeso','2018-09-04 14:38:10','richiede validazione',24),(48,'trascrizione in sospeso','2018-09-04 14:38:20','richiede validazione',25),(51,'immagine rifiutata','2018-09-04 15:41:25','richiede revisione',26),(52,'immagine in sospeso','2018-09-04 15:41:55','richiede validazione',39),(53,'trascrizione in sospeso','2018-09-04 15:41:55','richiede validazione',39);
/*!40000 ALTER TABLE `richiesta` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `convalide` BEFORE DELETE ON `richiesta` FOR EACH ROW BEGIN
declare _oggetto varchar(200);
declare _superid int(11);
select descr from richiesta where ID=OLD.ID into _oggetto;
select ID_pagina from richiesta where ID=OLD.ID into _superid;
		if(_oggetto like 'i%')then
        update pagine set stato_immagine='accettata' where pagine.ID=_superid;
        end if;
        if(_oggetto like 't%')then	
        update pagine set stato_trascrizione='accettata' where pagine.ID=_superid;
        end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ruolo` varchar(45) NOT NULL DEFAULT 'normale',
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `eta` int(11) NOT NULL,
  `sesso` enum('m','f') DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `livello` tinyint(5) DEFAULT NULL,
  `titolo_studio` varchar(200) DEFAULT NULL,
  `professione` varchar(45) DEFAULT NULL,
  `premium` varchar(3) NOT NULL DEFAULT 'no',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (3,'manager','romeo','dev',189,'m',NULL,'pippo',NULL,NULL,NULL,'no'),(4,'trascrittore','william','lat',18,'m',NULL,'pluto',2,NULL,NULL,'no'),(5,'trascrittore','lorenzo','iap',22,'m',NULL,'paperino',5,NULL,NULL,'si'),(6,'premium','gigino','tiap',120,'f',NULL,'topolino',NULL,NULL,NULL,'no'),(7,'normale','giorgio','merino',34,'m','giorgiomerino@gmail.com','grgmrn',NULL,'studente','studente','no'),(8,'trascrittore','giorgio','l\'altroperò',78,'m','adfv','però',2,'grerg','agr','no');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `utente_BEFORE_UPDATE` BEFORE UPDATE ON `utente` FOR EACH ROW BEGIN
declare _ruolotr varchar(45);
declare _rangeliv tinyint(5);
select ruolo from utente where ID=old.ID into _ruolotr;
select livello from utente where ID=old.ID into _rangeliv; 

	if(_ruolotr = 'tr%' and _rangeliv > 5) then
    update utente set livello=5 where ID=old.ID;
    end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `utente_AFTER_UPDATE` AFTER UPDATE ON `utente` FOR EACH ROW BEGIN
declare _ruolotr varchar(45);
declare _rangeliv tinyint(5);
declare _superid int(11);
select ruolo from utente where ID=OLD.ID into _ruolotr;
select livello from utente where ID=OLD.ID into _rangeliv; 
select ID from utente where ID=OLD.ID into _superid;
	if(_ruolotr = 'tr%' and _rangeliv > 5) then
    update utente set livello=5 where ID=_superid;
    end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `vista_trascrittori`
--

DROP TABLE IF EXISTS `vista_trascrittori`;
/*!50001 DROP VIEW IF EXISTS `vista_trascrittori`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vista_trascrittori` AS SELECT 
 1 AS `nome`,
 1 AS `cognome`,
 1 AS `email`,
 1 AS `livello`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'eramodb'
--

--
-- Dumping routines for database 'eramodb'
--
/*!50003 DROP PROCEDURE IF EXISTS `Convalida` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Convalida`(in _ID_ric int(11))
delete from richiesta where ID=_ID_ric ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GestisciTrascrittori` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GestisciTrascrittori`(in _nome varchar(45),in _passw varchar(45))
BEGIN
declare _idtr int(11);
declare _livellotr tinyint(5);

select ID from utente where nome=_nome and password=_passw into _idtr;
select livello from utente where ID=_idtr into _livellotr;

	if(_livellotr < 5) then
    update utente set livello=_livellotr + 1 where ID=_idtr;
end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserImage` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserImage`(in _titolo varchar(50),in _npag int(11),in _path varchar(200))
BEGIN
declare searchId int;
select ID from opera where titolo=_titolo into searchId;

insert into pagine (immagine,numero_pagina,ID_opera) values (_path,_npag,searchId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `loginUtente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loginUtente`(in _nome varchar(45),in _password varchar(45))
BEGIN

select * from utente where nome=_nome and utente.password=_password;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pagineDiUnOpera` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pagineDiUnOpera`(in _titolo varchar(50),in _autore varchar(45))
BEGIN
declare OPid int;
declare Maxim int;
select ID from opera where titolo=_titolo and autore=_autore into OPid;
select max(numero_pagina) from opera o join pagine p on(p.ID_opera=o.ID) where o.ID=OPid into Maxim;

update opera set pagina_max=Maxim where opera.ID=OPid;


select p.ID, p.ID_opera, p.numero_pagina, p.immagine, p.stato_immagine, p.trascrizione , p.stato_trascrizione, o.pagina_max
from opera o join pagine p on(p.ID_opera=o.ID)
where o.titolo=_titolo and o.autore=_autore
order by numero_pagina;
		
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `path_immagine` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `path_immagine`(in _titolo varchar(50), in _index int(11))
BEGIN
	select p.immagine from opera o join pagine p on (o.ID=p.ID_opera) where p.numero_pagina=_index and o.titolo=_titolo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `path_trascrizione` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `path_trascrizione`(in _titolo varchar(50), in _index int(11))
BEGIN
	select p.trascrizione from opera o join pagine p on (o.ID=p.ID_opera) where p.numero_pagina=_index and o.titolo=_titolo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrazioneUtente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrazioneUtente`(in _nome varchar(45),in _cognome varchar(45),in _eta int(11),in _sesso enum('m','f'),in _email varchar(100),in _password varchar(45),in _titoloStudio varchar(200),in _professione varchar(45))
BEGIN
insert into utente (
nome,
cognome,
eta,
sesso,
email,
password,
titolo_studio,
professione) values (
_nome,
_cognome,
_eta,
_sesso,
_email,
_password,
_titoloStudio,
_professione);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ricercaOpere` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ricercaOpere`(in _titolo varchar(50), in _autore varchar(45),in _anno int(11),in _categoria varchar(45))
SELECT o.titolo,o.autore,o.anno,o.categoria
FROM  opera as o

where  o.titolo like concat('%',_titolo,'%') or o.autore like concat('%',_autore,'%') or 
o.anno like concat('%',_anno,'%') or o.categoria like concat('%',_categoria,'%') ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `upgradePremium` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `upgradePremium`(in _nome varchar(45),in _password varchar(45))
BEGIN
declare Uid int;
select ID from utente where nome=_nome and utente.password=_password into Uid;

update utente set premium='si' where ID=Uid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `upgradeTrascrittore` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `upgradeTrascrittore`(in _nome varchar(45),in _password varchar(45))
BEGIN
declare Uid int;
select ID from utente where nome=_nome and utente.password=_password into Uid;

update utente set ruolo='trascrittore' , livello=1 where ID=Uid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vista_trascrittori`
--

/*!50001 DROP VIEW IF EXISTS `vista_trascrittori`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_trascrittori` AS select `utente`.`nome` AS `nome`,`utente`.`cognome` AS `cognome`,`utente`.`email` AS `email`,`utente`.`livello` AS `livello` from `utente` where (`utente`.`ruolo` like 'tr%') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-04 17:48:30
