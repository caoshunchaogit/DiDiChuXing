package com.csc.apipassenger.service;

import com.csc.apipassenger.openfeign.NumberVerificationServeice;
import com.csc.apipassenger.openfeign.UserPassenget;
import com.csc.dto.ResponseResult;
import com.csc.internalcommer.CommerStatusEeum;
import com.csc.internalcommer.IdentityConstant;
import com.csc.request.VeificationCodeDTO;
import com.csc.response.NumberCodeResponse;
import com.csc.response.TokenResponse;
import com.csc.util.JwtUtils;
import jdk.nashorn.internal.runtime.JSONFunctions;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.Objects;
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
    @Autowired
    private UserPassenget userPassenget;


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
        stringRedisTemplate.opsForValue().set(generatorCodeByPhone(passengerPhone),data.toString(),2, TimeUnit.MINUTES);
        ResponseResult success = ResponseResult.success();
        return success;
    }

    /**
     * @author Tonny
     * @Param 根据手机号生成Redis的kry
     * @return key
     * @date 2022/8/10 18:03
     */
    private String generatorCodeByPhone(String passengerPhone){
        return verificationCode + passengerPhone;
    }


    /**
     * @author Tonny  校验
     * @Param passengerPhone 接收的手机号 verificationCode 接收的验证码
     * @return token
     * @date 2022/8/10 17:41
     */
    public ResponseResult checkCode(String passengerPhone,String verificationCode){

        String code = stringRedisTemplate.opsForValue().get(generatorCodeByPhone(passengerPhone));
        //验证码校验
        if(StringUtils.isBlank(code)){
            //验证码不存在时的返回
            return ResponseResult.fail(CommerStatusEeum.VERIFICATION_CODE_ERROR.getCode()
                    ,CommerStatusEeum.VERIFICATION_CODE_ERROR.getValue());
        }
        if(!Objects.equals(verificationCode.trim(),code.trim())){
            return ResponseResult.fail(CommerStatusEeum.VERIFICATION_CODE_ERROR.getCode()
                    ,CommerStatusEeum.VERIFICATION_CODE_ERROR.getValue());
        }
        //给乘客注册表注册用户
        userPassenget.loginOrRegister(new VeificationCodeDTO().setPassengerPhone(passengerPhone));

        String token = JwtUtils.generatorToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);

        return ResponseResult.success(tokenResponse);
    }
}
