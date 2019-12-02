package com.rob.voidshop.repository;

import com.rob.voidshop.model.Cart;
import com.rob.voidshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUser(User user);
}
