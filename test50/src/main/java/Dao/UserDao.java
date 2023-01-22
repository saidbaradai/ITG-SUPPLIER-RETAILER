package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Category;
import models.User;

public class UserDao {


	public String authenticateUser(User user) {
		String userName = user.getName();
		String password = user.getPassword();

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String userNameDB = "";
		String passwordDB = "";
		String roleDB = "";

		try {
			con = DbConnection.getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select name,password,role from users");

			while (resultSet.next()) {
				userNameDB = resultSet.getString("name");
				passwordDB = resultSet.getString("password");
				roleDB = resultSet.getString("role");

				if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("admin"))
					return "Admin_Role";
				else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("retailer")) {
					System.out.println("OK its retailer...");
					return "Retailer_Role";}

			}
		} catch (SQLException e) {
			System.out.println(" its not retailer...");
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public String SaveNewUser(User user) {

		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = DbConnection.getConnection();
			statement = con.prepareStatement("INSERT INTO users (name, email, password, role) VALUES(?, ?, ?, ?);");
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getRole());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "err while saving user";
	}

	public int getUserIdByname(String username) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		int user_id = 0;

		con = DbConnection.getConnection();
		statement = con.prepareStatement("select user_id from users where name=?;");
		statement.setString(1, username);
		rs = statement.executeQuery();

		while (rs.next()) {
			user_id = rs.getInt("user_id");

		}
		return user_id;

	}

	// select user_id,name,password from users where role='admin';

	public List<User> GetSuppliersList() {
		List<User> suppliers = new ArrayList<> ();
        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select user_id,name,password from users where role='admin';");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String name = rs.getString("name");
     
                suppliers.add(new User(id,name));
            }
          } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return suppliers;

	}
	
	
	
	
	
	
	
	
	
	
	
	public String getUserNameById( int userId) throws SQLException {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String username="" ;

		con = DbConnection.getConnection();
		statement = con.prepareStatement("select name from users where user_id=?;");
		statement.setInt(1, userId);
		rs = statement.executeQuery();

		while (rs.next()) {
			username = rs.getString("name");

		}
		return username;

	}
	
	
	
	
	
	
	
	
	
	
	
	

}
