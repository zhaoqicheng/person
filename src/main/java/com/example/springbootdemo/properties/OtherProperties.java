package com.example.springbootdemo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoqicheng on 2017/3/20.
 *
 * 实体和数据库表字段映射关系
 */
@Component
@ConfigurationProperties(prefix = "Other")
public class OtherProperties {

    //自动映射
    private String work;

    private Integer size;

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
