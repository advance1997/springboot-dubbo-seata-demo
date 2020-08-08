package com.advance.order.api;

import com.advance.domain.entity.Deposit;

import java.util.List;

/**
 * @ClassName IDepositService
 * @Description TODO
 * @Author advance - 周舟
 * @Date 2020/8/4 10:24
 * @Version V1.0
 **/
public interface IDepositService {

    void insertOrder(Deposit deposit);

    List<Deposit> getOrderList();

    void deleteOrder(long orderId);

}
