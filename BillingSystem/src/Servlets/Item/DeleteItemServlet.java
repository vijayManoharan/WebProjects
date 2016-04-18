package Servlets.Item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Item;
import DB.Admin.DAO.ItemDAO;
@WebServlet("/DeleteItem")
public class DeleteItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ItemIDLabel = "DeleteItemId";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter(ItemIDLabel));
		response.setContentType("text/html");
		Item Item = new Item();
		PrintWriter out = response.getWriter();
		Item.setId(id);

		if (ItemDAO.DeleteItem(id) == 1) {
			System.out.println("Deleted Item");
			request.getRequestDispatcher("InventoryManagement.html").include(request, response);
		} else {
			System.out.println("Delete Item failed");
			request.getRequestDispatcher("InventoryManagement.html").include(request, response);
			out.print("Operation Failed");
		}
		out.close();
	}

}
