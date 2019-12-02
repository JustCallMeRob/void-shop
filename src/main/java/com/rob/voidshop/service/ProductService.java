package com.rob.voidshop.service;

import com.rob.voidshop.model.Product;
import com.rob.voidshop.model.User;
import com.rob.voidshop.repository.ProductRepository;
import com.rob.voidshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getProduct(String name){
        return productRepository.findByName(name);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }
}
