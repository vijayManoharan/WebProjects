package Servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Admin.DAO.UserDAO;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String OldPasswordLabel = "OldPassword";
	private static final String NewpasswordLabel = "NewPassword";
	private static final String ConfirmNewpasswordLabel = "ConfirmNewPassword";

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
		String OldPassword = (String) request.getParameter(OldPasswordLabel);
		String Newpassword = (String) request.getParameter(NewpasswordLabel);
		if (!Newpassword.equals((String) request.getParameter(ConfirmNewpasswordLabel))) {
			out.print("Password do not match<br>");
			request.getRequestDispatcher("changePasswordFail.jsp").include(request, response);
		} else {
			String reqDispatch = "changeUserPasswordSuccess.jsp";
			System.out.println("Old password : " + OldPassword);
			System.out.println("New password : " + Newpassword);
			int authCode = UserDAO.ChangePassword(OldPassword, Newpassword);

			if (authCode == -1) {
				request.getRequestDispatcher("changePasswordFail.jsp").include(request, response);
				out.print(
						"Internal error, please correct it<br>Click 'SUBMIT' to retry or 'CLOSE' to close the dialog .<br>");
			} else if (authCode == 0) {
				request.getRequestDispatcher("changePasswordFail.jsp").include(request, response);
				out.print("Authentication failed.Click 'SUBMIT' to retry or 'CLOSE' to close the dialog .<br>");
			} else {

				UserDAO.SessionUser.setPassword(Newpassword);
				request.getRequestDispatcher(reqDispatch).include(request, response);

			}
		}

		out.close();

	}

}
