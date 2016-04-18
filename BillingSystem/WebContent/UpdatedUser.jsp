<%@page import="DB.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify User</title>
</head>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<link rel="stylesheet" type="text/css" href="main.css">
<script src="jsFile.js"></script>
<body>
		<div class="Page-title">Item Category Management</div>

	<div class="desktop-header">Modify User record</div>	
	<%@ page import="DB.Admin.DAO.*" %>
	<%@ page import="DB.User" %>
	
	<%
		String uname =  request.getParameter("username");
		
	%>
	
	<%
	User user = fetchUserDB(uname);
	%>
	<%!public User fetchUserDB(String UserName) {
		return UserDAO.fetchUser(UserName);
		
	}%>
	<form id = "someform"></form>
		User Name : <%=user.getName()%><br>
		Password :<%=user.getPassword()%><br>
		Type : <%=user.getType()%>
	</form><br>
	  
	<ul>
		<li><a href='UserAccount.html'>Menu</a></li>
	</ul>

	

</body>
</html>