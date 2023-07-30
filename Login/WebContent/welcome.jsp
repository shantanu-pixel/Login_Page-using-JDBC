<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	if(session.getAttribute("uname")==null){
		response.sendRedirect("login.jsp");
	}
%>

<h1>
Welcome, <%=session.getAttribute("uname") %>
<br>
Login Successful !!
</h1>
<br><br>
<form action=Logout.jsp>
<input type=submit value=Logout>
</body>
</html>