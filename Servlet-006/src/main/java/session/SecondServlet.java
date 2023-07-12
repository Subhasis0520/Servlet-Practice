package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/res2")
public class SecondServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// transfer data using HttpSession
		HttpSession session2 = req.getSession();
		String email = (String) session2.getAttribute("e");
		String password =  (String) session2.getAttribute("pwd");
		
		System.out.println(email);
		System.out.println(password);
		
		
		PrintWriter pw = resp.getWriter();
		pw.write("<a href=res3>Servlet3</a>");
	}
}
