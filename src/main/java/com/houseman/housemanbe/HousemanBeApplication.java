package com.houseman.housemanbe;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableJSONDoc
//public class HousemanBeApplication extends SpringBootServletInitializer {
public class HousemanBeApplication{


	public static void main(String[] args) {
		SpringApplication.run(HousemanBeApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//		return builder.sources(HousemanBeApplication.class);
//	}
}
