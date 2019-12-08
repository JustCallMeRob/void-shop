package com.rob.voidshop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String name;
    private String description;
    private String price;
    private String pic_path;

    @ManyToMany
    private Set<Cart> carts;

    @ManyToMany
    private Set<Order> orders;

    protected Product(){}

    public Product(Long id, String name, String description, String price, String pic_path, Set<Cart> carts, Set<Order> orders) {
        this.productId = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pic_path = pic_path;
        this.carts = carts;
        this.orders = orders;
    }

    public Product(String name, String description, String price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description, String price, String pic_path){
        this.name = name;
        this.description = description;
        this.price = price;
        this.pic_path = pic_path;
    }

    public Long getId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setId(Long id) {
        this.productId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', description='%s, price='%s']",
                productId, name, description, price);
    }
}
