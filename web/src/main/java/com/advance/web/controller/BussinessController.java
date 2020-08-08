package com.advance.web.controller;

import com.advance.bussiness.api.IBussinessService;
import com.advance.domain.dto.BuyDTO;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: dubboDemo
 * @description: 业务控制器
 * @author: zhouh
 * @create: 2020-08-05 21:02
 **/
@RestController
@RequestMapping("/api/bussiness")
public class BussinessController {

    @Reference(cluster = "failfast", retries = 3, interfaceClass = IBussinessService.class, lazy = true, check = false, timeout = 5000)
    IBussinessService bussinessService;

    @PostMapping("/purchase")
    public void purchse(@RequestBody BuyDTO buyDTO){
        bussinessService.purchases(buyDTO);
    }

}
