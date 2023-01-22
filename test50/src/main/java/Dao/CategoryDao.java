package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Category;

public class CategoryDao {
    private static final String INSERT_CATEGORY_SQL = "INSERT INTO categories (name,supplier_id) VALUES (?,?);";
	private static final String SELECT_CATEGORY_BY_ID = "select category_id ,name from categories where category_id =?;";
    private static final String SELECT_ALL_CATEGORIES = "select * from categories where supplier_id=?";
    private static final String DELETE_CATEGORIES_SQL = "DELETE FROM categories WHERE category_id = ? ;";
    private static final String UPDATE_CATEGORIES_SQL = "update categories set name = ? where category_id = ?;";
    private static final String INSERT_USER_CATEGORY_SQL = "uINSERT INTO user_category (category_id,user_id) VALUES (22,1);";

    

    //insert category 
    public void insertCategory(Category category ) throws SQLException {
        System.out.println(INSERT_CATEGORY_SQL);
        try (Connection connection =DbConnection.getConnection();
        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getSupplier_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

        
       
        
    }
   
    									//delete category 
									    public void deleteCategory(int  id) throws SQLException {
									        System.out.println(DELETE_CATEGORIES_SQL);
									        try (Connection connection =DbConnection.getConnection();
									        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORIES_SQL)) {
									            preparedStatement.setInt(1, id);
									            System.out.println(preparedStatement);
									            preparedStatement.executeUpdate();
									        } catch (SQLException e) {
									            e.printStackTrace();
									        }
									    }
									    
	//get all categories
    public  List<Category> ListAllCategories(int supplier_id) {
        List<Category> categories = new ArrayList<> ();
        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES);) {
        	preparedStatement.setInt(1, supplier_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("name");
     
                categories.add(new Category(id,name));
            }
          } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return categories;
    }
    
    
    
    
    
    //update category 
    public void updateCategory(Category category) throws SQLException {
        System.out.println(UPDATE_CATEGORIES_SQL);
        try (Connection connection =DbConnection.getConnection();PreparedStatement 
        preparedStatement = connection.prepareStatement(UPDATE_CATEGORIES_SQL)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getCategory_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
								    
								    //get category by id
								    public Category getCategoryById(int id) throws SQLException {
								        System.out.println(SELECT_CATEGORY_BY_ID);
								        Category category=null;
								        try (Connection connection =DbConnection.getConnection();PreparedStatement 
								        preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
								            preparedStatement.setInt(1, id);
								            System.out.println(preparedStatement);
								            
								            ResultSet resultSet = preparedStatement.executeQuery();
								            
								            if (resultSet.next()) {
								                String name = resultSet.getString("name");
								                category = new Category(id, name);
								            }
								            
								            
								            preparedStatement.executeQuery();
								        } catch (SQLException e) {
								            e.printStackTrace();
								        }
								        return category;
								    }
    
    
    
    
}
