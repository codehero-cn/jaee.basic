/*MySQL创建数据库*/
DROP DATABASE IF EXISTS `jaeebasicdb`;
CREATE DATABASE `jaeebasicdb`  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ;

USE `javaee.basic`;
/*创建数据库后，在数据库中执行此sql文件 */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`(
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `username` varchar(32) NOT NULL,
   `email` varchar(64) NOT NULL,
   `grade` int(11) DEFAULT '1',
   `passwd` varchar(32) NOT NULL,
    `age` INT(10) DEFAULT '1',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO `users` VALUES (1,'admin','admin@sohu.com', 1,'123',5);
INSERT INTO `users` VALUES (2,'aaaaa2','aaaaa1@sohu.com', 5,'123',12);
INSERT INTO `users` VALUES (3,'aaaaa3','aaaaa1@sohu.com', 1,'123',13);
INSERT INTO `users` VALUES (4,'aaaaa4','aaaaa1@sohu.com', 1,'123',55);
INSERT INTO `users` VALUES (5,'aaaaa5','aaaaa1@sohu.com', 1,'123',66);
INSERT INTO `users` VALUES (6,'aaaaa5','aaaaa1@sohu.com', 1,'123',66);
INSERT INTO `users` VALUES (7,'aaaaa5','aaaaa1@sohu.com', 1,'123',66);
INSERT INTO `users` VALUES (8,'aaaaa5','aaaaa1@sohu.com', 1,'123',66);
INSERT INTO `users` VALUES (9,'aaaaa5','aaaaa1@sohu.com', 1,'123',66);
INSERT INTO `users` VALUES (10,'aaaaa5','aaaaa1@sohu.com', 1,'123',66);
INSERT INTO `users` VALUES (11,'aaaaa5','aaaaa1@sohu.com', 1,'123',66);
INSERT INTO `users` VALUES (Tom,'aaaaa5','aaaaa1@sohu.com', 1,'123',12);
INSERT INTO `users` VALUES (Jack,'aaaaa5','aaaaa1@sohu.com', 1,'123',11);


/*DROP TABLE IF EXISTS `t_category`;*/

CREATE TABLE orders(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    order_no VARCHAR(20),
    order_price FLOAT
 );
INSERT INTO orders(order_no,order_price) VALUES('aaaa',23);
INSERT INTO orders(order_no,order_price) VALUES('bbbb',33);
INSERT INTO orders(order_no,order_price) VALUES('cccc',22);


DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL DEFAULT '0' COMMENT '分类Id',
  `title` varchar(40) NOT NULL COMMENT '标题',
  `content` blob NOT NULL  COMMENT '内容',
  `description` varchar(500) NOT NULL DEFAULT '空' COMMENT '文章简介  用于列表显示',
  `statue` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0：正常  1：不可用',
  `author` varchar(15) DEFAULT 'Coriger' COMMENT '作者',
  `createTime` datetime NOT NULL COMMENT '发表时间',
  `showCount` int(11) NOT NULL DEFAULT '0' COMMENT '浏览量',
   KEY (`id`)
); 