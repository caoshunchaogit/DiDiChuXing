package com.csc.dto;

import com.csc.internalcommer.CommerStatusEeum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-06 13:58
 **/
@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;


    //成功响应的方法
    public static <T> ResponseResult success(T data){
        return new ResponseResult().setCode(CommerStatusEeum.SUCCESS.getCode()).setData(data).setMessage(CommerStatusEeum.SUCCESS.getValue());
    }

    //失败响应的方法
    public static <T> ResponseResult fail(T data){
        return new ResponseResult().setData(data);
    }

    public static ResponseResult fail(int code,String message){
        return new ResponseResult().setCode(code).setMessage(message);
    }

    public static ResponseResult fail(int code,String message,String data){
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }

}
