package com.zhichanzaixian.trademarkapi.controller;

import com.zhichanzaixian.trademarkapi.feign.MySpringApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by nerosun  on 2022/1/6
 *
 * @author nerosun
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    MySpringApiClient mySpringApiClient;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/test")
    //@RequestMapping(value = "/test",method = {RequestMethod.POST,RequestMethod.GET})
    public Object test() throws InterruptedException {
        log.info("========important print enter test========");
       // TimeUnit.SECONDS.sleep(300L);
        Map<String,String> map = new HashMap<>();
        map.put("msg","do work finish!");
        return map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @RequestMapping(value = "/testError",method = {RequestMethod.POST,RequestMethod.GET})
    public Object testError() throws InterruptedException {
        log.info("enter testError");
        Map<String,String> map = new HashMap<>();
        map.put("msg","500");
        return map;
    }


    @GetMapping("/callFeign")
    public Object callFeign() throws InterruptedException {
        Map<String,String> map = new HashMap<>();
        map.put("msg","call feign");
        mySpringApiClient.timeTest("123");
        return map;
    }

    @GetMapping("/callFeign500")
    public Object callFeign500() throws InterruptedException {
        Map<String,String> map = new HashMap<>();
        map.put("msg","call feign");
        mySpringApiClient.testError("123");
        return map;
    }

}
