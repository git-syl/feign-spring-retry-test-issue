package com.zhichanzaixian.trademarkapi.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FallBack implements FallbackFactory<MySpringApiClient> {


    @Override
    public MySpringApiClient create(Throwable throwable) {

        return new MySpringApiClient() {

            @Override
            public void timeTest(String q) {
                log.error("enter FallBack.time",throwable);
            }

            @Override
            public void testError(String q) {
                log.error("enter testError",throwable);
            }


        };
    }
}
