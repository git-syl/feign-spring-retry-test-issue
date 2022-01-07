package com.zhichanzaixian.trademarkapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



/**
 * @author syl  Date: 2019/12/6 Email:
 */
@SpringBootApplication
@EnableEurekaServer
public class TrademarkEurekaApplication {


    public static void main(String[] args) {
        SpringApplication.run(TrademarkEurekaApplication.class, args);
    }




}
