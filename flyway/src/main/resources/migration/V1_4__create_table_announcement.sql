DROP TABLE IF EXISTS `announcement`;

-- 公告
create table `announcement`
(
    id                  int         unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title               varchar(32)                      NOT NULL COMMENT '標題',
    content             varchar(256)                     NOT NULL COMMENT '公告內容',
    status              varchar(12)                      NOT NULL COMMENT '狀態，OPEN:已公告，CLOSE:未公告',
    type                varchar(32)                      NOT NULL COMMENT '類型，NORMAL:一般，URGENT:緊急，',
    create_time         datetime                         NOT NULL COMMENT '建立時間',
    announce_time       datetime                                  COMMENT '發布時間',
    user_id             int                              NOT NULL COMMENT '發布者'
);


