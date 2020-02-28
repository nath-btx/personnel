-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 28 fév. 2020 à 08:11
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10
 
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";
 
 
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
 
--
-- Base de données :  `application_ppe`
--
 
-- --------------------------------------------------------
 
--
-- Structure de la table `appartient`
--
 
DROP TABLE IF EXISTS `appartient`;
CREATE TABLE IF NOT EXISTS `appartient` (
  `IdNum` int(11) NOT NULL,
  `IdLigue` int(11) NOT NULL,
  PRIMARY KEY (`IdNum`,`IdLigue`),
  KEY `IdLigue` (`IdLigue`),
  KEY `IdNum` (`IdNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
--
-- Contraintes pour les tables déchargées
--
 
--
-- Contraintes pour la table `appartient`
--
ALTER TABLE `appartient`
  ADD CONSTRAINT `appartient_ibfk_1` FOREIGN KEY (`IdLigue`) REFERENCES `ligue` (`IdLigue`),
  ADD CONSTRAINT `appartient_ibfk_2` FOREIGN KEY (`IdNum`) REFERENCES `employe` (`IdEmploye`);
COMMIT;
 
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;