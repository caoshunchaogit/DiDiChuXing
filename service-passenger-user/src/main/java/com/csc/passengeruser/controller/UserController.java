package com.csc.passengeruser.controller;

import com.csc.dto.ResponseResult;
import com.csc.passengeruser.service.UserService;
import com.csc.request.VeificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.dc.pr.PRError;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VeificationCodeDTO veificationCodeDTO){

        String passengerPhone = veificationCodeDTO.getPassengerPhone();

        return userService.loginOrRegister(passengerPhone);
    }

    @GetMapping("/user/{phone}")
    public ResponseResult getUsre(@PathVariable("phone") String phone ){
        System.out.println("123");
        return userService.getUser(phone);
    }
}
