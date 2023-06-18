<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
    <h2>Login Here</h2>
    <% if(request.getAttribute("msg_error")!=null) {
    	out.println(request.getAttribute("msg_error"));
    }
    %>
    <br/>
	<form action="loginServlet" method="post">
		user name<input type="text" name="emailid" /> 
		Password<input type="password" name="password" /> 
		<input type="submit" value="login" />
	</form>
</body>
</html>