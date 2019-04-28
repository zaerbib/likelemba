package com.business.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.ValidationException;

import com.business.demo.util.StringUtils;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="t_address")
public class Address implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String street1;
	private String street2;
	
	@Column(nullable=false, length=100)
	private String city;
	private String state;
	
	@Column(nullable=false, length=10)
	private String zipcode;
	
	@Column(nullable=false, length=50)
	private String country;
	
	@PrePersist
	@PreUpdate
	public void validateData() {
		if(StringUtils.emptyOrNull(street1))
			throw new ValidationException(StringUtils.INVALID_STREET);
		if(StringUtils.emptyOrNull(city))
			throw new ValidationException(StringUtils.INVALID_CITY);
		if(StringUtils.emptyOrNull(zipcode))
			throw new ValidationException(StringUtils.INVALID_ZIPCODE);
		if(StringUtils.emptyOrNull(country))
			throw new ValidationException(StringUtils.INVALID_COUNRTY);
	}
}
