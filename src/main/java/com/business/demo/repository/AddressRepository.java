package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.business.demo.entity.Address;

@Component
public interface AddressRepository extends JpaRepository<Address, Long> {

}
