package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.User;

public class LogingDao {

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
}
