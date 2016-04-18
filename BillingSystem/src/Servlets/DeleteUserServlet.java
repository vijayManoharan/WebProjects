package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.User;
import DB.Admin.DAO.UserDAO;
@WebServlet("/DeleteUser")
public class DeleteUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String userLabel = "username";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		User user = new User();
		PrintWriter out = response.getWriter();
		user.setName((String) request.getParameter(userLabel));

		if (UserDAO.DeleteUser(request.getParameter(userLabel)) == 1) {
			System.out.println("Deleted user");
			request.getRequestDispatcher("ListUser.html").include(request, response);
		} else {
			System.out.println("Delete user failed");
			request.getRequestDispatcher("ListUser.html").include(request, response);
		}
		out.close();
	}

}
