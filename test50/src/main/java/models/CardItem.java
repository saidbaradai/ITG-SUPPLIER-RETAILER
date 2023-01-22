package models;

import java.sql.Date;

public class CardItem extends Product{
	
	
	private int quantity;
	
	
	


	public CardItem() {
		super();
	}

	public CardItem(int quantity) {
		super();
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	private int cart_item_id ;
	private int user_id  ;
	private int product_id  ;
	private int quantity;
	private double unit_price;
	
	
	
	
	
	
	
	
	
	
	
	
	public CardItem() {
		super();
	}
	public CardItem(int user_id, int product_id, int quantity, double unit_price) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.unit_price = unit_price;
	}
	public CardItem(int cart_item_id, int user_id, int product_id, int quantity, double unit_price) {
		super();
		this.cart_item_id = cart_item_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.unit_price = unit_price;
	}
	public int getCart_item_id() {
		return cart_item_id;
	}
	public void setCart_item_id(int cart_item_id) {
		this.cart_item_id = cart_item_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	@Override
	public String toString() {
		return "CardItem [cart_item_id=" + cart_item_id + ", user_id=" + user_id + ", product_id=" + product_id
				+ ", quantity=" + quantity + ", unit_price=" + unit_price + "]";
	}
	
	*/
	

}
