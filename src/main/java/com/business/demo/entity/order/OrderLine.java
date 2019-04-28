/**
 * 
 */
package com.business.demo.entity.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.ValidationException;

import com.business.demo.entity.category.Item;
import com.business.demo.util.StringUtils;

import lombok.Data;

/**
 * @author Utilisateur
 *
 */
@Data
@Entity
@Table(name="t_order_line")
@SuppressWarnings("serial")
public class OrderLine implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private Integer quantity;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_fk", nullable=false)
	private Item item;
	
	@PrePersist
	@PreUpdate
	private void validateData() {
		if(quantity == null || quantity < 0)
			throw new ValidationException(StringUtils.INVALID_QUANTITY);
	}
	
	public Float getSubTotal() {
		return item.getUnitCost()*quantity;
	}
}
