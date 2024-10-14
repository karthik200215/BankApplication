package com.bank.controller.package1;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

public class ChangePwdFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		String npwd= req.getParameter("npwd");
		String cpwd= req.getParameter("cpwd");
		if(npwd.equals(cpwd)) {
			chain.doFilter(req, resp);
		}
		else {
			((HttpServletResponse) resp).sendRedirect("/ChangePwdFail.html");
		}
	}
}
