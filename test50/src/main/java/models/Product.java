package models;

import java.util.Locale.Category;

public class Product {
	private int product_id;
	private String name;
	private String description;
	private String photo_path;
	private double price; 
	private int stock_number;
	private boolean is_in_stock;
	private int    category_id;
	private int    supplier_id;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", description=" + description + ", photo_path="
				+ photo_path + ", price=" + price + ", stock_number=" + stock_number + ", is_in_stock=" + is_in_stock
				+ ", category_id=" + category_id + ", supplier_id=" + supplier_id + "]";
	}
	
	public Product() {
		super();
	}
	public Product(int product_id, String name, String description, String photo_path, double price, int stock_number,
			boolean is_in_stock, int category_id, int supplier_id) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.photo_path = photo_path;
		this.price = price;
		this.stock_number = stock_number;
		this.is_in_stock = is_in_stock;
		this.category_id = category_id;
		this.supplier_id = supplier_id;
	}
	public Product(String name, String description, String photo_path, double price, int stock_number,
			boolean is_in_stock, int category_id, int supplier_id) {
		super();
		this.name = name;
		this.description = description;
		this.photo_path = photo_path;
		this.price = price;
		this.stock_number = stock_number;
		this.is_in_stock = is_in_stock;
		this.category_id = category_id;
		this.supplier_id = supplier_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock_number() {
		return stock_number;
	}
	public void setStock_number(int stock_number) {
		this.stock_number = stock_number;
	}
	public boolean isIs_in_stock() {
		return is_in_stock;
	}
	public void setIs_in_stock(boolean is_in_stock) {
		this.is_in_stock = is_in_stock;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	
}
