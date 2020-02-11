package com.net.commerce.product.rest.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.net.commerce.product.bean.Product;
import com.net.commerce.product.bean.error.CustomErrorResponse;

@RestController
public class NetCommerceProductRestResource   {
    
	private Map<String,Product> products =  new HashMap<String ,Product>();
	
	public NetCommerceProductRestResource() {
		fillProducts();
	}
	
	@GetMapping("/net/commerce/products")
	public Collection<Product> getProducts() {
	    return this.products.values();	 
	}
	
	@GetMapping("/net/commerce/products/{ProductSKU}")
	public Product getProductBySku(@PathVariable String ProductSKU ) throws CustomErrorResponse {
		Product product = this.products.get(ProductSKU);
		if(product==null) {
			throw new CustomErrorResponse("Product Not Found");
		}
	    return product; 
	}

	
	private void fillProducts() {
	     this.products.put("941",(createProduct("941","Pizza",10.0,true)));
	     this.products.put("942",createProduct("942","CAKE", 20.0,true));
	     this.products.put("943",createProduct("943","BURGER", 40.0,true));
	     this.products.put("944",createProduct("943","PASTA", 30.0,false));
	}
	
	private Product createProduct(String sku, String name , Double price , Boolean isavailable) {
		Product product = new Product(name,sku,price,isavailable);
	    return product;
	}
	
}
