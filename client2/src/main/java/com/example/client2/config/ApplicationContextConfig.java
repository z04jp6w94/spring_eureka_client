package com.example.client2.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(name = "PRODUCT",configuration = ReactorLoadBalancerConfig.class)
public class ApplicationContextConfig {

    //将这个对象放入ioc容器
    @Bean
    @LoadBalanced  //使用这个注解给restTemplate赋予了负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
