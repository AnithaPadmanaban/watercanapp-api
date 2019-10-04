package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import exception.DBException;
import model.Admin;
import service.AdminService;

public class AdminController {

	public String adminLogin(Admin admin) throws DBException {
		String errorMessage = null;

		Boolean value = false;
		try {
			AdminService adminService = new AdminService();

			value = adminService.adminLoginProcess(admin);
			if (value == false) {
				throw new DBException("Invalid Email or Password");
			}

		} catch (DBException e) {
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
