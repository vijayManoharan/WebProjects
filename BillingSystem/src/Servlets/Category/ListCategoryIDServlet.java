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

@WebServlet("/ListCategoryID.html")
public class ListCategoryIDServlet extends HttpServlet {
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
		out.print("<select name='ItemCategory'>");
		List<Category> categoryList = CategoryDAO.getAllCategory();
		for (Category category : categoryList) {
			out.print("<option value = '"+category.getId()+"'>"+ category.getName()+"</option>");
		}
		out.close();
	}
}
