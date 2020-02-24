DROP TABLE IF EXISTS `authority`;

-- 權限
create table `authority`
(
    id                  int         unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`              varchar(32)                      NOT NULL COMMENT '權限名稱',
    description         varchar(32)                      NOT NULL COMMENT '權限說明',
    parent_id           int                                       COMMENT '父權限',
    sort                tinyint                          NOT NULL COMMENT '排序',
    type                varchar(32)                      NOT NULL COMMENT '權限分類'
);


