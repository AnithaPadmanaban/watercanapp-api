package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;
import controller.StockController;
import exception.DBException;
import model.StockDetails;
import service.UserService;


public class ViewAvailabilityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	UserService userService = new UserService(); 
	StockDetails stockDetails=new StockDetails();
	StockController stockController=new StockController();
	
		try {
			stockDetails=stockController.viewStock();
		} catch (DBException e) {
			
			e.printStackTrace();
		}
	
	JsonObject obj = new JsonObject();
	obj.addProperty("availability_stock", stockDetails.getStockAvailability());
	obj.addProperty("inserted_date", stockDetails.getStockAddedDate().toString()
			);
		
        PrintWriter out = response.getWriter();
       out.println(obj.toString());
	}
	
}
