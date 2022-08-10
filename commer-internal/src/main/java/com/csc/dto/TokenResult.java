package com.csc.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Csc
 * @version 2021.2
 * @date 2022/8/11 1:42
 */
@Data
@Accessors(chain = true)
public class TokenResult {

    private String phone;

    private String identity;

}
