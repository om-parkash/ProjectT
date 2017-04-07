-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.5.19 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for shoppingcart
CREATE DATABASE IF NOT EXISTS `shoppingcart` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `shoppingcart`;


-- Dumping structure for table shoppingcart.cart
CREATE TABLE IF NOT EXISTS `cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `FK2E7B202FC2D3D3` (`item_id`),
  KEY `FK2E7B20F1E381CD` (`user_id`),
  CONSTRAINT `FK2E7B202FC2D3D3` FOREIGN KEY (`item_id`) REFERENCES `shopping_items` (`item_id`),
  CONSTRAINT `FK2E7B20F1E381CD` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table shoppingcart.cart: ~0 rows (approximately)
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;


-- Dumping structure for table shoppingcart.item_order_master
CREATE TABLE IF NOT EXISTS `item_order_master` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_amount` float DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKA035321FF1E381CD` (`user_id`),
  CONSTRAINT `FKA035321FF1E381CD` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table shoppingcart.item_order_master: ~23 rows (approximately)
/*!40000 ALTER TABLE `item_order_master` DISABLE KEYS */;
REPLACE INTO `item_order_master` (`order_id`, `order_amount`, `order_date`, `user_id`) VALUES
	(1, 450.5, '2015-07-13 13:23:01', 1),
	(2, 5000, '2015-07-13 13:24:09', 1),
	(3, 25752, '2015-07-13 13:30:00', 1),
	(4, 4505, '2015-07-13 16:19:59', 1),
	(5, 2351.5, '2015-07-13 16:21:38', 1),
	(6, 1351.5, '2015-07-13 16:28:31', 1),
	(7, 450.5, '2015-07-13 16:43:46', 1),
	(8, 450.5, '2015-07-14 17:29:15', 1),
	(9, 2901, '2015-07-15 10:59:58', 1),
	(10, 3351.5, '2015-07-15 11:05:10', 1),
	(11, 3351.5, '2015-07-15 11:07:09', 1),
	(12, 3351.5, '2015-07-15 11:22:29', 1),
	(13, 6054.5, '2015-07-15 11:30:42', 1),
	(14, 0, '2015-07-15 13:30:50', 1),
	(15, 8900, '2015-07-15 15:29:13', 1),
	(16, 0, '2015-07-15 18:19:28', 1),
	(17, 1050.5, '2015-07-15 19:01:47', 1),
	(18, 3000, '2015-07-15 19:03:44', 1),
	(19, 3153.5, '2015-07-15 19:25:01', 1),
	(20, 3901, '2015-07-15 23:39:46', 1),
	(21, 4351.5, '2015-07-15 23:41:09', 1),
	(22, 450.5, '2015-07-15 23:54:12', 1),
	(23, 4401, '2015-07-15 23:56:18', 1);
/*!40000 ALTER TABLE `item_order_master` ENABLE KEYS */;


-- Dumping structure for table shoppingcart.order_item
CREATE TABLE IF NOT EXISTS `order_item` (
  `order_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `FK2D110D642FC2D3D3` (`item_id`),
  CONSTRAINT `FK2D110D642FC2D3D3` FOREIGN KEY (`item_id`) REFERENCES `shopping_items` (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

-- Dumping data for table shoppingcart.order_item: ~39 rows (approximately)
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
REPLACE INTO `order_item` (`order_item_id`, `quantity`, `item_id`) VALUES
	(1, 1, 1),
	(2, 10, 3),
	(3, 8, 5),
	(4, 4, 1),
	(5, 3, 2),
	(6, 4, 3),
	(7, 10, 1),
	(8, 3, 1),
	(9, 2, 3),
	(10, 3, 1),
	(11, 1, 1),
	(12, 1, 1),
	(13, 2, 1),
	(14, 4, 3),
	(15, 3, 1),
	(16, 4, 3),
	(17, 3, 1),
	(18, 4, 3),
	(19, 3, 1),
	(20, 4, 3),
	(21, 9, 1),
	(22, 4, 3),
	(23, 3, 3),
	(24, 2, 2),
	(25, 1, 4),
	(26, 1, 6),
	(27, 1, 5),
	(28, 1, 1),
	(29, 1, 4),
	(30, 1, 6),
	(31, 7, 1),
	(32, 6, 3),
	(33, 2, 1),
	(34, 3, 1),
	(35, 1, 6),
	(36, 1, 1),
	(37, 2, 1),
	(38, 1, 3),
	(39, 1, 6);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;


-- Dumping structure for table shoppingcart.order_order_items
CREATE TABLE IF NOT EXISTS `order_order_items` (
  `order_id` int(11) NOT NULL,
  `order_item_id` int(11) NOT NULL,
  UNIQUE KEY `order_item_id` (`order_item_id`),
  KEY `FK2928001E40660986` (`order_item_id`),
  KEY `FK2928001E6C330ED8` (`order_id`),
  CONSTRAINT `FK2928001E40660986` FOREIGN KEY (`order_item_id`) REFERENCES `order_item` (`order_item_id`),
  CONSTRAINT `FK2928001E6C330ED8` FOREIGN KEY (`order_id`) REFERENCES `item_order_master` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table shoppingcart.order_order_items: ~39 rows (approximately)
/*!40000 ALTER TABLE `order_order_items` DISABLE KEYS */;
REPLACE INTO `order_order_items` (`order_id`, `order_item_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(3, 4),
	(3, 5),
	(3, 6),
	(4, 7),
	(5, 8),
	(5, 9),
	(6, 10),
	(7, 11),
	(8, 12),
	(9, 13),
	(9, 14),
	(10, 15),
	(10, 16),
	(11, 17),
	(11, 18),
	(12, 19),
	(12, 20),
	(13, 21),
	(13, 22),
	(15, 23),
	(15, 24),
	(15, 25),
	(15, 26),
	(15, 27),
	(17, 28),
	(17, 29),
	(18, 30),
	(19, 31),
	(20, 32),
	(20, 33),
	(21, 34),
	(21, 35),
	(22, 36),
	(23, 37),
	(23, 38),
	(23, 39);
/*!40000 ALTER TABLE `order_order_items` ENABLE KEYS */;


-- Dumping structure for table shoppingcart.shopping_items
CREATE TABLE IF NOT EXISTS `shopping_items` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_description` varchar(500) DEFAULT NULL,
  `item_name` varchar(200) DEFAULT NULL,
  `item_price` float DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table shoppingcart.shopping_items: ~6 rows (approximately)
/*!40000 ALTER TABLE `shopping_items` DISABLE KEYS */;
REPLACE INTO `shopping_items` (`item_id`, `item_description`, `item_name`, `item_price`) VALUES
	(1, 'computer USB Mouse', 'Mouse', 450.5),
	(2, 'computer USB KeyBoard', 'KeyBord', 650),
	(3, 'Portable PenDrive', 'PenDrive', 500),
	(4, 'headphone', 'Head Phone', 600),
	(5, 'dongle', 'Dongle', 2500),
	(6, 'camera', 'Camera', 3000);
/*!40000 ALTER TABLE `shopping_items` ENABLE KEYS */;


-- Dumping structure for table shoppingcart.user_master
CREATE TABLE IF NOT EXISTS `user_master` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` varchar(255) DEFAULT NULL,
  `email_id` varchar(200) DEFAULT NULL,
  `first_name` varchar(200) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `user_address` varchar(500) DEFAULT NULL,
  `user_contact` varchar(100) DEFAULT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table shoppingcart.user_master: ~2 rows (approximately)
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
REPLACE INTO `user_master` (`user_id`, `dob`, `email_id`, `first_name`, `gender`, `last_name`, `password`, `user_address`, `user_contact`, `user_name`) VALUES
	(1, '1992-10-27 22:13:41', 'naresh.goyal@nagarro.com', 'Naresh', 'Male', 'Goyal', '1234', 'GGN', '8588899060', 'naresh'),
	(2, '1992-10-26 ', 'narugoyal', ' Naru', 'Male', 'Goyal', '6789', 'ggn', '9417713690', 'naru');
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
