/**
 * 
 */
package com.business.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.business.demo.entity.customer.Customer;

/**
 * @author Utilisateur
 *
 */
@Component
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
