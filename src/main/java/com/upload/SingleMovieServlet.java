package com.upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int movieid=Integer.parseInt(request.getParameter("mid"));
		
		Movie mv=uploadDB.getMovie(movieid);
		
		if(mv!=null) {
			request.setAttribute("movie", mv);
		    RequestDispatcher dis = request.getRequestDispatcher("singlemovieview.jsp");
			dis.forward(request, response);
		}else
		{
			
		}
	}

	

}
