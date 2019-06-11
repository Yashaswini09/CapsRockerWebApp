package com.caps.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.beans.User;
import com.caps.services.UserServices;
import com.caps.services.UserServicesImpl;

@WebServlet("/createProfile")
public class CreateProfile extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		
		User user = new User();
		user.setUserid(Integer.parseInt(userid));
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwd);
		
		UserServices services = new UserServicesImpl();
		boolean state = services.createProfile(user);
		PrintWriter out = resp.getWriter();
		if(state) {
			out.println("<h1>Profile Creation Successful</h1>");
		}else {
			out.println("<h1>Profile Creation Failed</h1>");
		}
	}
}
