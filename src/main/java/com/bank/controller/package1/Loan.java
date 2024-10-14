package com.bank.controller.package1;

import java.io.IOException;

import com.bank.model.package1.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Loan extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int acc_num = (Integer) session.getAttribute("acc_num");
	
		try {
			Model m =new Model();
			m.setAcc_num(acc_num);
			boolean b = m.applyLoan();
			
			if(b==true) {
				session.setAttribute("name ", m.getName());
				session.setAttribute("mail", m.getMail());
				response.sendRedirect("/BankingApplication/LoanSuccess.jsp");
			}
			else {
				response.sendRedirect("/BankingApplication/LoanFail.html");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}
