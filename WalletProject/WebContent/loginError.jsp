<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>

	<form action="/WalletProject/index.html" method="post">

		<p style="color: red">
			<%
				out.println(session.getAttribute("ErrorMessage"));
			%>
		</p>

		<button name="goBack">Go Back!</button>
	</form>
</body>
</html>