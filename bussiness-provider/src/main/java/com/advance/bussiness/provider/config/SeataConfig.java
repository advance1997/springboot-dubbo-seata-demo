package com.advance.bussiness.provider.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: dubboDemo
 * @description: Seata配置，需要代理数据源
 * @author: zhouh
 * @create: 2020-08-05 17:38
 **/
@Configuration
public class SeataConfig {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * init global transaction scanner
     *
     * @Return: GlobalTransactionScanner
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        String applicationName = this.applicationContext.getEnvironment().getProperty("spring.application.name");
        return new GlobalTransactionScanner(applicationName, "my_test_tx_group");
    }

}
