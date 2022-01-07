package com.zhichanzaixian.trademarkapi.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

@Configuration
public class RestConfig {


    @Bean
    public RestTemplate restTemplate(
            RestTemplateBuilder restTemplateBuilder) {
        RestTemplate build = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(500))
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
        List<HttpMessageConverter<?>> messageConverters = build.getMessageConverters();
        messageConverters.removeIf(converter -> converter instanceof StringHttpMessageConverter);
        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return build;
    }


//    @Bean
//    @ConditionalOnMissingBean({RestOperations.class, RestTemplate.class})
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        return new RestTemplate(factory);
//    }
//
//    @Bean
//    @ConditionalOnMissingBean({ClientHttpRequestFactory.class})
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setReadTimeout(15000);
//        factory.setConnectTimeout(15000);
//        return factory;
//    }

//下面被注的是对编码进行了处理，但是一般是不需要的，如果你是第一次用的话，可以直接采用上面的配置，如果采用下面的是无法使用String进行接受的，这一点是需要注意的。
    /*

     */
//    @Bean
//    @ConditionalOnMissingBean({RestOperations.class, RestTemplate.class})
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        // return new RestTemplate(factory);
//
//        RestTemplate restTemplate = new RestTemplate(factory);
//
//        // 使用 utf-8 编码集的 conver 替换默认的 conver（默认的 string conver 的编码集为"ISO-8859-1"）
//        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
//        messageConverters.removeIf(converter -> converter instanceof StringHttpMessageConverter);
//        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
//
//        return restTemplate;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean({ClientHttpRequestFactory.class})
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setReadTimeout(15000);
//        factory.setConnectTimeout(15000);
//        //factory.
//        return factory;
//
//
//}
}

