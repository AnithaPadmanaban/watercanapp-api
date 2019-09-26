package controller;

import com.google.gson.JsonObject;
import model.ReserveCan;
import model.User;
import service.ReserveService;

public class ReserveController {

	public String reserveCan(User user, ReserveCan reserveCan) {
		String errorMessage = null;

		String message = null;
		try {
			ReserveService reserveService = new ReserveService();
			reserveService.reserveCanDetail(user, reserveCan);
			message = "Success";

		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		JsonObject obj = new JsonObject();
		if (message != null) {
			obj.addProperty("message", message);
		} else if (errorMessage != null) {
			obj.addProperty("errorMessage", errorMessage);
		}
		//System.out.println("Return value" + obj.toString());
		return obj.toString();
	}
}
