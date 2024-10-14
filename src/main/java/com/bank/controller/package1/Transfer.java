package com.bank.controller.package1;

import java.io.IOException;

import com.bank.model.package1.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int acc_num= (Integer) session.getAttribute("acc_num");
		String samt= req.getParameter("amt");
		int amt = Integer.parseInt(samt);

		String racc_num1 = req.getParameter("racc_num");

		int racc_num = Integer.parseInt(racc_num1);

		try {
			Model m =new Model();
			m.setAcc_num(acc_num);
			m.setRaccno(racc_num);
			m.setBal(amt);
			boolean b = m.transfer();
			
			if(b==true) {
				resp.sendRedirect("/BankingApplication/TransferSuccess.html");
			}
			else {
				resp.sendRedirect("/BankingApplication/TransferFail.html");

			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
