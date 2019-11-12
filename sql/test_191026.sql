/*
 Navicat Premium Data Transfer

 Source Server         : local-test
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : test_191026

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 12/11/2019 22:57:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses`  (
  `cno` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('9-888', '高等数学', '100');
INSERT INTO `courses` VALUES ('3-105', '计算机导论', '825');
INSERT INTO `courses` VALUES ('3-245', '操作系统', '804');
INSERT INTO `courses` VALUES ('6-166', '数据电路', '856');
INSERT INTO `courses` VALUES ('9-888', '高等数学', '100');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `low` int(3) NULL DEFAULT NULL,
  `upp` int(3) NULL DEFAULT NULL,
  `rankpai` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (90, 100, 'A');
INSERT INTO `grade` VALUES (80, 89, 'B');
INSERT INTO `grade` VALUES (70, 79, 'C');
INSERT INTO `grade` VALUES (60, 69, 'D');
INSERT INTO `grade` VALUES (0, 59, 'E');

-- ----------------------------
-- Table structure for scores
-- ----------------------------
DROP TABLE IF EXISTS `scores`;
CREATE TABLE `scores`  (
  `sno` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cno` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `degree` decimal(10, 1) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scores
-- ----------------------------
INSERT INTO `scores` VALUES ('103', '3-245', 86.0);
INSERT INTO `scores` VALUES ('105', '3-245', 75.0);
INSERT INTO `scores` VALUES ('109', '3-245', 68.0);
INSERT INTO `scores` VALUES ('103', '3-105', 92.0);
INSERT INTO `scores` VALUES ('105', '3-105', 88.0);
INSERT INTO `scores` VALUES ('109', '3-105', 76.0);
INSERT INTO `scores` VALUES ('101', '3-105', 64.0);
INSERT INTO `scores` VALUES ('107', '3-105', 91.0);
INSERT INTO `scores` VALUES ('108', '3-105', 78.0);
INSERT INTO `scores` VALUES ('101', '6-166', 85.0);
INSERT INTO `scores` VALUES ('107', '6-106', 79.0);
INSERT INTO `scores` VALUES ('108', '6-166', 81.0);

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `sno` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sname` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ssex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sbirthday` date NULL DEFAULT NULL,
  `class` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('108', '曾华', '男', '1977-09-01', '95033');
INSERT INTO `students` VALUES ('105', '匡明', '男', '1975-10-02', '95031');
INSERT INTO `students` VALUES ('107', '王丽', '女', '1976-01-23', '95033');
INSERT INTO `students` VALUES ('101', '李军', '男', '1976-02-20', '95033');
INSERT INTO `students` VALUES ('109', '王芳', '女', '1975-02-10', '95031');
INSERT INTO `students` VALUES ('103', '陆君', '男', '1974-06-03', '95031');

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers`  (
  `tno` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tname` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tsex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tbirthday` date NOT NULL,
  `prof` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `depart` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('804', '李诚', '男', '1958-12-02', '副教授', '计算机系');
INSERT INTO `teachers` VALUES ('856', '张旭', '男', '1969-03-12', '讲师', '电子工程系');
INSERT INTO `teachers` VALUES ('825', '王萍', '女', '1972-05-05', '助教', '计算机系');
INSERT INTO `teachers` VALUES ('831', '刘冰', '女', '1977-08-14', '助教', '电子工程系');

SET FOREIGN_KEY_CHECKS = 1;

# 题目和参考答案
# 19 查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录
SELECT * FROM scores WHERE  cno = '3-105' AND degree >
(SELECT degree  FROM scores WHERE cno='3-105' AND sno='109');

# 19 注意条件
SELECT s1.sno,s1.degree FROM scores AS s1 
INNER JOIN scores AS s2
ON(s1.cno=s2.cno AND s1.degree>s2.degree)
WHERE s1.cno='3-105' AND s2.sno='109'
ORDER BY s1.sno,s1.degree;

# 20 查询score中选学一门以上课程的同学中分数为非最高分成绩的记录
-- 错误点想法: 自以为 LIMIT 关键字能解决一切问题
SELECT *,COUNT(cno) AS a FROM scores
GROUP BY sno HAVING a>1
ORDER BY degree DESC LIMIT 1,5;

# 20 正确做法: 一门以上课程,并且成绩不是最高的
SELECT * 
FROM scores a 
WHERE sno IN (SELECT sno FROM scores GROUP BY sno HAVING count(cno)>1) 
AND degree<( SELECT max(degree) FROM scores b WHERE b.cno = a.cno);

# 21 查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录
SELECT * FROM scores WHERE cno ='3-105' AND degree > 
(SELECT degree FROM scores WHERE cno='3-105' AND sno = 109);

# 22 查询和学号为108的同学同年出生的所有学生的sno、sname和sbirthday列
SELECT * FROM students WHERE YEAR(sbirthday) = 
(SELECT YEAR(sbirthday) FROM students WHERE sno = '108');

# 23 查询“张旭“教师任课的学生成绩
SELECT sc.sno,sc.degree FROM students AS st
INNER JOIN scores AS sc ON sc.sno = st.sno
INNER JOIN courses AS co ON co.cno = sc.cno
INNER JOIN teachers AS te ON te.tno = co.tno
WHERE te.tname = '张旭'
GROUP BY  sc.sno,sc.degree;

# 24 查询选修某课程的同学人数多于5人的教师姓名
SELECT te.tno,te.tname FROM students AS st
INNER JOIN scores AS sc ON sc.sno = st.sno
INNER JOIN courses AS co ON co.cno = sc.cno
INNER JOIN teachers AS te ON te.tno = co.tno
GROUP BY   te.tno,te.tname HAVING COUNT(sc.cno) > 5;

# 25 查询95033班和95031班全体学生的记录
SELECT st.*,sc.cno,sc.degree FROM students AS st
INNER JOIN scores AS sc ON st.sno = sc.sno
WHERE class IN(95033,95031)
ORDER BY st.sno ASC;

# 26 查询存在有85分以上成绩的课程cno
SELECT DISTINCT cno FROM scores WHERE degree >85;

# 27 查询出“计算机系“教师所教课程的成绩表
SELECT sc.* FROM scores AS sc 
INNER JOIN courses AS co ON co.cno = sc.cno
INNER JOIN teachers AS te ON te.tno = co.tno
WHERE te.depart = '计算机系';

# 28 查询“计算机系”与“电子工程系“不同职称的教师的tname和prof
SELECT tname,prof FROM teachers WHERE depart = '计算机系' AND prof NOT IN
(SELECT prof FROM teachers WHERE depart = '电子工程系');

# 29查询选修编号为“3-105“课程且成绩至少
# 高于选修编号为“3-245”的同学的cno、sno和degree,并按Degree从高到低次序排序
-- 错误做法:将degree进行直接判断,而没有将它的子查询进行关联(ANY和ALL的区别)
SELECT cno,sno,degree FROM scores as a WHERE cno = '3-105' AND degree > 
ANY(SELECT degree FROM scores as b WHERE cno = '3-245' AND a.sno = b.sno)
ORDER BY degree DESC;

# 30 查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的cno、sno和degree
-- -- ALL 代表所有,ANY代表至少
-- all是表示所有的，如果主查询查的是大于所有的，则大于子查询最大的那个就是主查询的查询结果，
-- 小于所有的，则小于子查询最小的那个就是主查询的查询结果。any是表示任意一个，不是所有，如果主查询查的是大于
-- 任意一个，则大于子查询集中一个就可以了，小于任意一个，同样的，则小于子查询集中一个就可以了。这就是它们容易
-- 混淆的地方，也是它们区别的地方
SELECT cno,sno,degree FROM scores as a WHERE cno = '3-105' AND degree > 
ALL(SELECT degree FROM scores as b WHERE cno = '3-245' AND a.sno = b.sno);

# 31 查询所有教师和同学的name、sex和birthday
-- UNION 全关联,必须是所有字段不一样
SELECT tname AS name,tsex AS sex,tbirthday AS birthday FROM teachers 
WHERE tsex = '女'
UNION
SELECT sname AS name,ssex as sex,sbirthday AS birthday FROM students
WHERE ssex = '女';

# 32 查询所有“女”教师和“女”同学的name、sex和birthday
-- 条件为女(两个查询的条件)
SELECT tname AS name,tsex AS sex,tbirthday AS birthday FROM teachers 
WHERE tsex = '女'
UNION
SELECT sname AS name,ssex as sex,sbirthday AS birthday FROM students
WHERE ssex = '女';

# 33 查询成绩比该课程平均成绩低的同学的成绩表
-- 分组之后求平均成绩
SELECT * FROM scores AS a WHERE degree < 
(
SELECT ROUND(AVG(degree),2) FROM scores AS b WHERE a.cno = b.cno
);
-- 
-- 1、 查询Student表中的所有记录的Sname、Ssex和Class列。
-- 2、 查询教师所有的单位即不重复的Depart列。
-- 3、 查询Student表的所有记录。
-- 4、 查询Score表中成绩在60到80之间的所有记录。
-- 5、 查询Score表中成绩为85，86或88的记录。
-- 6、 查询Student表中“95031”班或性别为“女”的同学记录。
-- 7、 以Class降序查询Student表的所有记录。
-- 8、 以Cno升序、Degree降序查询Score表的所有记录。
-- 9、 查询“95031”班的学生人数。
-- 10、查询Score表中的最高分的学生学号和课程号。
-- 11、查询‘3-105’号课程的平均分。
-- 12、查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。
-- 13、查询最低分大于70，最高分小于90的Sno列。
-- 14、查询所有学生的Sname、Cno和Degree列。
-- 15、查询所有学生的Sno、Cname和Degree列。
-- 16、查询所有学生的Sname、Cname和Degree列。
-- 17、查询“95033”班所选课程的平均分。
-- 18、查询所有同学的Sno、Cno和rank列。
-- 19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
-- 20、查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。
-- 21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
-- 22、查询和学号为108的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
-- 23、查询“张旭“教师任课的学生成绩。
-- 24、查询选修某课程的同学人数多于5人的教师姓名。
-- 25、查询95033班和95031班全体学生的记录。
-- 26、查询存在有85分以上成绩的课程Cno.
-- 27、查询出“计算机系“教师所教课程的成绩表。
-- 28、查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。
-- 29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。
-- 30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno、Sno和Degree.
-- 31、查询所有教师和同学的name、sex和birthday.
-- 32、查询所有“女”教师和“女”同学的name、sex和birthday.
-- 33、查询成绩比该课程平均成绩低的同学的成绩表。
-- 34、查询所有任课教师的Tname和Depart.
				SELECT tname,depart FROM teachers;
-- 35  查询所有未讲课的教师的Tname和Depart. 
				SELECT tname,depart FROM teachers WHERE prof = '助教';
-- 36、查询至少有2名男生的班号。
				SELECT class,COUNT(sno)  AS a FROM students
				WHERE ssex = '男'
				GROUP BY class 
				HAVING a>=2;
-- 37、查询Student表中不姓“王”的同学记录。
				SELECT * FROM students WHERE sno NOT IN
				(SELECT sno FROM students WHERE sname LIKE '王%');
-- 38、查询Student表中每个学生的姓名和年龄。
				SELECT sname, (YEAR(NOW()) -YEAR(sbirthday)) AS '年龄' FROM students;
-- 39、查询Student表中最大和最小的Sbirthday日期值。
				SELECT MAX(sbirthday) AS '最大sbirthday日期值', MIN(sbirthday) AS '最小sbirthday日期值'FROM students;
-- 40、以班号和年龄从大到小的顺序查询Student表中的全部记录。
				SELECT *, (YEAR(NOW()) -YEAR(sbirthday)) AS 年龄 FROM students
				ORDER BY class DESC,年龄 DESC;
-- 41、查询“男”教师及其所上的课程。
				SELECT te.*,co.cname FROM teachers AS te
				INNER JOIN courses AS co ON te.tno = co.tno
				WHERE tsex = '男';
-- 42、查询最高分同学的Sno、Cno和Degree列。
				SELECT sno,cno,MAX(degree) AS '最高分' FROM scores;
-- 43、查询和“李军”同性别的所有同学的Sname.
				SELECT sname FROM students WHERE ssex IN(SELECT ssex FROM students WHERE sname = '李军');
-- 44、查询和“李军”同性别并同班的同学Sname.
				SELECT sname FROM students WHERE class IN	(SELECT class FROM students WHERE sname = '李军') AND ssex  IN (SELECT ssex FROM students WHERE sname = '李军');
				SELECT a.sname FROM students a,students b WHERE b.sname='李军' AND a.ssex=b.ssex AND a.class=b.class;
-- 45、查询所有选修“计算机导论”课程的“男”同学的成绩表
				SELECT scores.* FROM scores,courses,students WHERE cname='计算机导论'and courses.cno=scores.cno AND scores.sno =students.sno AND students.ssex='男';
