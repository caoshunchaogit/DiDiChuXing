package com.csc.request;

import lombok.Data;

/**
 * @author Csc
 * @version 2021.2
 * @date 2022/8/14 19:13
 */
@Data
public class ForecastPriceDto {

    private String depLongitude;  //出发经度

    private String deLatitude; //纬度

    private String destLongitude;

    private String destLatiude;
}
