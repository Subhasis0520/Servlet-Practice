package session;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/res3")
public class ThirdServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session3 = req.getSession();
		String email = (String) session3.getAttribute("e");
		String password =  (String) session3.getAttribute("pwd");
		
		System.out.println(email);
		System.out.println(password);
		
	}

}
