<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "silverApples.ejb.ics.Customer" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Customer</title>
</head>
<body>
<% Customer c = (Customer)request.getAttribute("customer"); %>
 <h2>Customer:</h2>
 <p>
 <input type="text" name="txtName" value="<%= c.getCName()%>">
 </p>
 <p><%= new java.util.Date() %></p>
<form action="/SilverApplesClientProjectProject/SilverApplesServlet" method="post">
 <input type="submit" name="submit" value="Tillbaka">
 <input name="operation" value="searchcustomer" type="hidden">
</form>
</body>
</html>