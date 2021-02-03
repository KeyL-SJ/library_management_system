package User;

import java.util.Scanner;

import dao.AdministratorDao;
import dao.UserDao;
import dao.impl.AdministratorDaoImpl;
import dao.impl.UserDaoImpl;
import pojo.Administrator;
import pojo.User;

public class Text {
	public static void main(String[] args) {
		while(true) {
		System.out.println("--------------欢迎光临--------------");
		System.out.println("------------用户登录请按1------------");
		System.out.println("------------用户注册请按2------------");
		System.out.println("------------管理员登录请按3------------");
		System.out.println("------------管理员注册请按4------------");
		System.out.println("--------------退出请按5--------------");
		System.out.println("请输入你的选择:");
		Scanner sc =new Scanner(System.in);
		String choiceString=sc.nextLine();
		
		 UserDao ud=new UserDaoImpl();
		 AdministratorDao ad=new AdministratorDaoImpl();
		switch(choiceString) {
		case "1":
			System.out.println("--------------用户登录界面--------------");
			System.out.println("请输入用户名");
			String username=sc.nextLine();
			System.out.println("请输入密码");
			String password=sc.nextLine();
			
			//调用登录功能
			// UserDao ud=new UserDaoImpl();
			
			boolean flag=ud.isLogin(username, password);
			if(flag) {
				System.out.println("登陆成功");
				new TextUser();
				
			}else {
				System.out.println("用户名或密码有误，登陆失败");
			}
			break; 
		case "2":
			
			System.out.println("--------------用户注册界面--------------");
			System.out.println("请输入用户名");
			String newUsername=sc.nextLine();
			System.out.println("请输入密码");
			String newUserpassword=sc.nextLine();
			
			User user=new User();
			user.setUsername(newUsername);
			user.setPassword(newUserpassword);
			
			ud.regist(user);
			System.out.println("用户注册成功");
			break;
		case "3":
			System.out.println("--------------管理员登录界面--------------");
			System.out.println("请输入用户名");
			String administratorname=sc.nextLine();
			System.out.println("请输入密码");
			String password2=sc.nextLine();
			
			boolean flag2=ad.isLogin(administratorname, password2);
			if(flag2) {
				System.out.println("管理员登陆成功");
				new TextAdministrator();
			}else {
				System.out.println("用户名或密码有误，管理员登陆失败");
			}break;
		case "4":
			
			System.out.println("--------------管理员注册界面--------------");
			System.out.println("请输入用户名");
			String newAdministratorname=sc.nextLine();
			System.out.println("请输入密码");
			String newUserpassword2=sc.nextLine();
			
			Administrator administrator=new Administrator();
			administrator.setAdministratorname(newAdministratorname);
			administrator.setPassword2(newUserpassword2);
			
			ad.regist(administrator);
			System.out.println("管理员注册成功");
			break;
		case"5":
		default:
			System.out.println("谢谢使用，欢迎下次再来");
			System.exit(0);
			break;
		}
	}
	}
}
