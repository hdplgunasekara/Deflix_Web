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
@WebServlet("/AuthorLoginServlet")
public class AuthorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AuthorLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String authorun=request.getParameter("adminun");
		String authorpw=request.getParameter("adminpw");
		
		
		
		boolean isSuccess=AuthorDB.authorlogin(authorun, authorpw);
		
		if(isSuccess==true) {
			HttpSession session=request.getSession();
			session.setAttribute("authorun", authorun);
			out.println("<script type='text/javascript'>");
			out.println("alert('Login Successful');");
			out.println("location='authorhome.jsp'");
			out.println("</script>");
			
			
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Passwor Or Username Incorrect');");
			out.println("location='authorlogin.jsp'");
			out.println("</script>");
			
			
		}
		
		
	}

}
