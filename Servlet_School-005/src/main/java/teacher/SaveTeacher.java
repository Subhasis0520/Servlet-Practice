package teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/saveTea")
public class SaveTeacher extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 int id = Integer.parseInt(req.getParameter("tid"));
		 String name = req.getParameter("tname"); 
		 String subject = req.getParameter("sub");
		 
		 int row =0;
		 	
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_school","root","Subhasis@123");
			 String query = "INSERT INTO teacher VALUES(?,?,?)";
			 PreparedStatement ps = con.prepareStatement(query);
			 ps.setInt(1, id);
			 ps.setString(2, name);
			 ps.setString(3, subject);
			 
			  row = ps.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
		 PrintWriter pw = resp.getWriter();
	        if(row !=0) {
	           pw.write("<h1> DATA SAVE SUCCESSFULLY </h1>");
	           RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
	           rd.include(req, resp);
	        }else {
	        	pw.write("<h1> SOMETHING WENT WRONG </h1>");
	            RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
	            rd.include(req, resp);
	        }
	}
}
