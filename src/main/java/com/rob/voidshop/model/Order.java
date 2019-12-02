package com.rob.voidshop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @OneToMany
    private Set<User> user;

    @OneToMany
    private Set<Product> products;

    public Order(Long id, Set<User> user, Set<Product> products) {
        this.orderId = id;
        this.user = user;
        this.products = products;
    }

    protected Order(){}

    public Long getId() {
        return orderId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setId(Long id) {
        this.orderId = id;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}