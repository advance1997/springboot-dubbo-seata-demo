package com.advance.goods.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
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
@DubboComponentScan("com.advance.goods.provider.service")
@MapperScan("com.advance.goods.provider.mapper")
public class GoodsProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsProviderApplication.class, args);
    }
}
