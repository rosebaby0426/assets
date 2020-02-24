package com.sihsing.assets.enums;

public enum ApiResultMsgEnum {

    ADD_SUCCESS(0, "新增成功，畫面將於3秒後刷新"),
    UPDATE_SUCCESS(1, "修改成功，畫面將於3秒後刷新"),
    DELETE_SUCCESS(2, "刪除成功，畫密將於3秒後刷新");

    private Integer code;

    private String description;

    private ApiResultMsgEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
