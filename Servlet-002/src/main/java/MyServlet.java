import java.io.IOException;


import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("en");
		String sal = req.getParameter("esal");
		String dept = req.getParameter("dept");
		
		System.out.println(name+" --> "+sal);
		System.out.println(dept);
		
	}

}
