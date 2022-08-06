package com.csc.apipassenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-06 10:29
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
