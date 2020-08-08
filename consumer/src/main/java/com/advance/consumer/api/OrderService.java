package com.advance.consumer.api;

import com.advance.domain.entity.Deposit;
import com.advance.order.api.IDepositService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dubboDemo
 * @description: 订单服务
 * @author: zhouh
 * @create: 2020-08-04 15:30
 **/
@Service
public class OrderService {

    @Reference(cluster = "failfast", retries = 3, interfaceClass = IDepositService.class, lazy = true, check = false, timeout = 5000)
    IDepositService orderService;

    public void createOrder(Deposit deposit){
        orderService.insertOrder(deposit);
    }

    public List<Deposit> listOrder(){
        return orderService.getOrderList();
    }

    public void deleteOrder(long id){
        orderService.deleteOrder(id);
    }

}
