package com.upload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class uploadDB {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean uploadmovie(String name,String link,String language,String fileName,String savePath,int year,int rating,String adminun) {

    	boolean isSuccess = false;
    	
    	PreparedStatement pst=null;
      	
    	
    	try {
    		con = DBconnect.getConnection();
    		 pst = con.prepareStatement("insert into movie(name,link,language,image,path,year,rating,adminun) values(?,?,?,?,?,?,?,?)");
             
             pst.setString(1, name);
             pst.setString(2, link);
             pst.setString(3, language);
             pst.setString(4, fileName);
             pst.setString(5, savePath);
             pst.setInt(6, year);
             pst.setInt(7, rating);
             pst.setString(8, adminun);

            if( pst.executeUpdate()>0) {
            	 isSuccess=true;
            }else {
            	 isSuccess=false;
            }
    		
    		
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}finally {
    		
    		close(con,pst,null);
    	}
 	
    	return isSuccess;
	}

	public static boolean checkavailability(String name) {
		boolean isAvailable=false;
		
		try {
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "select name from movie where name='"+name+"'";
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
	
	public static ArrayList<Movie> displayMovie(){
		
     ArrayList<Movie> cus = new ArrayList<>();
    	
    	try {
    		
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from movie";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int id = rs.getInt(1);
    			String nname = rs.getString(2);
    			String link = rs.getString(3);
    			String language = rs.getString(4);
    			String filename = rs.getString(5);
    			String path = rs.getString(6);
    			int year = rs.getInt(7);
    			int rating = rs.getInt(8);
    			
    			Movie c = new Movie(id,nname,link,language,filename,path,year,rating);
    			
    			cus.add(c);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return cus;	
		
	}
	
	public static ArrayList<Movie> displayMovieUn(String adminun){
		
	     ArrayList<Movie> cus = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select * from movie where adminun='"+adminun+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			int id = rs.getInt(1);
	    			String nname = rs.getString(2);
	    			String link = rs.getString(3);
	    			String language = rs.getString(4);
	    			String filename = rs.getString(5);
	    			String path = rs.getString(6);
	    			int year = rs.getInt(7);
	    			int rating = rs.getInt(8);
	    			
	    			Movie c = new Movie(id,nname,link,language,filename,path,year,rating);
	    			
	    			cus.add(c);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return cus;	
			
		}


	public static Movie getMovie(int id) {
		Movie m = null;
     
    	
    	try {
    		
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from movie where id='"+id+"'";
    		rs = stmt.executeQuery(sql);
    		
    	while(rs.next()) {
    			int idd = rs.getInt(1);
    			String nname = rs.getString(2);
    			String link = rs.getString(3);
    			String language = rs.getString(4);
    			String filename = rs.getString(5);
    			String path = rs.getString(6);
    			int year = rs.getInt(7);
    			int rating = rs.getInt(8);
    			
    			 m = new Movie(idd,nname,link,language,filename,path,year,rating);
    	}
    			
    		
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    	}	
    	
    	
		return m;
    	
	}

	public static boolean updateMovie(int id, String name, String link, String language,String fileName,String savePath,int year,int rating) {
    boolean isSuccess=false;
   
    try {
    				
    		con = DBconnect.getConnection();
    		PreparedStatement pst = con.prepareStatement("update movie set name=?,link=?,language=?,image=?,path=?,year=?,rating=? where id='"+id+"'");
             
             pst.setString(1, name);
             pst.setString(2, link);
             pst.setString(3, language);
             pst.setString(4, fileName);
             pst.setString(5, savePath);
             pst.setInt(6, year);
             pst.setInt(7, rating);
    		
    		if(pst.executeUpdate()>0) {
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

	public static boolean deleteMovie(int id) {
		boolean isSuccess = false;
          try {
    		
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from movie where id='"+id+"'";
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

	public static ArrayList<Movie> movieSearch(String mname) {
		
		 ArrayList<Movie> cus = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select * from movie where name LIKE '%"+mname+"%' ";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			int id = rs.getInt(1);
	    			String nname = rs.getString(2);
	    			String link = rs.getString(3);
	    			String language = rs.getString(4);
	    			String filename = rs.getString(5);
	    			String path = rs.getString(6);
	    			int year = rs.getInt(7);
	    			int rating = rs.getInt(8);
	    			
	    			Movie c = new Movie(id,nname,link,language,filename,path,year,rating);
	    			
	    			cus.add(c);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	
	    	return cus;	
			
		}
		
	
	
	public static boolean insertcontact(String name, String email, String subject, String message) {
		boolean isSuccess=false;
		try {
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into contactus values (0,'"+name+"','"+email+"','"+subject+"','"+message+"')";
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
	
	public static ArrayList<Contact> displaycontact(){
		
	     ArrayList<Contact> c = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select * from contactus";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    		    int id = rs.getInt(1);
	    			String name = rs.getString(2);
	    			String email = rs.getString(3);
	    			String subject = rs.getString(4);
	    			String message = rs.getString(5);
	    			
	    			Contact cc = new Contact(id,name, email,subject, message);
	    			
	    			c.add(cc);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return c;	

	}
	
	public static boolean deletecontact(int id) {
		boolean isSuccess = false;
          try {
    		
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from contactus where id='"+id+"'";
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
	
	public static boolean tvcheckavailability(String name) {
		boolean isAvailable=false;
		
		try {
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "select name from tvseries where name='"+name+"'";
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

	public static boolean uploadtvseries(String name, String language, String dbFileName, String savePath,
			String adminun) {
		
boolean isSuccess = false;
    	
    	
      	
    	
    	try {
    		con = DBconnect.getConnection();
    		PreparedStatement pst = con.prepareStatement("insert into tvseries(name,language,image,path,adminun) values(?,?,?,?,?)");
             
             pst.setString(1, name);            
             pst.setString(2, language);
             pst.setString(3, dbFileName);
             pst.setString(4, savePath);           
             pst.setString(5, adminun);

            if( pst.executeUpdate()>0) {
            	 isSuccess=true;
            }else {
            	 isSuccess=false;
            }
    		
    		
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}finally {
    		
    	}
 	
    	return isSuccess;
	}
	
	
	public static List<String> displayTvNames(){
		
	     List<String> cus = new ArrayList<String>() ;
	    	
	    	try {
	    		
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select * from tvseries ";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			
	    			String name = rs.getString(1);
	    			
	    			cus.add(name);
	    			
	    			
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return cus;	
			
		}

	public static boolean uploadepisode(String name, int season, int episode, String link, int year, int rating) {
boolean isSuccess = false;
    	
    	try {
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into episodes values (0,'"+season+"','"+episode+"','"+year+"','"+name+"','"+rating+"','"+link+"')";
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

	public static boolean checkavailabilityepisode(String name, int season, int episode) {
		// TODO Auto-generated method stub
boolean isAvailable=false;
		
		try {
    		con = DBconnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "select * from episodes where name='"+name+"' and season='"+season+"' and episode='"+episode+"'";
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
	
	
	public static ArrayList<TvSeries> displayTvseriesUn(String adminun){
		
	     ArrayList<TvSeries> cus = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select T.name,T.language,E.id,E.episode,E.season,E.year,E.rating,E.link,T.path,T.image from tvseries T,episodes E where T.name=E.name and T.adminun='"+adminun+"' ";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			
	    			String name = rs.getString(1);
	    			String language = rs.getString(2);
	    			int id = rs.getInt(3);
	    			int episode = rs.getInt(4);
	    			int season = rs.getInt(5);
	    			int year = rs.getInt(6);
	    			int rating = rs.getInt(7);
	    			String link = rs.getString(8);
	    			String filename = rs.getString(10);
	    			String path = rs.getString(9);
	    			
	    			
	    			TvSeries c = new TvSeries(id,name,language,year,rating,season,episode,link,filename,path);
	    			System.out.println(name);
	    			
	    			cus.add(c);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return cus;	
			
		}
	
	public static TvSeries getTvSeries(int idd){
		
	    TvSeries cus = null;
	    	
	    	try {
	    		
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select T.name,T.language,E.id,E.episode,E.season,E.year,E.rating,E.link,T.path,T.image from tvseries T,episodes E where T.name=E.name and E.id='"+idd+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			
	    			String name = rs.getString(1);
	    			String language = rs.getString(2);
	    			int id = rs.getInt(3);
	    			int episode = rs.getInt(4);
	    			int season = rs.getInt(5);
	    			int year = rs.getInt(6);
	    			int rating = rs.getInt(7);
	    			String link = rs.getString(8);
	    			String filename = rs.getString(10);
	    			String path = rs.getString(9);
	    			
	    			
	    			cus = new TvSeries(id,name,language,year,rating,season,episode,link,filename,path);
	    			
	    			
	    			
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return cus;	
			
		}

	public static boolean deleteTvSeries(int id) {
		
		boolean isSuccess = false;
        try {
  		
  		con = DBconnect.getConnection();
  		stmt = con.createStatement();
  		String sql = "delete from episodes where id='"+id+"'";
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
	
	
	public static ArrayList<TvSeries> displayTvseriesName(){
	     ArrayList<TvSeries> cus = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select * from tvseries";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			
	    			String name = rs.getString(1);
	    			String language = rs.getString(2);
	    			String path = rs.getString(3);
	    			
	    			
	    			TvSeries c = new TvSeries();
	    			c.setName(name);
	    			c.setLanguage(language);
	    			c.setPath(path);
	    		
	    			
	    			cus.add(c);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return cus;	
			
		}
	
	
	public static ArrayList<TvSeries> displayTvseriesNm(String namee){
		
	     ArrayList<TvSeries> cus = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select T.name,T.language,E.id,E.episode,E.season,E.year,E.rating,E.link,T.path,T.image from tvseries T,episodes E where T.name=E.name and e.name='"+namee+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			
	    			String name = rs.getString(1);
	    			String language = rs.getString(2);
	    			int id = rs.getInt(3);
	    			int episode = rs.getInt(4);
	    			int season = rs.getInt(5);
	    			int year = rs.getInt(6);
	    			int rating = rs.getInt(7);
	    			String link = rs.getString(8);
	    			String filename = rs.getString(10);
	    			String path = rs.getString(9);
	    			
	    			
	    			TvSeries c = new TvSeries(id,name,language,year,rating,season,episode,link,filename,path);
	    			
	    			
	    			cus.add(c);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return cus;	
			
		}
	
	
	public static TvSeries getEpisode(int idd){
		
	    TvSeries cus = null;
	    	
	    	try {
	    		
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select T.name,T.language,E.id,E.episode,E.season,E.year,E.rating,E.link,T.path,T.image from tvseries T,episodes E where T.name=E.name and e.id='"+idd+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    			
	    			String name = rs.getString(1);
	    			String language = rs.getString(2);
	    			int id = rs.getInt(3);
	    			int episode = rs.getInt(4);
	    			int season = rs.getInt(5);
	    			int year = rs.getInt(6);
	    			int rating = rs.getInt(7);
	    			String link = rs.getString(8);
	    			String filename = rs.getString(10);
	    			String path = rs.getString(9);
	    			
	    			
	    			cus = new TvSeries(id,name,language,year,rating,season,episode,link,filename,path);
	    			
	    			
	    			
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return cus;	
			
		}
	
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRe) {

		try {
		if (myRe != null) {
		myRe.close();
		}
		if (myStmt != null) {
		myStmt.close();
		}
		if (myConn != null) {
		myConn.close();
		}
		
		}
		catch (Exception exc){
		exc.printStackTrace();
		}
		}


}
	
	

