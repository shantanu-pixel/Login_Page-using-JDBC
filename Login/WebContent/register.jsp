<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align=center>
<h1>Registration</h1>
</div>
<%-- <form action="LoginRegister" method="post"> --%>
 <form action="RegisterServlet" method="post">
<%-- <form action="RegisterServlet" method="post">--%>
<table style="background-color: skyblue; margin-left: 320px; margin-left: 320px;">
<tr>
<td><h3 style="color:red;">Registration Page !!!</h3></td>
<td></td>
</tr>

<tr><td>Enter Name:</td><td><input type="text" name="name"></td></tr>
<tr><td>Enter Password:</td><td><input type="password" name="password1"></td></tr>
<tr><td>Re-Type Password:</td><td><input type=password name="password2"></td></tr>
<tr><td><input type="submit" name="submit" value="register"></td><td><input type=reset></td>
<td><a href="register.jsp">Registration</a></td></tr>
</table>

</form>

</body>
</html>