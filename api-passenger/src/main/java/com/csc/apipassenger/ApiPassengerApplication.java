package com.csc.apipassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-06 10:27
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ApiPassengerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiPassengerApplication.class);
    }
}
