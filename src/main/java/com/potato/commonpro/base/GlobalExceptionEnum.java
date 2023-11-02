package com.potato.commonpro.base;

import lombok.Getter;

@Getter
public enum GlobalExceptionEnum {

    ERROR(-1,"请求失败"),
    SUCCESS(200,"请求成功"),
    PARAM_ERROR (1002, "参数校验异常")
    ;

    private int code; //错误码
    private String msg;

    GlobalExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
