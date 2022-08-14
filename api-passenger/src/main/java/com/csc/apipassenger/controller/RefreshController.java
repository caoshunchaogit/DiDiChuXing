package com.csc.apipassenger.controller;

import com.csc.apipassenger.service.RefreshTokenService;
import com.csc.dto.ResponseResult;
import com.csc.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-13 12:43
 **/
@RestController
public class RefreshController {

    @Autowired
    private RefreshTokenService refreshTokenService;

    /**
     * @author Tonny
     * @Param 根据refreshToken生成双token
     * @return 
     * @date  13:54
     */
    @PostMapping("/token-refersh")
    public ResponseResult refreshToken(@RequestBody TokenResponse tokenResponse){

        return refreshTokenService.refreshToken(tokenResponse.getRefreshToken());
    }
}
