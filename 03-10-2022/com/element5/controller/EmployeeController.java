/*
 * Microsoft Windows [Version 10.0.19042.1889]
 *(c) Microsoft Corporation. All rights reserved.
 *
 */
package com.element5.controller;

import java.io.BufferedWriter;
import java.time.format.DateTimeParseException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import com.element5.model.Employee;
import com.element5.service.EmployeeService;
import com.element5.service.EmployeeServiceImpl.EmployeeServiceImpl;
import com.element5.util.UtilValidation;

/**
 * <h2>EmployeeController</h2>
 * <p>
 * Getting Employee details. And also getting Employee details to create the
 * record. And also update Employee details. And also remove the data based
 * through the id.
 * </p>
 *
 * @author Sivaramakrishnan
 */
public class EmployeeController {

    Scanner scanner = new Scanner(System.in);

    EmployeeService employeeService = new EmployeeServiceImpl();

    private int employeeCount = 100;
    private int choice;
    private String id;
    private String designation;

    /**
     * <p>
     * This method contains like add, delete, update, and read methods This is
     * available which is want to user
     * <p>
     *
     */
    public void employeeMenuView() {
        do {
	    StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append("\n 1.add Employee       : ")
		         .append("\n 2.search Employee    : ")
		         .append("\n 3.displayAll         : ")
		         .append("\n 4.displayEmployee    : ")
		         .append("\n 5.Update Employee    : ")
		         .append("\n 6.Delete Employee    : ")
		         .append("\n 7.FileReadAndWrite")
		         .append("\n 8.Exit Menu          : ");
	    System.out.println(stringBuilder);

            getUserChoice();
            switch (choice) {
                case 1:
                    createEmployee();
	            break;

	        case 2:
	            Employee();
	            break;

	        case 3:
	            displayAll();
	  	    break;

 	        case 4:
	            displayEmployee();
                    break;

                case 5:
	            updateEmployee();
	            break;

	        case 6:
	            deleteEmployee();
		    break;

	        case 7:
	            EmployeeController();
		       break;
		       
	        case 8:
	            System.out.println("Thank you");
                    break;

	        default:
	            System.out.println("Invalid option!");
	        }   
        } while (choice != 8);
    }

    /**
     * This method used to get the choice from ther valid user. 
     *
     */
    private void getUserChoice() {
        boolean ischoice = true;
        while (ischoice) {
            try {
	        choice = Integer.parseInt(scanner.nextLine());
	        ischoice = false;
            } catch (NumberFormatException e) {
                  System.out.println("invalid input");
            }
         }

    }

    /**
     * <p>
     * This method used to create the employee details like employee id, name,
     * email, salary, address, designation, dateOfBirth, mobileNo
     * </p>
     *
     */
    public void createEmployee() {
	System.out.println("Enter the number of employees you want to create");
        int numberOfEmployees = 0;
	try {
	    numberOfEmployees = Integer.parseInt(scanner.nextLine());
	} catch (NumberFormatException e) {
	      System.out.println("invalid input");
	}	
        for (int i = 0; i < numberOfEmployees; i++) {
	    Employee employee = new Employee();
	    String id = "E" + employeeCount++;
	    employee.setId(id);
	    employee.setMobileNo(getMobileNo());
	    employee.setName(getName());
	    employee.setSalary(getSalary());
	    System.out.println("Enter the Designation of the Employee " + " : ");
	    employee.setDesignation(getDesignation());
	    LocalDate dateOfBirth = getDob();
            LocalDate currentDate = LocalDate.now();
	    int age = currentDate.compareTo(dateOfBirth);
	    employee.setDob(dateOfBirth);
	    System.out.println(age);
	    employee.setEmail(getEmail());
	    if (employeeService.addEmployees(employee)) {
	        System.out.println("Employee added Successfully");
	        System.out.println("your employee id is this" + id);
	    } else {
		  System.out.println("Employee already added");
	    }
	}
    }

    /**
     * <p>
     * This method used to get the employeename for create purpose valid name it
     * accept, otherwise it will ask again to give valid input
     * </p>
     *
     */
    public String getName() {
	String name;
        boolean isValidName = false;
	    do {
		System.out.println("enter the employee name");
		name = scanner.nextLine();
		isValidName = !(UtilValidation.isValidUserName(name));
		if (isValidName) {
	   	    System.out.println("Invalid name");
		}

		} while (isValidName);

		return name;
	}

    /**
     * <p>
     * This method used to get the employee email for create purpose. valid email it
     * accept, otherwise it will ask again to give valid input
     * </p>
     *
     */
    public String getEmail() {
        String email;
   	boolean isValidEmail = false;
	    do {
		System.out.println("enter the employee email");
		email = scanner.nextLine();
		isValidEmail = !(UtilValidation.isValidateEmail(email));
		if (isValidEmail) {
	 	    System.out.println("Invalid email");
		}

		} while (isValidEmail);
        return email;
    }

    /**
     * <p>
     * This method used to get the employeemobileNo for create purpose. user give
     * valid mobile number it accept, otherwise it will ask again to give valid
     * input
     * </p>
     *
     */
    private long getMobileNo() {
	String inputMobileNo;
	long mobileNo;
	boolean isValidMobileNo = false;
	do {
	    System.out.println("enter the employee mobileNo");
   	    inputMobileNo = scanner.nextLine();
	    isValidMobileNo = !(UtilValidation.isValidMobileNumber(inputMobileNo));
	    if (isValidMobileNo) {
		System.out.println(" Invalid mobileNo");
	    }
       
         mobileNo = Long.parseLong(inputMobileNo);
	} while (isValidMobileNo);
		return mobileNo;
    }

    /**
     * <p>
     * This method used to get the employee salary from scanner for create purpose.
     * user give valid salary it accept otherwise, it will again ask to give salary
     * input
     * </p>
     *
     */
    public double getSalary() {
	String inputSalary;
        double salary;
        boolean isValidSalary = false;
	    do {
		System.out.println("enter the salary");
		inputSalary = scanner.nextLine();
		isValidSalary = !(UtilValidation.isValidateSalary(inputSalary));
		if (isValidSalary) {
		    System.out.println("Invalid salary");
		}
		} while (isValidSalary);
            salary = Double.parseDouble(inputSalary);
	    return salary;
	}

    /**
     * <p>
     * This method used to get the employee Id from scanner for search purpose. user
     * give valid Id it accept otherwise, it will again ask to give Id input
     * </p>
     *
     */
    public String getId() {
	String id;
        boolean isValidId = false;
	    do {
		System.out.println("enter the Id");
		id = scanner.nextLine();
		isValidId = !(UtilValidation.isValidId(id));
		if (isValidId) {
		    System.out.println(" Invalid Id");
			}
		} while (isValidId);
	    return id;
	}

    /**
     * <p>
     * This method used to get the dateofbirth from scannar for create purpose user
     * give valid dateofbirth it accept otherwise, it will again ask to give
     * dateofbirth input
     * </p>
     *
     */
    public LocalDate getDob() {
	    String inputDob = "";
	    boolean isValidDateOfBirth = false;
	    do {
		System.out.println("enter employee DateofBirth ex: yyyy-MM-dd");
		try {
	 	    inputDob = scanner.nextLine();
		    isValidDateOfBirth = !(UtilValidation.isValidDateOfBirth(inputDob));
		} catch (DateTimeParseException e) {
		      System.out.println(e);
		}
		if (isValidDateOfBirth) {
		    System.out.println("Invalid dateofbirth");
		}
		} while (isValidDateOfBirth);
	    LocalDate dateOfBirth = LocalDate.parse(inputDob);
	    return dateOfBirth;
	}

    /**
     * <p>
     * This method used to get all employee details.
     * </p>
     *
     */
    public void displayAll() {
        if (employeeService.getAllDetail().isEmpty()) {
		System.out.print("Employee ID not exist ");
	} else {
	      for (Map.Entry map : employeeService.getAllDetail().entrySet()) {
		  System.out.println(map.getKey() + "\n" + map.getValue());
	       }
	   }
	}

    /**
     * <p>
     * This method used to get the particular employee details through Mobile
     * number.
     * </p>
     *
     */
    public void searchMobileNo() {
	long mobileNo = getMobileNo();
        Employee mobileNumber = employeeService.checkMobileNo(mobileNo);
	if (null == mobileNumber) {
	    System.out.println("no details");
	} else {
	        System.out.println(mobileNumber.toString());
        }
    }

    /** 
     * <p>
     * This method used to get the particular employee details through Name
     * number.
     * </p>
     *
     */
    public void searchName() {
        String name = getName();
        Employee empName = employeeService.checkName(name);
        System.out.println(empName);
        if (null == empName) {
	    System.out.println("no details");
	} else {
	      System.out.println(empName.toString());
	}
    }

    /** 
     * <p>
     * This method used to get the particular employee details through Name
     * number.
     * </p>
     *
     */
    public void searchEmail() {
        String email = getEmail();
        Employee empEmail = employeeService.checkEmail(email);
        if (null == empEmail) {
	    System.out.println("no details");
	} else {
	      System.out.println(empEmail.toString());
	}
    }

    /** 
     * <p>
     * This method used to get the particular employee details through salary
     * number.
     * </p>
     *
     */
     public void searchSalary() {
	 double salary = getSalary();
         Employee empSalary = employeeService.checkSalary(salary);
         if (null == empSalary) {
	     System.out.println("no details");
	 } else {
	       System.out.println(empSalary.toString());
	 }
    }

    /** 
     * <p>
     * This method used to get the particular employee details through Dob
     * number.
     * </p>
     *
     */
    private void searchDob() {
        LocalDate dob = getDob();
         Employee empDob = employeeService.checkDob(dob);
        if (null == empDob) {
            System.out.println("no details");
        } else {
              System.out.println(empDob.toString());
        }
    }

    /** 
     * <p>
     * This method used to get the particular employee details through salary
     * number.
     * </p>
     *
     */
    private void searchDesignation() {
	String designation = getDesignation();
	Employee empDesignation = employeeService.checkDesignation(designation);
	if (null == empDesignation) {
	    System.out.println("no details");
	} else {
	      System.out.println(empDesignation.toString());
	}
    }

    private void Employee() {
	boolean isSearch = true;
	while (isSearch) {
	    StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append("\n 1.searchName             : ")
                         .append("\n 2.searchDesignation      : ")
		  	 .append("\n 3.searchSalary           : ")
                         .append("\n 4.searchMobileNo         : ")
			 .append("\n 5.searchEmail            : ")
                         .append("\n 6.searchDob              : ")
			 .append("\n 7.Exit Menu              : ");
	    System.out.println(stringBuilder);
	    System.out.println("enter your choice");
	    try {
		choice = Integer.parseInt(scanner.nextLine());
     	    } catch (NumberFormatException e) {
	 	  System.out.println(e);
	    }
	    switch (choice) {
		case 1:
 		    searchName();
		    break;

	        case 2:
		    searchDesignation();
		    break;

		case 3:
		    searchSalary();
		    break;

	        case 4:
		    searchMobileNo();
		    break;

                case 5:
		    searchEmail();
	   	    break;

		case 6:
		    searchDob();
 		    break;

		case 7:
		    break;

		default:
		    System.out.println("Invalid option!");

		}

		}
		while (choice != 7);
	}


    private void getEmployeeDesignation() {
	List<Employee> detail;
	detail = employeeService.displayByDesignation(designation);
	if (0 == detail.size()) {
	    System.out.println("no record found");
	} else {
	      for (Employee designation : detail) {
		  System.out.println(designation);
	       }
        }
    }
	

    /**
     * <p>
     * This method used to display the employee details by employeeId or
     * employeeDesignation
     * </p>
     *
     */
    private void displayEmployee() {
	System.out.println("Enter the option you want to \n1. get Employee details by id\n"
			    + "2.get Employee details by designation\n");
	try {
	    choice = Integer.parseInt(scanner.nextLine());
	} catch (NumberFormatException e) {
	      System.out.println("invalid input");
	}
	switch (choice) {
	    case 1:
		id = getId();
		System.out.println(employeeService.displayByID(id));
		break;

 	    case 2:
		do {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n 1.HR                  : ")
		 	     .append("\n 2.ADMIN               : ")
			     .append("\n 3.SOFTWARE DEVELOPER  : ")
			     .append("\n 4.SOFTWARE TESTING    : ")
			     .append("\n 5.SUPPORT TEAM        : ")
			     .append("\n 6.Exit Menu           : ");
		System.out.println(stringBuilder);
		List<Employee> detail;
		System.out.println("enter your choice");
		try {
		     choice = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
		      System.out.println("invalid input");
		}
		switch (choice) {
		case 1:
		    designation = "HR";
		    getEmployeeDesignation();
		    break;

		case 2:
		    designation = "ADMIN";
		    getEmployeeDesignation();
		    break;

		case 3:
		    designation = "SOFTWARE DEVELOPER";
		    getEmployeeDesignation();
		    break;

	       case 4:
	           designation = "SOFTWARE TESTING";
		   getEmployeeDesignation();
		   break;

	       case 5:
	 	   designation = "SUPPORT TEAM";
	 	   getEmployeeDesignation();
	 	   break;

	       case 6:
		   break;

	       default:
                   System.out.println("Invalid input");

	  }
	  } while (choice != 6);
              }
    }

    /**
     * <p>
     * This method used to get the employee details through Designation.
     * </p>
     *
     */
    private String getDesignation() {
	boolean isDesignation = true;
	while (isDesignation) {
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append("\n 1.HR                  : ")
		     .append("\n 2.ADMIN               : ")
	 	     .append("\n 3.SOFTWARE DEVELOPER  : ")
		     .append("\n 4.SOFTWARE TESTING    : ")
		     .append("\n 5.SUPPORT TEAM        : ")
		     .append("\n 6.Exit Menu           : ");
	System.out.println(stringBuilder);
	System.out.println("enter your choice");
	try {
	    choice = Integer.parseInt(scanner.nextLine());
	} catch (NumberFormatException e) {
	      System.out.println(e);
	}
	switch (choice) {
	    case 1:
		designation = "HR";
		isDesignation = false;
		break;

	    case 2:
		designation = "ADMIN";
		isDesignation = false;
		break;

	    case 3:
		designation = "SOFTWARE DEVELOPER";
		isDesignation = false;
		break;

	    case 4:
		designation = "SOFTWARE TESTING";
		isDesignation = false;
		break;

	    case 5:   
		designation = "SUPPORT TEAM";
		isDesignation = false;
		break;

	    case 6:
		System.out.println("Thank you for valuable time");
		break;

	    default:
		System.out.println("Invalid input");

	     }
		}
	return designation;
	}

	/**
	 * <p>
	 * This method used to update the employee detail like name designation, salary.
	 * </p>
	 *
	 */
    private void updateEmployee() {
	System.out.println("Enter the id of the employee to update details");
	id = getId();
	System.out.println(employeeService.displayByID(id));
	if (employeeService.isupdate(id)) {
	    StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append("\n 1.Name                 : ")
		 	 .append("\n 2.Designation          : ")
			 .append("\n 3.Salary               : ")
			 .append("\n 4.MobileNo             : ")
			 .append("\n 5.Dob                  : ")
			 .append("\n 6.Email                : ")
			 .append("\n 7.Exit                 : ");
	 System.out.println(stringBuilder);
	 int updateOption = Integer.parseInt(scanner.nextLine());
	 switch (updateOption) {
	     case 1:
		 if (employeeService.isUpdateName(id, getName())) {
		     System.out.println("Name is updated");
		 }
	         break;

	    case 2:
		System.out.println("Enter designation to update");
		designation = scanner.nextLine().toUpperCase();
		if (employeeService.isUpdateDesignation(id, designation)) {
		    System.out.println("Designation is updated");
		}
	        break;

	    case 3:
		if (employeeService.isUpdateSalary(id, getSalary())) {
		    System.out.println("Salary is updated");
		}
	        break;

	    case 4:
		if (employeeService.isUpdateMobileNo(id, getMobileNo())) {
		    System.out.println("mobileNo is updated");
		}
		break;

	    case 5:
		if (employeeService.isUpdateEmail(id, getEmail())) {
		    System.out.println("email is updated");
		}
		break;

	    case 6:
		if (employeeService.isUpdateDob(id, getDob())) {
		    System.out.println("dob is updated");
		}
		break;

	    default:
		System.out.println("Invalid input");
		break;
	    }
	} else {
	      System.out.println("invalid id");
	}
    }

    /**
      * <p>
     * This method used to delete the employee details by employee id
     * </p>
     *
     */
    private void deleteEmployee() {
	System.out.println("Enter id you want to Delete");
	id = getId();
	if (employeeService.delete(id)) {
	    System.out.println("Employee deleted Successful..");
	} else {
	      System.out.println("Record not found");
	}

    }

//    private List<Employee> getEmployeeByCsv() throws IOException, IOException {
//        String str = "";
//	File file = new File("EmployeeFile.txt");
//	Scanner scanner = new Scanner(file);
//	while (scanner.hasNext()) {
//	    String[] employeeList = scanner.nextLine().split(",");
//	    System.out.println(employeeList[0]);
//	}
//	System.out.println(str);
//	FileWriter fileWriter = new FileWriter("EmployeeNewFile.txt");
//	BufferedWriter bw = new BufferedWriter(fileWriter);
//
//	bw.write("welcome siva");
//	bw.close();
//	return null//
//	}
    
    void EmployeeController() {

		try {	     
                        FileReader fr= new FileReader("Details.txt");
			FileWriter fw = new FileWriter("DetailsNew.txt");
			String str = "";
			int i;
			while ((i = fr.read()) != -1) {
				str += (char)i;
			}
			System.out.println(str);			
			fw.write(str);
			fr.close();
			fw.close();

			// Display message
			System.out.println(
				"File reading and writing both done");
		}

		// Catch block to handle the exception
		catch (IOException e) {
			System.out.println(
				"There are some IOException");
		}
	}




}