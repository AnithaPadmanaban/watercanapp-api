package controller;

import com.google.gson.JsonObject;
import exception.DBException;
import model.StockDetails;
import service.AdminService;
import service.StockService;

public class StockController {

	public StockDetails viewStock() throws DBException {
		StockDetails stockDetails = null;
		StockService stockService = new StockService();
		try {
			stockDetails = stockService.viewAvailableStock();
		} catch (DBException e) {
			throw new DBException(e.getMessage());
		}
		return stockDetails;
	}

	public String updateStock(int can) {
		String errorMessage = null;
		String message = null;
		try {
			AdminService adminService = new AdminService();
			adminService.updateCanByAdmin(can);
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
