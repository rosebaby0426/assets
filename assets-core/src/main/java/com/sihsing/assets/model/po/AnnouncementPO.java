package com.sihsing.assets.model.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Christine 2020/01/08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementPO implements Serializable {

    /**
     * 自增主鍵
     */
    private Integer id;
    /**
     * 標題
     */
    private String title;
    /**
     * 內容
     */
    private String content;
    /**
     * 發布者
     */
    private Integer userId;
    /**
     * 狀態，OPEN:已公告，CLOSE:未公告
     */
    private String status;
    /**
     * 類型，NORMAL:一般，URGENT:緊急，
     */
    private String type;
    /**
     * 建立時間
     */
    private LocalDateTime createTime;
    /**
     * 公告時間
     */
    private LocalDateTime announceTime;

}
