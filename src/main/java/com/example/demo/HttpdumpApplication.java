package com.example.demo;

import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HttpdumpApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(HttpdumpApplication.class, args);
	}
	
	
	@Bean
	public FilterRegistrationBean someFilterRegistration() {

	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(someFilter());
	    registration.addUrlPatterns("/*");
	    registration.setName("someFilter");
	    registration.setOrder(1);
	    return registration;
	} 

	public Filter someFilter() {
	    return new SomeFilter();
	}
	
//	@RequestMapping("/")
//	public void dumpHTTP(HttpServletRequest request, HttpServletResponse response){
//		System.out.println(String.format("URL: %s", request.getRequestURL()));
//
//		Collections.list(request.getHeaderNames()).stream().forEach(s -> {
//			System.out.println(String.format("Header %s : %s", s, request.getHeader(s)));
//		});
//		
//	}
}
