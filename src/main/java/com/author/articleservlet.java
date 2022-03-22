package com.author;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/articleservlet")
public class articleservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID=Integer.parseInt(request.getParameter("article_ID"));
		
		try {
			
		article articleDetails=articleDB_util.validate(ID);
		request.setAttribute("articleDetails", articleDetails);
		
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher dis =request.getRequestDispatcher("articledetails.jsp");
		dis.forward(request, response);
		
		
		
		
		 
		
	}


	private int parseInteger(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
