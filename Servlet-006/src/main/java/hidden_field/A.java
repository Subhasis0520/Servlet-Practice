package hidden_field;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1")
public class A  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println(name);
		
		PrintWriter pw = resp.getWriter();
		
		pw.write("<html><body>");
		pw.write("<form action=s2>");
		pw.write("<input type=text name=n value='"+name+"' hidden>");
        pw.write("<input type=submit value = 'go to second'>");
		pw.write("</form></html></body>");
	}
}
