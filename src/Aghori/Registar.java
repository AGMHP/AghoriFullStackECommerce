package Aghori;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signupform")
public class Registar extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doMethod(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException
	{

		Connection con = Enterer.DbConnection(); 
		String user = request.getParameter("email");
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String pass = request.getParameter("password");
		
		Enterer.insertRecord(user, first, last, phone, pass, con);
		//Wrapper(user, pass, first, last);
		Statement myst = con.createStatement();
		
		ResultSet myrs = myst.executeQuery("Select * From user_info");
		
		response.setContentType("text/html"); 
		
		PrintWriter out = response.getWriter(); 
		
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
		+ "Transitional//EN\">\n"; 
		
		String title = "Reading All Request Parameters"; 
		
		out.println(docType
				+ "<HTML>\n" + 
				"<HEAD><TITLE>"+title + 
				"</TITLE>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\"></HEAD>\n"+ 
				"<BODY BGCOLOR=\"#b3ffff\">\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
				"<TABLE BORDER=1 ALIGN=CENTER class=\"table table-striped\">\n" + 
				"<TR BGCOLOR=\"#FFAD00\">");
		while (myrs.next()) {	
		out.print("<TR><TD>User :</TD><TD> " + myrs.getString("email")+" </TD>");
		out.print("<TR><TD>Firstname :</TD><TD> " + myrs.getString("firstname")+" </TD>");
		out.print("<TR><TD>Lastname :</TD><TD> " + myrs.getString("lastname")+" </TD>");
		out.print("<TR><TD>phone :</TD><TD> " + myrs.getString("phone")+" </TD>");
		out.println("</TABLE>\n</BODY></HTML>");
		}
		/*while (myrs.next()) {
		System.out.println(myrs.getString("username")+ " " + myrs.getString("password")
		+ " " + myrs.getString("firstname")+ " " + myrs.getString("lastname"));}*/
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try {
			doMethod(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try {
			doMethod(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
