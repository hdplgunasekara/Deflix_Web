package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RUserRegisterControllerServlet")
public class RUserRegisterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static RUserDBUtil RUserDBUtil = new RUserDBUtil();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userName = request.getParameter("userName");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			System.out.println(email);
			System.out.println(mobile);
			
			RegisteredUser user = new RegisteredUser(userName, name, password, email, mobile);
			
			int isSuccess = RUserDBUtil.RegisterUser(user);
			
			user = RUserDBUtil.getUserbyUserName(userName);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			if (isSuccess >= 0) {
				HttpSession session=request.getSession();
				session.setAttribute("user","RegisteredUser");
				session.setAttribute("userId",user.getId());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?UserId=" + user.getId());
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/RUserRegister.jsp?logged=false");
				dispatcher.forward(request, response);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
