package com.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminAddServlet
 */
@WebServlet("/AdminAddServlet")
public class AdminAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		String uname=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		boolean isSuccess,availability;
		
		availability=AdminDB.checkAvailability(uname);
	
	if(availability==false) {
		isSuccess=AdminDB.AddAdmin(uname,name,password,email,mobile);
		
		if(isSuccess==true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Successfully Added');");
			out.println("location='addadmin.jsp'");
			out.println("</script>");
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Not Added Failed');");
			out.println("location='addadmin.jsp'");
			out.println("</script>");
			
		}  }
	else {
		out.println("<script type='text/javascript'>");
		out.println("alert('Username already available');");
		out.println("location='addadmin.jsp'");
		out.println("</script>");
	}
		
	}

}
