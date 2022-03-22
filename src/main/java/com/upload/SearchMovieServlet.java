package com.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SearchMovieServlet")
public class SearchMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String mname=request.getParameter("search");
		
	
		ArrayList<Movie> movie=(ArrayList<Movie>)uploadDB.movieSearch(mname);
		
		if(movie.isEmpty()) {
			out.println("<script type='text/javascript'>");
			out.println("alert('No result found');");
			out.println("location='moviesearchresult.jsp'");
			out.println("</script>");
			
		}else {
		
		request.setAttribute("movie", movie);
	    RequestDispatcher dis = request.getRequestDispatcher("moviesearchresult.jsp");
		dis.forward(request, response);
		}
	}

}
