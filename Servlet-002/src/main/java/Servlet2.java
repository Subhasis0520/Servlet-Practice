import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test2")
public class  Servlet2 implements Servlet{

	static {
		System.out.println("class-loading for servlet-2");
	}
	{
		System.out.println("object-creation for servlet-2");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init for servlet-2");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("config");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service method of servlet-2");		
	}

	@Override
	public String getServletInfo() {
		System.out.println("info");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destroy of servlet-2");		
	}

}

