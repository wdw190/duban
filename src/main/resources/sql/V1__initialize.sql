--创建用户表
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


--USE soundxp;

insert into `users`(`userid`,`username`,`password`,`enabled`) values (1,'wangdaowen','$2a$04$aVS1uFHy4Ki7W421fLJNT.ptsU/mrIvSvrDc4RiAA27iSkUfa5S0O',1);
insert into `users`(`userid`,`username`,`password`,`enabled`) values (2,'wangfeixiang','$2a$04$aVS1uFHy4Ki7W421fLJNT.ptsU/mrIvSvrDc4RiAA27iSkUfa5S0O',0);
insert into `users`(`userid`,`username`,`password`,`enabled`) values (3,'zhangmin','$2a$04$OEFHjOw4sLx5220ARuo7QuQTlvEKVqMGJbUbUQxshzm/MY4uQeEk.',1);

--创建角色表

CREATE TABLE `roles` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  `roledesc` varchar(128) NOT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `uni_username_role` (`role`,`roledesc`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


--USE soundxp;

insert into `roles`(`roleid`,`role`,`roledesc`) values (1,'ROLE_ADMIN','管理员');
insert into `roles`(`roleid`,`role`,`roledesc`) values (2,'ROLE_USER','普通用户');


--创建用户角色表
CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`userid`),
  KEY `fk_username_idx` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


--USE soundxp;

insert into `user_roles`(`user_role_id`,`userid`,`role`) values (4,2,'ROLE_USER');
insert into `user_roles`(`user_role_id`,`userid`,`role`) values (5,1,'ROLE_ADMIN');
insert into `user_roles`(`user_role_id`,`userid`,`role`) values (6,1,'ROLE_USER');
