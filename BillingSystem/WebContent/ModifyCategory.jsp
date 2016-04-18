<%@page import="DB.Category"%>
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
	<%@ page import="DB.User"%>
	<%@ page import="DB.Admin.DAO.*"%>
	<%
		int id = Integer.parseInt(request.getParameter("categoryId"));
	%>

	<%
		Category category = fetchCategoryDB(id);
	%>

	<%!public Category fetchCategoryDB(int id) {
		Category categorytemp = new Category();
		categorytemp = CategoryDAO.fetchCategory(id);
		return categorytemp;
	}%>


	<div class="Page-title">Item Category Management</div>

	<div class="desktop-header">
		<br> <br>Modify Category record
	</div>
	<form action="ModifyCategoryServlet.html" method="post">
	<input type="hidden" name = "id" value = <%=category.getId() %>>
		<table summary="Enter the values for new Item Category">
			<tr>
				<td>New item category name</td>
				<td>:</td>
				<td><input type="text" name="categoryName" value = <%=category.getName() %>></td>
			</tr>
			<tr>
				<td>Category description</td>
				<td>:</td>
				<td><input type="text" name="categoryDesc" value = <%=category.getDesc() %>></td>
			</tr>
			<tr>
				<td><input type="submit" Value="UPDATE CATEGORY"></td>
			</tr>
		</table>
	</form>
</body>
</html>
