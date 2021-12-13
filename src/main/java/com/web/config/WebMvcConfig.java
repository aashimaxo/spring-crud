package com.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.web.dao.StudentDao;
import com.web.dao.StudentDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan("com.web")
public class WebMvcConfig {
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr= new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		
		return vr;
		
		
	}
	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mvcjdbc");
		ds.setUsername("root");
		ds.setPassword("PASSWORD");

		return ds;
	}
	
	@Bean
	public StudentDao getStudentDao() {
		return new StudentDaoImpl(getDataSource());
	}

}
