package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/one")
public class ServletOne extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		System.out.println(name+" "+age);
		Cookie c1 = new Cookie("n", name);
		resp.addCookie(c1);
		Cookie c2 = new Cookie("a", age);
		resp.addCookie(c2);
		
		PrintWriter pw = resp.getWriter();
		pw.write("<a href=two> Go to servlet2</a>");

	}
}
