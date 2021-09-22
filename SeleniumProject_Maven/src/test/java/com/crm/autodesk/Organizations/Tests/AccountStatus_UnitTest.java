package com.crm.autodesk.Organizations.Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class AccountStatus_UnitTest {
	@Test
	public void testAccountType() throws SQLException {
		Connection con = null;
		try {
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");
		// Create SQL Statement
		 Statement stat= con.createStatement();
			
			String query = "select * from account";
			
			// execute statement/Query
			ResultSet result=stat.executeQuery(query);
			
			while(result.next()) {
				int acctNum = result.getInt("accno");
				System.out.println(acctNum);
				if(acctNum == 123 && result.getString("accountType").equals("gold")) {
					System.out.println("account type Gold & verified==PASS");
					break;
				}
			}
					
	}catch (Exception e) {
		System.err.println("account type is not gold ==FAIL");
	}finally {
		// step 5: close the connection
		con.close();
	}
	}
		
	}
	


