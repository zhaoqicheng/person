package com.example.springbootdemo.Handle;

import com.example.springbootdemo.domain.Result;
import com.example.springbootdemo.exception.PersonException;
import com.example.springbootdemo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaoqicheng on 2017/3/25.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof PersonException){
            PersonException personException = (PersonException) e;
            return ResultUtil.error(personException.getCode() , personException.getMessage());
        }else{
            LOGGER.info("【系统异常】：" + e);
            return ResultUtil.error("-1" , "未知错误");
        }
    }
}
