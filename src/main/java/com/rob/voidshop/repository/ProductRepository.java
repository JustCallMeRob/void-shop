package com.rob.voidshop.repository;

import com.rob.voidshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    Product findByProductId(long id);
}
