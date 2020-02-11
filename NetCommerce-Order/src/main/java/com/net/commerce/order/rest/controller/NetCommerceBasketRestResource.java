package com.net.commerce.order.rest.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.commerce.order.basket.jpa.Basket;
import com.net.commerce.order.basket.jpa.BasketItem;
import com.net.commerce.order.basket.jpa.BasketItemJpaRepository;
import com.net.commerce.order.basket.jpa.BasketJpaRepository;
import com.net.commerce.order.internal.NetCommerceMicroserviceProxy;
import com.net.commerce.order.resourceobject.BasketRO;
import com.net.commerce.order.rest.handler.NetCommerceBasketHandler;

@RestController
public class NetCommerceBasketRestResource {
    
	@Autowired
	BasketJpaRepository basketRepository;
	
	@Autowired
	NetCommerceBasketHandler basketHandler;
	
	@Autowired
	BasketItemJpaRepository itemRepository;
	
	

	
	@PostMapping("/netcom/basket")
	public String createBasket()  {
		Basket basket = basketRepository.save(new Basket());
		return basket.getId();
	}
	
	@GetMapping("/netcom/basket/-")
	public void getActiveBasket() {
		
	}
	
	@GetMapping("/netcom/basket/{basketID}")
	public BasketRO getBasket(@PathVariable String basketID) {
	   Optional<Basket> basketOpt  = this.basketRepository.findById(basketID);
	   if(basketOpt.isPresent()) {
		   Basket basket = basketOpt.get();
		   List<BasketItem> items = this.basketHandler.getItemsForBasket(basket);
		   BasketRO basketRO = new BasketRO(basket, items);
		   return basketRO;
	   }
	  return null;
	}
	
	@PutMapping("/netcom/basket/{basketID}/{productID}")
	public String addProductToBasket(@PathVariable String basketID,@PathVariable String productID) {
		 System.out.println("BasketID is " + basketID);
		 Optional<Basket> basketOpt = basketRepository.findById(basketID);
		 if(basketOpt.isPresent()) {
			 Basket basket = basketOpt.get();
			 BasketItem item = this.basketHandler.addProductToBasket(productID, basket);
			 if(item!=null) {
				 this.basketHandler.validateBasket(basket);
				 return item.getId();
			 }
		 }
		 return null;
	}
	
}
