create schema if not exists student collate utf8mb4_0900_ai_ci;

create table if not exists bolg
(
    id         varchar(50)  not null comment '博客id',
    title      varchar(100) not null comment '博客标题',
    author     varchar(30)  not null comment '博客作者',
    creat_time datetime     not null comment '创建时间'
)
    charset = utf8;

create table if not exists teacher
(
    id   int(10)     not null comment '主键id'
        primary key,
    name varchar(30) null comment '老师名字'
)
    charset = utf8;

create table if not exists student
(
    id   int(10)     not null comment '主键id'
        primary key,
    name varchar(30) null comment '学生姓名',
    tid  int(10)     null comment '老师id',
    constraint fktid
        foreign key (tid) references teacher (id)
)
    charset = utf8;

create table if not exists user
(
    id   int(20)     not null comment '用户id'
        primary key,
    name varchar(30) null comment '用户名称',
    pwd  varchar(30) null comment '用户密码'
)
    charset = utf8;

