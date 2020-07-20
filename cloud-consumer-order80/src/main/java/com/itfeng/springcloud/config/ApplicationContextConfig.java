package com.itfeng.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuf
 * @Description TODO
 * @Date 2020/7/18
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //赋予了负载均衡的能力 轮询负载机制
    //@LoadBalanced 注释了用自己手写的负载均算法
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
