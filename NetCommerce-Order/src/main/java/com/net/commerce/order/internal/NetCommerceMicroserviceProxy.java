package com.net.commerce.order.internal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="prduct-proxy",url="http://localhost:8082")
public interface NetCommerceMicroserviceProxy {
   
	@GetMapping("/net/commerce/products/{sku}")
	public Product getProduct(@PathVariable("sku") String sku);
}
