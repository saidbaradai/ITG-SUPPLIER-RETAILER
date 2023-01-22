package API;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import Dao.ProductDao;
import models.Product;

/**
 * Servlet implementation class productsAPI
 */
@WebServlet("/api/all-product")
public class productsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		switch (action) {
		case "/api/all-product":
			ListAllProductsAPI(request, response);
			break;

			
		}
	}

	
	
	
	
	
	
	
	
	
	
	private void ListAllProductsAPI(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		ProductDao productDao=new ProductDao();
		System.out.println("HELLo");
		products=productDao.ListAllProductsForRetailer();
		
		Gson mapper = new Gson();

		String jsonString = mapper.toJson(products);
		System.out.println(jsonString);
        response.setContentType("application/json");
        // Write the JSON string to the response
        response.getWriter().write(jsonString);
        
       
	}

	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}
}
