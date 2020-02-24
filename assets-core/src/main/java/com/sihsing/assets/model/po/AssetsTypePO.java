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
public class AssetsTypePO implements Serializable {

    /**
     * 自增主鍵
     */
    private Integer id;
    /**
     * 分類名稱
     */
    private String name;
}
