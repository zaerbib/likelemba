/**
 * 
 */
package com.business.demo.entity.category;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.ValidationException;

import com.business.demo.util.StringUtils;

import lombok.Data;

/**
 * @author Utilisateur
 *
 */

@Data
@Entity
@Table(name="t_item")
@SuppressWarnings("serial")
public class Item implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=30)
	private String name;
	
	@Column(name="unit_cost", nullable=false)
	private Float unitCost;
	
	@Column(name="image_path")
	private String imagePath;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_fk", nullable=false)
	private Product product;
	
	@PrePersist
	@PreUpdate
	private void validateData() {
		if(StringUtils.emptyOrNull(name))
			throw new ValidationException(StringUtils.INVALID_NAME);
	}
}
