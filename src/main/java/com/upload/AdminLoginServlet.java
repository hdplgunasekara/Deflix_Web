package com.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String adminun=request.getParameter("adminun");
		String adminpw=request.getParameter("adminpw");
		
		
		
		boolean isSuccess=AdminDB.adminlogin(adminun, adminpw);
		
		if(isSuccess==true) {
			HttpSession session=request.getSession();
			session.setAttribute("adminun", adminun);
			out.println("<script type='text/javascript'>");
			out.println("alert('Login Successful');");
			out.println("location='adminhome.jsp'");
			out.println("</script>");
			
			
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Passwor Or Username Incorrect');");
			out.println("location='adminlogin.jsp'");
			out.println("</script>");
			
			
		}
		
		
	}

}
