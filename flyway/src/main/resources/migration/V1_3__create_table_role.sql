DROP TABLE IF EXISTS `role`;

-- 角色
create table `role`
(
    id                  int         unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`              varchar(32)                      NOT NULL COMMENT '部門名稱',
    description         varchar(32)                      NOT NULL COMMENT '角色說明',
    status              varchar(12)                      NOT NULL COMMENT '狀態，ENABLED：已啟用  DISABLED：已停用'
);


