package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.demo.entity.order.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}