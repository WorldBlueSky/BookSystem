drop table if exists user;

# 给的作业中 用户类型编号是 char 类型的，但是前端的界面没有可以输入这个char的文本框呀
# 我重新给id设置成int自增主键了

create table if not exists user(
    id int primary key auto_increment,
    name varchar(10) not null unique ,
    password varchar(10) not null
);