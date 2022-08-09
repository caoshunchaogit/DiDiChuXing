package com.csc.controller;

import com.csc.dto.ResponseResult;
import com.csc.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-06 13:31
 **/
@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size){

        double d = (Math.random() * 9 + 1) * Math.pow(10,size-1);
        int code = (int) d;
        //定义返回值
        NumberCodeResponse num = new NumberCodeResponse();
        num.setNumberCode(code);
        ResponseResult<Object> objectResponseResult = new ResponseResult<>();
        objectResponseResult.setData(code);
        return objectResponseResult;
    }
}
