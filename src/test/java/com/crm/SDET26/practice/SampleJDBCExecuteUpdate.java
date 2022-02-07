package com.crm.SDET26.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	@Test
	public void sampleJDBCExecuteUpdate() throws SQLException {
		
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		//get connection
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet26", "root", "root");
		
		Statement stat = con.createStatement();
		
		//execute query - 
		int result = stat.executeUpdate("insert into empInfo values('Spiderman',2,'Bali');");
		
		if(result==1) {
			Reporter.log("data created successfully" , true);
		}else {
			Reporter.log("data not created " , true);
		}
		con.close();
		
		
	}

}
