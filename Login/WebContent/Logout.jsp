<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log out</title>
</head>
<body>
<%
session.removeAttribute("uname");
session.invalidate();
%>
<h1>You have been logged out!</h1>
<a href=login.jsp>Login Again..</a>
</body>
</html>