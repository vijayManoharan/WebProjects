package Servlets.Category;

import java.io.IOException;
import java.io.PrintWriter;


import DB.*;
import DB.Admin.DAO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CategoryLabel= "categoryName";
	private static final String CategoryDescLabel = "categoryDesc";
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
		Category newCategory = new Category();
		newCategory.setName((String) request.getParameter(CategoryLabel));
	
		// newCategory.setId(((String) request.getParameter(CategoryIdLabel)));
		newCategory.setDesc((String) request.getParameter(CategoryDescLabel));

		if (CategoryDAO.AddNewCategory(newCategory)==1) {
			System.out.println("New Category added");
			out.print("New Category added<br>");
			request.getRequestDispatcher("ListCategory.html").include(request, response);
		} else {
			out.print("Please try again, OPERATION FAILED ");
			request.getRequestDispatcher("AddCategory.html").include(request, response);

		}
		out.close();
	}
}
