package com.sihsing.assets.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Christine 2020/01/07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssetsPO implements Serializable {

    /**
     * 自增主鍵
     */
    private Integer id;
    /**
     * 資產名稱
     */
    private String name;
    /**
     * 資產明細說明
     */
    private String description;
    /**
     * 狀態
     */
    private String status;
    /**
     * 建立時間
     */
    private LocalDateTime createTime;
    /**
     * 購買時間
     */
    private LocalDate buyTime;
    /**
     * 資產分類id
     */
    private Integer assetsTypeId;
}
