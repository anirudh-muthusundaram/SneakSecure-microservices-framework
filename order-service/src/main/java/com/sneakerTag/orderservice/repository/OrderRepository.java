package com.sneakerTag.orderservice.repository;

import com.sneakerTag.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
