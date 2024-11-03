package com.example.MeongdaySTS.order.repository;

import com.example.MeongdaySTS.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
