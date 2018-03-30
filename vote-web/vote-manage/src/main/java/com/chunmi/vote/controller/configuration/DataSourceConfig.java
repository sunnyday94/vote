package com.chunmi.vote.controller.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DataSourceConfig {
	@Autowired
	private Environment env;

 	@Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new com.alibaba.druid.pool.DruidDataSource();
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(env.getProperty("mybatis.mapper-locations")));
        sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource(env.getProperty("mybatis.config-location")));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 事务管理
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
}
