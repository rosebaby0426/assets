package com.sihsing.assets.model.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;
/**
 * Christine 2020/01/13
 */

@Data
public class PageVO implements Serializable {
    //當前分頁
    @Min(value = 1, message = "currentPage must higher then 0")
    private Long currentPage;
    //分頁總數
    private Long pageAmount;
    //分頁大小
    private Long pageSize = 10L;
    //總數量
    private Long total;

}
