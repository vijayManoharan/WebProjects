package DB.Admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.*;

public class CategoryDAO {

	public static List<Category> getAllCategory() {
		List<Category> categoryList = new ArrayList<Category>();
		try {

			// here sonoo is database name, root is Categoryname and password
			Connection con = DB.DBConnection.getCon();

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM item_category");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Category newCategory = new Category();
				newCategory.setId(rs.getInt("id"));
				newCategory.setName(rs.getString("c_name"));
				newCategory.setDesc(rs.getString("description"));
				categoryList.add(newCategory);
			}
		} catch (

		Exception e) {
			System.out.println(e);
		}

		return categoryList;
	}

	public static List<Integer> getAllCategoryID() {
		List<Integer> categoryIDList = new ArrayList<Integer>();
		try {

			// here sonoo is database name, root is Categoryname and password
			Connection con = DB.DBConnection.getCon();

			PreparedStatement stmt = con.prepareStatement("SELECT id FROM item_category");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				categoryIDList.add(rs.getInt("id"));
			}
		} catch (

		Exception e) {
			System.out.println(e);
		}

		return categoryIDList;
	}

	public static int AddNewCategory(Category newCategory) {
		int result = 0;
		try {
			System.out.println("adding new Category " + newCategory.getName());
			// here sonoo is database name, root is Categoryname and password
			Connection con = DB.DBConnection.getCon();

			Statement stmt = con.createStatement();
			StringBuilder insertStmt = new StringBuilder();
			insertStmt.append("insert into item_category (c_name,Description) values (\"");
			insertStmt.append(newCategory.getName() + "\", \"");
			insertStmt.append(newCategory.getDesc() + "\")");
			result = stmt.executeUpdate(insertStmt.toString());

		} catch (

		Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static Category fetchCategory(int id) {
		Category CategoryRecord = new Category();
		try {
			Connection con = DB.DBConnection.getCon();

			PreparedStatement stmt = con.prepareStatement("select * from item_category where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;

				CategoryRecord.setId(rs.getInt("id"));
				CategoryRecord.setName(rs.getString("c_name"));
				CategoryRecord.setDesc(rs.getString("Description"));

			}
			if (count == 0) {
				System.out.println(" Category does not exist!");
				return null;
			}
		} catch (

		Exception e) {
			System.out.println(e);
		}
		return CategoryRecord;
	}

	public static int ModifyCategory(Category newCategoryValue) {
		int result = 0;
		try {
			System.out.println("Update Category record for Category id : " + newCategoryValue.getId());
			// here sonoo is database name, root is Categoryname and password
			Connection con = DB.DBConnection.getCon();

			Statement stmt = con.createStatement();
			StringBuilder UpdateStmt = new StringBuilder();
			UpdateStmt.append("UPDATE item_category set " + "c_name= \"" + newCategoryValue.getName() + "\", "
					+ "Description=\"" + newCategoryValue.getDesc() + "\" ");
			UpdateStmt.append("WHERE id = " + newCategoryValue.getId());
			result = stmt.executeUpdate(UpdateStmt.toString());

		} catch (

		Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static int DeleteCategory(int id) {

		int result = 0;
		try {
			System.out.println("Delete Category record for category id : " + id);
			// here sonoo is database name, root is Categoryname and password
			Connection con = DB.DBConnection.getCon();

			Statement stmt = con.createStatement();
			StringBuilder UpdateStmt = new StringBuilder();
			UpdateStmt.append("DELETE from item_category WHERE id = " + id);
			result = stmt.executeUpdate(UpdateStmt.toString());

		} catch (

		Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static void main(String[] args) {

		/*
		 * Category newcategory = new Category(); newcategory.setDesc(
		 * "New category Desc"); newcategory.setName("New category"); if
		 * (AddNewCategory(newcategory) == 1) System.out.println("Successful");
		 * else { System.out.println("failure"); }
		 */
		Category newcategory = new Category();
		newcategory.setId(1);
		newcategory.setDesc("Modified category Desc");
		newcategory.setName("Category1");
		System.out.println(ModifyCategory(newcategory));
	}
}
