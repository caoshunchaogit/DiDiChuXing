package com.csc.apipassenger.service;

import com.csc.apipassenger.openfeign.NumberVerificationServeice;
import com.csc.dto.ResponseResult;
import com.csc.response.NumberCodeResponse;
import com.csc.response.TokenResponse;
import jdk.nashorn.internal.runtime.JSONFunctions;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
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


    /**
     *  接收手机号 调用验证码服务,获取验证码 返回 验证码
     * @author Tonny
     * @Param passengerPhone 手机号
     * @return 验证码
     * @date 2022/8/10 17:42
     */
    public ResponseResult generatorCode(String passengerPhone){

        ResponseResult responseResult = numberVerificationServeice.numberCode(6);
        Object data = responseResult.getData();
        System.out.println(data);
        //设置key和value 存储时间
        stringRedisTemplate.opsForValue().set(verificationCode+passengerPhone,data.toString(),2, TimeUnit.MINUTES);
        ResponseResult success = ResponseResult.success();
        return success;
    }

    /**
     * @author Tonny  谣言
     * @Param passengerPhone 接收的手机号 verificationCode 接收的验证码
     * @return token
     * @date 2022/8/10 17:41
     */
    public ResponseResult checkCode(String passengerPhone,String verificationCode){

        System.out.println("手机号:"+passengerPhone + "验证码:"+verificationCode);

        System.out.println("根据手机号在redis中查找");

        System.out.println("校验验证码");

        System.out.println("判断原来是否有用户");

        System.out.println("颁发令牌");

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken("token value");

        return ResponseResult.success(tokenResponse);
    }
}
