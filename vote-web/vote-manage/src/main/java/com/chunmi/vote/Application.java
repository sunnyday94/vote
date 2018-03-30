package com.chunmi.vote;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/***
 * 
 * @SpringBootApplication，这个注解的作用相当于同时添加了
 * @EnableAutoConfiguration
 * @ComponentScan
 * @Configuration
 */
@SpringBootApplication(
		exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class }, 
		scanBasePackages = {"com.chunmi.vote.*" })
@MapperScan(basePackages= {"com.chunmi.vote.dao"})  //扫描dao
@EnableCaching   //开启缓存
@EnableTransactionManagement  //开启事务管理
@EnableScheduling    //开启定时任务
public class Application extends SpringBootServletInitializer {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return configureApplication(builder);
	}

	public static void main(String[] args) {
		logger.debug("app start .....");
		configureApplication(new SpringApplicationBuilder()).run(args);
	}

	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
		return builder.sources(Application.class).bannerMode(Banner.Mode.OFF);
	}
}
