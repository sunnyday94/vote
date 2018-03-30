package com.chunmi.vote.controller.configuration;

import java.util.EventListener;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.chunmi.vote.controller.filter.LoginCheckFilter;
import com.chunmi.vote.controller.filter.MySessionListener;
import com.chunmi.vote.controller.filter.XSSFilter;

@Configuration
public class FilterConfig {
	/**
	 * 统一处理编码问题
	 * @return
	*/
    @Bean
	public FilterRegistrationBean encodingFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new CharacterEncodingFilter());
		registrationBean.addInitParameter("encoding","UTF-8");
		registrationBean.addInitParameter("forceEncoding","true");
		registrationBean.addServletNames("encodingFilter");
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}
	
    
    /**
     * 登录过滤器注册
     * @return
     */
	@Bean
	public FilterRegistrationBean regLoginCheckFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new LoginCheckFilter());
		return registration;
	}
	
    /**
     * XSS防御
     * @return
     */
	@Bean
	public FilterRegistrationBean regXSSFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new XSSFilter());
		return registration;
	}
	
	/**
	 * session监听器
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean<EventListener> regMySessionListener(){
		ServletListenerRegistrationBean<EventListener> registration = new ServletListenerRegistrationBean<EventListener>();
		registration.setListener(new MySessionListener());
		return registration;
	}
	
}
