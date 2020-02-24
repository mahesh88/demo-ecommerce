package com.net.commerce.product.rest.resource;


import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.commerce.product.bean.ProductRO;
import com.net.commerce.product.bean.error.CustomErrorResponse;
import com.net.commerce.product.internal.ApiUrl;
import com.net.commerce.product.internal.RestException;
import com.net.commerce.product.jpa.Product;
import com.net.commerce.product.jpa.ProductJpaRepository;

@RestController
public class NetCommerceProductRestResource   {
	
	@Autowired
	ProductJpaRepository productRepository;
    
	private Map<String,ProductRO> products =  new HashMap<String ,ProductRO>();
	
	public NetCommerceProductRestResource() {
		fillProducts();

	}
	
	@GetMapping(value = ApiUrl.PRODUCTS, headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public Collection<ProductRO> getProducts() {
	    return this.products.values();	 
	}
	
	@GetMapping("/net/commerce/products/{ProductSKU}")
	public ProductRO getProductBySku(@PathVariable String ProductSKU ) throws CustomErrorResponse {
		Product product = productRepository.findBySku(ProductSKU);
		if(product==null) {
			throw new RestException(HttpStatus.NOT_FOUND,"401","Product Not Found");
		}
	    return new ProductRO(product); 
	}
	
	
	 //@PostMapping(value = ApiUrl.PRODUCTS, headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value = ApiUrl.PRODUCTS)
	public ProductRO createProduct(ProductRO product) throws CustomErrorResponse {
		validateProduct(product);
		Product productPO = this.productRepository.save(createProductEntity(product));
	    return new ProductRO(productPO); 
	}
	
	private Product createProductEntity(ProductRO product) {
		Product productPO = new Product();
		productPO.setIsAvailable(product.getIsAvailable());
		productPO.setName(product.getName());
		productPO.setPrice(product.getPrice());
		productPO.setSku(product.getSku());
		return productPO;
	}
	
	private void validateProduct(ProductRO product) {
		if(product.getSku().isEmpty()) {
			  throw new RestException(HttpStatus.BAD_REQUEST,"401","Missing SKU");
		}
		if(product.getName().isEmpty()) {
			  throw new RestException(HttpStatus.BAD_REQUEST,"401","Missing Name");
		}
	}
	

	
	private void fillProducts() {
	     this.products.put("941",(createProduct("941","Pizza",10.0,true)));
	     this.products.put("942",createProduct("942","CAKE", 20.0,true));
	     this.products.put("943",createProduct("943","BURGER", 40.0,true));
	     this.products.put("944",createProduct("943","PASTA", 30.0,false));
	}
	
	private ProductRO createProduct(String sku, String name , Double price , Boolean isavailable) {
		ProductRO product = new ProductRO(name,sku,price,isavailable);
	    return product;
	}
	
}
