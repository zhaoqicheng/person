package com.example.springbootdemo.enums;

/**
 * Created by zhaoqicheng on 2017/3/25.
 * 异常信息枚举类
 */
public enum ResultEnum {

    UNKNOW_EROOR("-1" , "未知错误") ,
    SUCERR("0" , "成功"),
    WEICHENGNNIAN_ERROR("100","未成年"),
    YICHENGNIAN_ERROR("101","已成年");


    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
