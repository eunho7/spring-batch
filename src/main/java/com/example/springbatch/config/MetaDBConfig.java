package com.example.springbatch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MetaDBConfig {

    /*
     *  @Primary                 : DB 우선 순위 결정
     *  @ConfigurationProperties : application.yml에 있는 DB설정 가져옴
     */
    @Primary
    @Bean
    @ConfigurationProperties(prefix="spring.datasource-meta")
    public DataSource metaDBSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager metaTransactionManager() {
        return new DataSourceTransactionManager(metaDBSource());
    }
}
