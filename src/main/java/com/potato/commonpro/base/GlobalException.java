package com.potato.commonpro.base;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException{

    private int code;
    private String msg;

    public GlobalException() {
        super();
    }

    public GlobalException(String message) {
        super(message);
        this.msg = message;
    }

    public GlobalException( int code,String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public GlobalException(GlobalExceptionEnum globalExceptionEnum){
        super(globalExceptionEnum.getMsg());
        this.code=globalExceptionEnum.getCode();
        this.msg=globalExceptionEnum.getMsg();
    }
}
