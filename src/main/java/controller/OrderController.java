package controller;

import com.google.gson.JsonObject;

import model.OrderCan;
import model.User;
import service.OrderService;

public class OrderController {
	public String canOrder(User user, OrderCan orderCan) {
		String errorMessage = null;
		String message = null;
		try {
			OrderService orderService = new OrderService();
			orderService.orderCan(user, orderCan);
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
