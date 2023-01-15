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
import javax.servlet.http.HttpSession;



import Dao.CategoryDao;
import models.Category;


@WebServlet(urlPatterns = { 
		"/admin/index", "/admin/categories-list", "/admin/add-category",
		"/admin/delete-category","/admin/update-category",
		"/admin/save-category"})
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


		default:
			// index(request, response);
		}
	}

private void SaveCategory(HttpServletRequest request, HttpServletResponse response) {
	CategoryDao categoryDao = new CategoryDao();
	System.out.println("Huuuuuu");

	String categoryName = (String) request.getParameter("categoryName");
	int categoryId = Integer.parseInt(request.getParameter("existCategoryId"));

	Category c=null;

	try {
		c=categoryDao.getCategoryById(categoryId);
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
													Category existCategory=null;
													CategoryDao categoryDao = new CategoryDao();
													int category_id = Integer.parseInt(request.getParameter("category_id"));
											
													try {
														existCategory=categoryDao.getCategoryById(category_id);
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
		int supllier_id= Integer.parseInt(request.getSession().getAttribute("UserId").toString());
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
		int supllier_id= Integer.parseInt(request.getSession().getAttribute("UserId").toString());
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
	}

}
