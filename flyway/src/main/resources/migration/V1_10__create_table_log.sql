DROP TABLE IF EXISTS `log`;

-- 日誌
create table `log`
(
    id                  int         unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    content             varchar(32)                      NOT NULL COMMENT '內容',
    operator            int                              NOT NULL COMMENT '操作者',
    type                varchar(12)                      NOT NULL COMMENT '操作類型',
    create_time         datetime                         NOT NULL COMMENT '建立时间',
    status              varchar(20)                      NOT NULL COMMENT '操作狀態，SUCCESS：成功   FAIL：失敗'
);


