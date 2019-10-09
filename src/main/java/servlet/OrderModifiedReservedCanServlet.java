package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.ReserveController;
import model.ReserveCan;
import model.User;

public class OrderModifiedReservedCanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReserveCan reserveCan = new ReserveCan();
		User user = new User();
		String reserveCanValue = request.getParameter("can");
		int reserveCanVal = Integer.parseInt(reserveCanValue);
		String userIdVal = request.getParameter("userId");
		int userId = Integer.parseInt(userIdVal);
		reserveCan.setCanReserve(reserveCanVal);
		user.setUserId(userId);
		ReserveController reserveController = new ReserveController();
		String json=reserveController.orderModifiedReservedCan(user, reserveCan);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
}
