-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 12 mars 2020 à 19:29
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

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
CREATE DATABASE IF NOT EXISTS `application_ppe` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `application_ppe`;

-- --------------------------------------------------------

--
-- Structure de la table `appartient`
--

DROP TABLE IF EXISTS `appartient`;
CREATE TABLE IF NOT EXISTS `appartient` (
  `IdNum` int(11) NOT NULL,
  `IdLigue` int(11) NOT NULL,
  PRIMARY KEY (`IdNum`,`IdLigue`),
  KEY `IdLigue` (`IdLigue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `IdEmploye` int(255) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Mail` varchar(255) NOT NULL,
  `Mdp` varchar(255) NOT NULL,
  `DateArrive` date NOT NULL,
  `DateDepart` date DEFAULT NULL,
  `Level` int(255) NOT NULL,
  PRIMARY KEY (`IdEmploye`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ligue`
--

DROP TABLE IF EXISTS `ligue`;
CREATE TABLE IF NOT EXISTS `ligue` (
  `IdLigue` int(255) NOT NULL AUTO_INCREMENT,
  `NomLigue` varchar(255) NOT NULL,
  PRIMARY KEY (`IdLigue`)
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
--
-- Base de données :  `article`
--
CREATE DATABASE IF NOT EXISTS `article` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `article`;

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `id_post` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `contenu` longtext NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_post`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `post`
--

INSERT INTO `post` (`id_post`, `titre`, `contenu`, `date_creation`, `date_modification`) VALUES
(1, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 10:19:31'),
(2, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 10:39:56'),
(3, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 10:40:01'),
(4, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:03:22'),
(5, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:10:00'),
(6, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:10:41'),
(7, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:10:50'),
(8, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:11:35'),
(9, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:11:41'),
(10, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:11:46'),
(11, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:11:59'),
(12, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:13:37'),
(13, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:17:02'),
(14, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:23:01'),
(15, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:24:12'),
(16, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:39:26'),
(17, 'test', 'test', '2020-01-30 00:00:00', '2020-01-30 11:39:59'),
(18, 'zoro', 'le meilleur', '2020-02-06 00:00:00', '2020-02-06 14:17:25'),
(19, 'zoro', 'le meilleur', '2020-02-06 00:00:00', '2020-02-06 14:28:20'),
(20, 'zoro', 'le meilleur', '2020-02-06 00:00:00', '2020-02-06 14:30:16'),
(21, 'zoro', 'le meilleur', '2020-02-06 00:00:00', '2020-02-06 14:30:45'),
(22, 'test', 'Ici le contenu...', '2020-02-06 00:00:00', '2020-02-06 14:30:51');
--
-- Base de données :  `cine`
--
CREATE DATABASE IF NOT EXISTS `cine` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cine`;

-- --------------------------------------------------------

--
-- Structure de la table `sorties`
--

DROP TABLE IF EXISTS `sorties`;
CREATE TABLE IF NOT EXISTS `sorties` (
  `id_films` int(255) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `realisateur` varchar(255) NOT NULL,
  `acteurs` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `story` longtext NOT NULL,
  `afficher` varchar(255) NOT NULL,
  `date` year(4) NOT NULL,
  PRIMARY KEY (`id_films`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sorties`
--

INSERT INTO `sorties` (`id_films`, `titre`, `realisateur`, `acteurs`, `genre`, `story`, `afficher`, `date`) VALUES
(1, 'Captain America: Civil War', 'Anthony Russo, Joe Russo', 'Chris Evans, Robert Downey Jr., Scarlett Johansson', 'Action, Fantastique', 'Steve Rogers est désormais à la tête des Avengers, dont la mission est de protéger l’humanité. À la suite d’une de leurs interventions qui a causé d’importants dégâts collatéraux, le gouvernement décide de mettre en place un organisme de commandement et de supervision... ', 'img/182814.jpg', 2016),
(2, '20 Green Room', 'Jeremy Saulnier', 'Anton Yelchin, Imogen Poots, Patrick Stewart', 'Thriller , Action', 'Après avoir assisté à un acte de violence horrible, un jeune groupe de punk rock se retrouve piégé dans un lieu isolé. Pour survivre, ils vont devoir lutter contre une bande de skinheads bien décidés à éliminer tous les témoins.', 'img/310812.jpg', 2016);
--
-- Base de données :  `ecole`
--
CREATE DATABASE IF NOT EXISTS `ecole` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ecole`;

-- --------------------------------------------------------

--
-- Structure de la table `eleves`
--

DROP TABLE IF EXISTS `eleves`;
CREATE TABLE IF NOT EXISTS `eleves` (
  `id_eleve` int(11) NOT NULL AUTO_INCREMENT,
  `cursus` varchar(120) NOT NULL,
  `campus` varchar(120) NOT NULL,
  `niveau` varchar(120) NOT NULL,
  `formation` varchar(120) NOT NULL,
  `nom` varchar(120) NOT NULL,
  `prenom` varchar(120) NOT NULL,
  `telephone` int(32) NOT NULL,
  `mail` varchar(120) NOT NULL,
  `etudes` varchar(120) NOT NULL,
  PRIMARY KEY (`id_eleve`),
  UNIQUE KEY `mail` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Base de données :  `eleve`
--
CREATE DATABASE IF NOT EXISTS `eleve` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `eleve`;

-- --------------------------------------------------------

--
-- Structure de la table `classement`
--

DROP TABLE IF EXISTS `classement`;
CREATE TABLE IF NOT EXISTS `classement` (
  `id_classement` int(255) NOT NULL AUTO_INCREMENT,
  `langage` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id_classement`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classement`
--

INSERT INTO `classement` (`id_classement`, `langage`, `type`) VALUES
(1, 'Python', 'Web & Application'),
(2, 'C++', 'Application'),
(3, 'Node js', 'Web & Application'),
(4, 'PHP', 'Web & Application');

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
--
-- Base de données :  `ppeparking`
--
CREATE DATABASE IF NOT EXISTS `ppeparking` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ppeparking`;

-- --------------------------------------------------------

--
-- Structure de la table `date`
--

DROP TABLE IF EXISTS `date`;
CREATE TABLE IF NOT EXISTS `date` (
  `date` time NOT NULL,
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `place`
--

DROP TABLE IF EXISTS `place`;
CREATE TABLE IF NOT EXISTS `place` (
  `id_place` int(11) NOT NULL AUTO_INCREMENT,
  `datereservation` date DEFAULT NULL,
  PRIMARY KEY (`id_place`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `place`
--

INSERT INTO `place` (`id_place`, `datereservation`) VALUES
(1, NULL),
(2, NULL),
(3, NULL),
(4, NULL),
(5, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `reserver`
--

DROP TABLE IF EXISTS `reserver`;
CREATE TABLE IF NOT EXISTS `reserver` (
  `id_user` int(11) NOT NULL,
  `id_place` int(11) NOT NULL,
  `date` time NOT NULL,
  PRIMARY KEY (`id_user`,`id_place`,`date`),
  KEY `Reserver_Place0_FK` (`id_place`),
  KEY `Reserver_Date1_FK` (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `admin` varchar(150) DEFAULT NULL,
  `mdp` varchar(150) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `nom`, `email`, `admin`, `mdp`) VALUES
(1, 'toto', 'afaaga@gagaga.com', NULL, 'azerty'),
(2, 'azerty', 'toto@dede.com', NULL, 'test'),
(4, 'azerty', '113@afaf.com', NULL, 'wxcvb'),
(8, 'test', 'toto@gmail.com', NULL, 'test'),
(10, 'test', 'azfazfretg@goazfr.com', NULL, 'qsd'),
(11, 'test2', 'test2@ga.com', NULL, 'tes2'),
(12, 'toto', 'toto@hotmail.com', NULL, '12345');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reserver`
--
ALTER TABLE `reserver`
  ADD CONSTRAINT `Reserver_Date1_FK` FOREIGN KEY (`date`) REFERENCES `date` (`date`),
  ADD CONSTRAINT `Reserver_Place0_FK` FOREIGN KEY (`id_place`) REFERENCES `place` (`id_place`),
  ADD CONSTRAINT `Reserver_User_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
--
-- Base de données :  `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

-- --------------------------------------------------------

--
-- Structure de la table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
--
-- Base de données :  `user`
--
CREATE DATABASE IF NOT EXISTS `user` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `user`;

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `NOM` varchar(150) NOT NULL,
  `MOYENNE` int(150) NOT NULL,
  `ID` int(150) NOT NULL,
  `CLASSE` int(150) NOT NULL,
  `PRENOM` varchar(150) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
