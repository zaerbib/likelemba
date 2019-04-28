package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.demo.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
