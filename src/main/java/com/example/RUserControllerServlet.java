package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RUserControllerServlet")
public class RUserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static RUserDBUtil RUserDBUtil = new RUserDBUtil();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String command = request.getParameter("command");
			
			//System.out.println(command);
			
			if(command != null) {
				switch(command) {
				case "ACCOUNT":
					showAccount(request, response);
					break;
				case "LOAD":
					accountDetails(request, response);
					break;
//				case "UPDATE":
//					updateAccount(request, response);
//					break;
				case "DELETE":
					deleteAccount(request, response);
					break;
					
				default:
					System.out.println(command);
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
			}
			
		}
		catch(Exception exc) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			throw new ServletException(exc);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			String command = request.getParameter("command");
			
			if(command != null) {
				switch(command) {	
				case "UPDATE":
					updateAccount(request, response);
					break;
				default:
					System.out.println(command);
					System.out.println(request.getParameter("userId"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
			}
			//updateAccount(request, response);
			
		}
		catch(Exception exc) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			throw new ServletException(exc);
		}
	}

	private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		String userId = request.getParameter("UserId");
		
		RegisteredUser user = RUserDBUtil.getRegisteredUser(userId);
		boolean isSuccess = RUserDBUtil.deleteUser(user);
		
        HttpSession session=request.getSession();  
        session.invalidate(); 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	
	}

	private void updateAccount(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		int userId = Integer.parseInt(request.getParameter("userId"));		
		//System.out.println(userId);
		
		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		String password = null;
		System.out.println(request.getParameter("newPassword"));
		if (request.getParameter("newPassword").isEmpty()) {
			password = request.getParameter("password");
		} else {
			password = request.getParameter("newPassword");
		}
		
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		RegisteredUser user = new RegisteredUser(userName, name, password, email, mobile, userId);
		
		
		boolean isSuccess = RUserDBUtil.updateRegisteredUser(user);
		
		user = RUserDBUtil.getRegisteredUser("" + userId);
		request.setAttribute("REGISTERED_USER", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp?UserId=" + user.getId());
		dispatcher.forward(request, response);
		
	}

	private void accountDetails(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		String userId = request.getParameter("UserId");
		
		//System.out.println(userId);
		
		RegisteredUser user = RUserDBUtil.getRegisteredUser(userId);
		request.setAttribute("REGISTERED_USER", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AccountDetails.jsp");
		dispatcher.forward(request, response);
	}

	private void showAccount(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		String userId = request.getParameter("UserId");
		
		System.out.println(userId);
		
		RegisteredUser user = RUserDBUtil.getRegisteredUser(userId);
		request.setAttribute("REGISTERED_USER", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RUserAccount.jsp");
		dispatcher.forward(request, response);
	}
	
	private void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
	    Cookie[] cookies = req.getCookies();
	    if (cookies != null)
	        for (Cookie cookie : cookies) {
	            cookie.setValue("");
	            cookie.setPath("/");
	            cookie.setMaxAge(0);
	            resp.addCookie(cookie);
	        }
	}


}
