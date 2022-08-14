package com.csc.apipassenger.service;

import com.csc.dto.ResponseResult;
import com.csc.dto.TokenResult;
import com.csc.internalcommer.CommerStatusEeum;
import com.csc.internalcommer.IdentityConstant;
import com.csc.response.TokenResponse;
import com.csc.util.JwtUtils;
import com.csc.util.RedisKeyPerfixUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-13 12:47
 **/
@Service
public class RefreshTokenService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult refreshToken(String refreshTokenSrc){
        //校验Token
        TokenResult tokenResult = JwtUtils.checkToken(refreshTokenSrc);

        if(tokenResult == null){
            return ResponseResult.fail(CommerStatusEeum.TOKEN_ERROR.getCode(),CommerStatusEeum.TOKEN_ERROR.getValue());
        }
        //通过解析到的Token获取手机号和身份标识
        String identity = tokenResult.getIdentity();
        String phone = tokenResult.getPhone();
        //生成refreshToken的key
        String refreshKey = RedisKeyPerfixUtil.generatorKey(phone, identity, IdentityConstant.REFRESHTOKEN);

        //获取原来的refreshToken
        String oldRefreshToken = stringRedisTemplate.opsForValue().get(refreshKey);

        if ((Objects.isNull(oldRefreshToken)) || (!Objects.equals(oldRefreshToken.trim(), refreshTokenSrc.trim()))) {
            return ResponseResult.fail(CommerStatusEeum.TOKEN_ERROR.getCode(),CommerStatusEeum.TOKEN_ERROR.getValue());
        }

        //重新生成accessToken和refreshToken
        String accessKey = RedisKeyPerfixUtil.generatorKey(phone, IdentityConstant.PASSENGER_IDENTITY, IdentityConstant.ACCESSTOKEN);
        String accessToken = JwtUtils.generatorToken(phone, IdentityConstant.PASSENGER_IDENTITY, IdentityConstant.ACCESSTOKEN);
        String refreshToken = JwtUtils.generatorToken(phone, IdentityConstant.PASSENGER_IDENTITY, IdentityConstant.REFRESHTOKEN);

        stringRedisTemplate.opsForValue().set(accessKey,accessToken,30,TimeUnit.DAYS);
        stringRedisTemplate.opsForValue().set(refreshKey,refreshToken,31,TimeUnit.DAYS);

//        stringRedisTemplate.opsForValue().set(accessKey,accessToken,20,TimeUnit.DAYS);
//        stringRedisTemplate.opsForValue().set(refreshKey,refreshToken,50,TimeUnit.DAYS);

        TokenResponse tokenResponse = new TokenResponse().setAccessToken(accessToken).setRefreshToken(refreshToken);

        return ResponseResult.success(tokenResponse);
    }
}
