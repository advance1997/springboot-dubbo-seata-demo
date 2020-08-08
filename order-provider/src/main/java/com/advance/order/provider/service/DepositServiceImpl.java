package com.advance.order.provider.service;

import com.advance.domain.entity.Deposit;
import com.advance.order.api.IDepositService;
import com.advance.order.provider.mapper.DepositMapper;
import com.advance.utils.IdGenerator;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author advance
 * @since 2020-07-21
 */
@Service
public class DepositServiceImpl extends ServiceImpl<DepositMapper, Deposit> implements IDepositService {

    @Override
    public void insertOrder(Deposit deposit) {
        System.out.println("Deposit-全局事务id"+ RootContext.getXID());
        deposit.setItemOrder(IdGenerator.generatorCode());
        deposit.setCreateTime(LocalDateTime.now());
        save(deposit);
    }

    @Override
    public List<Deposit> getOrderList() {
        return list();
    }

    @Transactional
    @Override
    public void deleteOrder(long orderId) {
        removeById(orderId);
    }
}
