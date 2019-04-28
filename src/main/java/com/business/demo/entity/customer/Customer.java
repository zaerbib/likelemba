/**
 * 
 */
package com.business.demo.entity.customer;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.ValidationException;

import com.business.demo.entity.Address;
import com.business.demo.entity.User;
import com.business.demo.util.StringUtils;

import lombok.Data;

/**
 * @author Utilisateur
 *
 */
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="t_customer")
@PrimaryKeyJoinColumn(name="user_id")
public class Customer extends User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=30)
	private String firstname;
	
	@Column(nullable=false, length=30)
	private String lastname;
	private String telephone;
	private String email;
	
	@Column(nullable=false, name="date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="address_fk", nullable=true)
	public Address homeAdress;
	
	@Transient
	private Integer age;
	
	@PrePersist
	@PreUpdate
	private void validateData() {
		if(StringUtils.emptyOrNull(firstname))
			throw new ValidationException(StringUtils.INVALID_FIRSTNAME);
		if(StringUtils.emptyOrNull(lastname))
			throw new ValidationException(StringUtils.INVALID_LASTNAME);
		
	}
	
	@PostLoad
	@PostPersist
	@PostUpdate
	public void calculateAge() {
		if(dateOfBirth == null) {
			this.age = null;
			return;
		}
		
		Calendar birth = new GregorianCalendar();
		birth.setTime(dateOfBirth);
		Calendar now = new GregorianCalendar();
		now.setTime(new Date(System.currentTimeMillis()));
		
		int adjust = 0;
		
		if(now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0)
			adjust = - 1;
		
		age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
	}
	
	/**
	 * 
	 * @param password
	 */
	public void matchPassword(String password) {
		if(StringUtils.emptyOrNull(password))
			throw new ValidationException(StringUtils.INVALID_PASSWORD);
		if(!password.equals(this.getPassword()))
			throw new ValidationException(StringUtils.PASSWORD_DNT_MATCH);
	}
}
