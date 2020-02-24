package com.net.commerce.product.bean;

import com.net.commerce.product.jpa.Product;

public class ProductRO {

	private String id;
	private String name;
	private String sku;
	private Double price;
	private Boolean isAvailable;
	
	public ProductRO() {
		
	}

	public ProductRO(Product productPO) {
		this.id = productPO.getId();
		this.name = productPO.getName();
		this.sku = productPO.getSku();
		this.price = productPO.getPrice();
		this.isAvailable = productPO.getIsAvailable();
	}

	public ProductRO(String name, String sku, Double price, Boolean isAvailable) {
		super();
		this.name = name;
		this.sku = sku;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
