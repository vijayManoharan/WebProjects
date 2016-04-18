<%@page import="DB.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grocery Store</title>
</head>
<body>
<%String uname =  request.getParameter("username");%>

this is user name <%=uname%>
<form action= 'ChangeUserPassword' method = 'post' >
<p>Enter <br>Your Password   : <input type='password' name='UserPassword'><br>
<input type='hidden' name='username' value= '<%=uname%>'>
<br> New password for User : <input type='password' name='password'><br>
<input type='submit' value='SUBMIT'/>
<input type='button' value='CLOSE'  onclick='self.close()'></form>

</body>
</html>