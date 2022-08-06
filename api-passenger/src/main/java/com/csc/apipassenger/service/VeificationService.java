package com.csc.apipassenger.service;

import jdk.nashorn.internal.runtime.JSONFunctions;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-06 10:51
 **/
@Service
public class VeificationService {

    // 接收手机号 调用验证码服务,获取验证码 返回 验证码
    public String generatorCode(String passengerPhone){
        System.out.println("调用验证码服务,获取验证码");
        System.out.println("存入Redis中");
        JSONObject json = new JSONObject();
        json.put("code","111111");
        json.put("message","success");
        return json.toString();
    }

}
