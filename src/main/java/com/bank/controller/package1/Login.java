package com.bank.controller.package1;

import java.io.IOException;

import com.bank.model.package1.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	
	private HttpSession session;


	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		String pwd = req.getParameter("pwd");
		session = req.getSession(true);
		try {
			Model m = new Model();
			
			m.setCid(cid);
			m.setPwd(pwd);
			
			boolean b= m.Login();
			
			if(b==true) 
			{
				session.setAttribute("acc_num", m.getAcc_num());
				resp.sendRedirect("/BankingApplication/Home.html");
			}
			else {
				
				resp.sendRedirect("/BankingApplication/Errors.html");

			}
			 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
