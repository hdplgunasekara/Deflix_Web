package com.upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminProfileServlet
 */
@WebServlet("/AuthorProfileServlet")
public class AuthorProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("authorun");
		
		Author ad;
		
		ad=AuthorDB.getAuthor(username);
		
		request.setAttribute("author", ad);
		RequestDispatcher dis = request.getRequestDispatcher("authorprofile.jsp");
		dis.forward(request, response);
		
		
		
	}

	

}
