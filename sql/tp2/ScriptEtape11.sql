-- phpMyAdmin SQL Dump


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `mezabi`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE `articles` (
  `ID_ARTICLE` int(11) NOT NULL,
  `CODE_ARTICLE` varchar(15) NOT NULL,
  `DESIGNATION` varchar(30) NOT NULL,
  `CATEGORIE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `articles`
--

INSERT INTO `articles` (`ID_ARTICLE`, `CODE_ARTICLE`, `DESIGNATION`, `CATEGORIE`) VALUES
(1, 'PL001', 'Pantalon Sport', 1),
(2, 'JL001', 'Jean', 1),
(3, 'P001', 'Pull Col roulé', 4),
(4, 'P002', 'Pull Col V', 4),
(5, 'R003', 'Robe Printemps', 5),
(6, 'PZIZGAG', 'Pull Col Rond', 4),
(7, 'PV', 'Pull Col V', 4),
(8, 'VSTCOS', 'Veste costume', 2),
(9, 'JPE', 'Jupe Tube', 6),
(10, 'VSPORT', 'Veste Sportswear', 2),
(11, 'TSBATMAN', 'Tee-shirt Batman', 3),
(12, 'TSUPER', 'Tee-shirt Superman', 3);

-- --------------------------------------------------------

--
-- Structure de la table `a_categories`
--

CREATE TABLE `a_categories` (
  `CODE_CATEGORIE` int(11) NOT NULL,
  `DESIGNATION` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `a_categories`
--

INSERT INTO `a_categories` (`CODE_CATEGORIE`, `DESIGNATION`) VALUES
(1, 'Pantalons'),
(2, 'Vestes'),
(3, 'Tee-Shirt'),
(4, 'Pull'),
(5, 'Robe'),
(6, 'Jupe');

-- --------------------------------------------------------

--
-- Structure de la table `a_couleurs`
--

CREATE TABLE `a_couleurs` (
  `CODE_COULEUR` int(11) NOT NULL,
  `DESIGNATION` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `a_couleurs`
--

INSERT INTO `a_couleurs` (`CODE_COULEUR`, `DESIGNATION`) VALUES
(1, 'Rouge'),
(2, 'Vert'),
(3, 'Bleu'),
(4, 'Noir'),
(5, 'Jaune'),
(6, 'Rose'),
(7, 'Marron'),
(8, 'Blanc');

-- --------------------------------------------------------

--
-- Structure de la table `a_tailles`
--

CREATE TABLE `a_tailles` (
  `CODE_TAILLE` int(11) NOT NULL,
  `DESIGNATION` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `a_tailles`
--

INSERT INTO `a_tailles` (`CODE_TAILLE`, `DESIGNATION`) VALUES
(1, 'XS'),
(2, 'S'),
(3, 'M'),
(4, 'L'),
(5, 'XL'),
(6, '2XL');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `ID_CLIENT` int(11) NOT NULL,
  `CODE_CLIENT` varchar(15) NOT NULL,
  `NOM_MAGASIN` varchar(35) NOT NULL,
  `ADRESSE_1` varchar(35) NOT NULL,
  `ADRESSE_2` varchar(35) NOT NULL,
  `CODE_POSTAL` varchar(5) NOT NULL,
  `VILLE` varchar(35) NOT NULL,
  `RESPONSABLE` varchar(35) NOT NULL,
  `TELEPHONE` varchar(10) NOT NULL,
  `EMAIL` varchar(35) NOT NULL,
  `TYPE_CLIENT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `clients`
--

INSERT INTO `clients` (`ID_CLIENT`, `CODE_CLIENT`, `NOM_MAGASIN`, `ADRESSE_1`, `ADRESSE_2`, `CODE_POSTAL`, `VILLE`, `RESPONSABLE`, `TELEPHONE`, `EMAIL`, `TYPE_CLIENT`) VALUES
(1, 'CPV', 'VET ONLINE', 'ZA Bel Air', 'Impasse de la tour', '12000', 'Rodez', 'M. Vetman', '0565656565', 'vetonline@vet.com', 4),
(2, 'DZ', 'DumontZhabits', '33 Rue de bonald', '', '12000', 'Rodez', 'M. Dumont Pierre', '0565656565', 'dumont@orange.fr', 1),
(3, 'SUPERU12', 'SUPER U ONET', 'Route de Rodez', '', '12850', 'Onet Le Chateau', 'M. le directeur', '0565656565', 'superu@orange.com', 2),
(4, 'AMBU12', 'Le Marché qui va bien', '125 Rue des coquelicots', '', '12850', 'Sainte Radegonde', 'M. Durant Paul', '0565656565', 'vendeurZ@orange.com', 3);

-- --------------------------------------------------------

--
-- Structure de la table `c_types`
--

CREATE TABLE `c_types` (
  `CODE_TYPE` int(11) NOT NULL,
  `DESIGNATION` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `c_types`
--

INSERT INTO `c_types` (`CODE_TYPE`, `DESIGNATION`) VALUES
(1, 'Centre Ville'),
(2, 'Supermarché'),
(3, 'Vendeur Marché'),
(4, 'VPC');

-- --------------------------------------------------------

--
-- Structure de la table `devis_entetes`
--

CREATE TABLE `devis_entetes` (
  `ID_ENT_DEV` int(11) NOT NULL,
  `NO_DEVIS` int(11) NOT NULL,
  `CLIENT` int(11) NOT NULL,
  `DATE_DEVIS` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `devis_entetes`
--

INSERT INTO `devis_entetes` (`ID_ENT_DEV`, `NO_DEVIS`, `CLIENT`, `DATE_DEVIS`) VALUES
(1, 202201, 1, '2022-09-01'),
(2, 202202, 2, '2022-09-02');

-- --------------------------------------------------------

--
-- Structure de la table `devis_lignes`
--

CREATE TABLE `devis_lignes` (
  `ID_LIG_DEV` int(11) NOT NULL,
  `ID_DEVIS` int(11) NOT NULL,
  `ARTICLE` int(11) NOT NULL,
  `COULEUR` int(11) NOT NULL,
  `TAILLE` int(11) NOT NULL,
  `QUANTITE` int(11) NOT NULL,
  `PRIX` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `devis_lignes`
--

INSERT INTO `devis_lignes` (`ID_LIG_DEV`, `ID_DEVIS`, `ARTICLE`, `COULEUR`, `TAILLE`, `QUANTITE`, `PRIX`) VALUES
(1, 1, 2, 2, 4, 25, '45.00'),
(2, 1, 2, 3, 4, 32, '45.00');

-- --------------------------------------------------------

--
-- Structure de la table `factures_entetes`
--

CREATE TABLE `factures_entetes` (
  `ID_ENT_FCT` int(11) NOT NULL,
  `NO_FCT` int(11) NOT NULL,
  `CLIENT` int(11) NOT NULL,
  `DATE_FCT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `factures_entetes`
--

INSERT INTO `factures_entetes` (`ID_ENT_FCT`, `NO_FCT`, `CLIENT`, `DATE_FCT`) VALUES
(1, 202201, 4, '2022-08-23'),
(2, 202202, 3, '2022-08-31');

-- --------------------------------------------------------

--
-- Structure de la table `factures_lignes`
--

CREATE TABLE `factures_lignes` (
  `ID_LIG_FCT` int(11) NOT NULL,
  `ID_FCT` int(11) NOT NULL,
  `ARTICLE` int(11) NOT NULL,
  `COULEUR` int(11) NOT NULL,
  `TAILLE` int(11) NOT NULL,
  `QUANTITE` int(11) NOT NULL,
  `PRIX` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `factures_lignes`
--

INSERT INTO `factures_lignes` (`ID_LIG_FCT`, `ID_FCT`, `ARTICLE`, `COULEUR`, `TAILLE`, `QUANTITE`, `PRIX`) VALUES
(1, 1, 6, 5, 3, 25, '28.99'),
(2, 1, 5, 2, 5, 43, '34.90'),
(3, 2, 3, 5, 1, 2, '32.00'),
(4, 2, 7, 3, 4, 23, '22.55'),
(5, 2, 7, 2, 4, 1, '45.00'),
(6, 2, 2, 7, 3, 12, '26.00');

-- --------------------------------------------------------

--
-- Structure de la table `stockprix`
--

CREATE TABLE `stockprix` (
  `ARTICLE` int(11) NOT NULL,
  `COULEUR` int(11) NOT NULL,
  `TAILLE` int(11) NOT NULL,
  `PRIX` decimal(10,2) NOT NULL,
  `CODE_BARRE` varchar(13) NOT NULL,
  `STOCK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `stockprix`
--

INSERT INTO `stockprix` (`ARTICLE`, `COULEUR`, `TAILLE`, `PRIX`, `CODE_BARRE`, `STOCK`) VALUES
(1, 1, 1, '27.00', '1234567849871', 245),
(1, 1, 2, '28.00', '1234567938394', 61),
(1, 1, 3, '28.00', '1234567564062', 406),
(1, 1, 4, '28.00', '1234567675656', 690),
(1, 1, 5, '31.00', '1234567652227', 246),
(1, 1, 6, '31.00', '1234567152322', 401),
(1, 2, 1, '27.00', '1234567822570', 228),
(1, 2, 2, '27.00', '1234567553158', 236),
(1, 2, 3, '29.00', '1234567417669', 617),
(1, 2, 4, '30.00', '1234567784805', 603),
(1, 2, 5, '30.00', '1234567439477', 256),
(1, 2, 6, '29.00', '1234567400778', 49),
(1, 3, 1, '31.00', '1234567174322', 243),
(1, 3, 2, '30.00', '1234567726467', 338),
(1, 3, 3, '28.00', '1234567117907', 601),
(1, 3, 4, '32.00', '1234567584140', 325),
(1, 3, 5, '26.00', '1234567400311', 458),
(1, 3, 6, '26.00', '1234567117935', 330),
(1, 4, 1, '34.00', '1234567110986', 320),
(1, 4, 2, '32.00', '1234567118869', 212),
(1, 4, 3, '34.00', '1234567223760', 146),
(1, 4, 4, '33.00', '1234567449832', 248),
(1, 4, 5, '26.00', '1234567221838', 224),
(1, 4, 6, '29.00', '1234567270590', 606),
(1, 5, 1, '31.00', '1234567122796', 644),
(1, 5, 2, '29.00', '1234567962783', 116),
(1, 5, 3, '30.00', '1234567703588', 72),
(1, 5, 4, '29.00', '1234567954928', 654),
(1, 5, 5, '30.00', '1234567125543', 132),
(1, 5, 6, '25.00', '1234567447415', 306),
(1, 6, 1, '25.00', '1234567459362', 674),
(1, 6, 2, '32.00', '1234567737509', 553),
(1, 6, 3, '27.00', '1234567710125', 649),
(1, 6, 4, '30.00', '1234567844351', 138),
(1, 6, 5, '34.00', '1234567642285', 388),
(1, 6, 6, '34.00', '1234567433956', 149),
(1, 7, 1, '34.00', '1234567104669', 375),
(1, 7, 2, '27.00', '1234567944216', 687),
(1, 7, 3, '26.00', '1234567155480', 23),
(1, 7, 4, '34.00', '1234567409896', 341),
(1, 7, 5, '26.00', '1234567587298', 648),
(1, 7, 6, '33.00', '1234567887637', 571),
(1, 8, 1, '25.00', '1234567152075', 41),
(1, 8, 2, '28.00', '1234567580953', 274),
(1, 8, 3, '27.00', '1234567386138', 350),
(1, 8, 4, '32.00', '1234567365237', 164),
(1, 8, 5, '31.00', '1234567435192', 550),
(1, 8, 6, '27.00', '1234567412753', 145),
(2, 1, 1, '74.00', '1234567250045', 395),
(2, 1, 2, '69.00', '1234567341754', 262),
(2, 1, 3, '68.00', '1234567881594', 14),
(2, 1, 4, '72.00', '1234567745886', 464),
(2, 1, 5, '68.00', '1234567398251', 491),
(2, 1, 6, '73.00', '1234567504461', 12),
(2, 2, 1, '71.00', '1234567519155', 569),
(2, 2, 2, '75.00', '1234567281933', 638),
(2, 2, 3, '75.00', '1234567910324', 635),
(2, 2, 4, '71.00', '1234567827130', 23),
(2, 2, 5, '71.00', '1234567309646', 88),
(2, 2, 6, '66.00', '1234567498254', 383),
(2, 3, 1, '75.00', '1234567351889', 323),
(2, 3, 2, '70.00', '1234567887884', 231),
(2, 3, 3, '75.00', '1234567393692', 696),
(2, 3, 4, '70.00', '1234567747973', 160),
(2, 3, 5, '74.00', '1234567438571', 103),
(2, 3, 6, '71.00', '1234567714849', 217),
(2, 4, 1, '66.00', '1234567461917', 661),
(2, 4, 2, '75.00', '1234567834216', 77),
(2, 4, 3, '73.00', '1234567635995', 171),
(2, 4, 4, '72.00', '1234567786151', 619),
(2, 4, 5, '72.00', '1234567654946', 6),
(2, 4, 6, '66.00', '1234567110107', 596),
(2, 5, 1, '67.00', '1234567859786', 375),
(2, 5, 2, '74.00', '1234567229913', 318),
(2, 5, 3, '67.00', '1234567663406', 505),
(2, 5, 4, '72.00', '1234567178771', 423),
(2, 5, 5, '75.00', '1234567575570', 211),
(2, 5, 6, '73.00', '1234567424261', 651),
(2, 6, 1, '66.00', '1234567627920', 77),
(2, 6, 2, '66.00', '1234567393334', 19),
(2, 6, 3, '73.00', '1234567598971', 226),
(2, 6, 4, '71.00', '1234567497320', 501),
(2, 6, 5, '75.00', '1234567239114', 497),
(2, 6, 6, '68.00', '1234567556921', 194),
(2, 7, 1, '72.00', '1234567395614', 618),
(2, 7, 2, '74.00', '1234567927215', 503),
(2, 7, 3, '70.00', '1234567537612', 384),
(2, 7, 4, '72.00', '1234567922656', 6),
(2, 7, 5, '67.00', '1234567781124', 532),
(2, 7, 6, '75.00', '1234567842071', 240),
(2, 8, 1, '73.00', '1234567314041', 111),
(2, 8, 2, '67.00', '1234567393664', 266),
(2, 8, 3, '68.00', '1234567321127', 165),
(2, 8, 4, '69.00', '1234567720013', 349),
(2, 8, 5, '74.00', '1234567609024', 401),
(2, 8, 6, '66.00', '1234567123071', 32),
(3, 1, 1, '58.00', '1234567184045', 170),
(3, 1, 2, '56.00', '1234567630062', 631),
(3, 1, 3, '52.00', '1234567387347', 321),
(3, 1, 4, '58.00', '1234567246475', 640),
(3, 1, 5, '56.00', '1234567651733', 226),
(3, 1, 6, '60.00', '1234567569088', 493),
(3, 2, 1, '51.00', '1234567488531', 456),
(3, 2, 2, '60.00', '1234567448294', 30),
(3, 2, 3, '57.00', '1234567618444', 510),
(3, 2, 4, '59.00', '1234567731356', 381),
(3, 2, 5, '51.00', '1234567496551', 392),
(3, 2, 6, '52.00', '1234567887417', 640),
(3, 3, 1, '55.00', '1234567337304', 81),
(3, 3, 2, '59.00', '1234567132492', 141),
(3, 3, 3, '53.00', '1234567439532', 414),
(3, 3, 4, '59.00', '1234567354470', 38),
(3, 3, 5, '59.00', '1234567511437', 451),
(3, 3, 6, '60.00', '1234567938119', 673),
(3, 4, 1, '54.00', '1234567795599', 457),
(3, 4, 2, '57.00', '1234567790078', 350),
(3, 4, 3, '53.00', '1234567493969', 677),
(3, 4, 4, '58.00', '1234567363864', 420),
(3, 4, 5, '54.00', '1234567692877', 104),
(3, 4, 6, '51.00', '1234567984866', 545),
(3, 5, 1, '55.00', '1234567988024', 167),
(3, 5, 2, '53.00', '1234567575350', 280),
(3, 5, 3, '52.00', '1234567609490', 692),
(3, 5, 4, '56.00', '1234567179458', 646),
(3, 5, 5, '51.00', '1234567446728', 83),
(3, 5, 6, '59.00', '1234567588204', 101),
(3, 6, 1, '57.00', '1234567573565', 402),
(3, 6, 2, '58.00', '1234567764480', 323),
(3, 6, 3, '60.00', '1234567473205', 535),
(3, 6, 4, '58.00', '1234567768051', 79),
(3, 6, 5, '58.00', '1234567163226', 571),
(3, 6, 6, '52.00', '1234567180557', 301),
(3, 7, 1, '54.00', '1234567420581', 580),
(3, 7, 2, '55.00', '1234567130514', 61),
(3, 7, 3, '55.00', '1234567306597', 81),
(3, 7, 4, '52.00', '1234567818313', 250),
(3, 7, 5, '54.00', '1234567991979', 328),
(3, 7, 6, '60.00', '1234567841220', 245),
(3, 8, 1, '54.00', '1234567581805', 269),
(3, 8, 2, '57.00', '1234567118374', 192),
(3, 8, 3, '53.00', '1234567640527', 238),
(3, 8, 4, '58.00', '1234567115792', 476),
(3, 8, 5, '59.00', '1234567116973', 18),
(3, 8, 6, '57.00', '1234567471365', 499),
(4, 1, 1, '106.00', '1234567641763', 639),
(4, 1, 2, '97.00', '1234567423876', 246),
(4, 1, 3, '99.00', '1234567952072', 149),
(4, 1, 4, '98.00', '1234567733526', 664),
(4, 1, 5, '100.00', '1234567917410', 689),
(4, 1, 6, '104.00', '1234567253479', 106),
(4, 2, 1, '98.00', '1234567597543', 324),
(4, 2, 2, '105.00', '1234567801312', 66),
(4, 2, 3, '102.00', '1234567474111', 688),
(4, 2, 4, '102.00', '1234567453979', 611),
(4, 2, 5, '100.00', '1234567775631', 153),
(4, 2, 6, '103.00', '1234567972808', 562),
(4, 3, 1, '106.00', '1234567802493', 309),
(4, 3, 2, '101.00', '1234567828503', 469),
(4, 3, 3, '105.00', '1234567951962', 534),
(4, 3, 4, '100.00', '1234567826141', 684),
(4, 3, 5, '98.00', '1234567243179', 272),
(4, 3, 6, '104.00', '1234567730175', 138),
(4, 4, 1, '98.00', '1234567142160', 612),
(4, 4, 2, '105.00', '1234567389434', 17),
(4, 4, 3, '101.00', '1234567286795', 251),
(4, 4, 4, '101.00', '1234567862121', 431),
(4, 4, 5, '101.00', '1234567511849', 584),
(4, 4, 6, '97.00', '1234567140814', 596),
(4, 5, 1, '104.00', '1234567173965', 267),
(4, 5, 2, '105.00', '1234567577465', 405),
(4, 5, 3, '97.00', '1234567176657', 298),
(4, 5, 4, '97.00', '1234567108404', 605),
(4, 5, 5, '100.00', '1234567495315', 692),
(4, 5, 6, '105.00', '1234567579333', 169),
(4, 6, 1, '97.00', '1234567402206', 652),
(4, 6, 2, '101.00', '1234567770330', 678),
(4, 6, 3, '105.00', '1234567491470', 147),
(4, 6, 4, '106.00', '1234567220849', 184),
(4, 6, 5, '97.00', '1234567204122', 89),
(4, 6, 6, '100.00', '1234567354718', 399),
(4, 7, 1, '103.00', '1234567753054', 405),
(4, 7, 2, '97.00', '1234567205139', 559),
(4, 7, 3, '97.00', '1234567848031', 210),
(4, 7, 4, '102.00', '1234567239691', 403),
(4, 7, 5, '102.00', '1234567520693', 87),
(4, 7, 6, '102.00', '1234567785327', 352),
(4, 8, 1, '102.00', '1234567449557', 159),
(4, 8, 2, '98.00', '1234567453375', 275),
(4, 8, 3, '105.00', '1234567385012', 265),
(4, 8, 4, '99.00', '1234567864538', 373),
(4, 8, 5, '102.00', '1234567274325', 135),
(4, 8, 6, '104.00', '1234567573895', 649),
(5, 1, 1, '24.00', '1234567437115', 472),
(5, 1, 2, '26.00', '1234567591995', 488),
(5, 1, 3, '21.00', '1234567978356', 398),
(5, 1, 4, '25.00', '1234567625448', 678),
(5, 1, 5, '24.00', '1234567677166', 479),
(5, 1, 6, '29.00', '1234567728775', 666),
(5, 2, 1, '26.00', '1234567872998', 172),
(5, 2, 2, '21.00', '1234567342990', 663),
(5, 2, 3, '25.00', '1234567289678', 485),
(5, 2, 4, '20.00', '1234567680984', 595),
(5, 2, 5, '26.00', '1234567660412', 656),
(5, 2, 6, '21.00', '1234567452523', 279),
(5, 3, 1, '24.00', '1234567652777', 424),
(5, 3, 2, '27.00', '1234567589248', 299),
(5, 3, 3, '25.00', '1234567593725', 208),
(5, 3, 4, '21.00', '1234567869674', 76),
(5, 3, 5, '21.00', '1234567894586', 580),
(5, 3, 6, '22.00', '1234567144192', 149),
(5, 4, 1, '21.00', '1234567476062', 339),
(5, 4, 2, '22.00', '1234567160067', 248),
(5, 4, 3, '24.00', '1234567593231', 188),
(5, 4, 4, '24.00', '1234567386441', 168),
(5, 4, 5, '29.00', '1234567560546', 108),
(5, 4, 6, '29.00', '1234567939328', 644),
(5, 5, 1, '23.00', '1234567676837', 232),
(5, 5, 2, '25.00', '1234567106619', 26),
(5, 5, 3, '29.00', '1234567650305', 324),
(5, 5, 4, '21.00', '1234567873080', 58),
(5, 5, 5, '27.00', '1234567723529', 647),
(5, 5, 6, '22.00', '1234567345352', 447),
(5, 6, 1, '23.00', '1234567998461', 45),
(5, 6, 2, '26.00', '1234567776950', 440),
(5, 6, 3, '25.00', '1234567761431', 317),
(5, 6, 4, '29.00', '1234567793264', 401),
(5, 6, 5, '21.00', '1234567508142', 83),
(5, 6, 6, '22.00', '1234567116561', 585),
(5, 7, 1, '25.00', '1234567368670', 576),
(5, 7, 2, '24.00', '1234567690982', 612),
(5, 7, 3, '27.00', '1234567332470', 197),
(5, 7, 4, '25.00', '1234567607540', 340),
(5, 7, 5, '29.00', '1234567473370', 308),
(5, 7, 6, '20.00', '1234567629129', 48),
(5, 8, 1, '21.00', '1234567274572', 495),
(5, 8, 2, '26.00', '1234567815512', 603),
(5, 8, 3, '22.00', '1234567653656', 148),
(5, 8, 4, '23.00', '1234567748330', 135),
(5, 8, 5, '25.00', '1234567587573', 36),
(5, 8, 6, '29.00', '1234567656100', 520),
(6, 1, 1, '83.00', '1234567590072', 566),
(6, 1, 2, '81.00', '1234567799114', 55),
(6, 1, 3, '74.00', '1234567526406', 396),
(6, 1, 4, '78.00', '1234567469360', 690),
(6, 1, 5, '82.00', '1234567409567', 94),
(6, 1, 6, '81.00', '1234567865142', 8),
(6, 2, 1, '74.00', '1234567664944', 22),
(6, 2, 2, '75.00', '1234567682165', 137),
(6, 2, 3, '79.00', '1234567114804', 436),
(6, 2, 4, '77.00', '1234567950506', 202),
(6, 2, 5, '77.00', '1234567703286', 254),
(6, 2, 6, '75.00', '1234567759619', 9),
(6, 3, 1, '77.00', '1234567521408', 38),
(6, 3, 2, '82.00', '1234567183331', 219),
(6, 3, 3, '75.00', '1234567332058', 63),
(6, 3, 4, '78.00', '1234567504846', 417),
(6, 3, 5, '78.00', '1234567195004', 498),
(6, 3, 6, '82.00', '1234567841741', 694),
(6, 4, 1, '77.00', '1234567591885', 172),
(6, 4, 2, '77.00', '1234567170971', 418),
(6, 4, 3, '77.00', '1234567851217', 261),
(6, 4, 4, '78.00', '1234567253863', 511),
(6, 4, 5, '74.00', '1234567273391', 252),
(6, 4, 6, '81.00', '1234567461120', 122),
(6, 5, 1, '83.00', '1234567155673', 226),
(6, 5, 2, '78.00', '1234567697821', 305),
(6, 5, 3, '75.00', '1234567417202', 326),
(6, 5, 4, '74.00', '1234567728417', 690),
(6, 5, 5, '83.00', '1234567723995', 238),
(6, 5, 6, '81.00', '1234567401739', 360),
(6, 6, 1, '83.00', '1234567713943', 64),
(6, 6, 2, '76.00', '1234567775988', 128),
(6, 6, 3, '77.00', '1234567221810', 495),
(6, 6, 4, '76.00', '1234567743743', 611),
(6, 6, 5, '75.00', '1234567404238', 189),
(6, 6, 6, '80.00', '1234567856958', 299),
(6, 7, 1, '80.00', '1234567364743', 144),
(6, 7, 2, '83.00', '1234567851959', 642),
(6, 7, 3, '74.00', '1234567978713', 373),
(6, 7, 4, '76.00', '1234567774450', 611),
(6, 7, 5, '81.00', '1234567618417', 81),
(6, 7, 6, '80.00', '1234567304510', 386),
(6, 8, 1, '79.00', '1234567777993', 638),
(6, 8, 2, '78.00', '1234567781591', 122),
(6, 8, 3, '78.00', '1234567898458', 153),
(6, 8, 4, '77.00', '1234567929522', 129),
(6, 8, 5, '81.00', '1234567392703', 655),
(6, 8, 6, '74.00', '1234567681506', 344),
(7, 1, 1, '66.00', '1234567818066', 590),
(7, 1, 2, '64.00', '1234567750363', 374),
(7, 1, 3, '68.00', '1234567674200', 359),
(7, 1, 4, '66.00', '1234567529373', 517),
(7, 1, 5, '67.00', '1234567668762', 138),
(7, 1, 6, '68.00', '1234567613803', 127),
(7, 2, 1, '69.00', '1234567594329', 544),
(7, 2, 2, '66.00', '1234567360293', 664),
(7, 2, 3, '65.00', '1234567102856', 68),
(7, 2, 4, '66.00', '1234567672360', 323),
(7, 2, 5, '68.00', '1234567730670', 158),
(7, 2, 6, '69.00', '1234567625393', 520),
(7, 3, 1, '60.00', '1234567723474', 489),
(7, 3, 2, '68.00', '1234567391659', 457),
(7, 3, 3, '61.00', '1234567661346', 538),
(7, 3, 4, '61.00', '1234567565298', 106),
(7, 3, 5, '66.00', '1234567983740', 460),
(7, 3, 6, '60.00', '1234567587326', 377),
(7, 4, 1, '60.00', '1234567414483', 566),
(7, 4, 2, '66.00', '1234567770632', 495),
(7, 4, 3, '61.00', '1234567686779', 90),
(7, 4, 4, '61.00', '1234567724984', 278),
(7, 4, 5, '61.00', '1234567468206', 176),
(7, 4, 6, '62.00', '1234567482022', 308),
(7, 5, 1, '60.00', '1234567985717', 541),
(7, 5, 2, '68.00', '1234567720260', 8),
(7, 5, 3, '67.00', '1234567850640', 355),
(7, 5, 4, '61.00', '1234567290090', 619),
(7, 5, 5, '61.00', '1234567783679', 519),
(7, 5, 6, '61.00', '1234567938778', 466),
(7, 6, 1, '62.00', '1234567239910', 334),
(7, 6, 2, '62.00', '1234567335464', 46),
(7, 6, 3, '60.00', '1234567333789', 484),
(7, 6, 4, '64.00', '1234567396163', 95),
(7, 6, 5, '60.00', '1234567464141', 401),
(7, 6, 6, '66.00', '1234567308767', 364),
(7, 7, 1, '64.00', '1234567339172', 547),
(7, 7, 2, '68.00', '1234567358041', 495),
(7, 7, 3, '66.00', '1234567201458', 487),
(7, 7, 4, '63.00', '1234567350625', 194),
(7, 7, 5, '69.00', '1234567152954', 466),
(7, 7, 6, '69.00', '1234567740036', 110),
(7, 8, 1, '62.00', '1234567379986', 178),
(7, 8, 2, '64.00', '1234567151663', 608),
(7, 8, 3, '62.00', '1234567478259', 350),
(7, 8, 4, '67.00', '1234567107772', 540),
(7, 8, 5, '65.00', '1234567577850', 109),
(7, 8, 6, '68.00', '1234567752505', 227),
(8, 1, 1, '102.00', '1234567949270', 502),
(8, 1, 2, '96.00', '1234567395202', 484),
(8, 1, 3, '104.00', '1234567824520', 580),
(8, 1, 4, '105.00', '1234567259246', 574),
(8, 1, 5, '100.00', '1234567235269', 652),
(8, 1, 6, '99.00', '1234567198437', 209),
(8, 2, 1, '102.00', '1234567197531', 55),
(8, 2, 2, '104.00', '1234567511602', 224),
(8, 2, 3, '98.00', '1234567799197', 642),
(8, 2, 4, '103.00', '1234567906945', 381),
(8, 2, 5, '97.00', '1234567525033', 652),
(8, 2, 6, '97.00', '1234567727044', 245),
(8, 3, 1, '102.00', '1234567981680', 494),
(8, 3, 2, '101.00', '1234567973852', 59),
(8, 3, 3, '103.00', '1234567822653', 114),
(8, 3, 4, '105.00', '1234567933697', 221),
(8, 3, 5, '96.00', '1234567473342', 579),
(8, 3, 6, '104.00', '1234567202282', 53),
(8, 4, 1, '101.00', '1234567556015', 40),
(8, 4, 2, '104.00', '1234567709686', 86),
(8, 4, 3, '98.00', '1234567314810', 220),
(8, 4, 4, '104.00', '1234567645361', 123),
(8, 4, 5, '96.00', '1234567540744', 277),
(8, 4, 6, '97.00', '1234567983135', 124),
(8, 5, 1, '100.00', '1234567196707', 489),
(8, 5, 2, '102.00', '1234567306213', 377),
(8, 5, 3, '98.00', '1234567242465', 321),
(8, 5, 4, '100.00', '1234567432171', 271),
(8, 5, 5, '101.00', '1234567259658', 7),
(8, 5, 6, '101.00', '1234567337963', 576),
(8, 6, 1, '104.00', '1234567476803', 19),
(8, 6, 2, '104.00', '1234567884918', 110),
(8, 6, 3, '102.00', '1234567194290', 547),
(8, 6, 4, '101.00', '1234567543737', 126),
(8, 6, 5, '102.00', '1234567709384', 268),
(8, 6, 6, '96.00', '1234567119500', 276),
(8, 7, 1, '102.00', '1234567141226', 29),
(8, 7, 2, '104.00', '1234567276660', 190),
(8, 7, 3, '98.00', '1234567855831', 215),
(8, 7, 4, '97.00', '1234567864044', 353),
(8, 7, 5, '104.00', '1234567691091', 227),
(8, 7, 6, '101.00', '1234567239855', 176),
(8, 8, 1, '104.00', '1234567381771', 56),
(8, 8, 2, '105.00', '1234567896673', 276),
(8, 8, 3, '105.00', '1234567184512', 461),
(8, 8, 4, '96.00', '1234567686450', 544),
(8, 8, 5, '103.00', '1234567102828', 339),
(8, 8, 6, '100.00', '1234567245513', 328),
(9, 1, 1, '32.00', '1234567620257', 117),
(9, 1, 2, '36.00', '1234567103213', 44),
(9, 1, 3, '35.00', '1234567821362', 257),
(9, 1, 4, '34.00', '1234567671920', 461),
(9, 1, 5, '37.00', '1234567201129', 240),
(9, 1, 6, '40.00', '1234567628469', 255),
(9, 2, 1, '33.00', '1234567830261', 618),
(9, 2, 2, '32.00', '1234567370126', 206),
(9, 2, 3, '36.00', '1234567813836', 341),
(9, 2, 4, '38.00', '1234567716030', 460),
(9, 2, 5, '41.00', '1234567816308', 441),
(9, 2, 6, '34.00', '1234567432199', 0),
(9, 3, 1, '39.00', '1234567686505', 1),
(9, 3, 2, '33.00', '1234567956521', 329),
(9, 3, 3, '37.00', '1234567582629', 536),
(9, 3, 4, '39.00', '1234567323764', 38),
(9, 3, 5, '33.00', '1234567297259', 559),
(9, 3, 6, '32.00', '1234567590567', 586),
(9, 4, 1, '36.00', '1234567382348', 664),
(9, 4, 2, '34.00', '1234567860446', 168),
(9, 4, 3, '40.00', '1234567574224', 195),
(9, 4, 4, '38.00', '1234567208792', 201),
(9, 4, 5, '36.00', '1234567918591', 231),
(9, 4, 6, '38.00', '1234567607870', 587),
(9, 5, 1, '36.00', '1234567195526', 246),
(9, 5, 2, '39.00', '1234567851821', 597),
(9, 5, 3, '32.00', '1234567644482', 399),
(9, 5, 4, '36.00', '1234567381661', 441),
(9, 5, 5, '32.00', '1234567989288', 296),
(9, 5, 6, '39.00', '1234567410281', 45),
(9, 6, 1, '32.00', '1234567263146', 577),
(9, 6, 2, '39.00', '1234567547445', 627),
(9, 6, 3, '36.00', '1234567733636', 279),
(9, 6, 4, '33.00', '1234567824795', 669),
(9, 6, 5, '32.00', '1234567927709', 523),
(9, 6, 6, '33.00', '1234567120846', 292),
(9, 7, 1, '39.00', '1234567356695', 479),
(9, 7, 2, '37.00', '1234567885989', 37),
(9, 7, 3, '39.00', '1234567641296', 347),
(9, 7, 4, '37.00', '1234567367489', 333),
(9, 7, 5, '38.00', '1234567336590', 130),
(9, 7, 6, '36.00', '1234567734487', 274),
(9, 8, 1, '37.00', '1234567557031', 510),
(9, 8, 2, '36.00', '1234567302999', 597),
(9, 8, 3, '33.00', '1234567701446', 218),
(9, 8, 4, '35.00', '1234567960916', 352),
(9, 8, 5, '37.00', '1234567478039', 419),
(9, 8, 6, '32.00', '1234567293002', 581),
(10, 1, 1, '7.00', '1234567970529', 664),
(10, 1, 2, '14.00', '1234567474249', 32),
(10, 1, 3, '13.00', '1234567788211', 586),
(10, 1, 4, '8.00', '1234567268420', 323),
(10, 1, 5, '10.00', '1234567601937', 347),
(10, 1, 6, '15.00', '1234567696722', 650),
(10, 2, 1, '15.00', '1234567443350', 530),
(10, 2, 2, '11.00', '1234567286108', 29),
(10, 2, 3, '9.00', '1234567990963', 559),
(10, 2, 4, '9.00', '1234567347906', 434),
(10, 2, 5, '12.00', '1234567195169', 271),
(10, 2, 6, '8.00', '1234567702819', 664),
(10, 3, 1, '13.00', '1234567703231', 96),
(10, 3, 2, '14.00', '1234567805926', 20),
(10, 3, 3, '9.00', '1234567184292', 530),
(10, 3, 4, '11.00', '1234567871679', 585),
(10, 3, 5, '9.00', '1234567554367', 207),
(10, 3, 6, '11.00', '1234567298907', 392),
(10, 4, 1, '11.00', '1234567101345', 279),
(10, 4, 2, '9.00', '1234567595812', 604),
(10, 4, 3, '15.00', '1234567909994', 388),
(10, 4, 4, '7.00', '1234567204974', 85),
(10, 4, 5, '14.00', '1234567986953', 240),
(10, 4, 6, '8.00', '1234567128344', 479),
(10, 5, 1, '8.00', '1234567785739', 485),
(10, 5, 2, '13.00', '1234567552252', 82),
(10, 5, 3, '12.00', '1234567731741', 85),
(10, 5, 4, '16.00', '1234567172399', 320),
(10, 5, 5, '7.00', '1234567547225', 696),
(10, 5, 6, '15.00', '1234567918865', 320),
(10, 6, 1, '13.00', '1234567376333', 536),
(10, 6, 2, '7.00', '1234567981103', 587),
(10, 6, 3, '9.00', '1234567110079', 166),
(10, 6, 4, '15.00', '1234567432940', 380),
(10, 6, 5, '10.00', '1234567511355', 564),
(10, 6, 6, '10.00', '1234567557580', 688),
(10, 7, 1, '13.00', '1234567739926', 495),
(10, 7, 2, '11.00', '1234567472601', 199),
(10, 7, 3, '9.00', '1234567377432', 191),
(10, 7, 4, '10.00', '1234567954956', 383),
(10, 7, 5, '14.00', '1234567552389', 127),
(10, 7, 6, '13.00', '1234567165972', 59),
(10, 8, 1, '14.00', '1234567565188', 491),
(10, 8, 2, '14.00', '1234567176354', 481),
(10, 8, 3, '14.00', '1234567813095', 661),
(10, 8, 4, '8.00', '1234567891180', 598),
(10, 8, 5, '13.00', '1234567315249', 82),
(10, 8, 6, '8.00', '1234567274902', 41),
(11, 1, 1, '14.00', '1234567796423', 23),
(11, 1, 2, '18.00', '1234567995468', 196),
(11, 1, 3, '11.00', '1234567150701', 296),
(11, 1, 4, '10.00', '1234567838638', 529),
(11, 1, 5, '19.00', '1234567958251', 49),
(11, 1, 6, '15.00', '1234567473947', 214),
(11, 2, 1, '13.00', '1234567592901', 642),
(11, 2, 2, '19.00', '1234567664285', 229),
(11, 2, 3, '12.00', '1234567337854', 260),
(11, 2, 4, '19.00', '1234567569418', 39),
(11, 2, 5, '15.00', '1234567210687', 394),
(11, 2, 6, '16.00', '1234567670986', 579),
(11, 3, 1, '15.00', '1234567988354', 414),
(11, 3, 2, '16.00', '1234567297506', 219),
(11, 3, 3, '18.00', '1234567832183', 540),
(11, 3, 4, '15.00', '1234567549368', 550),
(11, 3, 5, '19.00', '1234567912878', 622),
(11, 3, 6, '16.00', '1234567923837', 249),
(11, 4, 1, '10.00', '1234567235516', 312),
(11, 4, 2, '12.00', '1234567440054', 163),
(11, 4, 3, '17.00', '1234567364550', 642),
(11, 4, 4, '15.00', '1234567564035', 677),
(11, 4, 5, '11.00', '1234567248809', 696),
(11, 4, 6, '10.00', '1234567933670', 492),
(11, 5, 1, '18.00', '1234567946496', 584),
(11, 5, 2, '12.00', '1234567483724', 300),
(11, 5, 3, '18.00', '1234567450189', 224),
(11, 5, 4, '18.00', '1234567370840', 158),
(11, 5, 5, '17.00', '1234567211840', 208),
(11, 5, 6, '13.00', '1234567598532', 364),
(11, 6, 1, '12.00', '1234567867779', 583),
(11, 6, 2, '19.00', '1234567242190', 232),
(11, 6, 3, '13.00', '1234567663708', 322),
(11, 6, 4, '18.00', '1234567374081', 367),
(11, 6, 5, '11.00', '1234567179705', 305),
(11, 6, 6, '19.00', '1234567688345', 37),
(11, 7, 1, '19.00', '1234567755224', 688),
(11, 7, 2, '13.00', '1234567625997', 155),
(11, 7, 3, '15.00', '1234567214093', 377),
(11, 7, 4, '12.00', '1234567499929', 646),
(11, 7, 5, '15.00', '1234567289514', 11),
(11, 7, 6, '18.00', '1234567819906', 626),
(11, 8, 1, '12.00', '1234567549066', 31),
(11, 8, 2, '16.00', '1234567717568', 678),
(11, 8, 3, '14.00', '1234567419702', 155),
(11, 8, 4, '18.00', '1234567871432', 225),
(11, 8, 5, '13.00', '1234567312750', 253),
(11, 8, 6, '14.00', '1234567131887', 506),
(12, 1, 1, '83.00', '1234567776895', 282),
(12, 1, 2, '75.00', '1234567807739', 327),
(12, 1, 3, '82.00', '1234567456149', 193),
(12, 1, 4, '80.00', '1234567296490', 450),
(12, 1, 5, '76.00', '1234567338870', 28),
(12, 1, 6, '80.00', '1234567162731', 551),
(12, 2, 1, '78.00', '1234567597323', 393),
(12, 2, 2, '75.00', '1234567986541', 107),
(12, 2, 3, '74.00', '1234567925650', 556),
(12, 2, 4, '80.00', '1234567507373', 675),
(12, 2, 5, '78.00', '1234567764865', 27),
(12, 2, 6, '81.00', '1234567149053', 463),
(12, 3, 1, '80.00', '1234567427859', 135),
(12, 3, 2, '75.00', '1234567744787', 108),
(12, 3, 3, '83.00', '1234567424398', 696),
(12, 3, 4, '75.00', '1234567962152', 52),
(12, 3, 5, '82.00', '1234567786123', 189),
(12, 3, 6, '78.00', '1234567228100', 11),
(12, 4, 1, '78.00', '1234567391549', 141),
(12, 4, 2, '77.00', '1234567753961', 559),
(12, 4, 3, '82.00', '1234567791067', 390),
(12, 4, 4, '80.00', '1234567560437', 492),
(12, 4, 5, '74.00', '1234567131942', 664),
(12, 4, 6, '75.00', '1234567902606', 517),
(12, 5, 1, '79.00', '1234567583316', 58),
(12, 5, 2, '83.00', '1234567194921', 611),
(12, 5, 3, '76.00', '1234567461203', 9),
(12, 5, 4, '80.00', '1234567536212', 210),
(12, 5, 5, '74.00', '1234567753494', 267),
(12, 5, 6, '77.00', '1234567734680', 477),
(12, 6, 1, '74.00', '1234567844955', 474),
(12, 6, 2, '78.00', '1234567132904', 275),
(12, 6, 3, '77.00', '1234567542227', 338),
(12, 6, 4, '76.00', '1234567632836', 549),
(12, 6, 5, '83.00', '1234567298825', 506),
(12, 6, 6, '81.00', '1234567620806', 295),
(12, 7, 1, '79.00', '1234567540139', 642),
(12, 7, 2, '80.00', '1234567592517', 237),
(12, 7, 3, '74.00', '1234567988436', 301),
(12, 7, 4, '77.00', '1234567678045', 203),
(12, 7, 5, '79.00', '1234567887857', 502),
(12, 7, 6, '81.00', '1234567866845', 0),
(12, 8, 1, '82.00', '1234567129415', 406),
(12, 8, 2, '75.00', '1234567332745', 286),
(12, 8, 3, '80.00', '1234567376004', 289),
(12, 8, 4, '79.00', '1234567358947', 648),
(12, 8, 5, '78.00', '1234567787387', 319),
(12, 8, 6, '83.00', '1234567963031', 477);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`ID_ARTICLE`),
  ADD KEY `fk_categorie` (`CATEGORIE`);

--
-- Index pour la table `a_categories`
--
ALTER TABLE `a_categories`
  ADD PRIMARY KEY (`CODE_CATEGORIE`);

--
-- Index pour la table `a_couleurs`
--
ALTER TABLE `a_couleurs`
  ADD PRIMARY KEY (`CODE_COULEUR`);

--
-- Index pour la table `a_tailles`
--
ALTER TABLE `a_tailles`
  ADD PRIMARY KEY (`CODE_TAILLE`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`ID_CLIENT`),
  ADD KEY `fk_typeClient` (`TYPE_CLIENT`);

--
-- Index pour la table `c_types`
--
ALTER TABLE `c_types`
  ADD PRIMARY KEY (`CODE_TYPE`);

--
-- Index pour la table `devis_entetes`
--
ALTER TABLE `devis_entetes`
  ADD PRIMARY KEY (`ID_ENT_DEV`),
  ADD KEY `fk_Client` (`CLIENT`);

--
-- Index pour la table `devis_lignes`
--
ALTER TABLE `devis_lignes`
  ADD PRIMARY KEY (`ID_LIG_DEV`),
  ADD KEY `fk_idDevis` (`ID_DEVIS`),
  ADD KEY `fk_articleLig` (`ARTICLE`),
  ADD KEY `fk_couleurLig` (`COULEUR`),
  ADD KEY `fk_tailleLig` (`TAILLE`);

--
-- Index pour la table `factures_entetes`
--
ALTER TABLE `factures_entetes`
  ADD PRIMARY KEY (`ID_ENT_FCT`),
  ADD KEY `fk_ClientFCT` (`CLIENT`);

--
-- Index pour la table `factures_lignes`
--
ALTER TABLE `factures_lignes`
  ADD PRIMARY KEY (`ID_LIG_FCT`),
  ADD KEY `fk_idFCT` (`ID_FCT`),
  ADD KEY `fk_articleLigF` (`ARTICLE`),
  ADD KEY `fk_couleurLigF` (`COULEUR`),
  ADD KEY `fk_tailleLigF` (`TAILLE`);

--
-- Index pour la table `stockprix`
--
ALTER TABLE `stockprix`
  ADD PRIMARY KEY (`ARTICLE`,`COULEUR`,`TAILLE`),
  ADD KEY `fk_couleur` (`COULEUR`),
  ADD KEY `fk_taille` (`TAILLE`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `articles`
--
ALTER TABLE `articles`
  MODIFY `ID_ARTICLE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `a_categories`
--
ALTER TABLE `a_categories`
  MODIFY `CODE_CATEGORIE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `a_couleurs`
--
ALTER TABLE `a_couleurs`
  MODIFY `CODE_COULEUR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT pour la table `a_tailles`
--
ALTER TABLE `a_tailles`
  MODIFY `CODE_TAILLE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `ID_CLIENT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `c_types`
--
ALTER TABLE `c_types`
  MODIFY `CODE_TYPE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `devis_entetes`
--
ALTER TABLE `devis_entetes`
  MODIFY `ID_ENT_DEV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `devis_lignes`
--
ALTER TABLE `devis_lignes`
  MODIFY `ID_LIG_DEV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `factures_entetes`
--
ALTER TABLE `factures_entetes`
  MODIFY `ID_ENT_FCT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `factures_lignes`
--
ALTER TABLE `factures_lignes`
  MODIFY `ID_LIG_FCT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `fk_categorie` FOREIGN KEY (`CATEGORIE`) REFERENCES `a_categories` (`CODE_CATEGORIE`);

--
-- Contraintes pour la table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `fk_typeClient` FOREIGN KEY (`TYPE_CLIENT`) REFERENCES `c_types` (`CODE_TYPE`);

--
-- Contraintes pour la table `devis_entetes`
--
ALTER TABLE `devis_entetes`
  ADD CONSTRAINT `fk_Client` FOREIGN KEY (`CLIENT`) REFERENCES `clients` (`ID_CLIENT`);

--
-- Contraintes pour la table `devis_lignes`
--
ALTER TABLE `devis_lignes`
  ADD CONSTRAINT `fk_articleLig` FOREIGN KEY (`ARTICLE`) REFERENCES `articles` (`ID_ARTICLE`),
  ADD CONSTRAINT `fk_couleurLig` FOREIGN KEY (`COULEUR`) REFERENCES `a_couleurs` (`CODE_COULEUR`),
  ADD CONSTRAINT `fk_idDevis` FOREIGN KEY (`ID_DEVIS`) REFERENCES `devis_entetes` (`ID_ENT_DEV`),
  ADD CONSTRAINT `fk_tailleLig` FOREIGN KEY (`TAILLE`) REFERENCES `a_tailles` (`CODE_TAILLE`);

--
-- Contraintes pour la table `factures_entetes`
--
ALTER TABLE `factures_entetes`
  ADD CONSTRAINT `fk_ClientFCT` FOREIGN KEY (`CLIENT`) REFERENCES `clients` (`ID_CLIENT`);

--
-- Contraintes pour la table `factures_lignes`
--
ALTER TABLE `factures_lignes`
  ADD CONSTRAINT `fk_articleLigF` FOREIGN KEY (`ARTICLE`) REFERENCES `articles` (`ID_ARTICLE`),
  ADD CONSTRAINT `fk_couleurLigF` FOREIGN KEY (`COULEUR`) REFERENCES `a_couleurs` (`CODE_COULEUR`),
  ADD CONSTRAINT `fk_idFCT` FOREIGN KEY (`ID_FCT`) REFERENCES `factures_entetes` (`ID_ENT_FCT`),
  ADD CONSTRAINT `fk_tailleLigF` FOREIGN KEY (`TAILLE`) REFERENCES `a_tailles` (`CODE_TAILLE`);

--
-- Contraintes pour la table `stockprix`
--
ALTER TABLE `stockprix`
  ADD CONSTRAINT `fk_article` FOREIGN KEY (`ARTICLE`) REFERENCES `articles` (`ID_ARTICLE`),
  ADD CONSTRAINT `fk_couleur` FOREIGN KEY (`COULEUR`) REFERENCES `a_couleurs` (`CODE_COULEUR`),
  ADD CONSTRAINT `fk_taille` FOREIGN KEY (`TAILLE`) REFERENCES `a_tailles` (`CODE_TAILLE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
