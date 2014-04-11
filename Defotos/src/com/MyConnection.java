package com;

import java.sql.*;

public class MyConnection {
	Connection con = null;

	public Connection getConnection() {
		try {  Class.forName("oracle.jdbc.driver.OracleDriver");
			    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Defotos", "Defotos");
		    }
		catch (Exception e) 
			{
				e.printStackTrace();
	        }
		return con;
	}
}
