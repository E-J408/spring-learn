package com.ej.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingLimitController {

    /*
    * 请求方法
    * 请求方法有：GET POST PUT DELETE HEAD OPTIONS TRACE
    * 常用的就是：GET和POST
    * */
    // 限定请求参数
    @RequestMapping(value = "/test01", params = {"age=18", "name","gender!=1"})
    public String handle(){
        return "hello world";
    }

    // 限定请求头
    @RequestMapping(value = "/test02", headers = "haha")
    public String handle02(){
        return "hello world";
    }

    // 限定请求内容类型，这里是json。consumes表示的是后端扮演的角色
    @RequestMapping(value = "/test03", consumes = "application/json")
    public String handle03(){
        return "hello world";
    }

    // 限定返回内容类型。produces表示的是后端扮演的角色
    @RequestMapping(value = "/test04", produces = "text/html")
    public String handle04(){
        return "<h1>hello<h1>";
    }
}

