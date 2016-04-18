package Servlets.Category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Category;
import DB.User;
import DB.Admin.DAO.*;

@WebServlet("/ModifyCategoryServlet.html")
public class ModifyCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	User user = new User();
	private static final String CategoryNameLabel = "categoryName";
	private static final String DescriptionLabel = "categoryDesc";
	private static final String IdLabel = "id";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("user.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		Category category = new Category();
		PrintWriter out = response.getWriter();
		category.setId(Integer.parseInt(request.getParameter(IdLabel)));
		category.setName((String) request.getParameter(CategoryNameLabel));
		category.setDesc((String) request.getParameter(DescriptionLabel));

		if (CategoryDAO.ModifyCategory(category) == 1) {
			System.out.println("User values Modified");
			out.print("User values Modified<br>");

			request.getRequestDispatcher("ListCategory.html").forward(request, response);

		} else {
			out.print("Please try again");
			request.getRequestDispatcher("ModifyCategory.jsp").include(request, response);

		}
		out.close();

	}
}
