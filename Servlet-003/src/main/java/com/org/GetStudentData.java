package com.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/std")
public class GetStudentData extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int sid = Integer.parseInt(req.getParameter("sid"));
		String sname = req.getParameter("sname");
		int age = Integer.parseInt(req.getParameter("sage"));
		String gender = req.getParameter("gender");
		
		System.out.println(sid +" "+sname+" "+age+" "+gender);
		
		String html = "<html><body><h1> GOOD EVENING "+ sname+" -->"+age+"</h1></body></html>";
		PrintWriter out = res.getWriter();
		out.write(html);
	}

}
