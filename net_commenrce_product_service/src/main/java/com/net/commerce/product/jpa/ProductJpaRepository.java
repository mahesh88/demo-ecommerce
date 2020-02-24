package com.net.commerce.product.jpa;

import org.springframework.data.repository.CrudRepository;

public interface ProductJpaRepository extends CrudRepository<Product,String>  {
    Product findBySku(String sku);
}
