package com.advance.user.provider;

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
@DubboComponentScan("com.advance.user.provider.service")
@MapperScan("com.advance.user.provider.mapper")
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }

}
