package com.csc.internalcommer;

import lombok.Getter;

public enum CommerStatusEeum {

    /*
    * 验证码错误提示 1000-1099
    * */
    VERIFICATION_CODE_ERROR(1099,"验证码不正确"),

    /**
     * Token错误提示 1100-1199
     * */
    TOKEN_ERROR(1199,"token错误"),

    /*
    * User错误
    * */
    USER_NOT_EXISTS(1200,"该用户不存在"),

    SUCCESS(1,"success"),

    FAIL(0,"fail");


    @Getter
    private int code;
    @Getter
    private String value;

    CommerStatusEeum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
