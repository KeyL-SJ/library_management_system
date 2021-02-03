package dao;

import pojo.User;

public interface UserDao {
	public abstract boolean isLogin(String username,String password);
	abstract void regist(User user);
	
}
