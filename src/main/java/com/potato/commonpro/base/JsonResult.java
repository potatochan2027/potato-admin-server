package com.potato.commonpro.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {

    private String msg = "请求成功";
    private int code = 200; //默认成功的状态码为 200
    private boolean success = true; //默认状态为成功
    private Object data; //任意类型的结果

    /**
     * 返回默认成功的json结果，没有结果数据
     *
     * @return
     */
    public static JsonResult success() {
        return new JsonResult();
    }

    /**
     * 指定code跟msg，返回操作成功的空结果
     * @param code
     * @param msg
     * @return
     */
    public static JsonResult success(int code, String msg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        return jsonResult;
    }

    public static JsonResult success(int code, String msg,Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        jsonResult.setData(data);
        return jsonResult;
    }

    public static JsonResult success(Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(data);
        return jsonResult;
    }

    public static JsonResult error(GlobalExceptionEnum globalExceptionEnum){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setCode(globalExceptionEnum.getCode());
        jsonResult.setMsg(globalExceptionEnum.getMsg());
        return jsonResult;
    }

    public static JsonResult error(int code,String msg){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        return jsonResult;
    }

    public static JsonResult error(int code, String msg,Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setSuccess(false);
        jsonResult.setMsg(msg);
        jsonResult.setData(data);
        return jsonResult;
    }




}
