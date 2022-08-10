package com.csc.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Calendar;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-06 10:56
 **/

@Data
@Accessors(chain = true)
public class VeificationCodeDTO {
    private String passengerPhone;

    private String verificationCode;
}
