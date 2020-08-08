package com.advance.order.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: dubboDemo
 * @description: 订单服务提供者启动类
 * @author: zhouh
 * @create: 2020-08-04 15:08
 **/
@EnableDubbo
@SpringBootApplication
@DubboComponentScan("com.advance.order.provider.service")
@MapperScan("com.advance.order.provider.mapper")
public class OrderProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class, args);
    }
}
