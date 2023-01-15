package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.UserDao;
import models.User;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDao logingDao=new UserDao();
		
		
		User user=new User();
		user.setName(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		System.out.println("nice");
		logingDao.SaveNewUser(user);
		System.out.println("saved");
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
