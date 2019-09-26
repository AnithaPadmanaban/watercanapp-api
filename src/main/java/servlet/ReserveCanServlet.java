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

public class ReserveCanServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReserveCan reserveCan = new ReserveCan();

		User user = new User();
		try {
			String canReserve = request.getParameter("can");
			int can = Integer.parseInt(canReserve);

			String userIdVal = request.getParameter("userId");
			int userId = Integer.parseInt(userIdVal);

			user.setUserId(userId);
			reserveCan.setCanReserve(can);
			ReserveController reserveController = new ReserveController();
			String json = reserveController.reserveCan(user, reserveCan);
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}

	}

}
