package com.example.SpringDatajpaDemo.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExampleInterseptor implements HandlerInterceptor {
	
	Logger logger=LoggerFactory.getLogger(ExampleInterseptor.class);
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("-----------preHandler----------");
		logger.info("RequestUrl:"+request.getRequestURI());
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("---------------postHandler------------------");
		logger.info("Request URI :"+request.getRequestURI());
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("--------------afterCompletion----------------");
		logger.info("Request URI :"+request.getRequestURI());
		long exe=System.currentTimeMillis()-(long)request.getAttribute("startTime");
		logger.info("executed Time=="+exe);
		
		
		
	}

}
