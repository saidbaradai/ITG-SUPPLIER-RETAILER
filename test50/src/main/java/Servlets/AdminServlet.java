package Servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dao.CategoryDao;
import Dao.ProductDao;
import Utilties.ProjectHelper;
import models.Category;
import models.Product;

@WebServlet(urlPatterns = { "/admin/index", "/admin/categories-list", "/admin/add-category", "/admin/delete-category",
		"/admin/update-category", "/admin/save-category", "/admin/list-products", "/admin/add-new-product",
		"/admin/save-product", "/admin/delete-product","/admin/update-product","/admin/save-updated-product" })
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		switch (action) {
		case "/admin/index":
			index(request, response);
			break;
		case "/admin/categories-list":
			categoriesList(request, response);
			break;
		case "/admin/add-category":
			InsertCategory(request, response);
			break;

		case "/admin/delete-category":
			DeleteCategory(request, response);
			break;
		case "/admin/update-category":
			UpdateCategory(request, response);
			break;

		case "/admin/save-category":
			SaveCategory(request, response);
			break;

//************products 

		case "/admin/list-products":
			ProductsList(request, response);
			break;
		case "/admin/add-new-product":
			System.out.println("in swithc");
			AddNewProduct(request, response);
			break;

		case "/admin/delete-product":
			DeleteProduct(request, response);
			break;

		case "/admin/update-product":
			UpdateProduct(request, response);
			break;
	

		default:
			// index(request, response);
		}
	}

	private void SaveUpdatedProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		ProductDao productDao = new ProductDao();

		// String categoryName = (String) request.getParameter("name"); 
		int db_product_id = Integer.parseInt(request.getParameter("db_product_id"));
		String name = (String) request.getParameter("name");
		String description = (String) request.getParameter("description");
		//String photo_path = (String) request.getParameter("photo_path");
		double price = Double.valueOf(request.getParameter("price"));
		int stock_number = Integer.parseInt(request.getParameter("stock_number"));
		boolean is_in_stock = Boolean.parseBoolean(request.getParameter("is_in_stock"));
		
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		int supplier_id = Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		
		
		Part filePart=request.getPart("image");
		String photo_pathString =null;
		if(filePart==null) {
			
		 photo_pathString =(String)request.getParameter("photo_path");
		 System.out.println("bir"+photo_pathString);
		}else {
			
			photo_pathString =ProjectHelper.SingleImageUploader(request);
			System.out.println("iki"+photo_pathString);
		}
		System.out.println(photo_pathString);
		Product updatedProduct = new Product(db_product_id,name, description, photo_pathString, price, stock_number, is_in_stock, category_id,
				supplier_id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("../admin/index");
		try {
			productDao.updateProduct(updatedProduct);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private void UpdateProduct(HttpServletRequest request, HttpServletResponse response) {
		ProductDao dao=new ProductDao();
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
		
		try {
			
			Product product= dao.getProductById(product_id);
			request.setAttribute("productFromDb", product);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../admin/product-update-form.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductDao p = new ProductDao();
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		try {
			p.deleteProduct(product_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/list-products");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void SaveProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		System.out.println("OK");
		ProductDao productDao = new ProductDao();

		// String categoryName = (String) request.getParameter("name");

		String name = (String) request.getParameter("name");
		String description = (String) request.getParameter("description");
		//String photo_path = (String) request.getParameter("photo_path");
		double price = Double.valueOf(request.getParameter("price"));
		int stock_number = Integer.parseInt(request.getParameter("stock_number"));
		boolean is_in_stock = Boolean.parseBoolean(request.getParameter("is_in_stock"));
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		int supplier_id = Integer.parseInt(request.getSession().getAttribute("UserId").toString());
	
		String photo_pathString =ProjectHelper.SingleImageUploader(request);
		
		Product newProduct = new Product(name, description, photo_pathString, price, stock_number, is_in_stock, category_id,
				supplier_id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("../admin/product-form.jsp");
		try {
			productDao.insertProduct(newProduct);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		

	}

	private void AddNewProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * CategoryDao c=new CategoryDao();
		 * c.ListAllCategories(Integer.parseInt(request.getSession().getAttribute(
		 * "UserId").toString())); request.setAttribute("categories", c);
		 */

		RequestDispatcher dispatcher = request.getRequestDispatcher("../admin/product-form.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void ProductsList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDao productDao = new ProductDao();
		int supllier_id = Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		List<Product> products = productDao.ListAllProducts(supllier_id);
		//products.forEach(System.out::println);

		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/product-list.jsp");
		dispatcher.forward(request, response);

	}

	private void SaveCategory(HttpServletRequest request, HttpServletResponse response) {
		CategoryDao categoryDao = new CategoryDao();
		System.out.println("Huuuuuu");

		String categoryName = (String) request.getParameter("categoryName");
		int categoryId = Integer.parseInt(request.getParameter("existCategoryId"));

		Category c = null;

		try {
			c = categoryDao.getCategoryById(categoryId);
			c.setName(categoryName);
			c.setCategory_id(categoryId);
			categoryDao.updateCategory(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/categories-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void UpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Category existCategory = null;
		CategoryDao categoryDao = new CategoryDao();
		int category_id = Integer.parseInt(request.getParameter("category_id"));

		try {
			existCategory = categoryDao.getCategoryById(category_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("existCategory", existCategory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/categories-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void InsertCategory(HttpServletRequest request, HttpServletResponse response) {

		CategoryDao categoryDao = new CategoryDao();
		Category c = new Category();

		String categoryName = (String) request.getParameter("categoryName");
		c.setName(categoryName);
		int supllier_id = Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		c.setSupplier_id(supllier_id);

		System.out.println((String) request.getAttribute("userName"));

		try {

			categoryDao.insertCategory(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/categories-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void DeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		CategoryDao categoryDao = new CategoryDao();
		int category_id = Integer.parseInt(request.getParameter("category_id"));

		try {
			categoryDao.deleteCategory(category_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/categories-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryDao c = new CategoryDao();
		int supllier_id = Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		List<Category> categories = c.ListAllCategories(supllier_id);
		categories.forEach(System.out::println);

		request.setAttribute("categoriy", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/index.jsp");
		dispatcher.forward(request, response);

	}

	private void categoriesList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/categories-list.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String action = request.getServletPath();
		System.out.println("uploded");

		switch (action) {
		case "/admin/save-product":

			try {
				SaveProduct(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "/admin/save-updated-product":
			SaveUpdatedProduct(request, response);
			break;
			
		
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/product-list.jsp");
		dispatcher.forward(request, response);
	}

}
