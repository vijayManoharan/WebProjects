package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.User;
import DB.Admin.DAO.UserDAO;

public class FetchUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String userLabel = "username";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		User user = UserDAO.fetchUser((String) request.getParameter(userLabel));
		PrintWriter out = response.getWriter();
		if (user!=null) {
			System.out.println("A record for User "+ user.getId() + " exist");
			request.getRequestDispatcher("ModifyUser.jsp").forward(request, response);
		} else {
			
			request.getRequestDispatcher("ModifyUser.html").include(request, response);
			out.print("Provided User do not exist in our database, please provide valid username");
		}
		out.close();

	}

}
