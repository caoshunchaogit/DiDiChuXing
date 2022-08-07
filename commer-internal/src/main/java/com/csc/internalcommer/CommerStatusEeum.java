package com.csc.internalcommer;

import lombok.Getter;

public enum CommerStatusEeum {

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
