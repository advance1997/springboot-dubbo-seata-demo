package com.advance.bussiness.provider.service;

import com.advance.account.api.IAccountService;
import com.advance.bussiness.api.IBussinessService;
import com.advance.consts.SysConsts;
import com.advance.domain.dto.BuyDTO;
import com.advance.domain.entity.Deposit;
import com.advance.domain.entity.Goods;
import com.advance.domain.entity.User;
import com.advance.goods.api.IGoodsService;
import com.advance.order.api.IDepositService;
import com.advance.user.api.IUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;

/**
 * @program: dubboDemo
 * @description: 商品服务提供类
 * @author: zhouh
 * @create: 2020-08-04 12:50
 **/
@Service
public class BussinessServiceImpl implements IBussinessService {

    @Reference(cluster = "failfast", retries = 3, interfaceClass = IAccountService.class, lazy = true, check = false, timeout = 5000)
    IAccountService accountService;
    @Reference(cluster = "failfast", retries = 3, interfaceClass = IGoodsService.class, lazy = true, check = false, timeout = 5000)
    IGoodsService goodsService;
    @Reference(cluster = "failfast", retries = 3, interfaceClass = IDepositService.class, lazy = true, check = false, timeout = 5000)
    IDepositService orderService;
    @Reference(cluster = "failfast", retries = 3, interfaceClass = IUserService.class, lazy = true, check = false, timeout = 5000)
    IUserService userService;

    @GlobalTransactional(timeoutMills = 300000,  name = "bussiness-provider")
    @Override
    public void purchases(BuyDTO buyDTO){
        System.out.println("Bussiness-全局事务id"+RootContext.getXID());
        Integer userId = buyDTO.getUserId();
        Integer goodsId = buyDTO.getGoodsId();
        Goods goods = goodsService.getGoodsById(goodsId);
        User user = userService.getById(userId);

        //先从账户扣钱
        accountService.reduceAccount(userId, goods.getPrice());
        //减库存
        goodsService.reduceNum(goodsId);
        //创建订单
        Deposit deposit = new Deposit();
        deposit.setGoodsId(goodsId);
        deposit.setUserId(userId);
        deposit.setPrice(goods.getPrice());
        deposit.setAddress(user.getAddress());
        deposit.setNickName(user.getName());
        deposit.setStatus(SysConsts.DATA_VAILD);
        orderService.insertOrder(deposit);
        if(goodsId == 2){
            int i = 1/0;
//            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
        }

    }

}
