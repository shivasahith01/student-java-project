<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<%= msg %>
<%} %>
<form action="login2">
userName:<input type="text" name="username"><br><br>
password:<input type="password" name="pwd"><br><br>
<input type="submit">
</form>


</body>
</html>
