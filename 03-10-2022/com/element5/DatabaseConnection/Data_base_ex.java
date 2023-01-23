package DBconnect;

import java.sql.*;



public class Data_base_ex {
//driver,url,user,password
	public static void main(String[] args) throws SQLException {

		String drivername = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sys";
		String userName = "root";
		String password = "4455";

		Connection con = DriverManager.getConnection(url, userName, password);
		System.out.println("connection successfully;" + con);

		//Statement st = con.createStatement();

		// st.execute("create database july");
		//System.out.println("database created");
      //  st.execute("use july");
		//st.execute("create table lolly(empname varchar(20),empid varchar(30))");
		System.out.println("table created");
		
		//st.execute("alter table lolly modify column empid int primary key");
		
		
		
		//st.execute("insert into lolly values('stell maria',5678)");

	
		
		/*ResultSet rs = st.executeQuery("Select * from lolly");
		while(rs.next()) {
			String data1= rs.getString("empname");
			String data2= rs.getString("empid");
			System.out.println(data1+"    "+data2);
		}*/
		
		// System.out.println(rs);

		// st.execute("insert into victoria values(26734534,5698,'mark',90000)");
//		while (rs.next()) {
//
//			String firstcol = rs.getString("emppassportno");
//			String secondcol = rs.getString("empid");
//			String thirdcol = rs.getString("ename");
//			String fourcol = rs.getString("empsalary");
//			System.out.println(firstcol + " " + secondcol + " " + thirdcol + " " + fourcol);
//		}
//		

	}

}
