package com.csc.util;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-13 09:39
 **/
public class RedisKeyPerfixUtil {

    public static String verificationCode = "passenger-verification-code-";

    public static String tokenPrefix = "token-";

    /**
     * @author Tonny
     * @Param 根据手机号生成Redis的kry
     * @return key
     * @date 2022/8/10 18:03
     */
    public static String generatorCodeByPhone(String passengerPhone){
        return verificationCode + passengerPhone;
    }

    /**
     * @author Tonny
     * @Param 根据身份表示和手机号生成Token 在Redis的Key
     * @return
     * @date  8:52
     */
    public static String generatorKey(String phone ,String identity,String tokenType){
        return tokenPrefix + phone + "-" + identity + "-" + tokenType;
    }
}
