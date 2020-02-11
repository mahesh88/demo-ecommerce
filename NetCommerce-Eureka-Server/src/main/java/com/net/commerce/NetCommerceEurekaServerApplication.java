package com.net.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetCommerceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetCommerceEurekaServerApplication.class, args);
	}

}
