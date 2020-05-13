# docker-compose 详解
```
1. 用dockerfile，或者镜像定义应用程序所依赖的环境，以便在任何地方都可以直接复制。

2. 在docker-compose.yaml中定义应用程序需要的服务，以便这些服务可以在单独的环境中一起运行。

3. 运行docker-compose build 安装应用程序所需要的服务镜像。

4. 运行docker-compose up -d 启动并在后台运行整个应用程序。

5. 运行docker compose down 停止整个应用程序。

```

# Dockerfile文件详解
```
FROM java:8
#FROM maven:3.5-jdk-8
VOLUME /tmp
ADD mazhichu.jar mazhichu.jar
EXPOSE 8082
#RUN bash -c 'touch /mazhichu.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/prod/./urandom","-Dspring.profiles.active=prod", "-jar","/mazhichu.jar"]

FROM java:8：基础镜像环境 JDK1.8

VOLUME /tmp：指定了挂载目录

ADD mazhichu.jar mazhichu.jar：把指定的 jar 包拷贝到 Docker 容器中并命名为 mazhichu.jar

EXPOSE 8082：运行监听端口

RUN bash -c 'touch /mazhichu.jar'：等同于上面的拷贝jar文件到容器

ENTRYPOINT...：启动jar的命令并指定运行环境等参数
```

# docker-compose.yaml文件详解

```yaml

version: '3'

services:

    nginx:
        container_name: nginx
        image: nginx:1.14
        environment:
            - TZ=Asia/Shanghai
        ports:
            - "80:80"
        volumes:
            - ./config/nginx/conf.d:/etc/nginx/conf.d
#            - ./data/nginx/:/usr/share/nginx/html/
            - ./log/nginx/:/var/log/nginx/
        restart: always

    redis:
        container_name: redis
        image: redis:5.0.7
        environment:
            - TZ=Asia/Shanghai
        ports:
            - "6379:6379"
        volumes:
            - ./config/redis/redis.conf:/usr/local/etc/redis/redis.conf
            - ./data/redis/:/data/
            - ./log/redis/:/var/log/redis/
        command: redis-server /usr/local/etc/redis/redis.conf
        restart: always

    mysql:
        container_name: mysql
        image: mysql:8.0.18
        environment:
            TZ: Asia/Shanghai
            MYSQL_DATABASE: mazhichu
            MYSQL_ROOT_PASSWORD: Moore@2019
            MYSQL_ROOT_HOST: '%'
        ports:
            - "3306:3306"
        volumes:
            - ./config/mysql/my.cnf:/etc/mysql/conf.d/my.cnf
            - ./data/mysql/:/var/lib/mysql/
            - ./data/init/:/docker-entrypoint-initdb.d/
            - ./log/mysql/:/var/log/mysql/
        command: [
            '--character-set-server=utf8mb4',
            '--collation-server=utf8mb4_unicode_ci',
          #这行代码解决无法访问的问题
            '--default-authentication-plugin=mysql_native_password'
        ]
        security_opt:
            - seccomp:unconfined
        restart: always

    mazhichu:
        container_name: mazhichu
        build:
            context: .
            dockerfile: Dockerfile
        environment:
            TZ: Asia/Shanghai
            spring.datasource.host: mysql
            spring.redis.host: redis
        expose:
            - "8082"
        depends_on:
            - nginx
            - redis
            - mysql
        links:
            - "mysql:mysql"
        restart: always
#        networks:
#            - my-network
#        command: mvn clean spring-boot:run -Dspring-boot.run.profiles=prod

# version: '3'： 表示使用第三代语法来构建 docker-compose.yaml 文件。

# services: 用来表示 compose 需要启动的服务，上面的配置文件中有四个服务分别为：nginx、redis、mysql还有我的博客项目mazhichu（码之初）。

# Image：指定下载镜像版本

# container_name: 指定容器名称

# environment: 此节点下的信息会当作环境变量传入容器，例如mysql 服务配置了数据库、密码和权限信息。

# ports: 表示对外开放的端口

# volumes: 加载本地目录下的配置文件到容器目标地址下

# restart: always 表示如果服务启动不成功会一直尝试。

# depends_on：配置依赖服务，表示需要先启动 depends_on 下面的服务后，再启动本服务。

# links：与depends_on相对应，depends_on控制启动顺序，links控制容器连接问题。值为"服务名:别名"或者直接使用服务名

# command: mvn clean spring-boot:run -Dspring-boot.run.profiles=docker: 表示以这个命令来启动项目，-Dspring-boot.run.profiles=prodr表示使用 application-prod.yml文件配置信息进行启动。

# networks：加入指定网络，我这儿没用到。
```

# 构建完整步骤

```
1. 将docker-build文件夹上传到centos指定目录中，使用命: scp -r docker-build mzc:/usr/local/server
2. 给log文件夹加上所有权限，然后重启一下docker服务
3. 使用docker-compose build构建服务
4. 使用docker-compose up -d 启动并在后台运行yaml中定义的所有服务
```

# docker-compose常用命令介绍

```
docker-compose --verbose：输出更多的调试信息

docker-compose --version：查看compose的版本

docker-compose -f --file FILE：使用特定的compose模板文件，默认为docker-compose.yaml。

docker-compose  -p --project-name NAME 指定项目名称，默认使用目录名称。

docker-compose  build：构建或重建服务

docker-compose ps：查看已经启动的服务状态       

docker-compose kill：停止某个服务、杀掉容器       

docker-compose logs：可以查看某个服务的log、显示容器的输出内容       

docker-compose port：打印绑定的public port（开放端口）        

docker-compose pull：拉取服务镜像      

docker-compose up：启动yml定义的所有服务     

docker-compose stop：停止yml中定义的所有服务       

docker-compose start：启动被停止的yml中的所有服务        

docker-compose kill：强行停止yml中定义的所有服务        

docker-compose rm：删除yml中定义的所有服务      

docker-compose restart：重启yml中定义的所有服务        

docker-compose scale：设置服务的容器数目

docker-compose run:运行一个一次性命令

```
