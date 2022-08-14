package com.csc.apipassenger.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.csc.dto.ResponseResult;
import com.csc.dto.TokenResult;
import com.csc.internalcommer.IdentityConstant;
import com.csc.util.JwtUtils;
import com.csc.util.RedisKeyPerfixUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-12 09:48
 **/
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Boolean result = true;
        String resultStr = "";
        TokenResult tokenResult = null;
        //获取token
        String token = request.getHeader("Authorization");

        tokenResult = JwtUtils.checkToken(token);

        if(Objects.isNull(tokenResult)){
            resultStr = "token invalid";
            result = false;
        }else {
            //拼接Key
            String phone = tokenResult.getPhone();
            String identity = tokenResult.getIdentity();
            //从Redis中获取token的key
            String tokenRedis = stringRedisTemplate
                    .opsForValue().get(RedisKeyPerfixUtil.generatorKey(phone, identity, IdentityConstant.ACCESSTOKEN));
            if ((Objects.isNull(tokenRedis)) || (!Objects.equals(token.trim(), tokenRedis.trim()))) {
                resultStr = "token invalid";
                result = false;
            }
        }

        if(!result){
            PrintWriter writer = response.getWriter();
            writer.println(JSONObject.fromObject(ResponseResult.fail(request)).toString());
        }

        return result;
    }
}
