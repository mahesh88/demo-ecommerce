package com.net.commerce.order.basket.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BasketItemJpaRepository extends CrudRepository<BasketItem, Integer>  {
       List<BasketItem> findByBasketId(String basketId);    
}