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
@WebServlet("/AdminProfileServlet")
public class AdminProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("adminun");
		
		Admin ad;
		
		ad=AdminDB.getAdmin(username);
		
		request.setAttribute("admin", ad);
		RequestDispatcher dis = request.getRequestDispatcher("adminprofile.jsp");
		dis.forward(request, response);
		
		
		
	}

	

}
