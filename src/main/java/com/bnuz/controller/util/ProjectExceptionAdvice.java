package com.bnuz.controller.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

//Spring MVC的异常处理器
@RestController
public class ProjectExceptionAdvice {

    //拦截所以异常信息
    @ExceptionHandler
    public R doException(Exception e){
        //记录日志
        //通知运维
        //通知开发
        e.printStackTrace();
        return new R(false, null, "服务器出现异常，请联系相关人员");
    }
}
