package com.element5.model;

import java.time.LocalDate;
import java.util.List;

/**
 * <EmployeeController> Getting Employee details.
 * And also getting Employee details to create the record.
 * And also update Employee details.
 * And also remove the data based through the id.
 *
 * @version    java "18.0.2.1".
 * @author     Sivaramakrishnan
 */
public class Employee {
    private double salary;  
    private long mobileNo;
    private String designation;
    private String name;
    private String id;
    private LocalDate dob;
    private String email;
    //private String address;

    public Employee() {}

    public Employee(long mobileNo, String designation, String name, String id, double salary, LocalDate dob) {
        this.mobileNo = mobileNo;
        this.designation = designation;
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.dob = dob;   
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
             .append("\n EmployeeID        : ")
             .append(id)        
             .append("\n EmployeeName      : ")
             .append(name)     
             .append("\n Designation       : ")
             .append(designation)
             .append("\n Salary            : ")
             .append(salary)
             .append("\n EmployeeMobileNo  : ")
             .append(mobileNo)
             .append("\n EmployeeDob       : ")
             .append(dob)
             .append("\n EmployeeEmail     : ")
             .append(email);
        return stringBuilder.toString();
    }

}    

