package com.wipro.hms.service;

import java.sql.SQLException;

import com.wipro.hms.bean.RentalPropertyBean;
import com.wipro.hms.dao.RentalPropertyDAO;
import com.wipro.hms.util.InvalidCityException;

public class RentalPropertyService {
	static RentalPropertyBean bean=new RentalPropertyBean();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InvalidCityException {
		
		bean.setCity("Chennai");
		bean.setLocation("Velachery");
		bean.setNoOfBedRooms(2);
		bean.setRentalAmount(15000);
		
		System.out.println(addRentalProperty(bean));
	}
	 static RentalPropertyDAO d=new RentalPropertyDAO();
	public static String addRentalProperty(RentalPropertyBean bean) throws ClassNotFoundException, SQLException, InvalidCityException {
		if(bean.getCity().length()==0||bean.getLocation().length()==0||bean.getNoOfBedRooms()==0||bean.getRentalAmount()==0) {
			System.out.println("INVALID INPUT");
		}
		else if(bean.getCity()==""||bean.getLocation()=="") {
			return "NULL VALUES IN INPUT";
		}
		else if(bean.getCity()!="Chennai"||bean.getCity()=="Banglore"){
			validateCity(bean.getCity());
		}
	     if(d.createRentalProperty(bean)>0) {
	    	 return "SUCCESS";
	     }
	     else {
	    	 return "FAILURE";
	     }
		
	}

	public static void validateCity(String city) throws InvalidCityException {
			throw new InvalidCityException();
	}

	

}
