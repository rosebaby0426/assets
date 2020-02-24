package com.sihsing.assets.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Christine 2019/12/11
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePO implements Serializable {

    /**
     * 自增主鍵
     */
    private Integer id;
    /**
     * 員工編號
     */
    private String empId;
    /**
     * 帳號
     */
    private String account;
    /**
     * 密碼
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 英文名
     */
    private String englishName;
    /**
     * 連絡電話
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 建立时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 最后登入时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 登入失敗次數
     */
    private Integer loginFailureTimes;
    /**
     * 狀態，NORMAL:可登入  LOCK:鎖定  LEAVE:離職
     */
    private String status;
    /**
     * 部門id
     */
    private Integer departmentId;
}
