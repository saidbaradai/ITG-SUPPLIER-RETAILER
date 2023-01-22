package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CardDao;
import Dao.ProductDao;
import models.CardItem;
import models.Product;
import models.ShoppingCard;

@WebServlet(urlPatterns = {"/retailer/index","/retailer/product-details",
		"/retailer/list-pruducts-by-supplier","/retailer/list-out-of-stock-pruducts",
		"/retailer/search-for-pruducts-by-name","/retailer/add-to-card","/retailer/card"})
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
			
			

		case "/retailer/add-to-card":
			try {
				AddToCard(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "/retailer/card":
			cardIndex(request, response);
			break;
			
		}
	

	}
		
		
		
	private void cardIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/retailer/card.jsp");
		dispatcher.forward(request, response);
		
	}


	
	
	private void AddToCard(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		
		ProductDao productDao=new ProductDao();
		CardItem item=new CardItem();
		
		List<CardItem> cartList = new ArrayList<>();
		if(request.getSession().getAttribute("card_list")!=null) {
			cartList=(ArrayList<CardItem>)request.getSession().getAttribute("card_list");
		}
		ShoppingCard shoppingCard=new ShoppingCard();
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Product product=productDao.getProductById(product_id);

		
		
		
		
		item.setName(product.getName());
		item.setProduct_id(product_id);
		item.setPrice(product.getPrice());
		item.setPhoto_path(product.getPhoto_path());
		item.setQuantity(quantity);
		cartList.add(item);
		
		
		shoppingCard.setCardItems(cartList);
		
		HttpSession session = request.getSession();
		session.setAttribute("card_list", cartList);
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/retailer/index.jsp");
				try {
					index(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
      }


	
	
	
/*
	private void AddToCard(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		
		CardDao cardDao=new CardDao();
		ProductDao productDao=new ProductDao();
		
		CardItem cardItem=new CardItem();
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int user_id =  Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		System.out.println("hhhhhhh: "+user_id);
		double price;
		try {
			price = productDao.getProductById(product_id).getPrice();
			cardItem.setUnit_price(price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cardItem.setProduct_id(product_id);
		cardItem.setQuantity(quantity);
		cardItem.setUser_id(user_id);
		
		System.out.println(cardItem);
		
		try {
			cardDao.insertCard(cardItem);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/retailer/index.jsp");
		try {
			index(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


*/
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
