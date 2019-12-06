DROP DATABASE IF EXISTS `socks`;
CREATE DATABASE `socks`;
USE `SOCKS`;
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USER_ID` varchar(50) ,
  `USERNAME` varchar(50) ,
  `PASSWORD` varchar(50) 
) ;

INSERT INTO `t_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `t_user` VALUES ('2', 'yizhiwazi', '123456');
INSERT INTO `t_user` VALUES ('4', 'wangyekun', '1234');
INSERT INTO `t_user` VALUES ('3', 'wangke', '123');