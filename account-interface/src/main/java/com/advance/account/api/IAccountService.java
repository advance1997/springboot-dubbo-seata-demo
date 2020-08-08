package com.advance.account.api;

import com.advance.domain.entity.Account;

import java.util.List;

/**
 * @ClassName IAccountService
 * @Description TODO 账户服务接口
 * @Author advance - 周舟
 * @Date 2020/8/4 10:21
 * @Version V1.0
 **/
public interface IAccountService {

    void InsertAccount(Account account);

    void reduceAccount(Integer userId, double money);

    List<Account> getAccountList();

    Account getAccountByUserId(Integer userId);

    void deleteAccount(Integer accountId);

}
