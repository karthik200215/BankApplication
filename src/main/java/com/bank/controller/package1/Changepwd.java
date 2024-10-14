package com.bank.controller.package1;

import java.io.IOException;

import com.bank.model.package1.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Changepwd")
public class Changepwd extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwd = req.getParameter("npwd");
		HttpSession session =  req.getSession();	

		int acc_num =  (Integer) session.getAttribute("acc_num");

		try {
			
			Model m= new Model();
			m.setAcc_num(acc_num);
			m.setPwd(pwd);
			boolean b = m.ChangePwd();
			
			if(b==true) {
				
				resp.sendRedirect("/BankingApplication/ChangePwdSuccess.html");
			}
			else{
				
				resp.sendRedirect("/BankingApplication/ChangePwdFail.html");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
