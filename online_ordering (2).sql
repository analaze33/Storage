-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 01, 2022 at 09:01 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `online_ordering`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(11) NOT NULL,
  `qty` int(4) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`ID`, `name`, `type`, `qty`, `price`) VALUES
(4, 'Cola', 'drink', 70, '10.99'),
(3, 'Pasta', 'food', 83, '60.34'),
(2, 'Pizza', 'food', 83, '59.99'),
(1, 'Soup', 'food', 70, '25.00'),
(5, 'Coffee', 'drink', 44, '7.99'),
(6, 'Juice', 'drink', 61, '10.99'),
(7, 'Cake', 'dessert', 63, '12.99'),
(8, 'Muffin', 'dessert', 72, '15.67'),
(9, 'Donut', 'dessert', 74, '10.55');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) NOT NULL,
  `customer_surname` varchar(255) NOT NULL,
  `customer_phone` text NOT NULL,
  `customer_address` text NOT NULL,
  `customer_email` text NOT NULL,
  `food_name` varchar(255) NOT NULL,
  `food_price` decimal(10,2) NOT NULL,
  `food_qty` int(11) NOT NULL,
  `drink_name` varchar(255) NOT NULL,
  `drink_price` decimal(10,2) NOT NULL,
  `drink_qty` int(11) NOT NULL,
  `dessert_name` varchar(255) CHARACTER SET utf32 NOT NULL,
  `dessert_price` decimal(10,2) NOT NULL,
  `dessert_qty` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`ID`, `customer_name`, `customer_surname`, `customer_phone`, `customer_address`, `customer_email`, `food_name`, `food_price`, `food_qty`, `drink_name`, `drink_price`, `drink_qty`, `dessert_name`, `dessert_price`, `dessert_qty`) VALUES
(1, 'John ', 'Smith', '+355 789 3456', 'aaaa', 'johnsmith@gmail.com', 'Soup', '5.00', 3, 'Juice', '10.99', 3, 'Cake', '5.99', 2),
(2, 'Williams ', 'Taylor', '+355 789 3456', 'bbbb', 'williamstaylor@gmail.com', 'Pizza', '9.99', 5, 'Cola', '10.99', 7, '-', '0.00', 0),
(3, 'Davies', 'Brown', '+355 789 3689', 'Tirana', 'daviesbrown@gmail.com', 'Pizza', '9.99', 5, 'Coffee', '7.99', 4, 'Muffin', '5.67', 4),
(4, 'Thompson', 'Wright', '+355 789 432', 'Tirana', 'thompsonwright@gmail.com', '-', '0.00', 0, 'Juice', '10.99', 5, '-', '0.00', 0),
(5, 'Walker', 'Hall', '+355 789 43256', 'Tirana', 'walkerhall@gmail.com', 'Pasta', '6.34', 5, '-', '0.00', 0, 'Donut', '4.55', 4),
(6, 'Lewis', 'Harris', '+355 679 4325', 'Tirana', 'lewisharris@gmail.com', 'Pizza', '9.99', 4, 'Cola', '10.99', 4, 'Muffin', '5.67', 4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
