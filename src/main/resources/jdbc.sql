CREATE TABLE `customer` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` varchar(255) DEFAULT NULL COMMENT '名字',
`email` varchar(255) DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into customer(name, email) values("tom", "tom@qq.com");
insert into customer(name, email) values("kite", "kite@qq.com");