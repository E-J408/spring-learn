package com.ej.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageTestController {
    /*
    * 1. 引入thymeleaf
    * 2. 引入后就可以用了
    * 默认规则：
    *       页面放在/resources/templates下
    *       静态资源放在/resources/static下*/
    @RequestMapping("/")
    public String index(){
        // 会默认去templates下找login.html
        return "login"; // 返回值就是页面名称（视图名）
    }

    @RequestMapping("/login.mvc")
    public String login(String username, String password, Model model){
        // 省略从数据库获取数据的过程
        model.addAttribute("name","zhangsan");
        model.addAttribute("pwd","123456");
        return "success";
    }
}
