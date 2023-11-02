package com.potato.commonpro.base;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public JsonResult exceptionHandler(Exception e){
        e.printStackTrace();
        return JsonResult.error(GlobalExceptionEnum.ERROR);
    }

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    public JsonResult exceptionHandler(GlobalException e){
        e.printStackTrace();
        return JsonResult.error(e.getCode(), e.getMsg());
    }


    /**
     * 处理请求参数-校验失败异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult exceptionHandler(MethodArgumentNotValidException e){
        e.printStackTrace();

        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String messages = errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
        return JsonResult.error(GlobalExceptionEnum.PARAM_ERROR.getCode(), messages);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public JsonResult exceptionHandler(ConstraintViolationException  e){
        e.printStackTrace();
        return JsonResult.error(GlobalExceptionEnum.PARAM_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public JsonResult exceptionHandler(BindException  e){
        e.printStackTrace();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String messages = errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
        return JsonResult.error(GlobalExceptionEnum.PARAM_ERROR.getCode(), messages);
    }


}
