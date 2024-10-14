package com.bank.controller.package1;

import java.io.IOException;
import java.util.ArrayList;

import com.bank.model.package1.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/GetStatement")
public class GetStatement extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int acc_num = (Integer) session.getAttribute("acc_num");
		
		try {
			Model m = new Model();
			m.setAcc_num(acc_num);
			ArrayList al = m.getStatement();
			
			if (al.isEmpty()==true) {
				
				resp.sendRedirect("/BankingApplication/StatementFail.html");
			}
			else {
				session.setAttribute("sal", m.sal);
				session.setAttribute("ral",m.ral);
				session.setAttribute("al", m.al);
				resp.sendRedirect("/BankingApplication/StatementSuccess.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}

}
