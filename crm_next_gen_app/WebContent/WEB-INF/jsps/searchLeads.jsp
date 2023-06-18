<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="menu.jsp" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leads Report</title>
</head>
<body>
	<h2>Leads Report</h2>
	<table border='1'>

		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>City</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
			ResultSet results = (ResultSet)request.getAttribute("results");
			while (results.next()) {
		%>

		<tr>
			<td><%=results.getString(1) %></td>
			<td><%=results.getString(2) %></td>
			<td><%=results.getString(3) %></td>
			<td><%=results.getString(4) %></td>
			<td><%=results.getString(5) %></td>
			<td><a href="deleteServlet?emailid=<%=results.getString(3) %>">delete</a></td>
			<td><a href="updateServlet?emailid=<%=results.getString(3)%>&mobile=<%=results.getString(5)%>">update</a></td>
		</tr>


		<%
			}
		%>


	</table>
</body>
</html>