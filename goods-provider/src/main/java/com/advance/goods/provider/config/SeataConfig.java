package com.advance.goods.provider.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

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
     * hikari数据源
     *
     * @return
     * @author zhouh
     * @time 2020年6月11日
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        return hikariDataSource;
    }

    /**
     * 代理数据源
     *
     * @param dataSource
     * @return
     * @author zhouh
     * @time 2020年6月11日
     */
    @Bean
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

    /**
     * 事务管理器代理
     * @param dataSourceProxy
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSourceProxy dataSourceProxy) {
        return new DataSourceTransactionManager(dataSourceProxy);
    }

//    /**
//     * 初始化Mybatis-plus的sqlSessionFactory
//     * @Param: dataSourceProxy  datasource proxy
//     * @Return: DataSourceProxy  datasource proxy
//     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//
//        // 配置mybatis-plus的分页
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        Interceptor[] plugins = {paginationInterceptor};
//        sqlSessionFactoryBean.setPlugins(plugins);
//        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath*:/mapper/*.xml"));
//        // 配置spring的本地事务
//        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
//
//        // 配置mybatis-plus的逻辑删除
//        sqlSessionFactoryBean.setGlobalConfig(new GlobalConfig().setSqlInjector(new LogicSqlInjector()));
//
//        // 配置mybatis-plus的log打印
//        MybatisConfiguration cfg = new MybatisConfiguration();
//        cfg.setJdbcTypeForNull(JdbcType.NULL);
//        cfg.setMapUnderscoreToCamelCase(true);
//        cfg.setCacheEnabled(false);
//        cfg.setLogImpl(StdOutImpl.class);
//        sqlSessionFactoryBean.setConfiguration(cfg);
//
//        return sqlSessionFactoryBean.getObject();
//    }

    /**
     * 初始化全局事务Scanner
     *
     * @Return: GlobalTransactionScanner
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        String applicationName = this.applicationContext.getEnvironment().getProperty("spring.application.name");
        return new GlobalTransactionScanner(applicationName , "my_test_tx_group");
    }

}
