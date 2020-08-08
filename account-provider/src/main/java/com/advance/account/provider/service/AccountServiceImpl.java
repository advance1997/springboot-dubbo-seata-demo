package com.advance.account.provider.service;

import com.advance.account.api.IAccountService;
import com.advance.account.provider.mapper.AccountMapper;
import com.advance.domain.entity.Account;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;

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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    @Override
    public void InsertAccount(Account account) {
        account.setCreateTime(LocalDateTime.now());
        save(account);
    }

    @Override
    public void reduceAccount(Integer userId, double money) {
        System.out.println("Account-全局事务id"+ RootContext.getXID());
        Account account = getAccountByUserId(userId);
        double lastMoney = account.getMoney() - money;
        UpdateWrapper<Account> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(Account::getMoney, lastMoney).eq(Account::getUserId, userId);
        update(updateWrapper);
    }

    @Override
    public List<Account> getAccountList() {
        return list();
    }

    @Override
    public Account getAccountByUserId(Integer userId) {
        QueryWrapper<Account> accountQueryWrapper = new QueryWrapper<>();
        accountQueryWrapper.lambda().eq(Account::getUserId, userId);
        return this.baseMapper.selectOne(accountQueryWrapper);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        removeById(accountId);
    }
}
