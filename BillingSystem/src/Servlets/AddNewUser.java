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
@WebServlet("/AddNewUser")
public class AddNewUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String userLabel = "username";
	private static final String passwordLabel = "password";
	private static final String UserTypeLabel = "userType";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("NewUser.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		User newUser = new User();
		PrintWriter out = response.getWriter();
		newUser.setName((String) request.getParameter(userLabel));
		newUser.setPassword((String) request.getParameter(passwordLabel));
		// newUser.setId(((String) request.getParameter(UserIdLabel)));
		newUser.setType((String) request.getParameter(UserTypeLabel));

		if (UserDAO.AddNewUser(newUser)==1) {
			System.out.println("New User added");
			out.print("New User added<br>");
			request.getRequestDispatcher("NewUser.html").include(request, response);
		} else {
			out.print("Please try again");
			request.getRequestDispatcher("NewUser.html").include(request, response);

		}
		out.close();

	}

}
