package com.advance.account.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: dubboDemo
 * @description: 服务提供者启动类
 * @author: zhouh
 * @create: 2020-07-08 17:57
 **/
@EnableDubbo
@SpringBootApplication
@DubboComponentScan("com.advance.account.provider.service")
@MapperScan("com.advance.account.provider.mapper")
public class AccountProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountProviderApplication.class, args);
    }

}
