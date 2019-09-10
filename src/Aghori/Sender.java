package Aghori;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Sender
 */
@WebServlet("/sender")
public class Sender extends HttpServlet {

	
    public void doMethod(HttpServletRequest request, HttpServletResponse response)
    {
    			String name = request.getParameter("name");
    			String email= request.getParameter("email");
    			String subject= request.getParameter("subject");
    			String message= request.getParameter("message");
    			String [] recepients =new String[]{"parth11041998@gmail.com"};
    			String [] bccRecepients =new String[]{"patelparthtulsibhai@gmail.com"};
    			
    			String messageMail = "Name : " + name + "\n Email : " + email +"\n Message : " + message;
    			
    			System.out.println(messageMail+recepients[0]+bccRecepients[0]);
    			new SendEmail1().sendMail(recepients, bccRecepients, name, subject, messageMail);
    	
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
    		doMethod(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
    		doMethod(request, response);
    }

}
