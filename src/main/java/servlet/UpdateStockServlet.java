package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.StockController;

public class UpdateStockServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String noOfCan=request.getParameter("canUpdate");
		int can=Integer.parseInt(noOfCan);
		
		StockController stockController= new StockController();
		String json=stockController.updateStock(can);
		PrintWriter out=  response.getWriter();
		out.write(json);
		out.flush();
		
	} 

}
