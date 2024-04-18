package com.example.client2.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public String getPort()
    {
        return port;
    }

    @GetMapping("/load")
    public String load() {
        try {
            return restTemplate.getForObject("http://PRODUCT/hello", String.class);
        }catch (Exception e){
            log.error("", e);
        }
        return "fail.";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World" + port;
    }

}
