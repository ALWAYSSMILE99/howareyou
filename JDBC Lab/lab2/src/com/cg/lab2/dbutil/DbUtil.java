package com.cg.lab2.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static Connection connect;
	public static Connection getConnection() throws SQLException
	{
		/*try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		try {
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
		}
		catch(SQLException e)
		{
			throw e;
		}
		return connect;
		
	}

}
