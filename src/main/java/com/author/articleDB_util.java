package com.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class articleDB_util {
	private static Connection con=null;
	private static Statement stat= null;
	private static ResultSet result=null;
	
	 static boolean isSuccess=false;
	

	public static article validate(int  ID1){
		article art =null;
		 

		
	//validate	 
		 
		try {
			con =DBconnect.getConnection();
			stat=con.createStatement();
			
			String sql1="select * from add_article1 where ID='"+ID1+"'";
			 result =stat.executeQuery(sql1);
		    
		    if(result.next()) {
		    	int ID=result.getInt(1);
		    	String name=result.getString(2);
		    	int rating=result.getInt(3);
		    	String category=result.getString(4);
		    	String description=result.getString(5);
		    	
		    	art= new article(ID,name,rating,category,description);
		    	System.out.println(art.getName());
		    	
		    }
		    else {
		    	
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
		
		
		 
		 return art;
	}
	public static boolean addArticle(String name,int rating,String category,String description) {
		boolean isSuccess=false;
		
		
		
		try {
			con =DBconnect.getConnection();
			stat=con.createStatement();
			
			String sql2="insert into add_article1 values(0,'"+name+"','"+rating+"','"+category+"','"+description+"') ";
			int result=stat.executeUpdate(sql2);
		    
		    if(result>0) {
		    	isSuccess=true;
		    }
		    else {
		    	isSuccess=false;
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	public static boolean updatearticle(String ID,String name ,int rating ,String category ,String description)	{
		 boolean isSuccess=false;
		try {
			con =DBconnect.getConnection();
			stat=con.createStatement();
			
			String sql3="update add_article1 set name='"+name+"', rating='"+rating+"',category='"+category+"' , description ='"+description+"'"+"where ID='"+ID+"'";
			int result= stat.executeUpdate(sql3);
			if(result>0) {
				isSuccess =true;
			}
			else {
				isSuccess=false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}

	public static List<article> getArticleDetails(String name1){
		ArrayList<article> arti=new ArrayList<>();
		try {
			con =DBconnect.getConnection();
			stat=con.createStatement();
			String sql4="select * from add_article1 where name='"+name1+"'";
			 result =stat.executeQuery(sql4);
			 
			 while(result.next()) {
				 int ID=result.getInt(1);
			    	String name=result.getString(2);
			    	int rating=result.getInt(3);
			    	String category=result.getString(4);
			    	String description=result.getString(5);
			   
			     	article a=new article(ID,name,rating ,category,description);
			     	  arti.add(a);
			    	
			 }
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return arti;
	}

	public static boolean deletearticle(String ID) {
		int convertedID=Integer.parseInt(ID);
		
		try{
			con =DBconnect.getConnection();
			stat=con.createStatement();
			String sql5="delete from add_article1 where ID='"+convertedID+"'";
			int result =stat.executeUpdate(sql5);
			
			if(result>0) {
				isSuccess =true;
			}
			else {
				isSuccess=false;
			}
		 
			
			
		}
		catch(Exception e) {
			
		}
		
		
		
		return isSuccess;
		
	}
	
	
	public static List<article> getArticleDetails(){
		ArrayList<article> arti=new ArrayList<>();
		try {
			con =DBconnect.getConnection();
			stat=con.createStatement();
			String sql4="select * from add_article1 ";
			 result =stat.executeQuery(sql4);
			 
			 while(result.next()) {
				 int ID=result.getInt(1);
			    	String name=result.getString(2);
			    	int rating=result.getInt(3);
			    	String category=result.getString(4);
			    	String description=result.getString(5);
			   
			     	article a=new article(ID,name,rating ,category,description);
			     	  arti.add(a);
			    	
			 }
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return arti;
	}
	
	public static article getSingleArticleDetails(int id){
		article ar=null;
		try {
			con =DBconnect.getConnection();
			stat=con.createStatement();
			String sql4="select * from add_article1 where ID='"+id+"' ";
			 result =stat.executeQuery(sql4);
			 
			 while(result.next()) {
				 int ID=result.getInt(1);
			    	String name=result.getString(2);
			    	int rating=result.getInt(3);
			    	String category=result.getString(4);
			    	String description=result.getString(5);
			   
			     	 ar=new article(ID,name,rating ,category,description);
			     	  
			    	
			 }
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ar;
	}

	
	
}
