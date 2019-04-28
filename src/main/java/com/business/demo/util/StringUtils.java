/**
 * 
 */
package com.business.demo.util;

/**
 * @author Utilisateur
 *
 */
public class StringUtils {
	
	public static final String INVALID_NAME = "Invalid name";
	public static final String INVALID_DESCRIPTION = "Invalid description";
	public static final String INVALID_FIRSTNAME = "Invalid firstname";
	public static final String INVALID_LASTNAME = "Invalid lastname";
	public static final String INVALID_LOGIN = "Invalid login";
	public static final String INVALID_PASSWORD = "Invalid password";
	public static final String INVALID_STREET = "Invalid Street";
	public static final String INVALID_CITY = "Invalid City";
	public static final String INVALID_COUNRTY = "Invalid Country";
	public static final String INVALID_ZIPCODE = "Invalid Zipcode";
	public static final String PASSWORD_DNT_MATCH = "Password don't match";
	public static final String INVALID_QUANTITY = "Invalid quantity";
	public static final String INVALID_NUMBER = "Invalid number";
	public static final String INVALID_TYPE = "Invalid type";
	public static final String INVALID_EXP_DATE = "Invalid exp date";
	
	
	public static boolean emptyOrNull(String string) {
		return string == null || string.equals("");
	}
}
