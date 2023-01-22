package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import models.CardItem;


public class CardDao {
	private static final String INSERT_NEW_CARD_SQL="INSERT INTO card_item (`user_id`,`product_id`,`quantity`,`unit_price`) VALUES (?,?,?,?);";

	/*
	  public void insertCard(CardItem cardItem ) throws SQLException {
		  System.out.println(INSERT_NEW_CARD_SQL);
	        try (Connection connection =DbConnection.getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CARD_SQL)) {
	        	

	        	preparedStatement.setInt(1, cardItem.getUser_id());
	        	preparedStatement.setInt(2, cardItem.getProduct_id());
	        	preparedStatement.setInt(3, cardItem.getQuantity());
	        	preparedStatement.setDouble(4, cardItem.getUnit_price());

	        	   
	            System.out.println("+++++++++++++++++++++"+preparedStatement);
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        

	        
	       
	        
	    }
	*/

}
