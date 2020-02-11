package com.net.commerce.product.bean;

public class Product {
    

	private String name ;
	private String sku ;
	private Double price ;
	private Boolean isAvailable;
	
	 
	public Product(String name, String sku, Double price, Boolean isAvailable) {
		super();
		this.name = name;
		this.sku = sku;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}
