package com.element5.service.EmployeeServiceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.element5.model.Employee;
import com.element5.dao.EmployeeDao;
import com.element5.service.EmployeeService;

/**
 * <EmployeeController> Getting Employee details.
 * And also getting Employee details to create the record.
 * And also update Employee details.
 * And also remove the data based through the id.
 *
 * @version    java "18.0.2.1".
 * @author     Sivaramakrishnan
 */

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao employeeDao = new EmployeeDao();

	/**
	 * <p>This method is to pass the employee object from employee service 
	 * to EmployeeDao class for create purpose</p>
	 *  
	 * @param employee
	 * @return boolean
	 */
    public boolean addEmployees(Employee employee) {
        return employeeDao.addEmployees(employee);
    }

    
  /**
   * <p>This method is to pass employee id from employee Service
   * to EmployeeDao for display purpose.</p>  
   * 
   * @param id
   * @return boolean
   */
   public String displayByID(String id) {
       return employeeDao.displayByID(id);
    }
   
//   public String displayAll(String id) {
//       return employeeDao.displayByID(id);
//    }
//   

   /**
    * <p>This method used to display the employee details by employee
    *  Designation.</p>
    *   
    * @param designation
    * @return List<String>
    */
    public List<Employee> displayByDesignation(String designation){
        return employeeDao.displayByDesignation(designation);
    }
    
    /**
     * <p>This method used to display All employee details.
     * </p>
     *   
     * @param
     * @return List<String>
     */
    public Map<String, Employee> getAllDetail(){
		return  employeeDao.getAllDetails();
    	
    }
    
    /**
     * <p>This method used to display the employee details through employee
     *  mobileNo.</p>
     *   
     * @param mobileNo
     * @return Employee
     */
    public Employee checkMobileNo(long mobileNo){
    	System.out.println(mobileNo);
    	return employeeDao.isCheckMobileNumber(mobileNo);
    }
    
    public Employee checkName(String name){
    	System.out.println(name);
    	return employeeDao.isCheckName(name);
    }
    
    public Employee checkDesignation(String designation){
    	return employeeDao.isCheckDesignation(designation);
    }
    
    
    public Employee checkSalary(double salary){
    	return employeeDao.isCheckSalary(salary);
    }
    
    public Employee checkEmail(String email){
    	return employeeDao.isCheckEmail(email);
    }
    
    public Employee checkDob(LocalDate dob){
    	return employeeDao.isCheckDob(dob);
    }

   /**
    * <p>
    * This method used to update employee details through employeeid.
    * </p>
    * 
    * @param id
    * @return 
    */
    public  boolean isupdate(String id) {
        return employeeDao.isupdate(id);
    }

   /**
    * <p>
    * This method used to update the employee name.
    * </p>
    * 
    * @param  id
    * @param name
    * @return boolean
    */
    public boolean isUpdateName(String id, String name) {
        return employeeDao.isUpdateName(id, name);
    }

   /**
    * This method used to update the employee Designation.
    * 
    * 
    */
    public boolean isUpdateDesignation(String id, String designation) {
        return employeeDao.isUpdateDesignation(id, designation);
    }

    public boolean isUpdateSalary(String id, double salary) {
        return employeeDao.isUpdateSalary(id, salary);
    }
    
    public boolean isUpdateMobileNo(String id, long mobileNo) {
        return employeeDao.isUpdateMobileNo(id, mobileNo);
    }
    
    public boolean isUpdateEmail(String id, String email) {
        return employeeDao.isupdateEmail(id, email);
    }
    
    public boolean isUpdateDob(String id, LocalDate dob) {
        return employeeDao.isupdateDob(id, dob);
    }

    public boolean delete(String id) {
        return employeeDao.isdelete(id);
    }

}
