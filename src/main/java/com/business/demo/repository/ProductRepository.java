package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.business.demo.entity.category.Product;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {

}
