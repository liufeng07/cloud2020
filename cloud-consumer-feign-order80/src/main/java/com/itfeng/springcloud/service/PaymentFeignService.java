package com.itfeng.springcloud.service;

import com.itfeng.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liuf
 * @Description TODO
 * @Date 2020/7/20
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //feign 接口调用
    @GetMapping(value = "payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    /**
     * 模拟feign超时
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
