package com.java.os.api.repository;

import com.java.os.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findByOrderId(int orderId);
    List<Order> findAll();
}
