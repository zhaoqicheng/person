package com.example.springbootdemo.exception;

import com.example.springbootdemo.enums.ResultEnum;

/**
 * Created by zhaoqicheng on 2017/3/25.
 * 需要继承 RuntimeException  只对RuntimeException产生回滚
 */

public class PersonException extends RuntimeException {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PersonException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
