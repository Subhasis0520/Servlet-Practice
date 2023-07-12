package com.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class ValidateLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("mail");
		String password = req.getParameter("pwd");
		
		
		if(email.equals("abcd@gmail.com") && password.equals("4321")) {
			HttpSession hs = req.getSession();
			hs.setAttribute("mail", email);
			RequestDispatcher rd = req.getRequestDispatcher("home");
			rd.forward(req, resp);
		}else {
			PrintWriter pw = resp.getWriter();
			pw.write("<h1 style='color:red'>Wrong username or password</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		}
	}
}
