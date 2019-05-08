/**
 * 
 */
package com.business.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.business.demo.entity.order.CreditCard;
import com.business.demo.entity.order.Order;

/**
 * @author Utilisateur
 *
 */

@Service
public interface OrderService {
	public Order findOrder(Long id);
	public void deleteOrder(Order order);
	public List<Order> findOrder();
	public void validateCreditCard(CreditCard creditCard);
	public Order createOrder(Order order);
}
