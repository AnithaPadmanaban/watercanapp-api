package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.ReserveCan;
import model.User;
import service.ReserveService;

public class ReserveController {

	public String reserveCan(User user, ReserveCan reserveCan) {
		String errorMessage = null;
		int reserveId = 0;
		try {
			ReserveService reserveService = new ReserveService();
			reserveId = reserveService.reserveCanDetail(user, reserveCan);
			if (reserveId == 0) {
				throw new Exception("Invalid");
			}

		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		String json = null;
		Gson gson = new Gson();
		if (reserveId != 0) {
			json = gson.toJson(reserveId);

		} else if (reserveId == 0) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
			json = obj.toString();
		}
		return json;
	}

	public String orderReservedCan(User user, ReserveCan reserveCan) {
		String errorMessage = null;
		String message = null;
		try {
			ReserveService reserveService = new ReserveService();
			reserveService.orderReservedCan(user, reserveCan);
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
		return obj.toString();
	}
	
	
	public String orderModifiedReservedCan(User user, ReserveCan reserveCan) {
		String errorMessage = null;
		String message = null;
		try {
			ReserveService reserveService = new ReserveService();
			reserveService.orderModifiedCan(user, reserveCan);
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
		return obj.toString();
	}

}
