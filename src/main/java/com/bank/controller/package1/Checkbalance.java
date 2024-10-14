package com.bank.controller.package1;

import java.io.IOException;

import com.bank.model.package1.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Checkbalance")
public class Checkbalance extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		int acc_num = (Integer) session.getAttribute("acc_num");
		try {
			Model m = new Model();
			m.setAcc_num(acc_num);
			boolean b= m.checkbalance();
			
			if (b==true) {
				session.setAttribute("bal", m.getBal());
				resp.sendRedirect("/BankingApplication/BalanceView.jsp");
			}
			else {
				resp.sendRedirect("/BankingApplication/BalanceFail.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
