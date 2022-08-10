package com.csc.apipassenger.controller;

import com.csc.apipassenger.service.VeificationService;
import com.csc.dto.ResponseResult;
import com.csc.request.VeificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-06 10:40
 **/
@RestController
public class VerificationController {

    @Autowired
    private VeificationService veificationService;

    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VeificationCodeDTO veificationCodeDTO){

        String code = veificationCodeDTO.getPassengerPhone();
        return veificationService.generatorCode(code);

    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkCode(@RequestBody VeificationCodeDTO veificationCodeDTO){

        String passengerPhone = veificationCodeDTO.getPassengerPhone();
        String verificationCode = veificationCodeDTO.getVerificationCode();

        return veificationService.checkCode(passengerPhone,verificationCode);
    }

}
