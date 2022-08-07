package com.csc.apipassenger.openfeign;

import com.csc.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-verificationcode")
public interface NumberVerificationServeice {


    @GetMapping("/numberCode/{size}")
    ResponseResult numberCode(@PathVariable("size") int size);
}
