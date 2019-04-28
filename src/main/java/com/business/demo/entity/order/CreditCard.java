/**
 * 
 */
package com.business.demo.entity.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.ValidationException;

import com.business.demo.util.StringUtils;

import lombok.Data;

/**
 * @author Utilisateur
 *
 */

@Embeddable
@SuppressWarnings("serial")
@Data
public class CreditCard implements Serializable {
	
	@Column(name="credit_card_number", length=30)
	private String creditCardNumber; 
	
	@Column(name="credit_card_type")
	private String creditCardType;
	
	@Column(name="card_card_expery_date", length=5)
	private String creditCardExpdate;
	
	@PrePersist
	@PreUpdate
	private void validateDate() {
		if(StringUtils.emptyOrNull(creditCardNumber))
			throw new ValidationException(StringUtils.INVALID_NUMBER);
		if(StringUtils.emptyOrNull(creditCardType))
			throw new ValidationException(StringUtils.INVALID_TYPE);
		if(StringUtils.emptyOrNull(creditCardExpdate))
			throw new ValidationException(StringUtils.INVALID_EXP_DATE);
	}
}
