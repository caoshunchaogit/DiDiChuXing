package com.csc.apipassenger.openfeign;

import com.csc.dto.ResponseResult;
import com.csc.request.VeificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "passenger-user")
public interface UserPassenget {

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VeificationCodeDTO veificationCodeDTO);
}
