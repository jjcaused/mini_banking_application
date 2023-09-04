package com.dest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dest.model.Model;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");//sender
		String samt = request.getParameter("amt");
		
		int amt = Integer.parseInt(samt);

		String sraccno = request.getParameter("raccno");
		
		int raccno = Integer.parseInt(sraccno);//receiver
		
		
		try {
			Model m = new Model();
			m.setAccno(accno);
			m.setRaccno(raccno);
			m.setBal(amt);
			boolean b = m.transfer();
			if(b==true) {
				response.sendRedirect("/Project1/TransferSuccess.html");
			}
			else {
				response.sendRedirect("/Project1/TransferFail.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
