package com.net.commerce.order.rest.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.commerce.order.basket.jpa.Basket;
import com.net.commerce.order.basket.jpa.BasketItem;
import com.net.commerce.order.basket.jpa.BasketItemJpaRepository;
import com.net.commerce.order.basket.jpa.BasketJpaRepository;
import com.net.commerce.order.internal.NetCommerceMicroserviceProxy;
import com.net.commerce.order.internal.Product;

@Service
public class NetCommerceBasketHandler {
	
	@Autowired
	BasketItemJpaRepository itemRepository;
	
	@Autowired
	BasketJpaRepository basketRepository;
	
	@Autowired
	private NetCommerceMicroserviceProxy proxy;
	
	
	private Double taxRate= 0.05;
     
	public BasketItem addProductToBasket(String productID ,Basket basket){
		 BasketItem item = new BasketItem();
		 item.setPrice(getProductPrice(productID));
		 item.setProductID(productID);
		 item.setTax(calculateTax(getProductPrice(productID)));
		 item.setBasketId(basket.getId());
		 return itemRepository.save(item);
	}
	
	public List<BasketItem> getItemsForBasket(Basket basket){
		return this.itemRepository.findByBasketId(basket.getId());
	}
	
	public void validateBasket(Basket basket) {
		List<BasketItem> items = this.itemRepository.findByBasketId(basket.getId());
		long totalValue = 0;
		long totalTax = 0;
		long totalPayable = 0;
		for(BasketItem item : items) {
		   	totalValue = (long) (item.getPrice() + totalValue);
		   	totalTax = (long) (item.getTax() + totalTax);
		}
		totalPayable = totalValue + totalTax;
		basket.setTax(totalTax);
		basket.setTotalPayableAmount(totalPayable);
		basket.setTotalValue(totalValue);
		this.basketRepository.save(basket);
	}
	
	
	private Double getProductPrice(String productID){
		Product product = proxy.getProduct(productID);
		return product.getPrice();
	}
	
	private Double calculateTax(Double productPrice){
		 return (productPrice)*taxRate;
	}
	
	public void calculateBasket(Basket basket){
		
	}
}
