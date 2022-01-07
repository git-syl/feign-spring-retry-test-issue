package com.zhichanzaixian.trademarkapi.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author syl  Date: 2018/5/8 Email:
 */
//@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer{


//    @Autowired
//    LogInterceptor logInterceptor;
//
//    @Autowired
//    UserArgumentResolver userArgumentResolver;



//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logInterceptor).addPathPatterns("/**")
//                //.excludePathPatterns("/home/login")
//                .excludePathPatterns("/dict/**")
//                .excludePathPatterns("/error")
//
//                .excludePathPatterns("/v2/api-docs/**")
//                .excludePathPatterns("/swagger-resources/**")
//                .excludePathPatterns("/webjars/**")
//                .excludePathPatterns("/swagger-ui.html")
//                .excludePathPatterns("/error")
//
//                // .excludePathPatterns("/druid/**")
//                .excludePathPatterns("/1o1/**")
//
//                .excludePathPatterns("/static/**")
//                .excludePathPatterns("/templates/**")
//
//                .excludePathPatterns("/qiniu/downloadStream/**")
//                .excludePathPatterns("/qiniu/downloadStream2/**");
//
//
//    }

    //.docx
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(false);
//        super.configurePathMatch(configurer);
    //  extends WebMvcConfigurationSupport {
    // implements WebMvcConfigurer {

//    }


//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(userArgumentResolver);
//    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }



}