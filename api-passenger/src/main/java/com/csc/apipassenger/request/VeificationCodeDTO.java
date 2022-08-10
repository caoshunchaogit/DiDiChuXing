package com.csc.apipassenger.request;

import lombok.Data;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-06 10:56
 **/

@Data
public class VeificationCodeDTO {
    private String passengerPhone;

    private String verificationCode;
}
