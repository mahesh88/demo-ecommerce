package com.net.commerce.order;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.net.commerce.order.internal")
@EnableSwagger2
public class NetCommerceOrderApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(NetCommerceOrderApplication.class, args);
	}

}
