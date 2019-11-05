/*
 Navicat Premium Data Transfer

 Source Server         : aliyun-mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : test_191025

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 05/11/2019 14:23:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `c_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `c_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `t_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('01', '语文', '02');
INSERT INTO `course` VALUES ('02', '数学', '01');
INSERT INTO `course` VALUES ('03', '英语', '03');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `s_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `c_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `s_score` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`s_id`, `c_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('01', '01', 80);
INSERT INTO `score` VALUES ('01', '02', 90);
INSERT INTO `score` VALUES ('01', '03', 99);
INSERT INTO `score` VALUES ('02', '01', 70);
INSERT INTO `score` VALUES ('02', '02', 60);
INSERT INTO `score` VALUES ('02', '03', 80);
INSERT INTO `score` VALUES ('03', '01', 80);
INSERT INTO `score` VALUES ('03', '02', 80);
INSERT INTO `score` VALUES ('03', '03', 80);
INSERT INTO `score` VALUES ('04', '01', 50);
INSERT INTO `score` VALUES ('04', '02', 50);
INSERT INTO `score` VALUES ('04', '03', 20);
INSERT INTO `score` VALUES ('05', '01', 76);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `s_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `s_birth` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `s_sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('01', '赵雷', '1990-01-01', '男');
INSERT INTO `student` VALUES ('02', '钱电', '1990-12-21', '男');
INSERT INTO `student` VALUES ('03', '孙风', '1990-05-20', '男');
INSERT INTO `student` VALUES ('04', '李云', '1990-08-06', '男');
INSERT INTO `student` VALUES ('05', '周梅', '1991-12-01', '女');
INSERT INTO `student` VALUES ('06', '吴兰', '1992-11-15', '女');
INSERT INTO `student` VALUES ('07', '郑竹', '1989-11-14', '女');
INSERT INTO `student` VALUES ('08', '王菊', '1990-01-20', '女');
INSERT INTO `student` VALUES ('09', '王菊', '1990-11-04', '女');
INSERT INTO `student` VALUES ('10', '吴兰', '1990-11-05', '女');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `t_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('01', '张三');
INSERT INTO `teacher` VALUES ('02', '李四');
INSERT INTO `teacher` VALUES ('03', '王五');

SET FOREIGN_KEY_CHECKS = 1;
-- ========================================================================================================

-- 题目
-- 1、查询"01"课程比"02"课程成绩高(条件)的学生的信息及课程分数
-- 2、查询"01"课程比"02"课程成绩低(条件)的学生的信息及课程分数
-- 3、查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
-- 4、查询平均成绩小于60分的同学的学生编号和学生姓名和平均成绩 (包括有成绩的和无成绩的)
-- 5、查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩
-- 6、查询"李"姓老师的数量
-- 7、查询学过"张三"老师授课的同学的信息 
-- 8、查询没学过"张三"老师授课的同学的信息
-- 9、查询学过编号为"01"并且也学过编号为"02"的课程的同学的信息
-- 10、查询学过编号为"01"但是没有学过编号为"02"的课程的同学的信息
-- 11、查询没有学全所有课程的同学的信息
-- 12、查询至少有一门课与学号为"01"的同学所学相同的同学的信息
-- 13、查询和"01"号的同学学习的课程完全相同的其他同学的信息
-- 14、查询没学过"张三"老师讲授的任一门课程的学生姓名
-- 15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
-- 16、检索"01"课程分数小于60，按分数降序排列的学生信息
-- 17、检索"01"课程分数小于60，按分数降序排列的学生信息
-- 18、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
-- 19、按各科成绩进行排序，并显示排名
-- 20、查询学生的总成绩并进行排名
-- 21、查询不同老师所教不同课程平均分从高到低显示
-- 22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩
-- 23、统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比
-- 24、查询学生平均成绩及其名次
-- 25、查询各科成绩前三名的记录
	-- 1.选出b表比a表成绩大的所有组
	-- 2.选出比当前id成绩大的 小于三个的
-- 26、查询每门课程被选修的学生数
-- 27、查询出只有两门课程的全部学生的学号和姓名
-- 28、查询男生、女生人数
-- 29、查询名字中含有"风"字的学生信息
-- 30、查询同名同性学生名单，并统计同名人数
-- 31、查询1990年出生的学生名单
-- 32、查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列
-- 33、查询平均成绩大于等于85的所有学生的学号、姓名和平均成绩
-- 34、查询课程名称为"数学"，且分数低于60的学生姓名和分数
-- 35、查询所有学生的课程及分数情况
-- 36、查询任何一门课程成绩在70分以上的姓名、课程名称和分数
-- 37、查询不及格的课程
-- 38、查询课程编号为01且课程成绩在80分以上的学生的学号和姓名
-- 39、求每门课程的学生人数
-- 40、查询选修"张三"老师所授课程的学生中，成绩最高的学生信息及其成绩
-- 41、查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩
-- 42、查询每门功成绩最好的前两名 
-- 43、统计每门课程的学生选修人数（超过5人的课程才统计）。要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
-- 44、检索至少选修两门课程的学生学号
-- 45、查询选修了全部课程的学生信息
-- 46、查询各学生的年龄
	-- 按照出生日期来算，当前月日 < 出生年月的月日则，年龄减一
-- 47、查询本周过生日的学生
-- 48、查询下周过生日的学生
-- 49、查询本月过生日的学生
-- 50、查询下月过生日的学生


-- =========================================================================答案1-50题SQL ===================================================================
-- 第一题答案
SELECT 
c.*,
a.s_score AS '01课程分数',b.s_score AS '02课程分数'
FROM

(
	SELECT c_id,s_id,s_score FROM score  WHERE c_id = '01'
) AS a
JOIN
(
SELECT c_id,s_id,s_score FROM score  WHERE c_id = '02'
) AS b ON a.s_id = b.s_id 

JOIN student AS c ON c.s_id = a.s_id

WHERE
a.s_score>b.s_score; 

-- 第二题答案 
SELECT 
c.*,
a.s_score AS '01课程分数',b.s_score AS '02课程分数'
FROM

(
	SELECT c_id,s_id,s_score FROM score  WHERE c_id = '01'
) AS a
JOIN
(
SELECT c_id,s_id,s_score FROM score  WHERE c_id = '02'
) AS b ON a.s_id = b.s_id 

JOIN student AS c ON c.s_id = a.s_id

WHERE
a.s_score<b.s_score; 

-- 第三题答案
SELECT s1.s_id AS '学生编号',s1.s_name AS '学生姓名',AVG(s.s_score) AS '平均成绩'
FROM score s
JOIN student s1 ON s1.s_id = s.s_id
GROUP BY s.s_id
HAVING AVG(s.s_score) >= 60;

-- 第四题答案(包括有无成绩)
SELECT s1.s_id AS '学生编号',s1.s_name AS '学生姓名',AVG(s.s_score) AS '平均成绩'
FROM score s
JOIN student s1 ON s1.s_id = s.s_id 
-- AND s.s_score IS NULL(包括有无成绩)未考虑到,因为不理解--留着这个问题
GROUP BY s.s_id
HAVING AVG(s.s_score) < 60;

-- 第五题答案
SELECT s.s_id AS '学生编号',s.s_name AS '学生姓名',COUNT(s1.s_id) AS '选课总数', SUM(CASE WHEN s1.s_score IS NULL THEN 0 ELSE s1.s_score END) AS '总成绩'
FROM student AS s
LEFT JOIN score AS s1 ON s.s_id = s1.s_id
GROUP BY s.s_id,s.s_name

-- 第六题答案
SELECT COUNT(t.t_id)  AS '李姓老师数量' FROM teacher t WHERE t.t_name LIKE '李%';

-- 第七题答案(有张三老师课程分数代表已学过)
SELECT s.* FROM student AS s 
JOIN score AS s1 ON s.s_id = s1.s_id
JOIN course AS c ON c.c_id = s1.c_id
JOIN teacher AS t ON t.t_id = c.t_id
WHERE
t.t_name ='张三';

-- 第八题答案(有张三老师课程分数代表已学过)
SELECT s.* FROM student s
WHERE s.s_id NOT IN(
SELECT s1.s_id FROM score AS s1  
JOIN course c ON s1.c_id = c.c_id
JOIN teacher t ON t.t_id = c.t_id
WHERE t.t_name='张三'
)


-- =第九题答案=
-- 01课程同学 02课程同学
-- 子查询在01和02成绩的同学
-- 连接查询条件学号
SELECT s1.* FROM student s1 WHERE s_id IN(
SELECT s1.s_id FROM  (
 (SELECT s_id FROM score WHERE c_id ='01') AS a
 INNER JOIN
 (SELECT s_id FROM score WHERE c_id ='02') AS b
 ON a.s_id=b.s_id)
 INNER JOIN student s1 ON s1.s_id = a.s_id
 );
  
 -- =第十题答案=
 -- 学过查询01和没学过02课程
 -- 查询01和02并集,并作为子查询
 -- 条件学号
SELECT s1.* FROM student s1 WHERE s_id IN(
SELECT s1.s_id FROM 
-- 学过01
(SELECT s_id FROM score WHERE c_id ='01') AS b
INNER JOIN
-- 没学过02
(SELECT DISTINCT s_id FROM score s WHERE s.s_id NOT IN( 
SELECT DISTINCT c_id FROM score WHERE c_id ='02')
) AS a
ON a.s_id = b.s_id
INNER JOIN student s1 ON a.s_id = s1.s_id
);

-- =第十一题答案=
-- 查询所有成绩课程号 01.02.03(数量) 
-- 连接查询 条件学学号(重点:LEFT JOIN 和 INNER JOIN 的区别)
-- 条件分组count(),动态写<3门课程(没学全)
SELECT s.s_id,s.s_name 
FROM student AS s
LEFT JOIN  score s1 ON s.s_id = s1.s_id
GROUP BY s.s_id HAVING COUNT(DISTINCT s1.c_id) < (SELECT COUNT(c.c_id) FROM course c)

-- =第十二题答案=
-- 01号课程学生信息
-- 子查询不包括它自己(01)
SELECT s_id,s_name FROM student WHERE s_id IN(
SELECT DISTINCT s_id FROM score WHERE s_id IN
(
SELECT s_id FROM score  WHERE c_id = '01' 
) AND s_id !=01
);

SELECT a.s_id,a.s_name FROM student AS a 
INNER JOIN (
SELECT DISTINCT s_id FROM score WHERE s_id IN
(
SELECT s_id FROM score  WHERE c_id = '01' 
) AND s_id !=01
) AS b ON a.s_id = b.s_id;

-- =十三题答案=
-- 查询01号同学课程号
-- 完成相同
	 -- 1. 数量相同 3
	 -- 2. 选课相同 123!=234 
SELECT  s_id FROM score WHERE s_id IN(
SELECT  s_id FROM score WHERE c_id IN(
SELECT c_id FROM score  WHERE s_id = '01' ) AND s_id!='01'
GROUP BY s_id HAVING COUNT(DISTINCT c_id) =(
SELECT COUNT(c_id) FROM score  WHERE s_id = '01')
)
GROUP BY s_id HAVING COUNT(DISTINCT c_id) =(
SELECT COUNT(c_id) FROM score  WHERE s_id = '01');

-- 更正--
SELECT * FROM student WHERE s_id IN(
-- 选择010203课程同学,但不包括01
SELECT s_id FROM score WHERE s_id!='01'
GROUP BY s_id HAVING COUNT(DISTINCT c_id) =(
SELECT COUNT(c_id) FROM score  WHERE s_id = '01')
)
-- 不在01,02,03课程中的同学
AND s_id NOT IN(
SELECT s_id FROM score WHERE c_id NOT IN(
SELECT c_id FROM score  WHERE s_id = '01')
)

-- =十四题答案=
-- 1. 查询张三老师讲授课程
-- 2. s_id不在张三老师里的子查询
SELECT s.s_name FROM student s  WHERE s.s_id IN(
SELECT s_id FROM score WHERE s_id IN(
SELECT c_id FROM course WHERE t_id NOT IN(
SELECT t_id FROM teacher WHERE t_name='张三')
))

-- =十五题答案=
-- 1. 学生表查询和成绩表查询
-- 2. COUNT()和SUM()、AVG()、GROUP BY/HAVING的使用
-- 3. COUNT>=2
SELECT s.s_id,s.s_name,AVG(DISTINCT s1.s_score) AS '平均成绩'
FROM student s 
JOIN score AS s1 ON s1.s_id = s.s_id
WHERE s1.s_score < 60
GROUP BY s.s_id,s.s_name HAVING COUNT(s1.s_id)>=2

-- =第十六题答案=
-- 1. 01课程分数,并且<60分
-- ORDER BY 分数 DESC
SELECT s.* FROM student AS s
INNER JOIN score AS s1 ON s.s_id = s1.s_id
WHERE  s1.c_id =01 AND s1.s_score > 60
ORDER BY s1.s_score DESC

-- =第十七题和16题一模一样=
SELECT s.* FROM student AS s
INNER JOIN score AS s1 ON s.s_id = s1.s_id
WHERE  s1.c_id =01 AND s1.s_score > 60
ORDER BY s1.s_score DESC

-- =第十八题答案=
-- 1. 学生课程成绩
-- 2. 平均分数排序
SELECT s.s_id
,MAX(CASE WHEN c_id ='01' THEN s.s_score ELSE NULL END) '语文成绩'
,MAX(CASE WHEN c_id ='02' THEN s.s_score ELSE NULL END) '数学成绩'
,MAX(CASE WHEN c_id ='03' THEN s.s_score ELSE NULL END) '英语成绩'
,AVG(DISTINCT s.s_score) AS avg_s_score FROM score AS s
GROUP BY s.s_id 
HAVING avg_s_score
ORDER BY avg_s_score DESC;

SELECT s_id AS '学号'
,MAX(CASE WHEN c_id ='01' THEN s_score ELSE NULL END) '语文成绩'
,MAX(CASE WHEN c_id ='02' THEN s_score ELSE NULL END) '数学成绩'
,MAX(CASE WHEN c_id ='03' THEN s_score ELSE NULL END) '英语成绩'
,AVG(s_score)  '平均成绩' 
FROM score 
GROUP BY s_id 
ORDER BY AVG(s_score) DESC;

-- =十九题==
-- 1. 各科成绩
-- 2. 排序
-- 3. 排名? ROW_NUMBER() over
SELECT 
s.s_id,s.s_score AS '学号' ,ROW_NUMBER() over(ORDER BY s.s_score DESC) AS '排名' 
FROM score s;

SELECT s_id AS '学号'
,MAX(CASE WHEN c_id ='01' THEN s_score ELSE NULL END) '语文成绩'
,MAX(CASE WHEN c_id ='02' THEN s_score ELSE NULL END) '数学成绩'
,MAX(CASE WHEN c_id ='03' THEN s_score ELSE NULL END) '英语成绩'
,row_number() over(ORDER BY SUM(s_score) DESC) '排名'
FROM score 
GROUP BY s_id; 

-- =第二十题答案=
SELECT s1.s_id,s1.s_name,SUM(s.s_score) AS '学生总成绩' FROM score s
INNER JOIN student s1 ON s1.s_id = s.s_id
GROUP BY s_id 
ORDER BY SUM(s.s_score) DESC;

SELECT s1.s_id,s1.s_name,SUM(s.s_score) AS '学生总成绩'
,row_number() over(ORDER BY SUM(s.s_score) DESC) AS '学生总成绩排名'
FROM score s
INNER JOIN student s1 ON s1.s_id = s.s_id
GROUP BY s_id;

-- =二十一题=答案
-- 1. 以课程(JOIN)为主体进行查询
-- 2. 分组排序
SELECT c.c_id,c.c_name,AVG(s.s_score) AS avg_s_score FROM score s 
INNER JOIN course AS c ON c.c_id = s.c_id 
GROUP BY c.c_id,c.c_name
ORDER BY avg_s_score DESC

-- =第二十二题答案=
-- 1. 所有课程成绩
-- 2. 学生信息、子查询课程信息(2,3) ROW_NUMBER 
SELECT * 
FROM (
SELECT s1.s_id,s1.c_id,s1.s_score,s.s_name,s.s_sex,s.s_birth
,row_number() over(PARTITION by s.s_id ORDER BY s1.s_score DESC) AS a
FROM score AS s1 
INNER JOIN student AS s ON s.s_id = s1.s_id
) AS m
WHERE a IN (2,3)

-- =第二十三题=
-- 1. 成绩和人数
-- 2. GROUP BY
SELECT c.c_id,c.c_name 
,SUM(case when s.s_score <=100 AND s.s_score>=85 THEN 1 ELSE 0 END) AS '[100-85]'
,SUM(case when s.s_score <=100 AND s.s_score>=85 THEN 1 ELSE 0 END) AS '[85-70]'
,SUM(case when s.s_score <=84 AND s.s_score>=70 THEN 1 ELSE 0 END) AS '[70-60]'
,SUM(case when s.s_score <=59  THEN 1 ELSE 0 END)	AS '[0-60]'
,SUM(case when s.s_score <=100 AND s.s_score>=85 THEN 1 ELSE 0 END)/(COUNT(c.c_id)) AS A
,SUM(case when s.s_score <=84 AND s.s_score>=70 THEN 1 ELSE 0 END)/(COUNT(c.c_id)) AS B
,SUM(case when s.s_score <=69 AND s.s_score>=60 THEN 1 ELSE 0 END)/(COUNT(c.c_id)) AS C
,SUM(case when s.s_score <=59  THEN 1 ELSE 0 END)/(COUNT(c.c_id)) AS D
FROM score s 
INNER JOIN course c ON c.c_id = s.c_id
GROUP BY c_id,c.c_name

-- =第二十四题答案=
-- 1. 与22题类似
SELECT s1.s_id,s1.s_name,AVG(s.s_score) AS '学生总成绩'
,row_number() over(ORDER BY AVG(s.s_score) DESC) AS '学生总成绩排名'
FROM score s
INNER JOIN student s1 ON s1.s_id = s.s_id
GROUP BY s_id;

-- =第二十五题答案=
-- 1. 查询各科成绩
-- 2. row_number进行排名
-- 3. 将row_number做为子查询 a IN(XX)
SELECT * FROM
(SELECT s_id AS '学号',s_score AS '该科目最高成绩'
,MAX(case WHEN c_id = '01' THEN s_score ELSE NULL END ) AS '语文成绩'
,MAX(case WHEN c_id = '02' THEN s_score ELSE NULL END ) AS '数学成绩'
,MAX(case WHEN c_id = '03' THEN s_score ELSE NULL END ) AS '英语成绩'
,dense_rank() over(ORDER BY s_score	DESC) AS a
FROM score
GROUP BY s_id,s_score
) AS m
WHERE a IN (1,2,3)

-- =第二十六题答案=
-- 1. GROUP BY 分组
-- 2. 连接查询
SELECT s1.c_id,c.c_name AS '课程名称',COUNT(s1.c_id) AS '被选的学生数'
FROM score AS s1 
INNER JOIN student AS s ON s.s_id = s1.s_id
INNER JOIN course AS c ON s1.c_id = c.c_id
GROUP BY s1.c_id,c.c_name

-- =第二十七题答案=
-- 1. 学生信息
-- 2. 连接查询
-- 3. COUNT(s_id)=2
SELECT s1.s_id, s.s_name
FROM score AS s1 
INNER JOIN student AS s ON s.s_id = s1.s_id 
GROUP BY s1.s_id,s.s_name HAVING COUNT(DISTINCT s1.c_id)=2

-- =第二十八题答案=
-- 学生信息
-- 条件 sex 男 or 女 和count()
SELECT s.s_sex,COUNT(DISTINCT s.s_id) AS '人数'
FROM student s
GROUP BY s.s_sex;

SELECT SUM(CASE WHEN s_sex = '男' THEN 1 ELSE 0 END) AS '男生人数'
,SUM(CASE WHEN s_sex = '女' THEN 1 ELSE 0 END) AS '女生人数'
FROM student;

SELECT count(CASE WHEN s_sex = '男' THEN 1 ELSE NULL END) AS '男生人数'
,count(CASE WHEN s_sex = '女' THEN 1 ELSE NULL END) AS '女生人数'
FROM student;

-- =第二十九题答案=
-- 1. 学生信息
-- 2. 条件name LIKE %风%
SELECT s.* FROM student s WHERE s.s_name LIKE '%风%';

-- =第三十题答案=
-- 1. 同名同姓学生信息
-- 2. 条件count(*)>1
SELECT s_name,count(*) AS '同名人数' FROM student
GROUP BY s_name HAVING count(*)>1

-- =第三十一题答案=
-- 1. 学生信息
-- 2.条件日期=1990
SELECT s.* FROM student s WHERE YEAR(s.s_birth) = 1990;

-- =第三十二题=
-- 1. 学生信息
-- 2. 平均成绩排序,相同是按照id升序
SELECT s.c_id,c.c_name,avg(s.s_score) AS '平均成绩' FROM score AS s
INNER JOIN course AS c ON c.c_id = s.c_id
GROUP BY c_id HAVING avg(s.s_score) 
ORDER BY avg(s.s_score) ASC,s.c_id DESC

-- =第三十三题=
-- 1. 学生信息
-- 2. 平均成绩>=85
SELECT s.s_id,s.s_name,AVG(s1.s_score) '平均成绩>=85' FROM student AS s 
INNER JOIN score s1 ON s1.s_id = s.s_id
GROUP BY s.s_id,s.s_name HAVING AVG(s1.s_score) >=85;

-- =第三十四题答案=
-- 1. 课程是数学
-- 2. 课程分数低于60
-- 3. 学生信息
SELECT st.s_name,sc.s_score FROM student AS st
INNER JOIN score AS sc ON st.s_id = sc.s_id
INNER JOIN course co ON co.c_id = sc.c_id
WHERE sc.s_score < 60 AND co.c_name = '数学';

-- =第三十五题答案=
-- 1. 学生信息
-- 2. 课程信息
SELECT st.s_id,st.s_name,sc.s_score FROM score AS sc
INNER JOIN student AS st ON st.s_id = sc.s_id
GROUP BY st.s_id,st.s_name,sc.s_score

SELECT sc.s_id,sc.s_score FROM score AS sc WHERE sc.c_id IN
(SELECT s_id FROM student )
GROUP BY sc.s_id,sc.s_score

-- =第三十六题答案=
-- 1. 学生信息
-- 2. 课程名称
-- 3. 课程分数
SELECT DISTINCT st.s_id,st.s_name,co.c_name,sc.s_score FROM  score AS sc
INNER JOIN student AS st ON sc.s_id = st.s_id
INNER JOIN course AS co ON co.c_id = sc.c_id 
WHERE sc.s_score > 70
GROUP BY st.s_id,st.s_name,co.c_name,sc.s_score 

-- =第三十七题答案=
-- 1. 学生信息
-- 2. 课程信息
-- 3. 条件不及格课程
SELECT sc.s_id,co.c_name,sc.s_score FROM score AS sc
INNER JOIN  course AS co ON sc.c_id = co.c_id
WHERE sc.s_score <60

-- =第三十八题答案=
-- 1. 课程信息
-- 2. 学生信息
-- 3. 条件课程标号为01 AND 分数>80
SELECT st.s_id,st.s_name FROM score AS sc 
INNER JOIN student AS st ON sc.s_id = st.s_id
WHERE sc.c_id = 01 AND sc.s_score >80

-- =第三十九题答案=
-- 1. 查询每门课程
-- 2. 计数学生人数
-- 3. 分数学生人数
SELECT c_name,COUNT(co.c_id) AS '学生人数' FROM score AS sc
INNER JOIN course AS co ON co.c_id = sc.c_id
GROUP BY c_name;

-- =第四十题答案=
-- 1. 张三老师课程
-- 2. 成绩最高并显示最高成绩
-- 3. 分组
SELECT st.*,MAX(a.s_score) AS '最高成绩' FROM student AS st
INNER JOIN 
(
SELECT sc.s_id,sc.s_score FROM score AS sc WHERE sc.s_id IN(
SELECT c_id FROM course WHERE c_id IN (
SELECT t_id FROM teacher WHERE t_name = '张三') 
) 
)AS a
ON a.s_id = st.s_id
GROUP BY s_id HAVING MAX(a.s_score)

-- =第四十一题答案=
-- 1. 课程信息
-- 2. 学生信息
-- 3. 条件不同课程相同成绩
SELECT st.s_id FROM score AS sc
INNER JOIN student AS st ON sc.s_id = st.s_id
GROUP BY st.s_id


-- =第四十一题答案=
-- 1. 不同课程(三门课程都不同)
-- 2. 相同成绩(分组之后就只有一个的)
SELECT st.s_id,st.s_name FROM
(SELECT a.s_id,a.s_score
FROM score as a
INNER JOIN 
(SELECT s_id FROM score GROUP BY s_id HAVING COUNT(DISTINCT c_id)>1)
AS c ON a.s_id = c.s_id
GROUP BY a.s_id,a.s_score 
) as b
INNER JOIN student AS st ON b.s_id = st.s_id
GROUP BY  st.s_id,st.s_name HAVING COUNT(st.s_id) = 1

-- =第四十二题答案=
-- 1. 每门成绩
-- 2. 条件 rank in(1,2)
-- 3. 重点从表里面找我们想要的东西
SELECT c_id AS '课程号',c_name AS '课程名'
,MAX(case WHEN m = 1 THEN s_score ELSE NULL END ) AS '1'
,MAX(case WHEN m = 2 THEN s_score ELSE NULL END ) AS '2'
FROM
(
SELECT sc.s_id,sc.s_score,sc.c_id,co.c_name,st.s_name
,row_number() over(PARTITION BY co.c_name ORDER BY s_score DESC) AS m
FROM score AS sc
INNER JOIN student AS st ON sc.s_id = st.s_id
INNER JOIN course AS co ON  co.c_id = sc.c_id
) AS a
WHERE m IN (1,2)
GROUP BY c_id,c_name;

-- =第四十三题答案=
-- 1. 选课人数
-- 2. 条件选课人数 > 5(GROUP BY)
-- 3. 人数相同时,ASC升序, DESC降序排列
SELECT c_id,COUNT(DISTINCT s_id) as a FROM score
GROUP BY c_id HAVING a >=5
ORDER BY a DESC,c_id ASC;


-- =第四十四题答案=
-- 1. 全部课程
-- 2. 条件 COUNT(c_id)>=2
SELECT sc.s_id,st.s_name,
COUNT(DISTINCT sc.c_id) as a FROM score AS sc
INNER JOIN student AS st ON sc.s_id = st.s_id
GROUP BY sc.s_id,st.s_name
HAVING a >= 2;

-- =第四十五题答案=
-- 1. 全部课程
-- 2. 连接学生信息
-- 3. 条件课程数>=3
SELECT sc.s_id,st.s_name,
COUNT(DISTINCT sc.c_id) as a FROM score AS sc
INNER JOIN student AS st ON sc.s_id = st.s_id
GROUP BY sc.s_id,st.s_name
HAVING a >= (SELECT COUNT(*) FROM course);

-- =第四十六题答案=
-- 1. 学生生日(分组)
-- 2. 条件(现在时间  - 生日年份)
SELECT *,(extract(YEAR FROM now()) - YEAR(s_birth)) as 'age' FROM student;
select *,year(now())-year(s_birth) AS 'age' from student;

-- =第四十七题答案=
-- 1. 学生生日(分组)
-- 2. 条件(当前月-日=出生月-日)
-- 3. 出生日期的年份去掉，得到月份和日期，再拼接上当前的年份
 select * from student where date_format(s_birth,'%m%d') between date_format('2019-11-04', '%m%d') and date_format('2019-11-10', '%m%d');
  
-- =第四十八题答案 =
-- 1. 格式化月-日
-- 2. 具体出下周日期并进行比较即可
select * from student where date_format(s_birth,'%m%d') between date_format('2019-11-11', '%m%d') and date_format('2019-11-17', '%m%d');

-- =第四十九题答案 =
-- 1. 现在月份和生日月份对比即可
-- 2. 条件 month(s_birth)=month(now())
select * from student where month(s_birth)=month(now());

-- =第五十题答案 =
-- 1. 现在月份和生日月份对比即可
-- 2. 条件 month(s_birth)=month(now())+1
select * from student where month(s_birth)=month(now())+1;

-- =第四十七题优解=
-- WEEK(date[,mode]) date 为日期格式 1990-10-11,mode为可选[1表示一周默认周一为第一天]
SELECT * FROM student WHERE WEEK(s_birth) = WEEK(DATE(NOW())) ;

-- =第四十八题优解=
-- WEEK(date[,mode]) date 为日期格式 1990-10-11,mode为可选[1表示一周默认周一为第一天]
SELECT * FROM student WHERE WEEK(s_birth,1) = WEEK(DATE(NOW()),1) +1 ;

-- =第四十九题优解=
SELECT * FROM student WHERE MONTH(s_birth) = MONTH(DATE(NOW()));

-- =第五十题优解=
SELECT * FROM student WHERE MONTH(s_birth) = MONTH(DATE(NOW())) +1 ;