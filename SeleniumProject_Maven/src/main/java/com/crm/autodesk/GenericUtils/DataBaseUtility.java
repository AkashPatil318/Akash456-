package com.crm.autodesk.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	Connection con = null;
	ResultSet result=null;
	Driver driverRef;
	/**
	 * 
	 * @throws Throwable
	 */
	
	public void connectTODatabase() throws Throwable {
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");
			
	}
    public void closeDb() throws Throwable {
    	con.close();
    }
    public String getDataFromDB(String query,int Columnindex) throws Throwable {
    	String value=null;
    	result=con.createStatement().executeQuery(query);
    	while(result.next()) {
    		value=result.getString(Columnindex);
    	}
		return value;
    	
    }
    public String getDataFromDB(String query,int columnName,String expData) throws SQLException {
    	boolean flag=false;
    	result=con.createStatement().executeQuery(query);
    while(result.next()) {
    	
    		if(result.getString(columnName).equalsIgnoreCase(expData)) {
    			flag=true;
    			break;
    		}
    		
    	}
    	if(flag)
    	{
    		System.out.println(expData +"data verified in database");
    		return expData;
    	}
    	else
    	{
    		System.out.println(expData + "data not verified");
    		return expData;
    	}
    }
	private void While(boolean next) {
		// TODO Auto-generated method stub
		
	}
}
