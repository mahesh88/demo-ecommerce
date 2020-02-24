package com.net.commerce.order.rest.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.commerce.order.basket.jpa.Basket;
import com.net.commerce.order.basket.jpa.BasketJpaRepository;

@RestController
public class NetCommerceOrderRestResource {
	
	@Autowired
	BasketJpaRepository basketRepository;
	
	private Logger logger = LoggerFactory.getLogger(NetCommerceBasketRestResource.class);
        
	@PostMapping("/netcom/order/{basketID}")
	public void createOrder(@PathVariable String basketID) {
		logger.info("Order API Called for basketID" + basketID);
	    Optional<Basket> basketOpt = this.basketRepository.findById(basketID);	
	    if(basketOpt!=null) {
	    	
	    }
	}
}  
