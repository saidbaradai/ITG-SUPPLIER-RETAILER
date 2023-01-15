package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Category;
import models.Product;

public class ProductDao {
	 private static final String INSERT_PRODUCT_SQL = "INSERT INTO products ( `name`, `description`, `photo_path`, `price`, `stock_number`, `is_in_stock`, `category_id`, `supplier_id`) VALUES (?,?,?,?,?,?,?,?)";
		//private static final String SELECT_PRODUCT_BY_ID = "select category_id ,name from categories where category_id =?;";
	    private static final String SELECT_ALL_PRODUCT = "select * from products where supplier_id=?";
	   // private static final String DELETE_PRODUCT_SQL = "DELETE FROM categories WHERE category_id = ? ;";
	   // private static final String UPDATE_PRODUCT_SQL = "update categories set name = ? where category_id = ?;";

	    

	    //insert product 
	    public void insertProduct(Product product ) throws SQLException {
	        System.out.println(INSERT_PRODUCT_SQL);
	        try (Connection connection =DbConnection.getConnection();
	        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
	            preparedStatement.setString(1, product.getName());
	            preparedStatement.setString(2, product.getDescription());
	            preparedStatement.setString(3, product.getPhoto_path());
	            preparedStatement.setDouble(4, product.getPrice());
	            preparedStatement.setInt(5, product.getStock_number());
	            preparedStatement.setBoolean(6, product.isIs_in_stock());
	            preparedStatement.setInt(7, product.getCategory_id());
	            preparedStatement.setInt(8, product.getSupplier_id());
	          
	            
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            }
	        }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		//get all products
	    public  List<Product> ListAllProducts(int supplier_id) {
	        List<Product> products = new ArrayList<> ();
	        try (Connection connection = DbConnection.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
	        	preparedStatement.setInt(1, supplier_id);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                
	                int product_id = rs.getInt("product_id");    
	                String name= rs.getString("name");        
	                String description= rs.getString("description"); 
	                String photo_path= rs.getString("photo_path"); 
	                double price= rs.getDouble("price");  
	                int stock_number  = rs.getInt("stock_number"); 
	                boolean is_in_stoc= rs.getBoolean("is_in_stock");
	                int    category_id = rs.getInt("category_id");
	                
	                
	                products.add(new Product(product_id,name,description,photo_path,price,stock_number,is_in_stoc,category_id,supplier_id));
	            }
	          } catch (SQLException e) {
	            System.out.println(e.getMessage());;
	        }
	        return products;
	    }
	    
	    
	    
	    
	    
	    
	    
}
