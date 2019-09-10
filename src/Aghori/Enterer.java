package Aghori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

	
public class Enterer {
	
		
		public static void insertRecord(String email, String firstname, String lastname,String phone, String password, Connection conn)
		{
			
			PreparedStatement stmt  =null;
			
			
			try {
				
				stmt =conn.prepareStatement("insert into USER_INFO (EMAIL,FIRSTNAME,LASTNAME, PHONE, PASSWORD)values (?,?,?,?,?)");
				
				stmt.setString(1, email);
				stmt.setString(2, firstname);
				stmt.setString(3, lastname);
				stmt.setString(4, phone);
				stmt.setString(5, password);
				stmt.executeUpdate();
				stmt.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				
				try{
					stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		public static Connection DbConnection() throws SQLException, ClassNotFoundException
		{
				Connection conn = null;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","system","Parth@1104");
				return conn;
				
		}
		/*public static void main(String args[]) throws ClassNotFoundException, SQLException {
			
			Connection con = EntryCreator.DbConnection("project");
			EntryCreator.insertRecord("Maulik", "Pass", "Maulikkumar", "Patel", con);
			
		}*/
		
			
			
}




