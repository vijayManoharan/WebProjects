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

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	User user = new User();
	private static final String oldNameLabel = "oldName";
	private static final String userLabel = "username";
	private static final String UserTypeLabel = "userType";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("user.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		User user = new User();
		PrintWriter out = response.getWriter();
		user.setName((String) request.getParameter(userLabel));
		//user.setPassword((String) request.getParameter(passwordLabel));
		// user.setId(((String) request.getParameter(UserIdLabel)));
		user.setType((String) request.getParameter(UserTypeLabel));
		
		if (UserDAO.ModifyUser(user, request.getParameter(oldNameLabel)) == 1) {
			System.out.println("User values Modified");
			out.print("User values Modified<br>");
			
			request.getRequestDispatcher("ListUser.html").forward(request, response);
			
		} else {
			out.print("Please try again");
			request.getRequestDispatcher("ModifyUser.jsp").include(request, response);

		}
		out.close();

	}
}
