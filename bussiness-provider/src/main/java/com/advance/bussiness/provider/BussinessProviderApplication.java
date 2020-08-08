package com.advance.bussiness.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: dubboDemo
 * @description: 商品服务提供者启动类
 * @author: zhouh
 * @create: 2020-08-04 12:55
 **/
@EnableDubbo
@SpringBootApplication
@DubboComponentScan("com.advance.bussiness.provider.service")
public class BussinessProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BussinessProviderApplication.class, args);
    }
}
