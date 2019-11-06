# 数据库中级操作

#### 视图
- 视图概念

```
它可以被称为虚拟表,其操作跟表差不多一致
```


- 创建视图

```
CREATE VIEW 视图名 AS 查询语句
```

- 查看视图

```
show create view 视图名
```

- 删除视图

```
drop view 视图名
```

- 创建视图注意事项


```
聚集函数（比如SUM(), MIN(), MAX(),COUNT()等等）
DISTINCT/GROUP BY/HAVING/UNION 或者 UNION ALL
某些子查询/某些连接查询/等等等等
```


---

#### 存储程序

- 分类

> 存储例程(存储函数-function/储存过程-procedure)

> 触发器(trigger)

> 时间(event)

- 变量

```
1、 SET @a = 1;

2、 SELECT @a;

3、SET @a = '哈哈哈';

4、SET @b = @a;

5、SET @a = (SELECT m1 FROM t1 LIMIT 1);

6、SELECT m1, n1 FROM t1 LIMIT 1 INTO @a, @b;

```

- 语句结束分隔符

```
delimiter $ 

```

---
#### 存储函数

- 创建存储函数

```
CREATE FUNCTION 存储函数名称([参数列表])
RETURNS 返回值类型
BEGIN
    函数体内容
END
```

- 调用存储函数
```
select 函数名
```

- 删除存储函数
```
DROP FUNCRION 函数名
```

- 查看存储函数

```
show create function 函数名
```
---

### 存储过程

- 创建存储过程
```
CREATE PROCEDURE 存储过程名称([参数列表])
BEGIN
    需要执行的语句
END
```

- 调用存储过程
```
call 过程名

```

-查看存储过程
```
show create procedure 过程名
```

- 删除存储过程
```
drop procedure 过程名
```

==存储过程和存储函数区别==
```
1. 存储函数在定义时需要显式用RETURNS语句标明返回的数据类型，而且在函数体中必须使用RETURN语句来显式指定返回的值，
   存储过程不需要。

2. 存储函数只支持IN参数，而存储过程支持IN参数、OUT参数、和INOUT参数。

3. 存储函数只能返回一个值，而存储过程可以通过设置多个OUT参数或者INOUT参数来返回多个结果。

4. 存储函数执行过程中产生的结果集并不会被显示到客户端，而存储过程执行过程中产生的结果集会被显示到客户端。

5. 存储函数直接在表达式中调用，而存储过程只能通过CALL语句来显式调用。
```

---
### 游标

- 游标概念
```
标取出它对应记录的信息，随后再移动游标，让它执向下一条记录。
游标既可以用在存储函数中，也可以用在存储过程中
```

- 创建游标
```
DECLARE 游标名称 CURSOR FOR 查询语句;
```

- 打开和关闭游标

```
OPEN 游标名称;

CLOSE 游标名称;
```

---
#### 触发器

- 创建触发器

```
CREATE TRIGGER 触发器名
{BEFORE|AFTER}
{INSERT|DELETE|UPDATE}
ON 表名
FOR EACH ROW
BEGIN
    触发器内容
END
```

==语法注意事项==

```
1. 对于INSERT语句来说，FOR EACH ROW影响的记录就是我们准备插入的那些新记录。

2. 对于DELETE语句和UPDATE语句来说，FOR EACH ROW影响的记录就是符合WHERE条件的那些记录
   如果语句中没有WHERE条件，那就是代表全部的记录

3. 对于INSERT语句设置的触发器来说，NEW代表准备插入的记录，OLD无效。
4. 对于DELETE语句设置的触发器来说，OLD代表删除前的记录，NEW无效。
5. 对于UPDATE语句设置的触发器来说，NEW代表修改后的记录，OLD代表修改前的记录。
```

- 查看触发器
```
show create trigger 触发器名
```

- 删除触发器
```
drop trigger 触发器名
```
==使用触发器注意事项==

```
1. 触发器内容中不能有输出结果集的语句。
2. 触发器内容中NEW代表记录的列的值可以被更改，OLD代表记录的列的值无法更改。
3. 如果我们的BEFORE触发器内容执行过程中遇到了错误，那这个触发器对应的具体语句将无法执行；
   如果具体的操作语句执行过程中遇到了错误，那与它对应的AFTER触发器的内容将无法执行。
```
--- 
#### 事件

- 创建事件

```
CREATE EVENT 事件名
ON SCHEDULE
{
    AT 某个确定的时间点| 
    EVERY 期望的时间间隔 [STARTS datetime][END datetime]
}
DO
BEGIN
    具体的语句
END
```

- 执行方式
```
1. 在某个确定的时间点执行

2. 每隔一段时间执行一次
```

- 查看事件
```
show create event 事件名
```

- 删除事件
```
drop event 事件名
```

---
==这里不设计数据增删改查,因为先阶段只了解出SQL查询之后的相关知识 2019-11-06 14:55==