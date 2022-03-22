package com.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tvUploadServlet2
 */
@WebServlet("/tvUploadServlet2")
public class tvUploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
		String name = request.getParameter("nameslist");
        String link = request.getParameter("link");
        int season=Integer.parseInt( request.getParameter("season"));
        int episode=Integer.parseInt( request.getParameter("episode"));
        int year=Integer.parseInt( request.getParameter("year"));
        int rating=Integer.parseInt( request.getParameter("rating"));
        boolean isAvailable,isSuccess;
        
        isAvailable=uploadDB.checkavailabilityepisode(name,season,episode);
        
        if(isAvailable==true) {
        	out.println("<script type='text/javascript'>");
   			out.println("alert('Episode Already Available ');");
   			out.println("location='tvupload.jsp'");
   			out.println("</script>");
        	
        	
        }else {
        	
        	isSuccess=uploadDB.uploadepisode(name,season,episode,link,year,rating);
        	 if(isSuccess==true) {
        		 
         		out.println("<script type='text/javascript'>");
       			out.println("alert('Successfully Uploaded ');");
       			out.println("location='tvupload.jsp'");
       			out.println("</script>");
         		 
         	 }else {
         		 
         		 out.println("<script type='text/javascript'>");
      			out.println("alert('Upload Failed ');");
      			out.println("location='tvupload.jsp'");
      			out.println("</script>");
         		 
         	 }
         	 
        }
        
        
	}

}
