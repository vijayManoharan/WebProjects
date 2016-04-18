package Servlets.Item;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DB.*;
import DB.Admin.DAO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListItem.html")
public class ListItemServlet extends HttpServlet {
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
		List<Item> itemList = ItemDAO.getAllItem();
		out.print("<title>Item List</title>");
		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>Id</th><th>Name</th><th>Description</th><th>Unit Price</th><th>Category</th><th>Edit</th><th>Delete</th></tr>");
		for (Item item : itemList) {
			out.print("<tr><td>" + item.getId() + "</td><td>" + item.getName() + "</td><td>" + item.getDescription()
					+ "</td><td>" + item.getPrice() + "</td><td>" + item.getCategory()
					+ "</td><td><a href='InventoryManagement.html'>edit</a></td><td><a href='DeleteItem?DeleteItemId="+item.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.print("<ul> <li><a href='InventoryManagement.html'>Menu</a></li></ul>");
		out.close();
	}
}