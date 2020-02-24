DROP TABLE IF EXISTS `department`;

-- 部門
create table `department`
(
    id                  int         unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`              varchar(32)                      NOT NULL COMMENT '部門名稱'
);


