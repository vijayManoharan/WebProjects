package DB;

import java.sql.*;

public class DBConnection {
	static Connection con = null;

	public static void setCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_system", "root", "vijay");
			System.out.println("Connecting to DB");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getCon() {
		if (con == null) {
			setCon();
		}
		return con;
	}

	public static void closeCon() {
		try {
			con.close();
			System.out.println("DB connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void finalize() {
		closeCon();
	}
}
