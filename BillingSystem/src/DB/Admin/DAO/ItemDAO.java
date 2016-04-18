package DB.Admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DB.Item;

public class ItemDAO {

	public static List<Item> getAllItem() {
		List<Item> UserList = new ArrayList<Item>();
		try {

			// here sonoo is database name, root is username and password
			Connection con = DB.DBConnection.getCon();

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM ITEM");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Item newItem = new Item();
				newItem.setId(rs.getInt("id"));
				newItem.setName(rs.getString("name"));
				newItem.setDescription(rs.getString("description"));
				newItem.setPrice(rs.getInt("Unit_Price"));
				newItem.setCategory(rs.getInt("Category"));

				UserList.add(newItem);
			}
		} catch (

		Exception e) {
			System.out.println(e);
		}

		return UserList;
	}

	public static int DeleteItem(int id) {

		int result = 0;
		try {
			System.out.println("Delete Item record for Item id : " + id);
			// here sonoo is database name, root is Itemname and password
			Connection con = DB.DBConnection.getCon();

			Statement stmt = con.createStatement();
			StringBuilder UpdateStmt = new StringBuilder();
			UpdateStmt.append("DELETE from item WHERE id = " + id);
			result = stmt.executeUpdate(UpdateStmt.toString());

		} catch (

		Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static int AddNewItem(Item newItem) {
		int result = 0;
		try {
			System.out.println("adding new Item " + newItem.getName());
			// here sonoo is database name, root is Categoryname and password
			Connection con = DB.DBConnection.getCon();

			Statement stmt = con.createStatement();
			StringBuilder insertStmt = new StringBuilder();
			insertStmt.append("INSERT INTO item (name, description, Unit_Price, Category) VALUES(\"");
			insertStmt.append(newItem.getName() + "\", \"" + newItem.getDescription() + "\"," + newItem.getPrice() + ","
					+ newItem.getCategory() + ")");
			result = stmt.executeUpdate(insertStmt.toString());

		} catch (

		Exception e) {
			System.out.println(e);
		}

		return result;
	}
	public static void main ( String[] args){
		/*Item newItem = new Item();
		newItem.setName("new Item 2");
		newItem.setDescription("New Item 2 Description");
		newItem.setCategory(2);
		newItem.setPrice(6);
		if(AddNewItem(newItem)==1){
			System.out.println("Item inserted");
			
		}*/
		if(DeleteItem(6)==1){
			System.out.println("Item Deleted");
			
		}
		
	}
}
