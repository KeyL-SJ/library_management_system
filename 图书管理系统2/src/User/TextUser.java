package User;

import java.util.ArrayList;
import java.util.Scanner;

import Book.Book;
import IO.IO;

public class TextUser {
	
	public ArrayList booklist = new ArrayList();
	public int count = 0;
	public TextUser(){
		printMenu();
		while(true) {
			Scanner scan=new Scanner(System.in);
			IO io = new IO(); 
			io.load(this);
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				findBook();break;
			case 5:
				System.out.println("成功退出用户系统，欢迎再次光临");break;
				default: System.out.println("输入非法"); printMenu(); continue;
			}
		}
	}
	
	void printMenu() {
		System.out.println("--------------欢迎来到图书管理系统--------------");
		System.out.println("----------------查询图书请按1----------------");
		System.out.println("----------------退出系统请按5----------------");
	}
	
	void findBook(){
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("当前共有:"+booklist.size()+"本书");
			System.out.println("请输入按哪种方法查找图书:1序号\t2书名\t3返回主菜单");
			int choose = scan.nextInt();
			if(choose == 1){
				System.out.println("请输入要查找第几本书:");
				int number = scan.nextInt();
				int id = orderFind(number);
				if(id > -1){
					Book book = (Book)booklist.get(id);
					System.out.println("你要查找的书名为:"+book.getBookname()+"\t作者:"+book.getAuthor()+"\t单价:"+book.getPrice()+"元/本");
				}else{
					System.out.println("输入错误");
				}
			}
			else if(choose == 2){
				System.out.println("请输入您要查找的书名:");
				String name = scan.next();
				int id = nameFind(name);
				if(id > -1){
					Book book = (Book)booklist.get(id);
					System.out.println("查找成功，您查找到的书为第"+(id+1)+"本书 "+"书名为:"+book.getBookname()+"\t作者:"+book.getAuthor()+"\t单价:"+book.getPrice()+"元/本");	
				}else {
					System.out.println("未能找到该图书");
				}
			}
			else if(choose == 3){
				printMenu();
				break;
			}
			else
			{
				System.out.println("输入非法");
			}
		}
	}
	
	
	
	void printAllBook(){
		for (int i = 0; i < count; i++){
			Book book = (Book)booklist.get(i);
			System.out.println("第"+(i+1)+"本书名:"+book.getBookname()+"\t作者:"+book.getAuthor()+"\t"+"单价:"+book.getPrice()+"元/本");
		}
	}
	
	int orderFind(int number){
		if(number <= count)
		{
			int id = number - 1;
			return id;
		}
		else
		{
			return -1;
		}
	}
	
	int nameFind(String name){
		int id = -1;
		for(int i = 0; i < count; i++){
			Book book = (Book)booklist.get(i);
			if(book.getBookname().equals(name)){
				id = i;
				break;
			}
			else if(i<count) {
				continue;
			}
			else
			{
				System.out.println("未查找到您想要的书名");
				break;
			}
		}
		return id;
	}
}
