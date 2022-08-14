package com.csc.apipassenger.service;

import com.csc.apipassenger.openfeign.UserPassenget;
import com.csc.dto.PassengerUser;
import com.csc.dto.ResponseResult;
import com.csc.dto.TokenResult;
import com.csc.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-13 15:34
 **/
@Service
public class UserService {

    @Autowired
    private UserPassenget userPassenget;

    public ResponseResult getUser(String accessToken){

        System.out.println("请求的Token:" + accessToken);

        TokenResult tokenResult = JwtUtils.checkToken(accessToken);

        ResponseResult usre = userPassenget.getUsre(tokenResult.getPhone());

        return ResponseResult.success(usre);

    }
}

