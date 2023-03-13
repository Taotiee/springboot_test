package com.gjy.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public R doException(Exception e){
        e.printStackTrace();
        return new R("服务器故障，请联系管理员！");
    }

}
