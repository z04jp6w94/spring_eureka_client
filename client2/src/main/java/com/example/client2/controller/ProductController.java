package com.example.client2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getOneProductById")
    public Integer getOneProductById() {
        try {
            return restTemplate.getForObject("http://PRODUCT/getProductById", Integer.class);
        } catch (Exception e) {
            log.error("", e);
        }
        return 1;
    }

    @RequestMapping(value = "/getProductById")
    public Integer getProductById() {
        return Integer.valueOf(111);
    }

}
