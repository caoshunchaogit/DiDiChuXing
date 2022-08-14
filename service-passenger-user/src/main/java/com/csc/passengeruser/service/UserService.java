package com.csc.passengeruser.service;

import com.csc.dto.PassengerUser;
import com.csc.dto.ResponseResult;

public interface UserService {

    public ResponseResult loginOrRegister(String passengerPhone);

    ResponseResult getUser(String passengerPhone);
}
