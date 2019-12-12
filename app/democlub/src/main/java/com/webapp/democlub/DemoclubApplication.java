package com.webapp.democlub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { 
		"com.webapp.democlub.rest","com.webapp.democlub.domain", 
		"com.webapp.democlub.repository", "com.webapp.democlub.service",
		})
@EnableAutoConfiguration
public class DemoclubApplication {

	public static void main(final String[] args) {
		SpringApplication.run(DemoclubApplication.class, args);
	}

}
