package com.wipro.hms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
     static Connection c=null;
	public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    c= DriverManager.getConnection("jdbc:mysql://localhost:3306/rental","root","root");
		return c;
	}

}

