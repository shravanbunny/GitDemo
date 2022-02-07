package com.crm.SDET26.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteExceptionHandleThroughFinally {
	
	@Test
	public void SampleJDBCExecuteUpdate() throws SQLException {
		
		Connection con = null;
		
		try {
			
				Driver driverRef= new Driver();
				DriverManager.registerDriver(driverRef);
				
			Reporter.log("step 1 successfull" ,true);
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet26" , "root" , "root");
			Reporter.log("step 2 successful" , true);
			
			Statement stat = con.createStatement();
			Reporter.log("step 3 successful" , true);
			
			int result = stat.executeUpdate("insert into empIn values('Spiderman',2,'Bali');");
			Reporter.log("step 4 successful" , true);
			
			if(result==1) {
				Reporter.log("Created successfully" , true);
			}else {
				Reporter.log("Created not successfully" , true);
			}
			
		}catch(Exception e) {
			
		}finally {
			con.close();
			Reporter.log("step 5 successful" , true);
			
		}
	}

}
