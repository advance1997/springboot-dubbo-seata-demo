package com.advance.consumer.api;

import com.advance.account.api.IAccountService;
import com.advance.domain.entity.Account;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dubboDemo
 * @description: 账户服务提供类
 * @author: zhouh
 * @create: 2020-08-04 11:20
 **/
@Service
public class AccountService {

    @Reference(cluster = "failfast", retries = 3, interfaceClass = IAccountService.class, lazy = true, check = false, timeout = 5000)
    IAccountService accountService;

    public List<Account> listAccounts(){
        return accountService.getAccountList();
    }

    public Account getAccount(Integer userId){
        return accountService.getAccountByUserId(userId);
    }

    public void createAccount(Account account){
        accountService.InsertAccount(account);
    }

    public void reduceAccount(Integer userId, double money) {
        accountService.reduceAccount(userId, money);
    }

    public void deleteAccount(Integer accountId){
        accountService.deleteAccount(accountId);
    }
}
