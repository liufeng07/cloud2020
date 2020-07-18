package com.itfeng.springcloud.service;

import com.itfeng.springcloud.entity.Payment;


/**
 * @author liuf
 * @Description TODO
 * @Date 2020/7/18
 */
public interface PaymentService {
    int insertPayment(Payment payment);

    Payment getPaymentById(Long id);
}
