package DB;

import java.sql.*;

import DB.Admin.DAO.UserDAO;

public class LoginValidation {

	private static final String userIdLable = "user_id";
	private static final String userLabel = "username";
	private static final String passwordLabel = "password";
	private static final String priviledgeLabel = "type";

	private static void initalizeUserData(String user) {

		try {
			Connection con = DBConnection.getCon();
			// here sonoo is database name, root is username and password

			PreparedStatement stmt = con.prepareStatement("select * from user where username = ?");
			stmt.setString(1, user);

			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
				System.out.println("no data");
			} else {
				System.out.println("values are set here id =" + rs.getInt(userIdLable));
				UserDAO.SessionUser.setId(rs.getInt(userIdLable));
				System.out.println("id set");
				UserDAO.SessionUser.setName(rs.getString(userLabel));
				UserDAO.SessionUser.setPassword(rs.getString(passwordLabel));
				UserDAO.SessionUser.setType(rs.getString(priviledgeLabel));
				System.out.println("Session user set");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static int validate(String user, String pwd) {
		initalizeUserData(user);
		System.out.println("user is " + user);
		System.out.println(UserDAO.SessionUser.getName());
		if (UserDAO.SessionUser.getName().equals(user)) {
			if (UserDAO.SessionUser.getPassword().equals(pwd)) {

				return 2;
			} else
				return 1;
		}

		return 0;
	}

	/*
	 * public static void main(String[] args){ LoginValidation.validate("admin",
	 * "admin123"); System.out.println("user "+ LoginValidation.userName);
	 * System.out.println("password "+ LoginValidation.password);
	 * System.out.println("priviledge "+ LoginValidation.priviledge ); }
	 */
}
