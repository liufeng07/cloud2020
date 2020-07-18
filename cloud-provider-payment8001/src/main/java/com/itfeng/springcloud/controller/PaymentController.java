package com.itfeng.springcloud.controller;

import com.itfeng.springcloud.entity.CommonResult;
import com.itfeng.springcloud.entity.Payment;
import com.itfeng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping(value = "/payment/insertPayment")
    public CommonResult insertPayment(@RequestBody Payment payment) {
        int i = paymentService.insertPayment(payment);
        if (i > 0) {
            return new CommonResult(200, "插入成功", i);
        }
        return new CommonResult(500, "插入失败");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        }
        return new CommonResult(400, "查询失败");
    }
}
