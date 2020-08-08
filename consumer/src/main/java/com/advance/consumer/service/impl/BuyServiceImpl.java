package com.advance.consumer.service.impl;

import com.advance.consts.SysConsts;
import com.advance.consumer.api.AccountService;
import com.advance.consumer.api.GoodsService;
import com.advance.consumer.api.OrderService;
import com.advance.consumer.api.UserService;
import com.advance.consumer.service.IBuyService;
import com.advance.domain.dto.BuyDTO;
import com.advance.domain.entity.Deposit;
import com.advance.domain.entity.Goods;
import com.advance.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: dubboDemo
 * @description: 下单类
 * @author: zhouh
 * @create: 2020-08-04 18:28
 **/
@Service
public class BuyServiceImpl implements IBuyService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @Override
    public void doBuy(BuyDTO buyDTO){
        Integer userId = buyDTO.getUserId();
        Integer goodsId = buyDTO.getGoodsId();
        Goods goods = goodsService.getGoodsById(goodsId);
        User user = userService.getUserById(userId);

        //先从账户扣钱
        accountService.reduceAccount(userId, goods.getPrice());
        //减库存
        goodsService.reduceGoodsNum(goodsId);
        //创建订单
        Deposit deposit = new Deposit();
        deposit.setGoodsId(goodsId);
        deposit.setUserId(userId);
        deposit.setPrice(goods.getPrice());
        deposit.setAddress(user.getAddress());
        deposit.setNickName(user.getName());
        deposit.setStatus(SysConsts.DATA_VAILD);
        orderService.createOrder(deposit);

    }
}
