package com.csc.apipassenger.service;

import com.csc.apipassenger.openfeign.NumberVerificationServeice;
import com.csc.dto.ResponseResult;
import jdk.nashorn.internal.runtime.JSONFunctions;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // 接收手机号 调用验证码服务,获取验证码 返回 验证码
    public ResponseResult generatorCode(String passengerPhone){
        System.out.println("调用验证码服务,获取验证码");
        ResponseResult responseResult = numberVerificationServeice.numberCode(6);
        System.out.println("调用远程返回的数字验证码:" + responseResult.getData());
        System.out.println("存入Redis中");
        return responseResult;
    }

}
