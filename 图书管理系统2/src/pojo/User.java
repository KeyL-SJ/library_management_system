package pojo;

import java.util.HashMap;

public class User {
	//用户民
	private String username;
	//密码
	private String password;
	
	 private HashMap<Integer, String> borrowBook = null;
	 
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 public HashMap<Integer, String> getBorrowBook() {
	        if (borrowBook == null) {
	            borrowBook = new HashMap<Integer, String>();
	            
	        }
	        return borrowBook;
	    }
}
