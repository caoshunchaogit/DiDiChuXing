package com.csc.passengeruser.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.csc.dto.PassengerUser;
import com.csc.dto.ResponseResult;
import com.csc.internalcommer.CommerStatusEeum;
import com.csc.passengeruser.mapper.PassengerUserMapper;
import com.csc.passengeruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService   {

    @Resource
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

    @Override
    public ResponseResult getUser(String passengerPhone) {

        Map<String,Object> map = new HashMap<>();
        map.put("passenger_phone",passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);

        if(passengerUsers.size() == 0){
            return ResponseResult.fail(CommerStatusEeum.USER_NOT_EXISTS.getCode(),CommerStatusEeum.USER_NOT_EXISTS.getValue());
        }

        PassengerUser user = passengerUsers.get(0);


        return ResponseResult.success(user);
    }
}
