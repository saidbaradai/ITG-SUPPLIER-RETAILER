package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDao;
import models.Product;

@WebServlet(urlPatterns = {"/retailer/index","/retailer/product-details",
		"/retailer/list-pruducts-by-supplier","/retailer/list-out-of-stock-pruducts",
		"/retailer/search-for-pruducts-by-name"})
public class RetailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getServletPath();
		System.out.println(action);

		switch (action) {
		case "/retailer/index":
			index(request, response);
			break;
			
			
		case "/retailer/product-details":
			productDetails(request, response);
			break;	
			
		case "/retailer/list-pruducts-by-supplier":
			ListProductsBySupplier(request, response);
			break;
			
		case "/retailer/list-out-of-stock-pruducts":
			ListOutOfStockProductsr(request, response);
			break;	
			
		case "/retailer/search-for-pruducts-by-name":
			SearchForProductsByName(request, response);
			break;	
		}
	

	}
		
		
		
	private void SearchForProductsByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductDao productDao = new ProductDao();
		String name_for_search = (String)request.getParameter("name_for_search");
		System.out.println("name_for_search "+name_for_search);
		List<Product> products = productDao.ListAllProductsByname(name_for_search);
		

		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/retailer/index.jsp");
		dispatcher.forward(request, response);
		
	}



	


	
	
	
	
	
	
	
	private void ListOutOfStockProductsr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductDao productDao = new ProductDao();
		//int supllier_id = Integer.parseInt(request.getParameter("supplier_id"));
		List<Product> products = productDao.ListAllOutOfStockProducts();
		

		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/retailer/index.jsp");
		dispatcher.forward(request, response);
		
	}









	private void ListProductsBySupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductDao productDao = new ProductDao();
		int supllier_id = Integer.parseInt(request.getParameter("supplier_id"));
		List<Product> products = productDao.ListAllAvalibaleProductsBySUpplierId(supllier_id);
		

		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/retailer/index.jsp");
		dispatcher.forward(request, response);
		
	}









	private void productDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			ProductDao dao=new ProductDao();
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			
			
			try {
				
				Product product= dao.getProductById(product_id);
				request.setAttribute("productFromDb", product);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/retailer/product-details.jsp");
		dispatcher.forward(request, response);
		
	}









	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		//int supllier_id = Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		List<Product> products = productDao.ListAllAvalibaleProducts();
		

		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/retailer/index.jsp");
		dispatcher.forward(request, response);
		
	}









	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
