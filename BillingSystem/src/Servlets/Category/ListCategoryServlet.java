package Servlets.Category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DB.*;
import DB.Admin.DAO.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListCategory.html")
public class ListCategoryServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Category> categoryList = CategoryDAO.getAllCategory();
		out.print("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Grocery store</title></head>");
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\"></head><body>");

		out.print("<div class='Page-title'>Item Category Management</div>");

		out.print("<div class='desktop-header'><br><br>Category List</div>");
		out.print("<table border='1' width='60%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Description</th><th>Edit</th><th>Delete</th></tr>");
		for (Category category : categoryList) {
			out.print("<tr><td>" + category.getId() + "</td><td>" + category.getName() + "</td><td>"
					+ category.getDesc() + "</td><td><a href='ModifyCategory.jsp?categoryId=" + category.getId()
					+ "'>edit</a></td><td><a href='DeleteCategory?categoryId=" + category.getId()
					+ "'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.print("<ul> <li><a href='UserAccount.html'>Menu</a></li></ul>");
		out.print("<a href='AddCategory.html'>Add new category</a>");
		out.close();
	}
}
