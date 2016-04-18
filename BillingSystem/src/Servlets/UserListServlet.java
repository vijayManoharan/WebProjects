package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DB.*;
import DB.Admin.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListUser.html")
public class UserListServlet extends HttpServlet {
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
		List<User> userList = UserDAO.getAllUsers();
		out.print("<title>User List</title>");
		out.print("View all users");
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Privileges</th><th>Edit</th><th>Delete</th></tr>");
		for (User user : userList) {
			out.print("<tr><td>" + user.getId() + "</td><td>" + user.getName() + "</td><td>" + user.getType()
					+ "</td><td><a href='ModifyUser.jsp?username=" + user.getName()
					+ "'>edit</a></td><td><a href='DeleteUser?username=" + user.getName() + "'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.print("<ul> <li><a href='UserAccount.html'>Menu</a></li></ul>");
		out.close();
	}
}
