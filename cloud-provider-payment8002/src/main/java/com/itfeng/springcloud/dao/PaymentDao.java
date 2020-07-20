package com.itfeng.springcloud.dao;

import com.itfeng.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuf
 * @Description TODO
 * @Date 2020/7/18
 */
@Mapper
public interface PaymentDao {
    int insertPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
