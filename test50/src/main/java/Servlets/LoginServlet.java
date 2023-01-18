package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("From login doGet");
	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 int userId;
		 String userName = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 
		 User user = new User();
		 
		// System.out.println(userName);
		 
		 user.setName(userName);
		 user.setPassword(password);
		 UserDao userDao=new UserDao();
		 

		
	
		
		
		 try
		    {
		        String userValidate = userDao.authenticateUser(user);
		        
		       
		        if(userValidate.equals("Admin_Role"))
		        {
		            System.out.println("Admin's Home");
		 
		            HttpSession session = request.getSession(); //Creating a session
		            session.setAttribute("userName", userName); //setting session attribute
		            //request.setAttribute("userName", userName);
		            session.setAttribute("role", userValidate); //I used this in filters
		            userId = userDao.getUserIdByname(userName);
					session.setAttribute("UserId",userId);

		            request.getRequestDispatcher("/admin/index.jsp").forward(request, response); 
		        } 
		      
		        else if(userValidate.equals("User_Role"))
		        {
		            System.out.println("User's Home");
		 
		            HttpSession session = request.getSession();
		            session.setMaxInactiveInterval(10*60);
		            session.setAttribute("UserName", userName);
		            //session.setAttribute("UserId",);
		            //request.setAttribute("userName", userName);
		            userId = userDao.getUserIdByname(userName);
					session.setAttribute("UserId",userId);
		            session.setAttribute("role", userValidate); //I used this in filters
		 
		            request.getRequestDispatcher("/user/user-home.jsp").forward(request, response); 
		        }
		        else
		        {
		        	
		            System.out.println("Error message = "+userValidate);
		            
		            request.setAttribute("SigninErrMessage", userValidate);
		            
		         
//need some validation code

		 
		            request.getRequestDispatcher("/login.jsp").forward(request, response);
		        }
		    }
		    catch (IOException e1)
		    {
		        e1.printStackTrace();
		    }
		    catch (Exception e2)
		    {
		        e2.printStackTrace();
		    }
		
		
		
		//doGet(request, response);
	}

}



