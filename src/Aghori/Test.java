package Aghori;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] recepients =new String[]{"parth11041998@gmail.com"};
		String [] bccRecepients =new String[]{"patelparthtulsibhai@gmail.com"};
		String subject ="hi";
		String name="Maulik Patel";
		String message ="this is test mail from shiva";
		
		new SendEmail1().sendMail(recepients, bccRecepients,name, subject, message);
	}

}
