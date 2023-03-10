package models;

public class User {
	private int user_id;
	private String name;
	private String email;
	private String password;
	private String role;
	
	
	
	
	public User(int user_id, String name) {
		super();
		this.user_id = user_id;
		this.name = name;
	}


	public User(int user_id, String name, String email, String password, String role) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	
	public User() {
		super();
	}


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}
	
	
	
}
