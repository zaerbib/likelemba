/**
 * 
 */
package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.demo.entity.customer.Customer;

/**
 * @author Utilisateur
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
