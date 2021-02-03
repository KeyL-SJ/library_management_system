package dao;

import pojo.Administrator;

public interface AdministratorDao {
	public abstract boolean isLogin(String administratorname,String password2);
	abstract void regist(Administrator administrator);
}
