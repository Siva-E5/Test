package com.element5.DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeDataBase {

        
    private static final String url = "jdbc:mysql://localhost:3306/sys";
    private static final String userName = "root";
    private static final String password = "4455";

    private EmployeeDataBase() {

    }

    public static EmployeeDataBase getInstance() {
        if(null == EmployeeDataBase) {
            EmployeeDataBase = new EmployeeDataBase();
        }
        return EmployeeDataBase;
    }

    public static Connection getConnection()  {
        try {

            Class.forName( "com.mysql.cj.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(url, userName, password);
         System.out.println("connection successfully;" + connection);
	} catch(ClassNotFoundException e) {
              System.out.println(e);
        } catch(SQLException e) {
              System.out.println(e);   
        }
   	    
	 return connection;
    }

}                                                                                                                                                                                                                          