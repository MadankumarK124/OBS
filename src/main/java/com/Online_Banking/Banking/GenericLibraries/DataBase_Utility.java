package com.Online_Banking.Banking.GenericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysql.cj.jdbc.Driver;

public class DataBase_Utility {
	
	
	/**
	 * This method is used to register and get connection for the database
	 */

	Connection con = null;

	public void connctToDB() throws Throwable {

		Driver driver = new Driver();

		DriverManager.registerDriver(driver);

		con = DriverManager.getConnection(IPathConstant.dbURL, IPathConstant.dbUsername, IPathConstant.dbPassword);

	}

	/**
	 * This method is used to execute query and get the data for user
	 * 
	 * @param query
	 * @param ColumnIndex
	 * @param expdata
	 * @param data
	 * @return
	 * @throws Throwable
	 */

	public String executeQueryAndgetData(String query, int ColumnIndex, String expdata, String data) throws Throwable {

		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while (result.next()) {
			data = result.getString(ColumnIndex);
			if (data.equalsIgnoreCase(expdata)) {

				flag = true;
				break;
			}
		}
		if (flag) {

			System.out.println(data + "------->data verified");
			return expdata;
		}

		else {
			System.out.println(data + "------->data not verified");
			return "";
		}
	}
	/**
	 * This method is used to close the database
	 * @throws Throwable
	 */
	
    public void closeDatabase() throws Throwable
    {
    	con.close();
    }
	

}

	
		
	
	
	
	


