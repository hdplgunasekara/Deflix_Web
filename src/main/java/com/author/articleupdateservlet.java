package com.author;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateservlet")
public class articleupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID= request.getParameter("ID");
		int IDD= Integer.parseInt( request.getParameter("ID"));
		String name=request.getParameter("name");
		int rating= Integer.parseInt(request.getParameter("rating"));
		String category=request.getParameter("category");
		String description =request.getParameter("description");
		
		boolean isTrue;
		isTrue=articleDB_util.updatearticle(ID, name, rating, category, description);
		if (isTrue==true) {
			
			article articleDetails=articleDB_util.validate(IDD);
			request.setAttribute("articleDetails", articleDetails);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("articledetails.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID= Integer.parseInt(request.getParameter("ID"));
		
		 article  art =articleDB_util.validate(ID);
		
		 request.setAttribute("articleDetails", art);
			RequestDispatcher dis = request.getRequestDispatcher("update_article.jsp");
			dis.forward(request, response);
		
	}

}
