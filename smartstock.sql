-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 06, 2024 at 09:25 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartstock`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cartid` int(11) NOT NULL,
  `INID` varchar(50) NOT NULL,
  `Product_Name` varchar(50) NOT NULL,
  `Bar_code` varchar(50) NOT NULL,
  `qty` varchar(50) NOT NULL,
  `Unit_Price` varchar(50) NOT NULL,
  `Total_Price` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cartid`, `INID`, `Product_Name`, `Bar_code`, `qty`, `Unit_Price`, `Total_Price`) VALUES
(1, '1', 'UltraHD 4K TV', '129781', '1', '33000', '33000.0'),
(2, '2', 'Portable Bluetooth Speaker', '129788', '2', '2750', '5500.0');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cid` int(11) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `Tp_Number` varchar(20) NOT NULL,
  `billing_address` varchar(50) NOT NULL,
  `shipping_address` varchar(50) NOT NULL,
  `bank` varchar(11) NOT NULL,
  `city` varchar(11) NOT NULL,
  `person_name` varchar(11) NOT NULL,
  `contact_person` varchar(11) NOT NULL,
  `person_tp` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `online` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cid`, `customer_name`, `Tp_Number`, `billing_address`, `shipping_address`, `bank`, `city`, `person_name`, `contact_person`, `person_tp`, `email`, `online`) VALUES
(1, 'Rafael Marsaga', '09104472313', 'Tadeco', 'Tadeco', '', 'Panabo', '', '', '', '', ''),
(2, 'Aude Mar Busaco', '09126962647', 'Northern Subd.', 'Northern Subd.', '', 'Panabo', '', '', '', '', ''),
(3, 'Xyze Mantalaba', '09126962647', 'Buhangin', 'Buhangin', '', 'Davao', '', '', '', '', ''),
(4, 'John Lyold Lozada', '09635690985', 'New Visayas', 'New Visayas', '', 'Panabo', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `eid` int(11) NOT NULL,
  `employee_name` varchar(50) NOT NULL,
  `Tp_Number` varchar(20) NOT NULL,
  `main_address` varchar(50) NOT NULL,
  `temp_address` varchar(50) NOT NULL,
  `bank` varchar(11) NOT NULL,
  `city` varchar(11) NOT NULL,
  `person_name` varchar(11) NOT NULL,
  `contact_person` varchar(11) NOT NULL,
  `person_tp` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `online` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`eid`, `employee_name`, `Tp_Number`, `main_address`, `temp_address`, `bank`, `city`, `person_name`, `contact_person`, `person_tp`, `email`, `online`) VALUES
(1, 'Rafael Marsaga', '09104472313', 'Tadeco', 'Tadeco', '', 'Panabo', '', '', '', '', ''),
(2, 'Xyze Mantalaba', '09126962647', 'Buhangin', 'Buhangin', '', 'Davao', '', '', '', '', ''),
(3, 'John Lyold Lozada', '09635690985', 'New Visayas', 'New Visayas', '', 'Panabo', '', '', '', '', ''),
(4, 'Aude Mar Busaco', '', 'Northern Subd.', 'Northern Subd.', '', 'Panabo', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `extra`
--

CREATE TABLE `extra` (
  `exid` int(11) NOT NULL,
  `val` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `extra`
--

INSERT INTO `extra` (`exid`, `val`) VALUES
(1, '2');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `Product_Name` varchar(100) NOT NULL,
  `Bar_code` varchar(100) NOT NULL,
  `Price` varchar(100) NOT NULL,
  `Sell_Price` varchar(50) NOT NULL,
  `Qty` varchar(100) NOT NULL,
  `Sid` varchar(100) NOT NULL,
  `Supplier_Name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pid`, `Product_Name`, `Bar_code`, `Price`, `Sell_Price`, `Qty`, `Sid`, `Supplier_Name`) VALUES
(1, 'UltraHD 4K TV', '129781', '22000', '33000', '100', '4', 'Aude Mar Busaco'),
(2, 'Wireless Noise-Cancelling Headphones', '129782', '4400', '150', '100', '1', 'Rafael Marsaga'),
(3, 'Smart Home Assistant', '129783', '2750', '5500', '50', '2', 'John Lyold Lozada'),
(4, 'Electric Scooter', '129784', '11000', '19250', '20', '3', 'Xyze Mantalaba'),
(5, 'Fitness Tracker', '129785', '1650', '4125', '200', '2', 'John Lyold Lozada'),
(6, 'Gaming Laptop', '129786', '49500', '66000', '50', '1', 'Rafael Marsaga'),
(7, 'Smartwatch', '129787', '3,300', '6600', '100', '3', 'Xyze Mantalaba'),
(8, 'Portable Bluetooth Speaker', '129788', '1100', '2750', '120', '4', 'Aude Mar Busaco'),
(9, 'Home Security Camera System', '129789', '8250', '13750', '50', '1', 'Rafael Marsaga'),
(10, 'Robotic Vacuum Cleaner', '129790', '5500', '11000', '100', '4', 'Aude Mar Busaco');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `saleid` int(11) NOT NULL,
  `INID` varchar(50) NOT NULL,
  `Cid` varchar(100) NOT NULL,
  `Customer_Name` varchar(30) NOT NULL,
  `Total_Qty` varchar(50) NOT NULL,
  `Total_Bill` varchar(50) NOT NULL,
  `Status` varchar(11) NOT NULL,
  `Balance` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`saleid`, `INID`, `Cid`, `Customer_Name`, `Total_Qty`, `Total_Bill`, `Status`, `Balance`) VALUES
(1, '1', '1', 'Rafael Marsaga', '1.0', '33000.0', 'Paid', '660.00'),
(2, '2', '2', 'Aude Mar Busaco', '2.0', '5500.0', 'Partial', '-500.00');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `sid` int(11) NOT NULL,
  `supplier_name` varchar(50) NOT NULL,
  `Tp_Number` varchar(20) NOT NULL,
  `billing_address` varchar(50) NOT NULL,
  `shipping_address` varchar(50) NOT NULL,
  `bank` varchar(11) NOT NULL,
  `city` varchar(11) NOT NULL,
  `person_name` varchar(11) NOT NULL,
  `contact_person` varchar(11) NOT NULL,
  `person_tp` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `online` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`sid`, `supplier_name`, `Tp_Number`, `billing_address`, `shipping_address`, `bank`, `city`, `person_name`, `contact_person`, `person_tp`, `email`, `online`) VALUES
(1, 'Rafael Marsaga', '09104472313', 'Tadeco', 'Tadeco', '', 'Panabo', '', '', '', '', ''),
(2, 'John Lyold Lozada', '09635690985', 'New Visayas', 'New Visayas', '', 'Panabo', '', '', '', '', ''),
(3, 'Xyze Mantalaba', '09126962647', 'Buhangin', 'Buhangin', '', 'Davao', '', '', '', '', ''),
(4, 'Aude Mar Busaco', '09126962647', 'Northern Subd.', 'Northern Subd.', '', 'Panabo', '', '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`eid`);

--
-- Indexes for table `extra`
--
ALTER TABLE `extra`
  ADD PRIMARY KEY (`exid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`saleid`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`sid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cartid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `eid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `extra`
--
ALTER TABLE `extra`
  MODIFY `exid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `saleid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
