package com.rob.voidshop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private boolean isActive;

    @ManyToMany
    private Set<Role> roles;

    @OneToOne
    private Cart cart;

    @OneToMany
    private Set<Order> orders;

    public User() { }

    public User(User user) {
        this.roles = user.getRoles();
        this.id = user.getId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.cart = user.getCart();
        this.orders = user.getOrders();
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Cart getCart() {
        return cart;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, username='%s', password='%s']",
                id, username, password);
    }
}
