package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.demo.entity.category.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
