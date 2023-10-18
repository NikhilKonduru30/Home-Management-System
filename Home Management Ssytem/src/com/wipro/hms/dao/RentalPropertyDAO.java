package com.wipro.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.wipro.hms.bean.RentalPropertyBean;
import com.wipro.hms.util.DButil;

public class RentalPropertyDAO {
	
	//static RentalPropertyBean r=new RentalPropertyBean();
	public String generatePropertyID(String city) throws ClassNotFoundException, SQLException {
		Connection g=DButil.getDBConnection();
		String s="select seq from rental_seq";
		Statement s1=g.createStatement();
		 ResultSet r1=s1.executeQuery(s);
		 int p=999;
		 while (r1.next()) {
				p = r1.getInt(1);
			}  
		 p++;
		return city.toUpperCase().substring(0,3)+p;
		
		
	}
	public int createRentalProperty(RentalPropertyBean r) throws ClassNotFoundException, SQLException {
		int c=0;
		try {
	
		Connection g=DButil.getDBConnection();
		String propertyId=generatePropertyID(r.getCity());
		String s="insert into rental values(?,?,?,?,?,?)";
		PreparedStatement p=g.prepareStatement(s);
		p.setInt(1,0);
		p.setString(2, propertyId);
		p.setFloat(3,r.getRentalAmount());
		p.setInt(4,r.getNoOfBedRooms());
		p.setString(5, r.getLocation());
		p.setString(6, r.getCity());
        c=p.executeUpdate();
        g.close();
        if (c > 0) {
			return c;
		} else {
			return -1;

		}
	}
        catch (Exception e) {
			e.printStackTrace();
		}
		return c;
		
	}
	

}
