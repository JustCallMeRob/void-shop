package com.rob.voidshop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    @OneToOne
    private User user;

    @OneToMany
    private Set<Product> products;

    protected Cart(){}

    public Cart(Long id, Set<Product> products, User user) {
        this.cartId = id;
        this.products = products;
        this.user = user;
    }

    public Long getId() {
        return cartId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.cartId = id;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
