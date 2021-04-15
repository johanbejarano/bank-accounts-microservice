package com.vobi.devops.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringBootRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunner.class, args);
	}
}
