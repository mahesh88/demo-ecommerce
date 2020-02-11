package com.net.commerce.order.basket.jpa;

import org.springframework.data.repository.CrudRepository;


public interface BasketJpaRepository extends CrudRepository<Basket, String> {
	
}
