package com.ej.springmvc.controller;

import com.ej.springmvc.bean.Person;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class RequestTestController {
    /*
    * 假设前端发送数据
    * username=zhangsan&password=123456&cellphone=12345678901&agreement=true
    *
    * */

    // 直接指定请求参数为处理函数的形参
    @RequestMapping("/handle01")
    public String handle01(String username, String password,
                           String cellphone, Boolean agreement) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(cellphone);
        System.out.println(agreement);
        return "ok";
    }

    // 使用@RequestParam注解指定请求参数名,默认是必需携带。可以通过指定默认值来解决。
    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam("password") String pwd,
                           @RequestParam("cellphone") String phone,
                           @RequestParam("agreement") Boolean ok) {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println(phone);
        System.out.println(ok);
        return "ok";

    }

    // 使用POJO匹配
    @RequestMapping("/handle03")
    public String handle03(Person person) {
        System.out.println(person);
        return "ok";
    }

    // 获取请求头
    @RequestMapping("/handle04")
    public String handle04(@RequestHeader("host") String host) {
        System.out.println(host);
        return "ok~" + host;
    }

    // 获取cookie
    @RequestMapping("/handle05")
    public String handle05(@RequestHeader("Cookie") String cookie) {
        System.out.println(cookie);
        return "ok~";
    }

    // 使用@CookieValue注解获取cookie
    @RequestMapping("/handle06")
    public String handle06(@CookieValue("ej") String EJ) {
        System.out.println(EJ);
        return "ok~" + EJ;
    }

    // 接收JSON格式数据
    @RequestMapping("/handle07")
    public String handle07(@RequestBody Person person) {
        System.out.println(person);
        System.out.println(person.getUsername());
        return "ok~";
    }

    // 接收二进制文件，MultipartFile
    @RequestMapping("/handle08")
    public String handle08(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        // 判断文件夹是否存在
        if(!new File("D:\\img").exists())
            new File("D:\\img").mkdir();
        // 保存文件
        file.transferTo(new File("D:\\img\\" + file.getOriginalFilename()));
        System.out.println(file.getOriginalFilename() + "文件已保存");
        return "ok~";
    }

    // 通过HTTPEntity，获取整个请求，包括请求头和请求体
    // 泛型内是封装了请求体的对象
    @RequestMapping("/handle09")
    public String handle09(HttpEntity<Person> entity){
        System.out.println("请求头" + entity.getHeaders());
        System.out.println("请求体" + entity.getBody());
        return "ok~";
    }


}
