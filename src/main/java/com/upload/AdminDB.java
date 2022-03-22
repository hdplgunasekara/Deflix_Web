package com.upload;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminDB {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean adminlogin(String username,String password) {
		boolean isAvailable=false;
		
		try {
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "select * from admin where username='"+username+"' and password='"+password+"'";
    		 rs =  stmt.executeQuery(sql);
    		
    		if(rs.next()) {
    			isAvailable = true;
    		} else {
    			isAvailable = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
		
		
		return isAvailable;
	}

	public static Admin getAdmin(String username) {
     Admin ad=null;
     
    	
    	try {
    		
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from admin where username='"+username+"'";
    		rs = stmt.executeQuery(sql);
    		
    		
    	while(rs.next()) {
    		    
    			String uname = rs.getString(1);
    			String password = rs.getString(2);
    			String email = rs.getString(3);
    			String name = rs.getString(4);
    			String mobile = rs.getString(5);
    			
    			
    			 ad=new Admin(uname,name, password, email, mobile);
    			 
    	}
    			
    		
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    	}	
    	
    	
		return ad;
	}

	public static boolean updateAdmin(String uname, String name, String password, String email, String mobile) {
		boolean isSuccess=false;
          try {
    		
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update admin set username='"+uname+"',password='"+password+"',email='"+email+"',name='"+name+"',mobile='"+mobile+"' where username='"+uname+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
	}

	public static boolean checkAvailability(String uname) {
boolean isAvailable=false;
		
		try {
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "select username from admin where username='"+uname+"'";
    		 rs =  stmt.executeQuery(sql);
    		
    		if(rs.next()) {
    			isAvailable = true;
    		} else {
    			isAvailable = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
		
		
		return isAvailable;
	}

public static boolean AddAdmin(String uname, String name, String password, String email, String mobile) {
boolean isSuccess = false;
    	
    	try {
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into admin values ('"+uname+"','"+password+"','"+email+"','"+name+"','"+mobile+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
	}

	public static boolean deleteAdmin(String adminun) {
		boolean isSuccess = false;
        try {
  		
  		con = DBconnect.getConnection();
  		stmt = con.createStatement();
  		String sql = "delete from admin where username='"+adminun+"'";
  		int r = stmt.executeUpdate(sql);
  		
  		if (r > 0) {
  			isSuccess = true;
  		}
  		else {
  			isSuccess = false;
  		}
  		
  	}
  	catch (Exception e) {
  		e.printStackTrace();
  	}
  	
  	return isSuccess;
	}

	
}
