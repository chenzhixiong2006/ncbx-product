package com.ncbx.configure;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * Druid bean配置
 * @author win7
 *
 */
@Configuration
public class DruidConfig {
 
    @Primary
    @Bean(name="dataSource")
    public DataSource druidDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
 
}