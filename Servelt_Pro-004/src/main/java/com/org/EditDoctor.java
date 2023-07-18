package com.org;

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

@WebServlet("/edit")
public class EditDoctor extends HttpServlet{
 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String query = "SELECT * FROM doctor WHERE id="+id;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_004","root","Subhasis@123");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			rs.next();
			
			PrintWriter pw = resp.getWriter();
			pw.write("<html><body>");
			pw.write("<form action=update><pre>");
			pw.write("     ID             : <input type=text name=id value="+rs.getInt(1)+" readonly><br>");
			pw.write("     NAME           : <input type=text name=name value='"+rs.getString(2)+"' ><br>");
			pw.write("     AGE            : <input type=text name=age value="+rs.getInt(3)+" ><br>");
			pw.write("     PHONE          : <input type=text name=phone value="+rs.getLong(4)+" ><br>");
			pw.write("     SPEC           : <input type=text name=spec value="+rs.getString(5)+" ><br><br>");
			pw.write("                       <input type=submit value=update ><br>");
			pw.write("</pre></form></body></html>");
			
			
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
