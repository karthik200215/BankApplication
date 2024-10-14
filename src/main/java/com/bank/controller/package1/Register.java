package com.bank.controller.package1;

import java.io.IOException;

import com.bank.model.package1.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String pwd = req.getParameter("pwd");
		String ba = req.getParameter("bal");
		String ac = req.getParameter("acc_num");
		int acc_num= Integer.parseInt(ac);
		int bal= Integer.parseInt(ba);

		try {
			Model m=new Model();
			m.setName(name);
			m.setAcc_num(acc_num);
			m.setBal(bal);
			m.setCid(cid);
			m.setMail(mail);
			m.setPwd(pwd);

			boolean b= m.register();
			if(b==true) {
				res.sendRedirect("/BankingApplication/SuccessReg.html");
			}else {
				res.sendRedirect("/BankingApplication/FailureReg.html");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
