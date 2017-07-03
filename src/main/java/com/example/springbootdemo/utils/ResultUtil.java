package com.example.springbootdemo.utils;


import com.example.springbootdemo.domain.Result;

/**
 * Created by zhaoqicheng on 2017/3/24.
 */
public class ResultUtil {

    public static Result success(Object obj){
        Result result = new Result();
        result.setCode("200");
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(String code , String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
