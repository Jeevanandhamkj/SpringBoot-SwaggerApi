package com.example.SpringDatajpaDemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(ex());
	}
	@Bean
	public ExampleInterseptor ex() {
		return new ExampleInterseptor();
	}

}
