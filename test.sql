create table customertbl
(
    id int primary key auto_increment,
    name varchar(20),
    email varchar(20)
);
insert into customertbl(name,email) values("tom","tom@qq.com");
insert into customertbl(name,email) values("kite","kite@qq.com");