-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2015 at 08:48 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `scheduler`
--
CREATE DATABASE IF NOT EXISTS `scheduler` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `scheduler`;

-- --------------------------------------------------------

--
-- Table structure for table `classrooms`
--

CREATE TABLE IF NOT EXISTS `classrooms` (
  `roomCode` varchar(10) NOT NULL,
  `roomName` varchar(255) NOT NULL,
  `roomCapacity` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  PRIMARY KEY (`roomCode`),
  KEY `typeId` (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `class_types`
--

CREATE TABLE IF NOT EXISTS `class_types` (
  `typeId` int(11) NOT NULL,
  `typeName` varchar(255) NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class_types`
--

INSERT INTO `class_types` (`typeId`, `typeName`) VALUES
(1, 'Lecture'),
(2, 'Tutorial'),
(3, 'Lab'),
(4, 'Workshop');

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `groupCode` varchar(10) NOT NULL,
  `noOfStudents` int(11) NOT NULL,
  PRIMARY KEY (`groupCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `group_module`
--

CREATE TABLE IF NOT EXISTS `group_module` (
  `groupCode` varchar(10) NOT NULL,
  `moduleCode` varchar(10) NOT NULL,
  `identifier` varchar(20) NOT NULL,
  PRIMARY KEY (`groupCode`,`moduleCode`),
  KEY `groupCode` (`groupCode`,`moduleCode`),
  KEY `moduleCode` (`moduleCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login_info`
--

CREATE TABLE IF NOT EXISTS `login_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `login_info`
--

INSERT INTO `login_info` (`id`, `username`, `password`) VALUES
(1, 'nikesh', 'maharjan123');

-- --------------------------------------------------------

--
-- Table structure for table `modules`
--

CREATE TABLE IF NOT EXISTS `modules` (
  `moduleCode` varchar(10) NOT NULL,
  `moduleName` varchar(255) NOT NULL,
  PRIMARY KEY (`moduleCode`),
  UNIQUE KEY `moduleName` (`moduleName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `module_classes`
--

CREATE TABLE IF NOT EXISTS `module_classes` (
  `typeId` int(11) NOT NULL,
  `moduleCode` varchar(10) NOT NULL,
  `classHours` decimal(10,2) NOT NULL,
  PRIMARY KEY (`typeId`,`moduleCode`),
  KEY `typeId` (`typeId`,`moduleCode`),
  KEY `moduleCode` (`moduleCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE IF NOT EXISTS `teachers` (
  `teacherId` varchar(20) NOT NULL,
  `teacherName` varchar(50) NOT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `teacher_modules`
--

CREATE TABLE IF NOT EXISTS `teacher_modules` (
  `teacherId` varchar(20) NOT NULL,
  `moduleCode` varchar(10) NOT NULL,
  `typeId` int(11) NOT NULL,
  `identifier` varchar(10) NOT NULL,
  PRIMARY KEY (`teacherId`,`moduleCode`,`typeId`),
  UNIQUE KEY `identifier` (`identifier`),
  KEY `teacherId` (`teacherId`),
  KEY `typeId` (`typeId`),
  KEY `moduleCode` (`moduleCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classrooms`
--
ALTER TABLE `classrooms`
  ADD CONSTRAINT `classrooms_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `class_types` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `group_module`
--
ALTER TABLE `group_module`
  ADD CONSTRAINT `group_module_ibfk_1` FOREIGN KEY (`groupCode`) REFERENCES `groups` (`groupCode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `group_module_ibfk_2` FOREIGN KEY (`moduleCode`) REFERENCES `modules` (`moduleCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `module_classes`
--
ALTER TABLE `module_classes`
  ADD CONSTRAINT `module_classes_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `class_types` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `module_classes_ibfk_2` FOREIGN KEY (`moduleCode`) REFERENCES `modules` (`moduleCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `teacher_modules`
--
ALTER TABLE `teacher_modules`
  ADD CONSTRAINT `teacher_modules_ibfk_2` FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teacher_modules_ibfk_3` FOREIGN KEY (`typeId`) REFERENCES `class_types` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teacher_modules_ibfk_4` FOREIGN KEY (`moduleCode`) REFERENCES `modules` (`moduleCode`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
