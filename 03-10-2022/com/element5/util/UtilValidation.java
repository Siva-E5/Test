package com.element5.util;

import java.util.regex.Pattern;


/**
 * This class main purpose is validate email,name, mobile No
 * dateofBirth, 
 * @version    java "18.0.2.1".
 * @author     Sivaramakrishnan
 */
public class UtilValidation {
	
	/**
	 * This method used validate the mobileNumber
	 * 
	 * @param mobileNo
	 * @return boolean
	 */
    public static boolean isValidMobileNumber (String mobileNo){
        return (Pattern.matches("^[7-9][0-9]{9}$", mobileNo));
    }

	/**
	 * This method used validate the id
	 * 
	 * @param  id
	 * @return boolean
	 */
    public static boolean isValidId (String id){
        return (Pattern.matches("^[E][1][0-2][0-9]$", id));
    }

	/**
	 * This method used validate the name
	 * 
	 * @param name
	 * @return boolean
	 */
    public static boolean isValidUserName (String name){
        return (Pattern.matches("^[a-zA-Z]{1,20}[ ]?([a-zA-Z]{2,20})?$", name));
    }
    
	/**
	 * This method used validate the salary
	 * 
	 * @param salary
	 * @return boolean
	 */
    public static boolean isValidateSalary (String salary){
        return (Pattern.matches("^[1-9][0-9]{4,10}([.][0-9]{2})?$", salary));
    }

	/**
	 * This method used validate the email
	 * 
	 * @param email
	 * @return boolean
	 */
    public static boolean isValidateEmail (String email){
        return (Pattern.matches("^[a-zA-Z]{1,20}[.]?([0-9]{1,10})?[.]?([a-zA-Z]{1,20})?[.]?([0-9]{1,10})?[@]{1}([gmail]{5}[.]{1}[com]{3})?([a-zA-Z]{1,20})?([0-9]{1,10})?[.]?([a-zA-Z]{1,20})?([0-9]{1,10})?([gmail]{5})?[.]?([com]{3})?$", email));
    }

	/**
	 * This method used validate the mobileNumber
	 * 
	 * @param mobileNo
	 * @return boolean
	 */
    public static boolean isValidDateOfBirth (String dateOfBirth){
        return (Pattern.matches("^(([1][9][789][0-9])[-](1[0-2]|0[1-9])[-](3[01]|[12][0-9]|0[1-9]))|(([2][0][01][0-9]|[2][0][2][0-2])[-](1[0-2]|0[1-9])[-](3[01]|[12][0-9]|0[1-9]))$", dateOfBirth));
    }
}


