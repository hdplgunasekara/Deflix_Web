package com.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class episodeDeleteServlet
 */
@WebServlet("/episodeDeleteServlet")
public class episodeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int id=Integer.parseInt(request.getParameter("id"));
		boolean isSuccess;
		isSuccess=uploadDB.deleteTvSeries(id);
        
		
		if (isSuccess == true) {
			
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Successfully deleted');");
			out.println("location='admintvserieslist.jsp'");
			out.println("</script>");
			
		}
		else {
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Unsuccessfull ');");
			out.println("location='admintvserieslist.jsp'");
			out.println("</script>");
			
			
		}
		
		
	}
		
	

	

}
