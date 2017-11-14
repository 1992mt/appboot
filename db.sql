-- --------------------------------------------------------
-- 主机:                           120.24.159.22
-- 服务器版本:                        5.5.43-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 yichaodata 的数据库结构
CREATE DATABASE IF NOT EXISTS `yichaodata` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `yichaodata`;

-- 导出  表 yichaodata.cms_content 结构
CREATE TABLE IF NOT EXISTS `cms_content` (
  `content_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_type` bigint(6) DEFAULT NULL,
  `content_kind` bigint(6) DEFAULT NULL COMMENT '小类别 例如产品具体类型',
  `content_title` varchar(256) DEFAULT NULL,
  `content_title_sub` varchar(256) DEFAULT NULL,
  `content_body` varchar(4000) DEFAULT NULL,
  `content_body_sub` varchar(4000) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `sort_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `complete_time` datetime DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `remarks` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`content_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- 正在导出表  yichaodata.cms_content 的数据：~18 rows (大约)
/*!40000 ALTER TABLE `cms_content` DISABLE KEYS */;
INSERT INTO `cms_content` (`content_id`, `content_type`, `content_kind`, `content_title`, `content_title_sub`, `content_body`, `content_body_sub`, `user_id`, `sort_id`, `create_time`, `update_time`, `complete_time`, `state`, `remarks`) VALUES
	(1, 8, NULL, '测试', NULL, '低洼地', NULL, 'admin', 1, '2016-10-07 20:19:42', NULL, NULL, 'E', NULL),
	(2, 8, NULL, 'haha', NULL, 'hh', NULL, 'admin', 1, '2016-10-07 22:11:33', NULL, NULL, 'E', NULL),
	(3, 8, NULL, 'ces', NULL, '<img src="http://www.haoyuqin.com/yichao/resource/kindeditor/plugins/emoticons/images/10.gif" border="0" alt="" />', NULL, 'admin', 1, '2016-10-08 13:33:40', NULL, NULL, 'E', NULL),
	(4, 4, NULL, '杨见春', NULL, '优秀设计师，从业10年', NULL, 'yichao', 1, '2016-10-08 19:33:17', NULL, NULL, 'U', NULL),
	(5, 4, NULL, '许路伟', NULL, '优秀设计师，从业9年', NULL, 'yichao', 1, '2016-10-08 19:37:26', NULL, NULL, 'U', NULL),
	(6, 8, NULL, '样板/情节', NULL, '<p>\r\n	<br />\r\n</p>', NULL, 'yichao', 1, '2016-10-08 19:40:18', NULL, '2016-10-08 19:45:17', 'U', NULL),
	(7, 8, NULL, '简约/都会', NULL, '舒适', NULL, 'yichao', 2, '2016-10-08 19:42:58', NULL, '2016-10-08 19:44:57', 'U', NULL),
	(8, 8, NULL, '梦幻/时空', NULL, '星/尙/秀/台', NULL, 'yichao', 3, '2016-10-08 19:47:59', NULL, NULL, 'U', NULL),
	(9, 8, NULL, '交流/SOHO', NULL, '<p>\r\n	玻/璃/房\r\n</p>', NULL, 'yichao', 4, '2016-10-08 19:51:09', NULL, NULL, 'U', NULL),
	(10, 1, NULL, '公司简介', NULL, '<span> </span> \r\n<p>\r\n	<span style="font-family:宋体;font-size:15pt;">陆良<span style="font-size:18px;">伊潮装饰</span>成立于</span><span style="font-size:15pt;"><span>2002</span></span><span style="font-family:宋体;font-size:15pt;">年，至今已有</span><span style="font-size:15pt;"><span>14</span></span><span style="font-family:宋体;font-size:15pt;">年的装修行业经验，也是一家集家庭、别墅、办公大楼、娱乐场所、大型门面、公共场所等装饰装修、配套家具、厨具、洁具及建材为一体的综合性专业装饰公司。目前公司经营面积达</span><span style="font-size:15pt;"><span>500</span></span><span style="font-family:宋体;font-size:15pt;">平方米，拥有各类管理人才</span><span style="font-size:15pt;"><span>100</span></span><span style="font-family:宋体;font-size:15pt;">多人，资深的优秀设计团队和专业的设计研发工作室—“具象设计”；专业的施工队伍，完善的售后服务。公司一贯秉承质量、信誉为生存的根本</span><span style="font-size:15pt;"><span>&nbsp;</span></span><span style="font-family:宋体;font-size:15pt;">，</span><span style="font-size:15pt;"><span> </span></span><span style="font-family:宋体;font-size:15pt;">“工程不外包，实行项目经理管理制”，力争做有责任，有爱心的一流优秀装饰企业。经过多年的沉淀与发展，已为</span><span style="font-size:15pt;"><span>1000</span></span><span style="font-family:宋体;font-size:15pt;">多位客户提供高品质、高品位的服务。伊潮装饰已成为陆良著名的品牌公司和一流的装饰企业。</span> \r\n</p>\r\n<span> </span>', NULL, 'yichao', 1, '2016-10-08 19:52:55', NULL, '2016-10-08 19:56:34', 'U', NULL),
	(11, 3, NULL, '公司理念', NULL, '<span> </span><span> </span><span><span style="font-family:宋体;">公司一贯秉承“质量、信誉”为生存的根本，“绿色环保为基础”，“引领</span><span><span>e</span></span><span style="font-family:宋体;">时代家居文化、打造</span><span><span>e</span></span><span style="font-family:宋体;">时代家居风格”为发展目标的企业理念，同时，在售前、售中、售后服务方面也因严格把关，力争做到最好，在客户那里形成良好的口碑，长期的积淀之后，美誉度自然而然就会形成，今天，公司面对激烈的市场竞争能镇定自若，其根本原因是基于消费者的立场来考虑问题。</span></span><span></span>', NULL, 'admin', 2, '2016-10-08 19:57:35', NULL, '2016-10-08 22:58:29', 'U', NULL),
	(12, 5, 1, '龙湖壹号', '杨晓瑞', '<p>\r\n	灰调现代风\r\n</p>', '曲靖市陆良县中枢镇', 'yichao', 1, '2016-10-08 20:28:02', NULL, '2016-10-10 17:39:52', 'E', NULL),
	(13, 3, NULL, '经营理念', NULL, '<span style="font-family:宋体;">伊潮人秉承“求实奋进”的务实经营理念，并将继续以能为尊贵的您提供质量可靠、价格满意的产品而感到无尚光荣！因能为您营造一个雅致、惬意的居室空间而感到无限欢欣！</span>', NULL, 'admin', 1, '2016-10-08 22:13:52', NULL, NULL, 'U', NULL),
	(14, 8, NULL, '1', NULL, '1', NULL, 'admin', 1, '2016-10-10 18:10:40', NULL, NULL, 'E', NULL),
	(15, 6, NULL, '陆良论坛', NULL, 'http://www.luliang.org/', NULL, 'admin', 1, '2016-10-16 10:29:02', NULL, NULL, 'U', NULL),
	(16, 6, NULL, '陆良在线', NULL, 'http://www.llzx.ccoo.cn/', NULL, 'admin', 1, '2016-10-16 10:29:46', NULL, NULL, 'U', NULL),
	(17, 6, NULL, '太平人寿保险有限公司陆良支公司', NULL, 'http://9126519.czvv.com/?_t=t', NULL, 'admin', 0, '2016-10-16 10:34:26', NULL, NULL, 'U', NULL),
	(18, 5, 1, '龙湖壹号', '郭双南', '简约现代的居住空间', '云南省陆良县', 'yichao', 1, '2016-12-03 20:53:15', NULL, '2016-12-03 00:00:00', 'U', NULL);
/*!40000 ALTER TABLE `cms_content` ENABLE KEYS */;

-- 导出  表 yichaodata.cms_content_attr 结构
CREATE TABLE IF NOT EXISTS `cms_content_attr` (
  `attr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_id` bigint(20) DEFAULT NULL,
  `attr_code` varchar(128) DEFAULT NULL,
  `attr_name` varchar(128) DEFAULT NULL,
  `attr_val` varchar(256) DEFAULT NULL,
  `attr_desc` varchar(256) DEFAULT NULL,
  `sort_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `remarks` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  yichaodata.cms_content_attr 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `cms_content_attr` DISABLE KEYS */;
/*!40000 ALTER TABLE `cms_content_attr` ENABLE KEYS */;

-- 导出  表 yichaodata.cms_content_pic 结构
CREATE TABLE IF NOT EXISTS `cms_content_pic` (
  `pic_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_id` bigint(20) DEFAULT NULL,
  `pic_type` int(6) DEFAULT NULL,
  `pic_name` varchar(64) DEFAULT NULL,
  `pic_actual_name` varchar(64) DEFAULT NULL,
  `pic_path` varchar(128) DEFAULT NULL,
  `pic_desc` varchar(512) DEFAULT NULL,
  `sort_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `remarks` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- 正在导出表  yichaodata.cms_content_pic 的数据：~26 rows (大约)
/*!40000 ALTER TABLE `cms_content_pic` DISABLE KEYS */;
INSERT INTO `cms_content_pic` (`pic_id`, `content_id`, `pic_type`, `pic_name`, `pic_actual_name`, `pic_path`, `pic_desc`, `sort_id`, `create_time`, `state`, `remarks`) VALUES
	(1, 1, 1, 'b36c4aad-3a19-45cf-b125-16834772d830.jpg', '300x300x75x1.jpg', '/b36c4aad-3a19-45cf-b125-16834772d830.jpg', '方法', NULL, '2016-10-07 20:19:59', 'E', NULL),
	(2, 3, 1, '147cd13d-a6a4-4abc-9522-52c0ad3d17f6.jpg', '54fbb2fb43166d22e902ab41412309f79152d2ea.jpg', '/147cd13d-a6a4-4abc-9522-52c0ad3d17f6.jpg', '测试', NULL, '2016-10-08 13:34:25', 'E', NULL),
	(3, 4, 1, '6e9dd794-567d-40e7-8a09-5d5f45a87f4c.jpg', '111.jpg', '/6e9dd794-567d-40e7-8a09-5d5f45a87f4c.jpg', '优秀设计师', NULL, '2016-10-08 19:34:04', 'U', NULL),
	(4, 5, 1, '6b6320ac-898d-4f0b-bb93-717dadb2c19a.jpg', '333.jpg', '/6b6320ac-898d-4f0b-bb93-717dadb2c19a.jpg', '优秀设计师', NULL, '2016-10-08 19:37:49', 'U', NULL),
	(5, 6, 1, '3951dbea-73a7-4673-9f0e-786644180dd0.jpg', '1.jpg', '/3951dbea-73a7-4673-9f0e-786644180dd0.jpg', '帅', NULL, '2016-10-08 19:40:33', 'U', NULL),
	(6, 7, 1, '3aafdb0d-6fce-4069-9abe-91e6d8ce1d42.jpg', '2.jpg', '/3aafdb0d-6fce-4069-9abe-91e6d8ce1d42.jpg', '温馨', NULL, '2016-10-08 19:43:17', 'U', NULL),
	(7, 8, 1, 'fe640fe0-7486-473b-b672-332e35cfc23d.jpg', '3.jpg', '/fe640fe0-7486-473b-b672-332e35cfc23d.jpg', '星尚', NULL, '2016-10-08 19:48:18', 'U', NULL),
	(8, 9, 1, '4252bef1-2fdb-45a9-9a0b-d4ef216d2f5f.jpg', '4.jpg', '/4252bef1-2fdb-45a9-9a0b-d4ef216d2f5f.jpg', '玻璃房', NULL, '2016-10-08 19:51:27', 'U', NULL),
	(9, 12, 2, '85e3d031-2286-40ea-88bf-a766afa5ba31.jpg', '角度2.jpg', '/85e3d031-2286-40ea-88bf-a766afa5ba31.jpg', '角度2', NULL, '2016-10-10 17:41:52', 'E', NULL),
	(10, 12, 2, '6d92c85c-e8e8-46f0-8d65-dd0f39240107.jpg', '角度1.jpg', '/6d92c85c-e8e8-46f0-8d65-dd0f39240107.jpg', '角度1', NULL, '2016-10-10 17:41:53', 'E', NULL),
	(11, 12, 1, '2bf8b51b-b923-43f3-844d-f6f464802137.jpg', '角度1.jpg', '/2bf8b51b-b923-43f3-844d-f6f464802137.jpg', '灰调', NULL, '2016-10-10 17:45:02', 'E', NULL),
	(12, 12, 2, '63b8957a-9506-4ffa-95eb-29575741f7e3.jpg', '角度1.jpg', '/63b8957a-9506-4ffa-95eb-29575741f7e3.jpg', '1', NULL, '2016-10-10 17:47:23', 'E', NULL),
	(13, 12, 2, '65930758-4a32-48db-ab4f-6f46c1c727d7.jpg', '角度2.jpg', '/65930758-4a32-48db-ab4f-6f46c1c727d7.jpg', '2', NULL, '2016-10-10 17:47:24', 'E', NULL),
	(14, 12, 1, '11b4425e-6de5-4a10-8fd0-28306a17dd93.jpg', '20130731184.jpg', '/11b4425e-6de5-4a10-8fd0-28306a17dd93.jpg', '1', NULL, '2016-10-10 20:05:07', 'E', NULL),
	(15, 12, 1, '8ce39bb9-bd72-40b4-8097-6ad33c9fc928.jpg', 'logo.jpg', '/8ce39bb9-bd72-40b4-8097-6ad33c9fc928.jpg', '1', NULL, '2016-10-14 22:38:05', 'E', NULL),
	(16, 12, 1, 'ce88d76f-72ea-4f88-a929-b6d515852a95.jpg', '1 (11).jpg', '/ce88d76f-72ea-4f88-a929-b6d515852a95.jpg', '测试', NULL, '2016-10-14 22:41:36', 'E', NULL),
	(17, 12, 2, '2f918461-4c1c-470e-8a4f-63c22f9bc8a2.jpg', '300x300x75x1.jpg', '/2f918461-4c1c-470e-8a4f-63c22f9bc8a2.jpg', '3', NULL, '2016-10-14 22:41:36', 'E', NULL),
	(18, 12, 2, 'c5fe76be-74c1-4828-bd6c-2b237d42f936.png', '13.png', '/c5fe76be-74c1-4828-bd6c-2b237d42f936.png', '2', NULL, '2016-10-14 22:41:37', 'E', NULL),
	(19, 12, 2, '35e7f882-1b40-4199-a2c3-494b67a16fd5.png', '10.png', '/35e7f882-1b40-4199-a2c3-494b67a16fd5.png', '1', NULL, '2016-10-14 22:41:38', 'E', NULL),
	(20, 12, 2, 'c958f47f-839b-4fd3-916e-e1c357bc918f.png', '13.png', '/c958f47f-839b-4fd3-916e-e1c357bc918f.png', '2', NULL, '2016-10-15 00:28:32', 'E', NULL),
	(21, 12, 2, '680e8843-eec5-4622-8be5-2cce4a3db829.png', '13.png', '/680e8843-eec5-4622-8be5-2cce4a3db829.png', '3', NULL, '2016-10-16 13:30:53', 'E', NULL),
	(22, 18, 1, 'a20ccae7-228b-4b9d-989c-817954097f92.jpg', '客厅角度.jpg', '/a20ccae7-228b-4b9d-989c-817954097f92.jpg', '客厅主角度', 1, '2016-12-03 20:55:10', 'U', NULL),
	(23, 18, 2, '1f35b606-5909-4e0f-82b1-bb7499316b28.jpg', '电视墙.jpg', '/1f35b606-5909-4e0f-82b1-bb7499316b28.jpg', '电视背景', 2, '2016-12-03 20:57:18', 'U', NULL),
	(24, 18, 2, '5662a101-22e1-46c8-91f3-86782a0be8e3.jpg', '窗户角度.jpg', '/5662a101-22e1-46c8-91f3-86782a0be8e3.jpg', '阳台', 3, '2016-12-03 20:57:57', 'U', NULL),
	(25, 18, 2, 'd238ab08-6b11-41d2-9581-0d6e99b00c1e.jpg', '餐厅角度.jpg', '/d238ab08-6b11-41d2-9581-0d6e99b00c1e.jpg', '餐厅', 4, '2016-12-03 20:58:24', 'U', NULL),
	(26, 18, 2, 'cb1271e2-32c2-4e49-bf22-31cb91e44704.jpg', '主卧室效果图2222.jpg', '/cb1271e2-32c2-4e49-bf22-31cb91e44704.jpg', '主卧室', 5, '2016-12-03 20:59:15', 'U', NULL);
/*!40000 ALTER TABLE `cms_content_pic` ENABLE KEYS */;

-- 导出  表 yichaodata.wx_counter 结构
CREATE TABLE IF NOT EXISTS `wx_counter` (
  `counter_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `counter_type` bigint(20) NOT NULL COMMENT '1:点赞数',
  `counter_name` varchar(128) DEFAULT NULL,
  `counter_desc` varchar(4000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `remarks` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`counter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  yichaodata.wx_counter 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `wx_counter` DISABLE KEYS */;
INSERT INTO `wx_counter` (`counter_id`, `counter_type`, `counter_name`, `counter_desc`, `create_time`, `state`, `remarks`) VALUES
	(1, 1, '180.102.113.20', '点赞ip地址', '2016-10-16 14:46:45', 'U', NULL),
	(2, 1, '66.249.65.190', '点赞ip地址', '2016-10-19 18:42:19', 'U', NULL),
	(3, 1, '180.102.113.207', '点赞ip地址', '2016-10-25 22:27:14', 'U', NULL);
/*!40000 ALTER TABLE `wx_counter` ENABLE KEYS */;

-- 导出  表 yichaodata.wx_dictionary 结构
CREATE TABLE IF NOT EXISTS `wx_dictionary` (
  `name` varchar(30) NOT NULL,
  `id` bigint(20) NOT NULL,
  `value` varchar(128) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  UNIQUE KEY `Index 1` (`name`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  yichaodata.wx_dictionary 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `wx_dictionary` DISABLE KEYS */;
INSERT INTO `wx_dictionary` (`name`, `id`, `value`, `description`) VALUES
	('productType', 0, 'product_all', '所有项目'),
	('productType', 1, 'product_house', '住宅项目'),
	('productType', 2, 'product_business', '商业项目'),
	('userType', -1, '超级管理员', 'SUPER_ADMIN'),
	('userType', 0, '管理员', 'ADMIN'),
	('userType', 1, '普通用户', 'NORMAL'),
	('userType', 2, '游客', 'TOURIST');
/*!40000 ALTER TABLE `wx_dictionary` ENABLE KEYS */;

-- 导出  表 yichaodata.wx_i18n 结构
CREATE TABLE IF NOT EXISTS `wx_i18n` (
  `i18n_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `i18n_key` varchar(64) NOT NULL,
  `i18n_val` varchar(400) DEFAULT NULL,
  `i18n_val_en` varchar(400) DEFAULT NULL,
  `i18n_desc` varchar(4000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `remarks` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`i18n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- 正在导出表  yichaodata.wx_i18n 的数据：~39 rows (大约)
/*!40000 ALTER TABLE `wx_i18n` DISABLE KEYS */;
INSERT INTO `wx_i18n` (`i18n_id`, `i18n_key`, `i18n_val`, `i18n_val_en`, `i18n_desc`, `create_time`, `state`, `remarks`) VALUES
	(1, 'menu_index', '主页', NULL, '主页', '2016-10-03 11:31:56', 'U', NULL),
	(2, 'menu_background', '公司背景', NULL, '公司背景', '2016-10-03 11:31:56', 'U', NULL),
	(3, 'menu_idea', '公司理念', NULL, '公司理念', '2016-10-03 11:31:56', 'U', NULL),
	(4, 'menu_our-team', '设计团队', NULL, '设计团队', '2016-10-03 11:31:56', 'U', NULL),
	(5, 'menu_product', '我们的作品', NULL, '我们的作品', '2016-10-03 11:31:56', 'U', NULL),
	(6, 'menu_partners', '合作伙伴', NULL, '合作伙伴', '2016-10-03 11:31:56', 'U', NULL),
	(7, 'menu_contact', '联系方式', NULL, '联系方式', '2016-10-03 11:31:56', 'U', NULL),
	(8, 'menu_new-message', '最新消息', NULL, '最新消息', '2016-10-03 11:31:56', 'U', NULL),
	(9, 'satisfied_clients', '满意客户', NULL, '满意客户', '2016-10-03 11:31:56', 'U', NULL),
	(10, 'delivered_projects', '交付项目', NULL, '交付项目', '2016-10-03 11:31:56', 'U', NULL),
	(11, 'good_star', '好评数', NULL, '好评数', '2016-10-03 11:31:56', 'U', NULL),
	(12, 'questions_answered', '问题解决', NULL, '问题解决', '2016-10-03 11:31:56', 'U', NULL),
	(13, 'product_all', '所有', NULL, '所有', '2016-10-03 11:31:56', 'U', NULL),
	(14, 'product_house', '住宅项目', NULL, '住宅项目', '2016-10-03 11:31:56', 'U', NULL),
	(15, 'product_business', '商业项目', NULL, '商业项目', '2016-10-03 11:31:56', 'U', NULL),
	(16, 'contact_name', '姓名', NULL, '姓名', '2016-10-03 11:31:56', 'U', NULL),
	(17, 'contact_phone', '电话', NULL, '电话', '2016-10-03 11:31:56', 'U', NULL),
	(18, 'contact_message', '内容', NULL, '内容', '2016-10-03 11:31:56', 'U', NULL),
	(19, 'contact_submit', '提交', NULL, '提交', '2016-10-03 11:31:56', 'U', NULL),
	(20, 'message_detail', '详情', NULL, '详情', '2016-10-03 11:31:56', 'U', NULL),
	(21, 'contact_details', '联系方式详情', NULL, '联系方式详情', '2016-10-03 11:31:56', 'U', NULL),
	(22, 'contact_company_addr', '云南省陆良县中枢镇吉祥街帝景华庭大门左', NULL, '云南省陆良县中枢镇吉祥街帝景华庭大门左', '2016-10-03 11:31:56', 'U', NULL),
	(23, 'contact_company_phone', '15188106763', NULL, '18888888888', '2016-10-03 11:31:56', 'U', NULL),
	(24, 'contact_company_email', '570854215.qq.com', NULL, '570854215.qzone.qq.com', '2016-10-03 11:31:56', 'U', NULL),
	(25, 'contact_company_qq', '570854215', NULL, '570854215', '2016-10-03 11:31:56', 'U', NULL),
	(26, 'contact_company_wechat', '', NULL, '', '2016-10-03 11:31:56', 'U', NULL),
	(27, 'seo_company_name', '伊潮装饰', NULL, '伊潮装饰', '2016-10-03 11:31:56', 'U', NULL),
	(28, 'seo_keywords', '伊潮装饰，室内外设计，园林，景观', NULL, '伊潮装饰', '2016-10-03 11:31:56', 'U', NULL),
	(29, 'seo_description', '伊潮装饰承接室内外、园林景观装饰设计，电话:15188106763', NULL, '伊潮装饰', '2016-10-03 11:31:56', 'U', NULL),
	(30, 'app_index', 'http://www.haoyuqin.com/yichao', NULL, '伊潮装饰主页', '2016-10-03 11:31:56', 'U', NULL),
	(31, 'close', '关闭', NULL, '', '2016-10-03 11:31:56', 'U', NULL),
	(32, 'tip_title', '提示', NULL, '', '2016-10-03 11:31:56', 'U', NULL),
	(33, 'close', '关闭', NULL, '', '2016-10-03 11:31:56', 'U', NULL),
	(34, 'tip_title', '提示', NULL, '', '2016-10-03 11:31:56', 'U', NULL),
	(35, 'suggest_success_msg', '我们已经收到您的意见或建议，谢谢！', NULL, '', '2016-10-03 11:31:56', 'U', NULL),
	(36, 'invalid_user_name', '请填写姓名!', NULL, '', '2016-10-03 11:31:56', 'U', NULL),
	(37, 'invalid_phone_number', '请填写正确手机号!', NULL, '', '2016-10-03 11:31:56', 'U', NULL),
	(38, 'invalid_content', '请填写意见或建议!', NULL, '', '2016-10-03 11:31:56', 'U', NULL),
	(39, 'invalid_content_lenth', '您的意见太多了，最大500字!分次提交吧', NULL, '', '2016-10-03 11:31:56', 'U', NULL);
/*!40000 ALTER TABLE `wx_i18n` ENABLE KEYS */;

-- 导出  表 yichaodata.wx_user 结构
CREATE TABLE IF NOT EXISTS `wx_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(30) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `pwd` varchar(30) DEFAULT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `user_type` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `remarks` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  yichaodata.wx_user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `wx_user` DISABLE KEYS */;
INSERT INTO `wx_user` (`user_id`, `user_code`, `user_name`, `pwd`, `phone_number`, `user_type`, `create_time`, `remarks`) VALUES
	(1, 'admin', '管理员', 'lhy123456', '18114015057', '-1', '2016-09-02 23:10:21', ''),
	(2, 'yichao', '伊潮管理员', 'yichao890927', '15188106763', '1', '2016-09-02 23:10:21', '');
/*!40000 ALTER TABLE `wx_user` ENABLE KEYS */;

-- 导出  表 yichaodata.wx_user_suggestion 结构
CREATE TABLE IF NOT EXISTS `wx_user_suggestion` (
  `suggest_id` bigint(12) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `phone_number` varchar(32) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `qq` varchar(64) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`suggest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  yichaodata.wx_user_suggestion 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `wx_user_suggestion` DISABLE KEYS */;
INSERT INTO `wx_user_suggestion` (`suggest_id`, `user_name`, `phone_number`, `email`, `qq`, `content`, `create_time`, `state`, `remarks`) VALUES
	(1, NULL, NULL, NULL, NULL, NULL, '2016-10-19 18:42:27', 'U', NULL);
/*!40000 ALTER TABLE `wx_user_suggestion` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
