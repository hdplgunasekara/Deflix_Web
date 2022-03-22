package com.author;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add_article")
public class add_article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name =request.getParameter("name");
		int rating=Integer.parseInt(request.getParameter("rating"));
		String category=request.getParameter("category");
		String description=request.getParameter("description");
		boolean isTrue;
		
		
		
		isTrue=articleDB_util.addArticle(name, rating, category, description);
		if(isTrue==true) {
			RequestDispatcher dis1=request.getRequestDispatcher("added_successfully.jsp");
			dis1.forward(request, response);
		}
		else {
			RequestDispatcher dis2=request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
		
	}

		
		
		
	}

