package com.itfeng.springcloud.service.impl;

import com.itfeng.springcloud.dao.PaymentDao;
import com.itfeng.springcloud.entity.Payment;
import com.itfeng.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuf
 * @Description TODO
 * @Date 2020/7/18
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
