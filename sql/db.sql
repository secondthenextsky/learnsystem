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

-- 导出  表 learnsystem.article 结构
DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `textContent` text NOT NULL COMMENT '文字内容',
  `teacherId` varchar(50) NOT NULL COMMENT '发布者-教师id',
  `teacherName` varchar(50) DEFAULT NULL COMMENT '教师姓名',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='课程章节';

-- 正在导出表  learnsystem.article 的数据：~11 rows (大约)
DELETE FROM `article`;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`id`, `sort`, `title`, `textContent`, `teacherId`, `teacherName`, `createTime`) VALUES
	(3, 0, 'asd', '阿萨德撒地方', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-18 06:15:22'),
	(4, 0, 'asd', '阿萨德撒地方2222222', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-18 06:17:16'),
	(5, 4, '安安定定', '阿萨达阿士大夫阿士大夫阿士大夫阿士大夫阿萨达发送到发送到发斯蒂芬阿士大夫阿萨达发斯蒂芬阿士大夫阿萨达阿萨达', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-18 06:21:45'),
	(6, 3, '安安定定', '阿萨达阿士大夫阿士大夫阿士大夫阿士大夫阿萨达发送到发送到发斯蒂芬阿士大夫阿萨达发斯蒂芬阿士大夫阿萨达阿萨达', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-18 06:23:02'),
	(7, 0, '安安定定', '阿萨达阿士大夫阿士大夫阿士大夫阿士大夫阿萨达发送到发送到发斯蒂芬阿士大夫阿萨达发斯蒂芬阿士大夫阿萨达阿萨达', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-18 06:24:00'),
	(8, 0, '安安定定', '阿萨达阿士大夫阿士大夫阿士大夫阿士大夫阿萨达发送到发送到发斯蒂芬阿士大夫阿萨达发斯蒂芬阿士大夫阿萨达阿萨达', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-18 06:25:26'),
	(9, 0, 'sd', '少的地方水电费', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-19 01:53:31'),
	(10, 0, '111', '1111111111', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-19 02:36:41'),
	(11, 0, '2222', '222222222222222', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-19 02:37:03'),
	(12, 0, '4', '44', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-19 02:56:41'),
	(13, 0, '1111', '11111', '7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '2018-12-19 03:45:22');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- 导出  表 learnsystem.attachment 结构
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE IF NOT EXISTS `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(100) NOT NULL DEFAULT '0' COMMENT '文件名',
  `articleId` int(11) NOT NULL DEFAULT '0' COMMENT '所属课程章节id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='课程附件';

-- 正在导出表  learnsystem.attachment 的数据：~5 rows (大约)
DELETE FROM `attachment`;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
INSERT INTO `attachment` (`id`, `fileName`, `articleId`) VALUES
	(5, '1545085525716捕获.PNG', 8),
	(6, '1545085525718显卡.PNG', 8),
	(11, '1545155610577', 9),
	(12, '1545158200552详细报表.txt', 10),
	(13, '1545158223124详细报表.txt', 11);
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;

-- 导出  表 learnsystem.homework 结构
DROP TABLE IF EXISTS `homework`;
CREATE TABLE IF NOT EXISTS `homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL COMMENT '作业内容',
  `beginTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `endTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '截止提交时间',
  `teacherId` varchar(50) NOT NULL COMMENT '发布者id',
  `teacherName` varchar(50) NOT NULL COMMENT '发布者姓名',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作业';

-- 正在导出表  learnsystem.homework 的数据：~0 rows (大约)
DELETE FROM `homework`;
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;

-- 导出  表 learnsystem.manager 结构
DROP TABLE IF EXISTS `manager`;
CREATE TABLE IF NOT EXISTS `manager` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL DEFAULT '0' COMMENT '姓名',
  `password` varchar(50) NOT NULL DEFAULT '0' COMMENT '密码（加密后保存）',
  `phonenumber` varchar(50) NOT NULL DEFAULT '0' COMMENT '联系方式',
  `gender` varchar(10) NOT NULL DEFAULT '男' COMMENT '性别',
  `number` varchar(10) NOT NULL DEFAULT '0' COMMENT '工号',
  `birthday` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '生日',
  `nation` varchar(50) NOT NULL DEFAULT '汉族' COMMENT '民族',
  `remarks` varchar(50) NOT NULL DEFAULT '0' COMMENT '备注',
  `idcardnumber` varchar(50) NOT NULL DEFAULT '0' COMMENT '身份证号',
  `address` varchar(50) NOT NULL DEFAULT '0' COMMENT '地址',
  `email` varchar(50) NOT NULL DEFAULT '0' COMMENT '电子邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员';

-- 正在导出表  learnsystem.manager 的数据：~1 rows (大约)
DELETE FROM `manager`;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`id`, `username`, `password`, `phonenumber`, `gender`, `number`, `birthday`, `nation`, `remarks`, `idcardnumber`, `address`, `email`) VALUES
	('1', 'root', 'Y6nw6nu5gFB5a2SehUgYRQ==', '13919191919', '男', '0', '2018-12-17 08:00:00', '汉族', '汉族', '0', '0888', '123@QQ。com');
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
	('sdfasdf', 'sky', '4QrcOUm6Wau+VuBX8g+IPg==', '男vv', '12344411', '2018-12-17 08:00:00', '汉族', '商学院233', '数学专业233', '141312121212121212', '夏威夷233', '12131313131', '123@qq.com', '2018-12-18 08:00:00', '无');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- 导出  表 learnsystem.student_homework 结构
DROP TABLE IF EXISTS `student_homework`;
CREATE TABLE IF NOT EXISTS `student_homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(50) NOT NULL COMMENT '学生id',
  `homeworkId` int(11) NOT NULL COMMENT '作业id',
  `answer` text NOT NULL COMMENT '学生作答',
  `opinion` text NOT NULL COMMENT '教师批改意见',
  `score` float NOT NULL COMMENT '分数',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生-作业关联表';

-- 正在导出表  learnsystem.student_homework 的数据：~0 rows (大约)
DELETE FROM `student_homework`;
/*!40000 ALTER TABLE `student_homework` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_homework` ENABLE KEYS */;

-- 导出  表 learnsystem.teacher 结构
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL DEFAULT '0' COMMENT '姓名',
  `password` varchar(50) NOT NULL DEFAULT '0' COMMENT '密码（加密后保存）',
  `phonenumber` varchar(50) NOT NULL DEFAULT '0' COMMENT '联系方式',
  `gender` varchar(10) NOT NULL DEFAULT '男' COMMENT '性别',
  `number` varchar(10) NOT NULL DEFAULT '0' COMMENT '工号',
  `birthday` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '生日',
  `nation` varchar(50) NOT NULL DEFAULT '汉族' COMMENT '民族',
  `remarks` varchar(50) NOT NULL DEFAULT '无' COMMENT '备注',
  `idcardnumber` varchar(50) NOT NULL DEFAULT '0' COMMENT '身份证号',
  `address` varchar(50) NOT NULL DEFAULT '0' COMMENT '地址',
  `email` varchar(50) NOT NULL DEFAULT '0' COMMENT '电子邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';

-- 正在导出表  learnsystem.teacher 的数据：~3 rows (大约)
DELETE FROM `teacher`;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`id`, `username`, `password`, `phonenumber`, `gender`, `number`, `birthday`, `nation`, `remarks`, `idcardnumber`, `address`, `email`) VALUES
	('45a78722-2863-4a57-b0a2-97b5277cae1e', 'asdf111', '4QrcOUm6Wau+VuBX8g+IPg==', 'asdf', 'asdf', 'asdf', '2018-12-21 08:00:00', 'a11111111111111111', 'x11', 'd1111111111111111', 'd11111111111111111', 'x11'),
	('6f8b91ba-3612-432f-9a8e-413ba1f8f742', 't333', '4QrcOUm6Wau+VuBX8g+IPg==', 'sfdad', '男233', '123', '2018-12-19 08:00:00', '汉族', '无', '456', '789', '000'),
	('7fad3404-cbb5-476a-943f-a3f1a24d93df', 't1', '4QrcOUm6Wau+VuBX8g+IPg==', '123412341234', '男2', '134134', '2018-12-17 08:00:00', '汉族', '无233', '114422323', 'add', '55@66.com11');
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
