/*MySQL创建数据库*/
DROP DATABASE IF EXISTS `userdb`;
CREATE DATABASE `userdb`  CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ;

USE `userdb`;
/*创建数据库后，在数据库中执行此sql文件 */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`(
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `username` varchar(32) NOT NULL,
   `email` varchar(64) NOT NULL,
   `grade` int(11) DEFAULT '1',
   `passwd` varchar(32) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO `users` VALUES (1,'admin','admin@sohu.com', 1,'123');
INSERT INTO `users` VALUES (2,'aaaaa2','aaaaa1@sohu.com', 5,'123');
INSERT INTO `users` VALUES (3,'aaaaa3','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (4,'aaaaa4','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (5,'aaaaa5','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (6,'aaaaa5','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (7,'aaaaa5','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (8,'aaaaa5','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (9,'aaaaa5','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (10,'aaaaa5','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (11,'aaaaa5','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (12,'aaaaa5','aaaaa1@sohu.com', 1,'123');
INSERT INTO `users` VALUES (13,'aaaaa5','aaaaa1@sohu.com', 1,'123');

/*DROP TABLE IF EXISTS `t_category`;*/


