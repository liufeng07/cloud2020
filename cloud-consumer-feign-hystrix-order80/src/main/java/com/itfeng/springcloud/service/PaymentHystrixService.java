package com.itfeng.springcloud.service;

/**
 * @author liuf
 * @Description TODO
 * @Date 2020/7/20
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
//统一为接口实现异常处理
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
