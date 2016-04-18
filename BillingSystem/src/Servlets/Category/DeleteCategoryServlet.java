package Servlets.Category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Category;
import DB.Admin.DAO.CategoryDAO;
@WebServlet("/DeleteCategory")
public class DeleteCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CategoryIDLabel = "categoryId";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter(CategoryIDLabel));
		response.setContentType("text/html");
		Category Category = new Category();
		PrintWriter out = response.getWriter();
		Category.setId(id);

		if (CategoryDAO.DeleteCategory(id) == 1) {
			System.out.println("Deleted Category");
			request.getRequestDispatcher("ListCategory.html").include(request, response);
		} else {
			System.out.println("Delete Category failed");
			request.getRequestDispatcher("ListCategory.html").include(request, response);
		}
		out.close();
	}

}
