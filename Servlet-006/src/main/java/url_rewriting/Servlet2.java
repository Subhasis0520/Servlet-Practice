package url_rewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serv2")
public class Servlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("mail");
		String password = req.getParameter("pwd");
		
		System.out.println(name);
		System.out.println(password);
		
		PrintWriter pw = resp.getWriter();
		// we have to re-write again url rewriting /it is not a good practice
		pw.write("<a href=serv3?mail="+name+"&pwd="+password+">Servlet3</a>");
	}
}
