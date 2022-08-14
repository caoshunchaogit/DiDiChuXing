package com.csc.apipassenger.service;

import com.csc.dto.ResponseResult;
import com.csc.response.ForecasPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Csc
 * @version 2021.2
 * @date 2022/8/14 19:39
 */
@Service
@Slf4j
public class ForecasPriceService {

    /**
     * @author Tonny
     * @Param 根据出发地的经度 纬度 和 目的地的经度 纬度 算出预计价格
     * @return
     * @date 2022/8/14 19:43
     */
    public ResponseResult forecasPrice(String depLongitude,String deLatitude,String destLatiude,String destLongitude){

        log.info("出发地的经度:" + depLongitude);
        log.info("出发地的纬度:" + deLatitude);
        log.info("目的地的经度:" + destLatiude);
        log.info("目的地的纬度:" + destLongitude);

        //调用

        ForecasPriceResponse forecasPriceResponse = new ForecasPriceResponse();
        forecasPriceResponse.setPrice(13.14);
        return ResponseResult.success(forecasPriceResponse);
    }
}
