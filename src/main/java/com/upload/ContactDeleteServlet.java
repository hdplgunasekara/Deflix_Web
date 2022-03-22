package com.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteControl
 */
@WebServlet("/ContactDeleteServlet")
public class ContactDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int id=  Integer.parseInt(request.getParameter("id"));
		boolean isSuccess;
		isSuccess=uploadDB.deletecontact(id);
        
		
		if (isSuccess == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Successfully deleted');");
			out.println("location='contactuslist.jsp'");
			out.println("</script>");
			
		}
		else {
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Unsuccessfull ');");
			out.println("location='contactuslist.jsp'");
			out.println("</script>");
			
			
		}
		
		
		
	}

	
	

}
