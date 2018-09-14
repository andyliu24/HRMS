-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2018-09-14 22:14:37
-- 服务器版本： 5.6.37-log
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- 表的结构 `department`
--

CREATE TABLE `department` (
  `id` varchar(20) NOT NULL COMMENT '部门编号',
  `name` varchar(20) DEFAULT NULL COMMENT '部门名称',
  `manager_id` varchar(20) DEFAULT NULL COMMENT '部门经理工号',
  `superior` varchar(20) DEFAULT NULL COMMENT '上级部门编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `department`
--

INSERT INTO `department` (`id`, `name`, `manager_id`, `superior`) VALUES
('201801', '市场部', '2018070501', '201802'),
('201802', '销售部', '2018070501', '201803'),
('201803', '后勤部', '2018070502', '201802');

-- --------------------------------------------------------

--
-- 表的结构 `department_movement`
--

CREATE TABLE `department_movement` (
  `id` varchar(30) NOT NULL,
  `old_department_id` varchar(30) NOT NULL,
  `new_department_id` varchar(30) NOT NULL,
  `department_movement_date` date NOT NULL DEFAULT '0000-00-00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 表的结构 `employees`
--

CREATE TABLE `employees` (
  `id` varchar(20) NOT NULL COMMENT '员工编号',
  `department_id` varchar(20) DEFAULT NULL COMMENT '部门编号',
  `position_id` varchar(20) DEFAULT NULL COMMENT '岗位编号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `salary` int(11) DEFAULT NULL COMMENT '月薪',
  `trial_start_time` date DEFAULT NULL COMMENT '试用起始时间',
  `trial_end_time` date DEFAULT NULL COMMENT '试用终止时间',
  `register_date` date DEFAULT NULL COMMENT '转正时间',
  `dimission_date` date DEFAULT NULL COMMENT '离职时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `employees`
--

INSERT INTO `employees` (`id`, `department_id`, `position_id`, `name`, `sex`, `birthday`, `telephone`, `salary`, `trial_start_time`, `trial_end_time`, `register_date`, `dimission_date`) VALUES
('2018070501', '201801', '20180705', '周家梁', '男', '2018-07-10', '110', 500, '2018-07-03', '2018-07-19', '2018-07-19', '2018-07-31'),
('2018070502', '201803', '20180707', '周云瑞', '男', '2018-07-03', '112', 12000, '2018-07-03', '2018-07-03', '2018-07-04', '2018-07-28'),
('2018070503', '201802', '20180707', '刘孟骁', '男', '1998-02-04', '15564863850', 70000, '2018-07-15', '2018-07-16', '2018-07-16', NULL),
('2018070504', '201803', '20180705', '赵心昊', '男', '1990-11-11', '122', 7999, '2018-07-12', '2018-07-15', '2018-07-15', NULL),
('2018070505', '201803', '20180705', '周韬', '男', '2018-07-15', '10010', 8000000, '2018-07-02', '2018-07-05', '2018-07-05', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `employee_information`
--

CREATE TABLE `employee_information` (
  `id` varchar(20) NOT NULL,
  `old_company` varchar(30) DEFAULT NULL,
  `seniority` varchar(30) DEFAULT NULL,
  `master_language` varchar(30) DEFAULT NULL,
  `political_status` varchar(30) DEFAULT NULL,
  `whether_married` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `employee_information`
--

INSERT INTO `employee_information` (`id`, `old_company`, `seniority`, `master_language`, `political_status`, `whether_married`) VALUES
('2018070503', '', '', '', '中共党员', '');

-- --------------------------------------------------------

--
-- 表的结构 `positions`
--

CREATE TABLE `positions` (
  `id` varchar(20) NOT NULL COMMENT '岗位编号',
  `name` varchar(20) DEFAULT NULL COMMENT '岗位名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `positions`
--

INSERT INTO `positions` (`id`, `name`) VALUES
('20180705', '经理'),
('20180706', '程序员'),
('20180707', '总裁');

-- --------------------------------------------------------

--
-- 表的结构 `position_movement`
--

CREATE TABLE `position_movement` (
  `id` varchar(30) NOT NULL,
  `old_position_id` varchar(30) NOT NULL,
  `new_position_id` varchar(30) NOT NULL,
  `position_movement_date` date NOT NULL DEFAULT '0000-00-00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 表的结构 `userinfo`
--

CREATE TABLE `userinfo` (
  `username` varchar(30) NOT NULL,
  `password` varchar(35) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `userinfo`
--

INSERT INTO `userinfo` (`username`, `password`, `name`) VALUES
('admin', 'c4ca4238a0b923820dcc509a6f75849b', '管理员');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`),
  ADD KEY `manager_id` (`manager_id`),
  ADD KEY `superior` (`superior`);

--
-- Indexes for table `department_movement`
--
ALTER TABLE `department_movement`
  ADD PRIMARY KEY (`id`,`old_department_id`,`new_department_id`,`department_movement_date`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD KEY `position_id` (`position_id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `employee_information`
--
ALTER TABLE `employee_information`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `positions`
--
ALTER TABLE `positions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `position_movement`
--
ALTER TABLE `position_movement`
  ADD PRIMARY KEY (`id`,`old_position_id`,`new_position_id`,`position_movement_date`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`username`);

--
-- 限制导出的表
--

--
-- 限制表 `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`id`),
  ADD CONSTRAINT `department_ibfk_2` FOREIGN KEY (`superior`) REFERENCES `department` (`id`);

--
-- 限制表 `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`position_id`) REFERENCES `positions` (`id`),
  ADD CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- 限制表 `employee_information`
--
ALTER TABLE `employee_information`
  ADD CONSTRAINT `control_id` FOREIGN KEY (`id`) REFERENCES `employees` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
