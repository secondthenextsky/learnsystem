-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.19-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 learnsystem 的数据库结构
DROP DATABASE IF EXISTS `learnsystem`;
CREATE DATABASE IF NOT EXISTS `learnsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `learnsystem`;

-- 导出  表 learnsystem.manager 结构
DROP TABLE IF EXISTS `manager`;
CREATE TABLE IF NOT EXISTS `manager` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL DEFAULT '0' COMMENT '姓名',
  `password` varchar(50) NOT NULL DEFAULT '0' COMMENT '密码（加密后保存）',
  `phonenumber` varchar(50) NOT NULL DEFAULT '0' COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员';

-- 正在导出表  learnsystem.manager 的数据：~0 rows (大约)
DELETE FROM `manager`;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`id`, `username`, `password`, `phonenumber`) VALUES
	('1', 'root', 'Y6nw6nu5gFB5a2SehUgYRQ==', '13919191919');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;

-- 导出  表 learnsystem.privilege 结构
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE IF NOT EXISTS `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '0' COMMENT '权限名（采用接口url）',
  `description` varchar(100) NOT NULL DEFAULT '0' COMMENT '权限描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

-- 正在导出表  learnsystem.privilege 的数据：~0 rows (大约)
DELETE FROM `privilege`;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;

-- 导出  表 learnsystem.role 结构
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '0' COMMENT '角色名',
  `description` varchar(100) NOT NULL DEFAULT '0' COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色：管理员，教师，学生';

-- 正在导出表  learnsystem.role 的数据：~3 rows (大约)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `description`) VALUES
	(1, '管理员', '管理员'),
	(2, '教师', '教师'),
	(3, '学生', '学生');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- 导出  表 learnsystem.role_privilege 结构
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE IF NOT EXISTS `role_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  `privilegeId` int(11) NOT NULL DEFAULT '0' COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

-- 正在导出表  learnsystem.role_privilege 的数据：~0 rows (大约)
DELETE FROM `role_privilege`;
/*!40000 ALTER TABLE `role_privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_privilege` ENABLE KEYS */;

-- 导出  表 learnsystem.student 结构
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL DEFAULT '0' COMMENT '姓名',
  `password` varchar(50) NOT NULL DEFAULT '0' COMMENT '密码（加密后保存）',
  `gender` varchar(10) NOT NULL DEFAULT '男' COMMENT '性别',
  `number` varchar(10) NOT NULL COMMENT '学号',
  `birthday` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '生日',
  `nation` varchar(50) NOT NULL DEFAULT '汉族' COMMENT '民族',
  `college` varchar(50) NOT NULL COMMENT '学院',
  `major` varchar(50) NOT NULL COMMENT '专业',
  `idcardnumber` varchar(50) NOT NULL COMMENT '身份证号',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `phonenumber` varchar(50) NOT NULL COMMENT '联系方式',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `intendtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入学时间',
  `remarks` varchar(50) NOT NULL DEFAULT '无' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  learnsystem.student 的数据：~0 rows (大约)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `username`, `password`, `gender`, `number`, `birthday`, `nation`, `college`, `major`, `idcardnumber`, `address`, `phonenumber`, `email`, `intendtime`, `remarks`) VALUES
	('1', 'sky', '4QrcOUm6Wau+VuBX8g+IPg==', '男', '12344411', '2018-12-17 04:04:15', '汉族', '商学院', '数学专业', '141312121212121212', '夏威夷', '12131313131', '123@qq.com', '2018-12-17 03:24:43', '无');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- 导出  表 learnsystem.teacher 结构
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL DEFAULT '0' COMMENT '姓名',
  `password` varchar(50) NOT NULL DEFAULT '0' COMMENT '密码（加密后保存）',
  `phonenumber` varchar(50) NOT NULL DEFAULT '0' COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';

-- 正在导出表  learnsystem.teacher 的数据：~0 rows (大约)
DELETE FROM `teacher`;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- 导出  表 learnsystem.user_role 结构
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) NOT NULL DEFAULT '0' COMMENT '用户id',
  `roleId` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色关联表';

-- 正在导出表  learnsystem.user_role 的数据：~0 rows (大约)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
