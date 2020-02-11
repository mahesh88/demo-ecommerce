package com.net.commerce.order.resourceobject;

import com.net.commerce.order.basket.jpa.BasketItem;

public class BasketItemRO {
    
	private String id;
	private String productID;
	private Double price;
	private Double tax;
	private String basketId;
	
	public BasketItemRO(BasketItem item) {
	  this.basketId= item.getBasketId();
	  this.productID = item.getProductID();
	  this.price = item.getPrice();
	  this.tax = item.getPrice();
	  this.id = item.getId();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public String getBasketId() {
		return basketId;
	}

	public void setBasketId(String basketId) {
		this.basketId = basketId;
	}
	
	
}
