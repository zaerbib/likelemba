package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.demo.entity.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
