package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
			
@WebServlet("/res1")
public class FirstServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("mail");
		String password = req.getParameter("pwd");
		
		System.out.println(email);
		System.out.println(password);
		
		// transfer data using HttpSession
		HttpSession session = req.getSession();
		session.setAttribute("e",email);
		session.setAttribute("pwd", password);
		
		PrintWriter pw = resp.getWriter();
		pw.write("<a href=res2>Servlet2</a>");
	}
}
