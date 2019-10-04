package controller;

import com.google.gson.JsonObject;

import exception.DBException;
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

		} catch (DBException e) {
			errorMessage = e.getMessage();
		}
		JsonObject obj = new JsonObject();
		if (message != null) {

			obj.addProperty("message", message);
		} else if (errorMessage!= null) {
			obj.addProperty("errorMessage", errorMessage);
		}
	
		return obj.toString();
	}
}
