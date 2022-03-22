package com.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminDeleteServlet
 */
@WebServlet("/AdminDeleteServlet")
public class AdminDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String adminun=request.getParameter("adminun");
		boolean isSuccess;
		isSuccess=AdminDB.deleteAdmin(adminun);
        
		
		if (isSuccess == true) {
			
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Successfully deleted');");
			out.println("location='adminlogout.jsp'");
			out.println("</script>");
			
		}
		else {
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Unsuccessfull ');");
			out.println("location='adminlogin.jsp'");
			out.println("</script>");
			
			
		}
		
		
	}

	

}
