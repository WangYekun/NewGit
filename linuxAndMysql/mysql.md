# linux 远程登录

> 1. 安装mysql

> 2. 启动mysql server

```
1、启动mysql：systemctl start mysqld

2、重启mysql：systemctl stopmysqld

3、The innodb_system data file 'ibdata1' must be writable-->执行权限不够：chmod -R 777 /var/lib/mysql

4、查看初始密码：cat /var/log/mysqld.log | grep password

```

> 3. 启动防火墙


```
1、查看防火墙状态：systemctl status firewalld

2、开启防火墙：systemctl start firewalld

3、关闭防火墙：systemctl stop firewalld

```
	

> 4. 服务器允许3306端口可以访问
```
1、firewall-cmd --zone=public --add-port=3306/tcp --permanent
```

> 5. 数据库赋予连接权限

```
1、create user 'root'@'%' identified by '你的数据库密码';

2、grant all privileges on *.*  to 'root'@'%'  with grant option;

3、flush privileges;

```

> 6. 本地navicat连接服务器

'注意：这里面有很多的坑'