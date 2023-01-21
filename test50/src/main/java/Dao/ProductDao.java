package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Category;
import models.Product;

public class ProductDao {
	 private static final String INSERT_PRODUCT_SQL = "INSERT INTO products ( `name`, `description`, `photo_path`, `price`, `stock_number`, `is_in_stock`, `category_id`, `supplier_id`) VALUES (?,?,?,?,?,?,?,?)";
		private static final String SELECT_PRODUCT_BY_ID = "select `product_id`,`name`, `description`, `photo_path`, `price`, `stock_number`, `is_in_stock`, `category_id`, `supplier_id` FROM products where product_id=?;";
	    private static final String SELECT_ALL_AVALIBALE_PRODUCT_BY_SUPPLIER_ID = "select * from products where supplier_id=? and is_in_stock=1";
	    private static final String SELECT_ALL_PRODUCT_BY_SUPPLIER_ID = "select * from products where supplier_id=?";

	    private static final String SELECT_ALL_AVALIBALE_PRODUCT = "select * from products where is_in_stock=1;";
	    //SELECT_ALL_OUT_OF_STOCK_PRODUCT
	    private static final String SELECT_ALL_OUT_OF_STOCK_PRODUCT = "select * from products where is_in_stock=0;";
	    private static final String SELECT_ALL_PRODUCTS_BY_NAME = "select * from products where name like ?;";

	    private static final String SELECT_ALL_PRODUCT = "select * from products";

	    private static final String DELETE_PRODUCT_SQL = "DELETE FROM products WHERE product_id = ? ;";
	    private static final String UPDATE_PRODUCT_SQL = "update products set name = ?,description= ?,photo_path= ?,price= ?,stock_number= ?, is_in_stock= ?, category_id= ? where product_id = ?;";

	    

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
	    
	
	    
	    
	    
												//get all products by supplier id
											    public  List<Product> ListAllProducts(int supplier_id) {
											        List<Product> products = new ArrayList<> ();
											        try (Connection connection = DbConnection.getConnection();
											            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_BY_SUPPLIER_ID);) {
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
											    
											    
	    
  //delete product 
    public void deleteProduct(int  product_id) throws SQLException {
        System.out.println(DELETE_PRODUCT_SQL);
        try (Connection connection =DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            preparedStatement.setInt(1, product_id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	    
	



		
	public void updateProduct(Product product) {
		 System.out.println(UPDATE_PRODUCT_SQL);
		 try (Connection connection =DbConnection.getConnection();
			        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
			 		int inStock = product.isIs_in_stock() ? 1 : 0;
		            preparedStatement.setString(1, product.getName());
		            preparedStatement.setString(2, product.getDescription());
		            preparedStatement.setString(3, product.getPhoto_path());
		            preparedStatement.setDouble(4, product.getPrice());
		            preparedStatement.setInt(5, product.getStock_number());
		            preparedStatement.setInt(6, inStock);
		            preparedStatement.setInt(7, product.getCategory_id());
		            preparedStatement.setInt(8, product.getProduct_id());
		            
			            System.out.println(preparedStatement);
			            preparedStatement.executeUpdate();
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
		
		
	}


	
	
	
	public Product getProductById(int product_id) throws SQLException {
        System.out.println(SELECT_PRODUCT_BY_ID);
        Product product=null;
        try (Connection connection =DbConnection.getConnection();PreparedStatement 
        preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1,product_id);
            System.out.println(preparedStatement);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
            	int id = rs.getInt("product_id");    
                String name= rs.getString("name");        
                String description= rs.getString("description"); 
                String photo_path= rs.getString("photo_path"); 
                double price= rs.getDouble("price");  
                int stock_number  = rs.getInt("stock_number"); 
                boolean is_in_stoc= rs.getBoolean("is_in_stock");
                int    category_id = rs.getInt("category_id");
                int    supplier_id = rs.getInt("supplier_id");
                product=new Product(id,name,description,photo_path,price,stock_number,is_in_stoc,category_id,supplier_id);
            }
            
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
	
	
	
	
	
	
	
	
	
	
	
	//get all products by supplier id
    public  List<Product> ListAllProductsForRetailer() {
        List<Product> products = new ArrayList<> ();
        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            
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
                int    supplier_id = rs.getInt("supplier_id");
                
                
                products.add(new Product(product_id,name,description,photo_path,price,stock_number,is_in_stoc,category_id,supplier_id));
            }
          } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return products;
    }
	
	
	
	
	
	
	
	//SELECT COUNT(product_id) AS recordCount FROM products WHERE  supplier_id=?;
	
    public  int GetProductNumberBySupplierId(int supplier_id) {
    	System.out.println(supplier_id+"  supplier_id");
    	
    	int count=0;
    	 try (Connection connection = DbConnection.getConnection();
    	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(product_id) AS recordCount FROM products WHERE  supplier_id=? AND is_in_stock=1");) {
    	        	preparedStatement.setInt(1, supplier_id);
    	            ResultSet rs = preparedStatement.executeQuery();
    	            while (rs.next()) {
    	            	count = rs.getInt("recordCount"); 
    	            }
        }
		  catch (SQLException e) {
		      System.out.println(e.getMessage());;
		  }
	
        
        
        
        
        return count;
        
        
        

    }
    

    
    
    
    
    
    
    
    
    
  //get all products by supplier id
    public  List<Product> ListAllAvalibaleProducts() {
        List<Product> products = new ArrayList<> ();
        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AVALIBALE_PRODUCT);) {
        	//preparedStatement.setInt(1, supplier_id);
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
                int    supplier_id = rs.getInt("supplier_id");
                
                
                products.add(new Product(product_id,name,description,photo_path,price,stock_number,is_in_stoc,category_id,supplier_id));
            }
          } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return products;
    }









  //get all products by supplier id
    public  List<Product> ListAllAvalibaleProductsBySUpplierId(int supplier_id) {
        List<Product> products = new ArrayList<> ();
        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AVALIBALE_PRODUCT_BY_SUPPLIER_ID);) {
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








  //get all products out of stock
    public  List<Product> ListAllOutOfStockProducts() {
        List<Product> products = new ArrayList<> ();
        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_OUT_OF_STOCK_PRODUCT);) {
            
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
                int    supplier_id = rs.getInt("supplier_id");
                
                
                products.add(new Product(product_id,name,description,photo_path,price,stock_number,is_in_stoc,category_id,supplier_id));
            }
          } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return products;
    }


    
    //SELECT_ALL_PRODUCTS_BY_NAME

  //get all products by name
    public  List<Product> ListAllProductsByname(String name_for_search) {
        List<Product> products = new ArrayList<> ();
        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_BY_NAME);) {
        	System.out.println(SELECT_ALL_PRODUCTS_BY_NAME);
        	preparedStatement.setString(1, "%"+name_for_search+"%");
        	System.out.println(SELECT_ALL_PRODUCTS_BY_NAME);
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
                int    supplier_id = rs.getInt("supplier_id");
                
                
                products.add(new Product(product_id,name,description,photo_path,price,stock_number,is_in_stoc,category_id,supplier_id));
            }
          } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return products;
    }
}
