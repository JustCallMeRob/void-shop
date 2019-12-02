package com.rob.voidshop.repository;

import com.rob.voidshop.model.Order;
import com.rob.voidshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUser(User user);
    Order findByOrderId(Long id);
}
