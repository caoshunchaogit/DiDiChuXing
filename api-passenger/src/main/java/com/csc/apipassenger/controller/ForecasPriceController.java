package com.csc.apipassenger.controller;

import com.csc.dto.ResponseResult;
import com.csc.request.ForecastPriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Csc
 * @version 2021.2
 * @date 2022/8/14 19:25
 */
@RestController
@Slf4j
public class ForecasPriceController {


    @PostMapping("/foreacst-price")
    public ResponseResult forecasPrice(@RequestBody ForecastPriceDto forecastPriceDto){

        String depLongitude = forecastPriceDto.getDepLongitude(); //经度
        String deLatitude = forecastPriceDto.getDeLatitude();
        String destLatiude = forecastPriceDto.getDestLatiude();
        String destLongitude = forecastPriceDto.getDestLongitude();


        return ResponseResult.success();
    }
}
