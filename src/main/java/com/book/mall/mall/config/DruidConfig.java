package com.book.mall.mall.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//public class DruidConfig {
//
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druid() {
//        return new MysqlDataSource();
//    }
//}
