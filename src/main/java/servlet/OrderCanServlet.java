package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.OrderController;
import model.OrderCan;
import model.User;

public class OrderCanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderCan orderCan = new OrderCan();
		User user = new User();

		String canOrder = request.getParameter("can");
		int can = Integer.parseInt(canOrder);
		String userIdVal = request.getParameter("userId");
		int userId = Integer.parseInt(userIdVal);
		System.out.println("can");
		user.setUserId(userId);
		orderCan.setCanOrder(can);
		OrderController OrderController = new OrderController();
		String json = OrderController.canOrder(user, orderCan);
		System.out.println("Servlet response" + json);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
}
