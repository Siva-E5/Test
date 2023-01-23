package com.element5.service;

import com.element5.model.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
	
	/**
	 * <p>
	 * This method used to create the employee details.
	 * </p>
	 * @param employee
	 */
    boolean addEmployees(Employee employee);
    
    /**
     * This method used to display employee Id through id.
     * 
     * @return id
     */
    String displayByID(String id);

    /**
     * This method used to display employee displayByDesignation
     * 
     * @param designation
     */
    List<Employee> displayByDesignation(String designation);
    
    /**
     * This method used to getEmployees details.
     * 
     */
    Map<String, Employee> getAllDetail();
    
    /**
     * This method used to get employeeDetails through MobileNo
     * 
     * @param mobileNo
     */
    Employee checkMobileNo(long mobileNo);
    /**
     * This method used to get employeeDetails through name
     * 
     * @param name
     */
    Employee checkName(String name);
    
    /**
     * This method used to get employeeDetails through designation.
     * 
     * @param designation
     */
    Employee checkDesignation(String designation);
    
    /**
     * This method used to get employeeDetails through salary
     * 
     * @param salary
     */   
    Employee checkSalary(double salary);

    /**
     * This method used to get employeeDetails through email
     * 
     * @param email
     */
    Employee checkEmail(String email);
    
    /**
     * This method used to get employeeDetails through dateOfBirth;
     * 
     * @param dob
     */
    Employee checkDob(LocalDate dob);
    
     /**
      * This method used to update employee Id.
      * 
      * @param id
      */
     boolean isupdate(String id);
     
     /**
      * This method used to update employeeDetails by id.
      * 
      * @param id
      * @param name
      */
    boolean isUpdateName(String id, String name);

    /**
     * This method used to get employeeDetails through salary;
     * 
     * @param id
     * @param salary
     */
    boolean isUpdateSalary(String id, double salary);
  
    /**
     * This method used to get employeeDetails through mobileNo.
     * 
     * @param id
     * @param mobileNo
     */
    boolean isUpdateMobileNo(String id, long mobileNo);
    
    /**
     * This method used to get employeeDetails through designation;
     * 
     * @param id
     * @param designation
     */
    boolean isUpdateDob(String id, LocalDate dob);

    
    
    /**
     * This method used to delete employee details through id;
     * 
     * @param id
     * @param email
     */
    boolean delete(String id);
    /**
     * This method used to get employeeDetails through email;
     * 
     * @param id
     * @param email
     */
    boolean isUpdateEmail(String id, String email);

    /**
     * This method used to get employeeDetails through designation;
     * 
     * @param id
     * @param designation
     */
	boolean isUpdateDesignation(String id, String designation);
}
