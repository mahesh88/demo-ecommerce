package com.net.commerce.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.net.commerce.order.internal")
public class NetCommerceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetCommerceOrderApplication.class, args);
	}

}
