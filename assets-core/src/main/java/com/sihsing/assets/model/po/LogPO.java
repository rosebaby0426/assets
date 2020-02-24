package com.sihsing.assets.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Christine 2020/01/07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogPO implements Serializable {

    /**
     * 自增主鍵
     */
    private Integer id;
    /**
     * 內容
     */
    private String content;
    /**
     * 操作類型
     */
    private String type;
    /**
     * 紀錄時間
     */
    private LocalDateTime createTime;
    /**
     * 日誌狀態
     */
    private String status;
}
