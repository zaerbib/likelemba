/**
 * 
 */
package com.business.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.business.demo.entity.Address;
import com.business.demo.entity.customer.Customer;

/**
 * @author Utilisateur
 *
 */
@Service
public interface CustomerService {
	public Customer createCustomer(Customer customer, Address address);
	public Customer findCustomer(Long idCustomer);
	public Customer updateCustomer(Customer customer, Address address);
	public void deleteCustomer(Customer customer);
	public List<Customer> findCustomer();
}
 