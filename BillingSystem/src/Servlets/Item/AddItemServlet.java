package Servlets.Item;

import java.io.IOException;
import java.io.PrintWriter;


import DB.*;
import DB.Admin.DAO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ItemNameLabel= "ItemName";
	private static final String ItemDescriptionLabel = "ItemDescription";
	private static final String ItemPriceLabel = "ItemPrice";
	private static final String ItemCategoryLabel = "ItemCategory";
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
		Item newItem = new Item();
		newItem.setName((String) request.getParameter(ItemNameLabel));
		newItem.setDescription((String) request.getParameter(ItemDescriptionLabel));
		newItem.setCategory(Integer.parseInt(request.getParameter(ItemCategoryLabel)));
		newItem.setPrice(Integer.parseInt(request.getParameter(ItemPriceLabel)));
		if (ItemDAO.AddNewItem(newItem)==1) {
			System.out.println("New Item added");
			out.print("New Item added<br>");
			request.getRequestDispatcher("InventoryManagement.html").include(request, response);
		} else {
			out.print("Please try again, OPERATION FAILED ");
			request.getRequestDispatcher("AddItem.html").include(request, response);

		}
		out.close();
	}
}
