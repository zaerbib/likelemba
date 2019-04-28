/**
 * 
 */
package com.business.demo.entity.order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.business.demo.entity.Address;
import com.business.demo.entity.customer.Customer;

import lombok.Data;

/**
 * @author Utilisateur
 *
 */

@Data
@Entity
@Table(name="t_order")
@SuppressWarnings("serial")
public class Order implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="order_date", updatable=false)
	@Temporal(TemporalType.TIME)
	private Date orderDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customer_fk", nullable=false)
	private Customer customer;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="delivery_fk", nullable=false)
	private Address deliveryAddress;
	
	@Embedded
	private CreditCard creditCard = new CreditCard();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="t_order_order_line",
				joinColumns= {@JoinColumn(name="order_fk")},
				inverseJoinColumns= {@JoinColumn(name="order_line_fk")})
	private List<OrderLine> orderLines;
	
	@PrePersist
	public void setDefaultData() {
		orderDate = new Date();
	}
	
	public Float getTotal() {
		if(orderLines == null || orderLines.isEmpty())
			return 0f;
		
		Float total = 0f;
		for(OrderLine orderLine : orderLines) {
			total += (orderLine.getSubTotal());
		}
		
		return total;
	}
}
