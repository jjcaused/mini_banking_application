package com.dest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dest.model.Model;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custid = request.getParameter("custid");
		String pwd = request.getParameter("pwd");
		session = request.getSession(true);
		try {
			Model m = new Model();
			m.setCustid(custid);
			m.setPwd(pwd);
			boolean b = m.login();
			
			if(b==true) {
				session.setAttribute("accno", m.getAccno());
				response.sendRedirect("/Project1/Home.html");
			}
			else {
				response.sendRedirect("/Project1/Error.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
