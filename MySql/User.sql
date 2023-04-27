create database if not exists db4;

use db4;

create table if not exists `user`(
    uid bigint primary key auto_increment,
    uname varchar(100) not null,
    uphone char(11) not null unique check(length(uphone) = 11),
    uage int default(18),
		usex char(2) default('男'),
		utime datetime default(NOW())
);


insert into `user`(uname, uphone, uage) values
('张三', '16685461320', 22),
('李四', '16685461321', 21),
('王五', '16685461322', 20),
('老六', '16685461323', 19),
('张三', '13385461320', 22);

alter table `user` auto_increment = 1;