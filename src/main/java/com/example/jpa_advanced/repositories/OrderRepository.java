package com.example.jpa_advanced.repositories;

import com.example.jpa_advanced.models.embedded.Order;
import com.example.jpa_advanced.models.embedded.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
