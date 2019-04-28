/**
 * 
 */
package com.business.demo.entity.category;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.ValidationException;

import com.business.demo.util.StringUtils;

import lombok.Data;

/**
 * @author joel ilunga
 *
 */

@Data
@Entity
@SuppressWarnings("serial")
@Table(name="t_category")
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=30)
	private String name;
	
	@Column(nullable=false)
	private String description;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	@OrderBy("name ASC")
	private List<Product> products;
	
	@PrePersist
	@PreUpdate
	private void validateDate() {
		if(StringUtils.emptyOrNull(name))
			throw new ValidationException(StringUtils.INVALID_NAME);
		if(StringUtils.emptyOrNull(description))
			throw new ValidationException(StringUtils.INVALID_DESCRIPTION);
	}
	
}
