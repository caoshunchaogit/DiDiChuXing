package com.csc.apipassenger.service;

import com.csc.apipassenger.openfeign.NumberVerificationServeice;
import com.csc.dto.ResponseResult;
import jdk.nashorn.internal.runtime.JSONFunctions;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-06 10:51
 **/
@Service
public class VeificationService {

    @Autowired
    private NumberVerificationServeice numberVerificationServeice;

    private String verificationCode = "passenger-verification-code-";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 接收手机号 调用验证码服务,获取验证码 返回 验证码
    public ResponseResult generatorCode(String passengerPhone){
        ResponseResult responseResult = numberVerificationServeice.numberCode(6);
        String s = responseResult.getData().toString();
        //设置key和value 存储时间
        stringRedisTemplate.opsForValue().set(verificationCode+passengerPhone,s,2, TimeUnit.MINUTES);

        return ResponseResult.success() ;
    }

}
