package Servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.*;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String userLabel = "username";
	private static final String passwordLabel = "password";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Login.html").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String username = (String) request.getParameter(userLabel);
		String password = (String) request.getParameter(passwordLabel);

		HttpSession session = request.getSession(true);
		session.setAttribute("user", username);

		int authCode = LoginValidation.validate(username, password);
		
		if (authCode == 0) {
			out.print("User Do not exist in DB<br>");
			request.getRequestDispatcher("Login.html").include(request, response);
		} else if (authCode == 1) {
			
			request.getRequestDispatcher("Login.html").include(request, response);
			out.print("incorrect password<br>");
		} else if (authCode == 2) {
			request.getRequestDispatcher("AdminLandingPage.jsp").include(request, response);
		}
		out.close();

	}

}
