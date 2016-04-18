package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.User;
import DB.Admin.DAO.UserDAO;

public class ChangeUserPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	User user = new User();
	private static final String userLabel = "username";
	private static final String passwordLabel = "password";
	private static final String accessLabel = "UserPassword";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("user.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String accessCode = request.getParameter(accessLabel);
		User user = new User();
		String reqDispatch = "changeUserPassword";
		
		System.out.println("accesscode" + accessCode);
		System.out.println("SessionUser.getPassword()" + UserDAO.SessionUser.getPassword());
		user.setName((String) request.getParameter(userLabel));
		String reqDispatch2 = ".jsp?username="+user.getName();
		if (UserDAO.SessionUser.getPassword().equals(accessCode)) {
			response.setContentType("text/html");
			
			user.setPassword((String) request.getParameter(passwordLabel));

			if (UserDAO.ChangeUserPassword(user) == 1) {
				System.out.println("User password Modified");
				/*
				 * out.print(
				 * "Password changed.<br><form><input type='button' value='CLOSE'  onclick='self.close()></form>"
				 * );
				 */
				request.getRequestDispatcher(reqDispatch + "Success" + reqDispatch2 )
						.include(request, response);
			} else {
				System.out.println(" Password Change failed.");
				
				// out.print(responsePage());
				request.getRequestDispatcher(reqDispatch + "Fail" + reqDispatch2)
						.include(request, response);
				out.print("Operation failed. Click 'SUBMIT' to retry or 'CLOSE' to close the dialog .<br>");
			}
		} else {

			System.out.println("Authentication failed.");
			
			// out.print(responsePage());
			String requestDispatchpath = reqDispatch+ "Fail" + reqDispatch2 ;
			request.getRequestDispatcher(requestDispatchpath).include(request, response);
			out.print("Authentication failed.Click 'SUBMIT' to retry or 'CLOSE' to close the dialog .<br>");
		}
		out.close();

	}

/*	private String responsePage() {
		StringBuilder result = new StringBuilder();

		result.append("this is user name <%=uname%>" + "<form action= 'ChangeUserPassword' method = 'post' >"
				+ "<p>Enter <br>Your Password   : <input type='password' name='UserPassword'><br>"
				+ "<input type='hidden' name='username' value= '<%=uname%>'"
				+ "<br> New password for User : <input type='password' name='password'><br>"
				+ "<input type='submit' value='SUBMIT'/>"
				+ "<input type='button' value='CLOSE'  onclick='self.close()'></form>");

		return result.toString();
	}*/
}
