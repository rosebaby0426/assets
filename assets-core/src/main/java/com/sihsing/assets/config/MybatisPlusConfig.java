package com.sihsing.assets.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Christine 2020/01/13
 */

@EnableTransactionManagement
@Configuration
@MapperScan("com.sihsing.assets.storage.mysql.mapper")
public class MybatisPlusConfig {

    private static final String DB_TYPE = "mysql";

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DB_TYPE);
        return paginationInterceptor;
    }
}
