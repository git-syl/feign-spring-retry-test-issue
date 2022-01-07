package com.zhichanzaixian.trademarkapi.feign;

/**
 * Created by nerosun  on 2021/11/24
 *
 * @author nerosun
 */

import feign.Contract;
import feign.Logger;
import feign.QueryMapEncoder;
import feign.Retryer;
import feign.querymap.BeanQueryMapEncoder;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MyFeignConfig {


    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public QueryMapEncoder queryMapEncoder() {
        return new BeanQueryMapEncoder();
    }

    @Bean
    public Contract contract() {
        return new Contract.Default();
    }







}
