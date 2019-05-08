/**
 * 
 */
package com.business.demo.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;

import com.business.demo.entity.order.CreditCard;
import com.business.demo.entity.order.Order;
import com.business.demo.repository.OrderRepository;
import com.business.demo.util.StringUtils;

/**
 * @author Utilisateur
 *
 */
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order findOrder(Long idOrder) {
		if(idOrder == null)
			throw new ValidationException(StringUtils.INVALID_ORDER_ID);
		return orderRepository.findById(idOrder).get();
	}

	@Override
	public void deleteOrder(Order order) {
		if(order == null)
			throw new ValidationException(StringUtils.ORDER_OBJECT_NULL);
		orderRepository.delete(order);
	}

	@Override
	public List<Order> findOrder() {
		return orderRepository.findAll();
	}

	@Override
	public void validateCreditCard(CreditCard creditCard) {
		if(creditCard == null)
			throw new ValidationException();
		
	}

	@Override
	public Order createOrder(Order order) {
		if(order == null)
			throw new ValidationException(StringUtils.ORDER_OBJECT_NULL);
		return orderRepository.save(order);
	}

}
