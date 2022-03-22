package com.author;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteservlet")
public class articledeleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID =request.getParameter("ID");
		boolean isTrue;
		isTrue=articleDB_util.deletearticle(ID);
		
		if(isTrue==true) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("Article.jsp");
			dispatcher.forward(request, response);
		}
		else {
			List<article> articleDetails =articleDB_util.getArticleDetails(ID);
			request.setAttribute("articleDetails", articleDetails);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("articledetails.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
	}
	

}
