<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Leads</title>
</head>
<body>
<h2>Click here to logout</h2>
<form action="logOutServlet" method="post">
	<input type="submit" value="logout"/>
</form>

<h2>Enter the customer details</h2>

<%if(request.getAttribute("msg_leads")!=null){
	out.println(request.getAttribute("msg_leads"));
}

%>

<br/>

<form action="createLeadServlet" method="post">
<pre>
	First Name <input type="text" name="firstname"/>
	Last Name <input type="text" name="lastname"/>
	Email Id <input type="text" name="emailid"/>
	Mobile <input type="text" name="mobile"/>
	city <input type="text" name="city"/>
	<input type="submit" value="save"/>
</pre>
</form>



</body>
</html>