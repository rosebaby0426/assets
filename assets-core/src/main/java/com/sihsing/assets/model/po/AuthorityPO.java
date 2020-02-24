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
public class AuthorityPO implements Serializable {

    /**
     * 自增主鍵
     */
    private Integer id;
    /**
     * 權限名稱
     */
    private String name;
    /**
     * 權限說明
     */
    private String description;
    /**
     * 父權限
     */
    private Integer parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 類型
     */
    private String type;
}
