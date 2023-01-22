package models;

import java.sql.Date;
import java.util.List;

public class ShoppingCard {
	private int shopping_card_id;
	private int user_id;
	private double total_amount;
	private Date created_at;
	private List<CardItem> cardItems;
	private boolean status;   // open or close 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ShoppingCard(int user_id, double total_amount, Date created_at, List<CardItem> cardItems, boolean status) {
		super();
		this.user_id = user_id;
		this.total_amount = total_amount;
		this.created_at = created_at;
		this.cardItems = cardItems;
		this.status = status;
	}
	public ShoppingCard() {
		super();
	}
	public ShoppingCard(int shopping_card_id, int user_id, double total_amount, Date created_at,
			List<CardItem> cardItems, boolean status) {
		super();
		this.shopping_card_id = shopping_card_id;
		this.user_id = user_id;
		this.total_amount = total_amount;
		this.created_at = created_at;
		this.cardItems = cardItems;
		this.status = status;
	}
	public int getShopping_card_id() {
		return shopping_card_id;
	}
	public void setShopping_card_id(int shopping_card_id) {
		this.shopping_card_id = shopping_card_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public List<CardItem> getCardItems() {
		return cardItems;
	}
	public void setCardItems(List<CardItem> cardItems) {
		this.cardItems = cardItems;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
 
}
