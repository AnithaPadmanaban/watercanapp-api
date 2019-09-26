package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.UserController;
import loggerUtil.Logger;
import model.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// public static final Logger logger = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		User user = new User();
		user.setEmail(userEmail);
		user.setPassword(userPassword);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		UserController userController = new UserController();
		String userValue = userController.login(userEmail, userPassword);
		HttpSession session = request.getSession();
		session.setAttribute("USER_ID", userValue);
		out.write(userValue);
		out.flush();
	}
}
