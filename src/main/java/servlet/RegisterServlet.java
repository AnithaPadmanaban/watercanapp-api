package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.UserController;
import model.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	UserController userController = new UserController();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");

		String json = userController.register(name, email, password, address);

		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();

	}

}
