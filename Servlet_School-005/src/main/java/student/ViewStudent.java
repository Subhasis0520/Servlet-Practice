package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewStu")
public class ViewStudent extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_school","root","Subhasis@123");
			 String query = "SELECT * FROM student";
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(query);
			 
				PrintWriter pw = resp.getWriter();
				
				pw.write("<html><body>");
				pw.write("<table border= 2px><tr>");
				pw.write("<th>ROLL</th>");
				pw.write("<th>NAME</th>");
				pw.write("<th>AGE</th>");
				pw.write("</tr>");
				
				while(rs.next()) {
					pw.write("<tr>");
					pw.write("<td>"+rs.getInt(1)+"</td>");
					pw.write("<td>"+rs.getString(2)+"</td>");
					pw.write("<td>"+rs.getInt(3)+"</td>");
					pw.write("</tr>");
				}
				pw.write("</table></html></body>");
			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
}
