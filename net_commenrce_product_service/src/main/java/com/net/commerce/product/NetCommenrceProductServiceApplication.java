package com.net.commerce.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NetCommenrceProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetCommenrceProductServiceApplication.class, args);
	}

}
