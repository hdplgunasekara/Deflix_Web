package com.upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=  Integer.parseInt(request.getParameter("id"));
		
		Movie getmovie;
		getmovie=uploadDB.getMovie(id);
	    request.setAttribute("getmovie", getmovie);
		RequestDispatcher dis = request.getRequestDispatcher("singlemovie.jsp");
		dis.forward(request, response);
		
		
		
	}

	
}
