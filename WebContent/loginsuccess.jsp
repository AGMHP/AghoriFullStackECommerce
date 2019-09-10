<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Aghori.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
  $( "div" ).dialog({
    modal: true,
    buttons: {
      Ok: function() {
        $( this ).dialog( "close" );
      }
    }
  });
} );
</script>
</head>
<body>
			<jsp:useBean id="myaccount2" class="Aghori.LoginBean" />

            <jsp:setProperty property="*" name="myaccount2" />

            <%
  LoginDao loginDao = new LoginDao();
   boolean status = loginDao.validate(myaccount2);
   if (status) {
           out.print("<div><h1>Success!</h1></div>");
   }
   else{
	   out.print("<div><h1>Error!!!!!</h1></div>");
   }
 %>
</body>
</html>