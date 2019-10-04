package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReserveCan;
import service.ReserveService;

public class OrderModifiedReservedCanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        ReserveCan reserveCan=new ReserveCan();
		String reserveCanValue= request.getParameter("can");
		int reserveCanVal = Integer.parseInt(reserveCanValue);
		String userIdVal = request.getParameter("userId");
		int userId = Integer.parseInt(userIdVal);
		String reserveIdValue= request.getParameter("reserveId");
		int reserveId= Integer.parseInt(reserveIdValue);
		reserveCan.setCanReserve(reserveCanVal);
		ReserveService reserveService = new ReserveService();
		//reserveService.
	}
}
