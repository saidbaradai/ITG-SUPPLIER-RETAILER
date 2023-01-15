package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
				else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("user"))
					return "User_Role";

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}
}
