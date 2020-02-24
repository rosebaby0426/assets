package com.sihsing.assets.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Christine 2020/01/07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolePO implements Serializable {

    /**
     * 自增主鍵
     */
    private Integer id;
    /**
     * 角色名稱
     */
    private String name;
    /**
     * 角色說明
     */
    private String description;
    /**
     * 狀態，
     */
    private String status;
}
