package com.csc.apipassenger.controller;

import com.csc.apipassenger.service.UserService;
import com.csc.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-13 15:33
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseResult getUser(HttpServletRequest request){

        String accessToken = request.getHeader("Authorization");

        return userService.getUser(accessToken);
    }
}
