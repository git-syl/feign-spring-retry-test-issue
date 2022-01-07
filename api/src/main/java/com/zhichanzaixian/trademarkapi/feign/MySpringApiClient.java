package com.zhichanzaixian.trademarkapi.feign;


import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "MY-SPRING-API", configuration = {MyFeignConfig.class}, fallbackFactory = FallBack.class)
public interface MySpringApiClient {

    @RequestLine("GET /test?q={appNo}")
    void timeTest(@Param("appNo") String q);


    @RequestLine("GET /testError?q={q}")
    void testError(@Param("appNo") String q);


}
