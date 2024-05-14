<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
h1 {
	color: red;
	text-transform: uppercase;
}

body {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

nav {
	background: blue;
	height: 200px;
}

nav ul {
	display: flex;
	justify-content: space-around;
	list-style: none;
	font-size: 15px;
	align-items: center;
	align-content: center;
	text-align: center;
	border: 2px solid;
	height: 50px
}
</style>
<body>
	<nav>
		<ul>
			<li><a href="userdetails.jsp">HOME</a></li>
			<li><a href="login.jsp">LOGIN</a></li>
			<li><a href="user.html">REGISTER</a></li>
		</ul>
	</nav>
	<%
	User u = (User) request.getAttribute("us");
	%>
	<p><%=u.getId()%></p>
	<p><%=u.getName()%></p>
	<p><%=u.getEmail()%></p>
	<p><%=u.getQualification()%></p>
	<p><%=u.getPhone()%></p>
	<p><%=u.getAge()%></p>
	<h1>
		HI
		<%=u.getName()%>
		WELCOME TO THE SATYA'S GLOBAL BANK
	</h1>
</body>
</html>
