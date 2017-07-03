package com.example.springbootdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by zhaoqicheng on 2017/3/24.
 *
 * 拦截器的使用
 * 拦截controller包下的所有的方法
 * 定义切点  并在其他地方上使用
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.springbootdemo.controller.PersonController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        logger.info("拦截器前置日志");
        logger.info("请求参数列表:"+joinPoint.getArgs());
        logger.info("远程主机地址:"+request.getRemoteHost());
        logger.info("远程请求方法:"+request.getMethod());
        logger.info("远程请求URL:"+request.getRequestURI());

    }

    @After("log()")
    public void logAfter(){
        logger.info("拦截器后置日志");
    }

    @AfterReturning(returning = "object" , pointcut = "log()")
    public void doAfterReturning(Object object){
        //System.out.print(object.toString());
        //logger.info("返回值为:",object.toString());
    }
}
