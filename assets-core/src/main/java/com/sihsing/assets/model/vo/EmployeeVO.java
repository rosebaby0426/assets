package com.sihsing.assets.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVO {

    /**
     * 員工編號
     */
    private String empId;
    /**
     * 帳號
     */
    private String account;

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
     * 狀態，NORMAL:可登入  LOCK:鎖定  LEAVE:離職
     */
    private String status;
    /**
     * 部門id
     */
    private Integer departmentId;
    /**
     * 部門名稱
     */
    private String departmentName;


}
