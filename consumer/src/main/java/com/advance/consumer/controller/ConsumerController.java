package com.advance.consumer.controller;


import com.advance.consumer.api.AccountService;
import com.advance.consumer.api.GoodsService;
import com.advance.consumer.api.OrderService;
import com.advance.consumer.api.UserService;
import com.advance.consumer.service.IBuyService;
import com.advance.domain.dto.BuyDTO;
import com.advance.domain.dto.UserDTO;
import com.advance.domain.entity.Account;
import com.advance.domain.entity.Deposit;
import com.advance.domain.entity.Goods;
import com.advance.domain.entity.User;
import com.advance.domain.vo.UserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author advance
 * @since 2020-07-21
 */
@RestController
@RequestMapping("/api")
public class ConsumerController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private IBuyService buyService;

    @GetMapping("/user/page")
    public IPage<UserVO> listUserPage(Page page, @RequestBody UserDTO userDTO){
        return userService.getUserList(page, userDTO);
    }

    @PutMapping("/user")
    public void saveUser(@RequestBody User user){
        userService.saveOrUpdateUser(user);
    }

    @PostMapping("/user")
    public void updateUser(@RequestBody User user){
        userService.saveOrUpdateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

    @GetMapping("/user/list")
    public List<User> userList(){
        return userService.getUserList();
    }

    @GetMapping("/account/list")
    public List<Account> getAccountList(){
        return accountService.listAccounts();
    }

    @PutMapping("/account")
    public void getAccountList(@RequestBody Account account){
        accountService.createAccount(account);
    }

    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable("id")Integer id){
        accountService.deleteAccount(id);
    }

    @GetMapping("/goods/list")
    public List<Goods> getGoodsList(){
        return goodsService.listGoods();
    }

    @PutMapping("/goods")
    public void insertGoods(@RequestBody Goods goods){
        goodsService.addGoods(goods);
    }

    @DeleteMapping("/goods/{id}")
    public void deleteGoods(@PathVariable("id")Integer id){
        goodsService.deleteGoods(id);
    }

    @GetMapping("/order/list")
    public List<Deposit> listOrders(){
        return orderService.listOrder();
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable("id")long id){
        orderService.deleteOrder(id);
    }

    @PostMapping("/buy")
    public void doBuy(@RequestBody BuyDTO buyDTO) {
        buyService.doBuy(buyDTO);
    }

}
