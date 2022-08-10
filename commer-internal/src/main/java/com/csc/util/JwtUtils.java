package com.csc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.csc.dto.TokenResult;

import javax.print.DocFlavor;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    public static final String SIGN = "csc!@#$";

    public static final String JWT_KEY = "phone";
    //身份标识 1:乘客 2：司机
    private static final String JWT_IDENTITY = "identity";

    /** 生成token
     * @author Tonny
     * @Param 传递进来的map集合
     * @return 返回token
     * @date 2022/8/11 1:21
     */
    public static String generatorToken(String passengerPhone,String identity){

        Map<String,String> map = new HashMap<>();
        map.put(JWT_KEY,passengerPhone);
        map.put(JWT_IDENTITY,identity);
        //设置过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1); //当前时间+1天
        Date date = calendar.getTime();
        //创建JWT
        JWTCreator.Builder builder = JWT.create();
        //整合map
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //整合过期时间
        builder.withExpiresAt(date);
        //生成Token
        String sign = builder.sign(Algorithm.HMAC256(SIGN));

        return sign;
    }


    /**解析token
     * @author Tonny
     * @Param
     * @return 
     * @date 2022/8/11 1:22
     */
    public static TokenResult parseToken(String token){

        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        String phone = verify.getClaim(JWT_KEY).toString();
        String identity = verify.getClaim(JWT_IDENTITY).toString();
        TokenResult result = new TokenResult().setIdentity(identity).setPhone(phone);

        return result;
    }
}
