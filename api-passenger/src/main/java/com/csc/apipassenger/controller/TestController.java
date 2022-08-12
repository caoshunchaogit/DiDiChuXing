package com.csc.apipassenger.controller;

import com.csc.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-12 09:38
 **/
@RestController
public class TestController {


    /**
     * @author Tonny
     * @Param 需要token的方法
     * @return
     * @date  9:39
     */
    @GetMapping("/authTest")
    public ResponseResult autoTest(){

        return ResponseResult.success("auth test");
    }

    @GetMapping("/authTest")
    public ResponseResult noAutoTest(){

        return ResponseResult.success("noauth test");
    }
}
