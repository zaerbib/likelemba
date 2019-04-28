package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.business.demo.entity.order.OrderLine;

@Component
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
