package com.example.springbootdemo.controller;

import com.example.springbootdemo.properties.OtherProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoqicheng on 2017/3/20.
 */

/**
 *@RestController和@Controller的区别:
 *@RestController等同于Controller和Responsebody的整合,返回json格式数据
 * 在方法上没有定义请求方式,既可以通过get方法也可以通过post方式来请求
 *
 * @PathVariable获取URL中的数据
 * 对应的请求URL localhost:8080/hello/say/15
 *
 * @RequestParam获取请求参数的值
 * 对应的请求URL localhost:8080/hello/say?id=15
 * 不希望获取到的属性值为空,可以通过@RequestParam设定默认值
 *
 * @GetMapping
 * @PostMapping
 * @PutMapping
 * 组合注解
 *
 */
@RestController
@RequestMapping(value = "/springboot")
public class HelloController {

    @Value("${cupSize.A}")
    private String cupSize;

    @Autowired
    private OtherProperties otherProperties;

    @RequestMapping(value = {"/hello","/hi"} , method = RequestMethod.GET)
    public String say(){
        return "你好,第一个springboot应用" + cupSize + otherProperties.getSize() + otherProperties.getWork();
    }
}
