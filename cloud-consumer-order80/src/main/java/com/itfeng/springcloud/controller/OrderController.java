package com.itfeng.springcloud.controller;

import com.itfeng.springcloud.entity.CommonResult;
import com.itfeng.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @author liuf
 * @Description TODO
 * @Date 2020/7/18
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/create")
    public CommonResult<Payment> insertPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insertPayment", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}