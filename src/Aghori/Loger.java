package Aghori;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Loger")
public class Loger extends HttpServlet {
	
	public void doMethod(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException
	{

		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Parth@1104");
		String user = request.getParameter("email");
		String pass = request.getParameter("password");
		
		Statement myst = conn.createStatement();
		ResultSet query = myst.executeQuery("select * from user_info where email="+user);
		String check = query.getString("password");
		if(pass == check)
		{
			
			System.out.print(query.getString("password") + " "+ pass);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String docType = "<!DOCTYPE HTML>\n"; 
					
					String title = "Reading All Request Parameters"; 
					
					out.println(docType
							+ "<HTML>\n" + 
							"<HEAD><TITLE>"+title + 
							"</TITLE>"
							+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\"></HEAD>\n"+ 
							"<BODY BGCOLOR=\"#b3ffff\">\n");
			//String Check =query.getString("Password"); 	
			out.println("<H1 ALIGN=CENTER>" + query.getString("Firstname") + "</H1>\n</BODY></HTML>");
		}
		else {
			response.sendRedirect("loginsample.html");
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doMethod(request,response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doMethod(request,response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
