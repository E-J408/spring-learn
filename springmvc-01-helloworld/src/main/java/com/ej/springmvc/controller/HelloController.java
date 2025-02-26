package com.ej.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello()
    {
        return "hello 你好！";
    }

    @ResponseBody
    @RequestMapping("/hell?")
    public String hello2()
    {
        return "hell? 你好！";
    }

    @ResponseBody
    @RequestMapping("/hell*")
    public String hello3()
    {
        return "hell* 你好！";
    }

    @ResponseBody
    @RequestMapping("/hello/**")
    public String hello4()
    {
        return "hello/** 你好！";
    }
}
