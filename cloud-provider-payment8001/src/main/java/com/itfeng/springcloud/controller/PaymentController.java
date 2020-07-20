package com.itfeng.springcloud.controller;

import com.itfeng.springcloud.entity.CommonResult;
import com.itfeng.springcloud.entity.Payment;
import com.itfeng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    //服务发现
    @Resource
    private DiscoveryClient discoveryClient;
    //端口
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

    /**
     * 服务发现
     *
     * @return
     */
    @GetMapping(value = "payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:" + element);
        }
        // 一个微服务下的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.debug(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + instance.getUri());
        }
        return this.discoveryClient;
    }
}
