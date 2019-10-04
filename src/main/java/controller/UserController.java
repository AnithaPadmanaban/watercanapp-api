package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import exception.DBException;
import model.User;
import service.UserService;

public class UserController {

	public String login(String email, String password) {
		String errorMessage = null;
		User user = new User();
		int userId = 0;
		try {
			UserService UserService = new UserService();
			user.setEmail(email);
			user.setPassword(password);

			userId = UserService.loginProcess(user);
			if (userId == 0) {
				throw new DBException("Invalid Email or Password");
			}

		} catch (DBException e) {
			errorMessage = e.getMessage();
		}

		String json = null;
		Gson gson = new Gson();
		if (userId != 0) {
			json = gson.toJson(userId);

		} else if (userId == 0) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
			json = obj.toString();
		}

		return json;

	}

	public String register(String name, String email, String password, String address) {
		String errorMessage = null;
		String message = null;
		User user = new User();

		try {

			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setAddress(address);
			UserService userService = new UserService();

			userService.registerProcess(user);
			message = "Success";
		} catch (DBException e) {
			errorMessage = e.getMessage();
		}
		JsonObject obj = new JsonObject();
		if (message != null) {

			obj.addProperty("message", message);
		} else if (errorMessage != null) {
			obj.addProperty("errorMessage", errorMessage);
		}
		return obj.toString();

	}
}
