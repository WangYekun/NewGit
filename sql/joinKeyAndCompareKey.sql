# 复合主键

CREATE TABLE `join_key_student` (   
	`join_name` varchar(30) NOT NULL COMMENT '姓名',   
	`join_age` int(30) NOT NULL COMMENT '年龄',   
	PRIMARY KEY (`join_name`,`join_age`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# 联合主键

CREATE TABLE `key_info` (   
	`id` mediumint(9) NOT NULL AUTO_INCREMENT COMMENT '主键',   
	`name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',   
	`age` int(10) DEFAULT NULL COMMENT '年龄',   
PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `key_team` (   
	`id` mediumint(9) NOT NULL AUTO_INCREMENT COMMENT '主键',   
	`dev` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '码农',   
	`pm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目经理',   
	`hr` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人力',   
	PRIMARY KEY (`id`) USING BTREE 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `key_team_info` (   
	`id` mediumint(9) NOT NULL COMMENT '主键Id',   
	`team_id` mediumint(9) NOT NULL COMMENT '团队Id',   
	`info_id` mediumint(9) NOT NULL COMMENT '信息Id',   
	PRIMARY KEY (`team_id`,`info_idi`) USING BTREE 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
