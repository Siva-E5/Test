package com.element5.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;

import com.element5.model.Employee;


/**
 * <Employeedao> Getting Employee details. And also getting Employee
 * details to create the record. And also update Employee details. And also
 * remove the data based through the id.
 *
 * @version java "18.0.2.1".
 * @author Sivaramakrishnan
 */
public class EmployeeDao {

	Map<String, Employee> map = new HashMap<>();
	
	/**
	 * <p>
	 * This method used to create the employee details.
	 * </p>
	 * 
	 * @param Employee employee 
	 * @return boolean
	 */
	public boolean addEmployees(Employee employee) {
           // PreparedStatement preparedStatement = null;
           // Connection connection = EmployeeDataBase.getConnection;
            //preparedstatement
	    map.put(employee.getId(), employee);
	    return true;
	}

    /**
     * This method used to display employee Id.
     * 
     * @param String id
     * @return boolean
     */
    public String displayByID(String id) {
        return map.get(id).toString();
    }
    
    /**
     * <p>
     * This method used to search particular employee mobileNo for get
     * employee details
     * </p>
     * @param long mobileNo
     * @return Employee
     */
   public Employee isCheckMobileNumber(long mobileNo){
	   Employee search = null;
	   for(Map.Entry<String,Employee> m : map.entrySet()) {
		   if(mobileNo == m.getValue().getMobileNo()) {
		     search = m.getValue();
		   }
	   }
       return search;
    	
    }
   
   /**
    * <p>

    * This method used to search particular employee name for get
    * employee details
    * </p>
    * 
    * @param Strong name
    * @return Employee
    */
   public Employee isCheckName(String name){
	   Employee search = null;
	   for(Map.Entry<String,Employee> m : map.entrySet()) {
		   if( m.getValue().getName() == name) {
			   System.out.println(m.getValue().getName());
		       search =  m.getValue();
		   }
	   }
	return search;
    	
    }
   
   /**
    * <p>
    * This method used to search employee designation for get
    * employees details
    * </p>
    * @param String designation
    * @param Strong mobileNo
 * @return 
 * @return 
    */
   public Employee isCheckDesignation(String designation){
	   Employee search = null;
	   for(Map.Entry<String,Employee> m : map.entrySet()) {
		   if( m.getValue().getName() == designation) {
			   System.out.println(m.getValue().getName());
		       search =  m.getValue();
		   }
	   }
	return search;
	
    	
    }
   
   /**
    * <p>
    * This method used to search particular employee salary for get
    * employee details
    * </p>
    * 
    * @param double salary
    * @return Employee
    */
   public Employee isCheckSalary(double salary){
	   Employee search = null;
	   for(Map.Entry<String,Employee> m : map.entrySet()) {
		   if(salary == m.getValue().getMobileNo()) {
		       search = m.getValue();
		   }
	   }
	return search;
    	
    }
   
   /**
    * <p>
    * This method used to search particular employee email for get
    * employee details
    * </p>
    * 
    * @param Strong mobileNo
    * @return Employee
    */
   public Employee isCheckEmail(String email){
	   Employee search = null;
	   for(Map.Entry<String,Employee> m : map.entrySet()) {
		   if(email == m.getValue().getEmail()) {
		       search = m.getValue();
		   }
	   }
	return search;
    	
    }
   
   /**
    * <p>
    * This method used to search particular employee dob for get
    * employee details
    * </p>
    * 
    * @param Strong mobileNo
    * @return Employee
    */
   public Employee isCheckDob(LocalDate dob){
	   Employee search = null;
	   for(Map.Entry<String,Employee> m : map.entrySet()) {
		   if(dob == m.getValue().getDob()) {
			   search = m.getValue();
		   }
	   }
	return search;
    	
    }
   
   /**
    * <p>
    * This method used to display employees details.
    * </p>
    * 
    * @param String designation
    */ 
    public Map<String, Employee>  getAllDetails() {
    	return map;
    }
    
    /**
     * <p>
     * This method used to display employee details via designation
     * </p>
     * 
     * @param String designation
     */
    public List<Employee> displayByDesignation(String designation) {
        List<Employee> employeeByDesignation = new ArrayList<>();
        for (Map.Entry<String, Employee> entry : map.entrySet()) {
            if (entry.getValue().getDesignation().equals(designation)) {
                employeeByDesignation.add(map.get(entry.getKey()));
            }
        }
        return employeeByDesignation;
    }
    
	/**
	 * This method used check id Existing or not
	 * 
	 * @param String id
	 * @return boolean
	 */
	public boolean isupdate(String id) {
		return map.containsKey(id);

	}

	/**
	 * This method used to update the name with the help of id
	 * 
	 * @param double salary
	 * @return boolean
	 */
	public boolean isUpdateName(String id, String name) {
		map.get(id).setName(name);
		return true;
	}

	/**
	 * This method used to update the designation with the help of id
	 * 
	 * @param String id
	 * @param String designation
	 * @return boolean
	 */
	public boolean isUpdateDesignation(String id, String designation) {
		map.get(id).setDesignation(designation);
		return true;
	}
	
	/**
	 * This method used to update the mobileNo with the help of id
	 * 
	 * @param String id
	 * @param double salary
	 * @return boolean
	 */
	public boolean isUpdateMobileNo(String id, long mobileNo) {
		map.get(id).setMobileNo(mobileNo);
		return true;
	}

	/**
	 * This method used to update the dob with the help of id
	 * 
	 * @param Strong id
	 * @param Localdate dob
	 * @return boolean
	 */
	public boolean isupdateDob(String id, LocalDate dob) {
		map.get(id).setDob(dob);
		return true;
	}

	/**
	 * This method used to update the email with the help of id
	 * 
	 * @param String id
	 * @param String email
	 * @return boolean
	 */
	public boolean isupdateEmail(String id, String email) {
		map.get(id).setEmail(email);
		return true;
	}
    
	/**
	 * This method used to update the salary with the help of id
	 * 
	 * @param String id
	 * @param double salary
	 * @return boolean
	 */
	public boolean isUpdateSalary(String id, double salary) {
		map.get(id).setSalary(salary);
		System.out.println(map
				);
		return true;
	}
	
    /**
     * This method used to delete employee details via id
     * 
     * @param id
     * @return boolean
     */
	public boolean isdelete(String id) {
		map.remove(id);
		return true;
	}
}
