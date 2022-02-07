package com.crm.SDET26.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class SampleJDBCExecuteQuery {
	@Test
	public void SampleJDBCExecuteQuery() throws SQLException {
		
		//step1 register to database
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2 get connection from database-provide db name
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet26", "root", "root");
		
		//step 3 issue create statement 
		
		Statement stat = con.createStatement();
		
		//step 4 execute a query - provide table name
		
		ResultSet result = stat.executeQuery("select * from empInfo;");
		
		while(result.next()) {
			System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3));
			
		}
		
		//step 5 : close the database
		
		con.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
