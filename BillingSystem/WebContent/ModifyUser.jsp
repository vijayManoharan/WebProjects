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
	<%@ page import="DB.User" %>
	<%@ page import="DB.Admin.DAO.*" %>
	<% 
		String uname =  request.getParameter("username");
		
	%>
	
	<%
	User user = fetchUserDB(uname);
	%>
	
	<%!public User fetchUserDB(String UserName) {
		User usertemp = new User();
		usertemp= UserDAO.fetchUser(UserName);
		return usertemp;
	}%>
	
	<form id="newValues" action = "UpdateUser" method="post">
	<input name="oldName" type="hidden" value= "<%=uname %>">
	<table with="50%"  >
		<tr ><td bgcolor="blue">Name</td><td><input type="text" name="username" value =<%=uname %>><br></td></tr>
		 
		 
		<tr ><td bgcolor="blue">User type  </td>
		<td>
		<select	name="userType" value = "<%=user.getType()%>">
			<option value="admin">Admin</options>
			<option value="user">User</option>
		</select></td></tr>
		 <tr ><td><input type="submit" value="SUBMIT"></td></tr>
		</table>
	</form>
	
	
	<input type="submit" value="CHANGE PASSWORD" onclick="validateAccess()" >
	
	
	<ul>
		<li><a href='UserAccount.html'>Menu</a></li>
	</ul>
<script type="text/javascript">
function validateAccess() {
	var uname = document.getElementById("newValues").elements.namedItem("oldName").value;
	
    my_window = window.open("abce","mywindow", "width=600,height=300");
    
    my_window.document.writeln("username is :" + uname);
    my_window.document.write("<form action= 'ChangeUserPassword' method = 'post' >");
    my_window.document.write("<p>Enter <br>Your Password   : <input type='password' name='UserPassword'><br><input type='hidden' name='username' value='" + uname);
    my_window.document.write("'<br> New password for User : <input type='password' name='password'><br>");
    my_window.document.write("<input type='submit' value='SUBMIT'/>");
    my_window.document.write("<input type='button' value='CLOSE'  onclick='self.close()'/></form");	
    
    popup_window.close ();
}


function closeSelf(){
    // do something

	opener.location.reload(true);
    Validate.close(); 
}

</script>


</body>
</html>





