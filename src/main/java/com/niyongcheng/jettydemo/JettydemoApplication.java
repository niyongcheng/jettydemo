package com.niyongcheng.jettydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class JettydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JettydemoApplication.class, args);
	}
}
