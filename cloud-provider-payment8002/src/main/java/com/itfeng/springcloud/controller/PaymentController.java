package com.itfeng.springcloud.controller;

import com.itfeng.springcloud.entity.CommonResult;
import com.itfeng.springcloud.entity.Payment;
import com.itfeng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author liuf
 * @Description TODO
 * @Date 2020/7/18
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/insertPayment")
    public CommonResult insertPayment(@RequestBody Payment payment) {
        int i = paymentService.insertPayment(payment);
        if (i > 0) {
            return new CommonResult(200, "insert success,serverPort " + serverPort, i);
        }
        return new CommonResult(500, "insert fail");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "find success,serverPort " + serverPort, payment);
        }
        return new CommonResult(400, "find fail");
    }
}
