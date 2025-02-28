package com.ej.springmvc.controller;

import com.ej.springmvc.bean.Address;
import com.ej.springmvc.bean.Person;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class ResponseTestController {

    // 返回对象，默认返回json格式数据 核心注解是 @ResponseBody
    @RequestMapping("resp01")
    public Person resp01() {
        Person person = new Person();
        person.setUsername("EJ");
        person.setPassword("123456");
        person.setCellphone("123456789");
        person.setAgreement(true);
        person.setSex("男");
        person.setHobbies(new String[]{"打球", "打豆豆"});
        person.setAddress(new Address());
        return person;
    }

    // 文件下载
    @RequestMapping("/resp02")
    public ResponseEntity<InputStreamResource> download() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/img/500KB以下.jpg");
        // 以下代码不用改
        // 1. 文件名出现中文乱码：解决：
        String encode = URLEncoder.encode("简历头像.jpg", "UTF-8");
        // 2. 文件太大会oom溢出：解决：
        InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);


        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(fileInputStream.available())
                .header("Content-Disposition", "attachment;filename=" + encode)
                .body(inputStreamResource);
    }
}
