DROP TABLE IF EXISTS `assets_type`;

-- 資產分類
create table `assets_type`
(
    id                  int         unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`              varchar(32)                      NOT NULL COMMENT '分類名稱'
);


