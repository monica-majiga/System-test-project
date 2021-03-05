package com.java.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SystemTestProjectApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SystemTestProjectApplication.class, args);
	}

}
