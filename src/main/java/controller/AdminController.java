package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.Admin;
import model.User;
import service.AdminService;
import service.UserService;

public class AdminController {

	public String adminLogin(Admin admin) {
		String errorMessage = null;

		Boolean value = false;
		try {
			AdminService adminService = new AdminService();

			value = adminService.adminLoginProcess(admin);
			if (value == false) {
				throw new Exception("Invalid Email or Password");
			}

		} catch (Exception e) {
			errorMessage = e.getMessage();
		}

		String json = null;
		Gson gson = new Gson();
		if (value != false) {
			json = gson.toJson(value);

		} else if (value == false) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
			json = obj.toString();
		}

		return json;
	}

}
