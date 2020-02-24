DROP TABLE IF EXISTS `assets`;

-- 資產
create table `assets`
(
    id                  int         unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name`              varchar(32)                      NOT NULL COMMENT '名稱',
    description          varchar(50)                               COMMENT '備註說明',
    status              varchar(12)                      NOT NULL COMMENT '狀態',
    create_time         datetime                         NOT NULL COMMENT '建立時間',
    buy_time            date                             NOT NULL COMMENT '購買時間',
    assets_type_id      int                              NOT NULL COMMENT '資產分類id'
);


