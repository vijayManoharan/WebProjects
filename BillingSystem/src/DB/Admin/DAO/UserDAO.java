package DB.Admin.DAO;

import java.sql.*;
import java.util.*;

import DB.User;

public class UserDAO {
	public static User SessionUser = new User();

	protected void finalize() {

	}

	public static int ChangePassword(String oldPassword, String newPassword) {
		try {

			System.out.println("Change password requested");
			System.out.println(" oldpassword" + oldPassword + " new password" + newPassword);

			if (oldPassword.equals(SessionUser.getPassword())) {
				// password authenticated
				Connection con = DB.DBConnection.getCon();
				Statement stmt = con.createStatement();
				String sqlUpdateStmt = "UPDATE user set password ='" + newPassword + "' WHERE user_id = "
						+ SessionUser.getId();
				int affectRowCount = stmt.executeUpdate(sqlUpdateStmt);
				System.out.println("Number of rows affected are " + affectRowCount);
				return affectRowCount;
			} else {
				System.out.println("Invalid old password");
				return 0;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return -1;
	}

	public static List<User> getAllUsers() {
		List<User> UserList = new ArrayList<User>();
		try {

			// here sonoo is database name, root is username and password
			Connection con = DB.DBConnection.getCon();

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE type = \"user\"");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User newUser = new User();
				newUser.setId(rs.getInt("user_id"));
				newUser.setName(rs.getString("username"));
				newUser.setPassword(rs.getString("password"));
				newUser.setType(rs.getString("type"));

				UserList.add(newUser);
			}
		} catch (

		Exception e) {
			System.out.println(e);
		}

		return UserList;
	}

	public static int AddNewUser(User newUser) {
		int result = 0;
		try {
			System.out.println("adding new user " + newUser.getName());
			// here sonoo is database name, root is username and password
			Connection con = DB.DBConnection.getCon();

			Statement stmt = con.createStatement();
			StringBuilder insertStmt = new StringBuilder();
			insertStmt.append("insert into user (username,password,type) values (\"");
			insertStmt.append(newUser.getName() + "\", \"");
			insertStmt.append(newUser.getPassword() + "\",  \"");
			insertStmt.append(newUser.getType() + "\")");
			result = stmt.executeUpdate(insertStmt.toString());

		} catch (

		Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static int ModifyUser(User newUserValue, String OldName) {
		int result = 0;
		try {
			System.out.println("Update user record for user id : " + OldName);
			// here sonoo is database name, root is username and password
			Connection con = DB.DBConnection.getCon();

			Statement stmt = con.createStatement();
			StringBuilder UpdateStmt = new StringBuilder();
			UpdateStmt.append("UPDATE user set " + "username = \"" + newUserValue.getName() + "\", " + "type =\""
					+ newUserValue.getType() + "\" ");
			UpdateStmt.append("WHERE username = \"" + OldName + "\"");
			UpdateStmt.append("AND type= \"user\"");
			result = stmt.executeUpdate(UpdateStmt.toString());

		} catch (

		Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static int ChangeUserPassword(User newUserValue) {
		int result = 0;
		try {
			System.out.println(
					"change password for user id :" + newUserValue.getName() + "| " + newUserValue.getPassword());
			// here sonoo is database name, root is username and password
			Connection con = DB.DBConnection.getCon();

			Statement stmt = con.createStatement();
			StringBuilder UpdateStmt = new StringBuilder();

			UpdateStmt.append("UPDATE user SET password = '" + newUserValue.getPassword() + "' WHERE username = '"
					+ newUserValue.getName() + "' AND type = 'user'");
			result = stmt.executeUpdate(UpdateStmt.toString());
			PreparedStatement ps = con
					.prepareStatement("select * from user WHERE username = 'USER2' AND type = \"USER\"");
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				++count;
				// Get data from the current row and use it
			}
			System.out.println("result " + result + " -- " + count);
		} catch (

		Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static int DeleteUser(String userName) {
		int result = 0;
		try {
			System.out.println("Delete user record for user id : " + userName);
			// here sonoo is database name, root is username and password
			Connection con = DB.DBConnection.getCon();

			Statement stmt = con.createStatement();
			StringBuilder UpdateStmt = new StringBuilder();
			UpdateStmt.append("DELETE from user WHERE username = \"" + userName + "\" AND type =\"user\"");
			result = stmt.executeUpdate(UpdateStmt.toString());

		} catch (

		Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static User fetchUser(String userName) {
		User userRecord = new User();
		try {
			Connection con = DB.DBConnection.getCon();

			PreparedStatement stmt = con.prepareStatement("select * from user where username = ?");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			int count =0;
			while(rs.next()){
				count++;

				userRecord.setId(rs.getInt("user_id"));
				userRecord.setName(rs.getString("username"));
				userRecord.setPassword(rs.getString("password"));
				userRecord.setType(rs.getString("type"));
			} 
			if(count ==0)
			{
				
				System.out.println(" User does not exist!");
				return null;
			}
		} catch (

		Exception e) {
			System.out.println(e);
		}
		return userRecord;
	}

	public static void main(String[] args) {

		User newUser = new User();
		newUser.setName("USER2");
		newUser.setPassword("password123");
		newUser.setType("user");
		System.out.println(ChangeUserPassword(newUser));

	}

}
