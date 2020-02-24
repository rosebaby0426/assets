DROP TABLE IF EXISTS `employee`;

-- 員工
create table `employee`
(
    id                  int         unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    emp_id              varchar(32)                      NOT NULL COMMENT '員工編號',
    account             varchar(32)                      NOT NULL COMMENT '账号',
    password            varchar(32)                      NOT NULL COMMENT '密码',
    name                varchar(32)                      NOT NULL COMMENT '姓名',
    english_name        varchar(32)                      NOT NULL COMMENT '英文名',
    phone               varchar(20)                      NOT NULL COMMENT '電話',
    address             varchar(256)                     NOT NULL COMMENT '地址',
    create_time         datetime                         NOT NULL COMMENT '建立时间',
    update_time         datetime                                  COMMENT '更新时间',
    last_login_time     datetime                                  COMMENT '最後登入时间',
    login_failure_times int       default 0                       COMMENT '登入失敗次數',
    status              varchar(20)                      NOT NULL COMMENT '會員狀態，NORMAL:可登入  LOCK:鎖定  LEAVE:離職',
    department_id       int                                       COMMENT '部門id',
    UNIQUE KEY (account,emp_id)
);


