/**
 * 
 */
package com.business.demo.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;

import com.business.demo.entity.Address;
import com.business.demo.entity.customer.Customer;
import com.business.demo.repository.CustomerRepository;
import com.business.demo.util.StringUtils;

/**
 * @author Utilisateur
 *
 */
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer, Address address) {
		if(customer == null) {
			throw new ValidationException(StringUtils.CUSTOMER_OBJECT_NULL);
		}
		
		customer.setHomeAdress(address);
		return customerRepository.saveAndFlush(customer);
	}

	@Override
	public Customer findCustomer(Long idCustomer) {
		if(idCustomer == null)
			throw new ValidationException(StringUtils.INVALID_CUSTOMER_ID);
		
		return customerRepository.findById(idCustomer).get();
	}
	
	@Override
	public void deleteCustomer(Customer customer) {
		if(customer == null)
			throw new ValidationException(StringUtils.CUSTOMER_OBJECT_NULL);
		customerRepository.delete(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, Address address) {
		if(customer == null)
			throw new ValidationException(StringUtils.CUSTOMER_OBJECT_NULL);
		customer.setHomeAdress(address);
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findCustomer() {
		return customerRepository.findAll();
	}
}
