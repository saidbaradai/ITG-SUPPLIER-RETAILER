package models;

public class Category {
	
	private int category_id;
	private String name;
	private int supplier_id;
	
	
	
	
	
	public int getSupplier_id() {
		return supplier_id;
	}


	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}


	public Category(String name, int supplier_id) {
		super();
		this.name = name;
		this.supplier_id = supplier_id;
	}


	public Category(String name) {
		super();
		this.name = name;
	}


	public Category(int category_id, String name) {
		super();
		this.category_id = category_id;
		this.name = name;
	}
	
	
	public Category() {
		// TODO Auto-generated constructor stub
	}


	public Category(int category_id) {
		super();
		this.category_id = category_id;
		// TODO Auto-generated constructor stub
	}


	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", name=" + name + "]";
	}
	

}
