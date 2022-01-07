package com.zhichanzaixian.trademarkapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;


/**
 * @author nerosun  Date: 2019/12/6 Email:
 */

@EnableRetry
@EnableFeignClients
@SpringBootApplication
public class ApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }




}
