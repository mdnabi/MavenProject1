package com.lti.DatabaseEntry;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class EmployeeDao {

	// TODO Auto-generated method stub

	public void insert(String empno, String empname, String salary) {
		Connection con = null;
		PreparedStatement ps = null; // pre compiled sql statement

		System.out.println(empno + empname + salary);
		try {
			//why not FileInputStream is=new FileInputStream("dev-db.properties") ??
			InputStream is=this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
			//the prop files will be loaded only once in the memory
			
			Properties dbProps=new Properties();         ///Extends hash table class It takes the form of key value pair
			
			dbProps.load(is);
					//loading properties from the properties class 
			String driverClassName= dbProps.getProperty("driverClassName");
			String url=dbProps.getProperty("url");
			String username=dbProps.getProperty("username");
			String password=dbProps.getProperty("password");
			
			Class.forName(driverClassName);

			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected....");

			ps = con.prepareStatement("insert into emp values(?,?,?)");
			ps.setString(1, empno);
			ps.setString(2, empname);
			ps.setString(3, salary);
			ps.executeUpdate();

			System.out.println("Data inserted");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {

				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
