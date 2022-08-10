package com.csc.passengeruser.service.impl;

import com.csc.dto.ResponseResult;
import com.csc.passengeruser.dto.PassengerUser;
import com.csc.passengeruser.mapper.PassengerUserMapper;
import com.csc.passengeruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PassengerUserMapper passengerUserMapper;


    @Override
    public ResponseResult loginOrRegister(String passengerPhone) {

        Map<String,Object> map = new HashMap<>();
        map.put("passenger_phone",passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);

        //判断用户是否存在
        if(passengerUsers.size() == 0){
            //设置一个新的注册用户
            PassengerUser user = new PassengerUser().setGmtCreate(LocalDateTime.now())
                    .setGmtModified(LocalDateTime.now()).setPassengerGender((byte) 0).setPassengerName("张三")
                    .setPassengerPhone(passengerPhone).setState((byte) 0);

            passengerUserMapper.insert(user);
        }

        return ResponseResult.success();
    }
}
