<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lead</title>
</head>
<body>
	<h2>Update Lead</h2>
	<form action="updateServlet" method="post">
		email id<input type="text" name="emailid" value=<%=request.getAttribute("emailid") %> readonly>
		mobile<input type="text" name="mobile" value=<%=request.getAttribute("mobile") %>>
		<input type="submit" value="Update"/>
	</form>
</body>
</html>