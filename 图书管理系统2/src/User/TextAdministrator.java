package User;

import java.util.ArrayList;
import java.util.Scanner;

import Book.Book;
import IO.IO;

public class TextAdministrator {

	public ArrayList booklist = new ArrayList();
	public int count = 0;
	
	public TextAdministrator() {
		
		Scanner scan = new Scanner(System.in);
		IO io = new IO(); 
		io.load(this);
		
		printMenu();
		
		while(true) {
			int choice = scan.nextInt();
		
			switch(choice) {
			case 1:
				addBook();
				io.save(this);break;
			case 2:
				deleteBook();
				io.save(this);break;
			case 3: 
				changeBook();
				io.save(this);break;
			case 4:
				findBook();
				io.save(this);break;
			case 5:
				io.save(this);
				System.out.println("成功退出管理员系统，欢迎再次光临");break;
			default: System.out.println("输入非法"); printMenu(); continue;
			}
		}
	}
	
	
	void printMenu() {
		System.out.println("--------------欢迎来到图书管理系统--------------");
		System.out.println("----------------增加图书请按1----------------");
		System.out.println("----------------删除图书请按2----------------");
		System.out.println("----------------修改图书请按3----------------");
		System.out.println("----------------查询图书请按4----------------");
		System.out.println("----------------退出系统请按5----------------");	
	}
	
	
	void printBook() {
		System.out.println("----------------增加图书请按1----------------");
		System.out.println("----------------删除图书请按2----------------");
		System.out.println("----------------修改图书请按3----------------");
		System.out.println("----------------查询图书请按4----------------");
		System.out.println("----------------退出系统请按5----------------");	
	}
	
	
	void addBook() {
		if (count > booklist.size()-1) {
			System.out.println("当前共有:"+booklist.size()+"本书");
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入图书名:");
			String bookname = scan.next();
			System.out.println("请输入作者:");
			String author = scan.next();
			System.out.println("请输入单价:");
			float price = scan.nextFloat();
			Book book = new Book(bookname,author,price);
			booklist.add(book);
			count++;
			System.out.println("增加成功");
			
			printAllBook();
			printBook();
		}
		else
		{
			System.out.println("图书库已满");
		}
		
		
	}
	
	void deleteBook()
	{
		Scanner scan = new Scanner(System.in);
		printAllBook();
		while(true)
		{
			
			System.out.println("请输入按哪种方法删除图书:1序号\t2书名\t3 返回主菜单");
			int choose = scan.nextInt();
			if(choose == 1){
				System.out.println("请输入要删除第几本书:");
				int id = scan.nextInt();
				id = orderFind(id);
				if(id > -1){
					booklist.remove(id);
					count--;
					System.out.println("删除成功");
					
					printAllBook();
				}
				else
				{
					System.out.println("输入错误");
				}
			}
			else if(choose == 2){
				System.out.println("请输入您要删除的书名:");
				String name = scan.next();
				int id = nameFind(name);
				if(id > -1){
					booklist.remove(id);
					count --;
					System.out.println("删除成功");
					printAllBook();
				}
				else
				{
					System.out.println("未查找到您想要的书名");
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
	
	void changeBook(){
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("请输入按哪种方法修改图书:1序号\t2书名\t3返回主菜单");
			int choose = scan.nextInt();
			if(choose == 1){
				System.out.println("请输入要修改第几本书:");
				int number = scan.nextInt();
				int id = orderFind(number);
				if(id > -1){
					Book book = (Book)booklist.get(id);
					System.out.println("原书名为:"+book.getBookname()+"\t作者是:"+book.getAuthor()+"\t单价是:"+book.getPrice()+"\n请输入要修改的信息"+"\n"+"1书名\t2作者\t3单价");
					int num=scan.nextInt();
					switch(num) {
					case 1:
						System.out.println("请输入书名:");
						String str = scan.next();
						book.setBookname(str);
						System.out.println("修改成功");break;
					case 2:
						System.out.println("请输入作者:");
						String author = scan.next();
						book.setAuthor(author);
						
						System.out.println("修改成功");break;
					case 3:
						
					System.out.println("请输入单价:");
					float price = scan.nextFloat();
					book.setPrice(price);
					System.out.println("修改成功");break;
					
					default:
						System.out.println("输入错误");break;
					}
					
					printAllBook();
				}
				else
				{
					System.out.println("输入错误");
				}
			}
			else if(choose == 2){
				System.out.println("请输入您要修改的书名:");
				String name = scan.next();
				int id = nameFind(name);
				if(id > -1){
					Book book = (Book)booklist.get(id);
					System.out.println("原书名为:"+book.getBookname()+" "+"作者是:"+book.getAuthor()+"\t单价是:"+book.getPrice()+"\n请输入要修改的信息"+"\n"+"1书名\t2作者\t3单价");
					int num=scan.nextInt();
					switch(num) {
					case 1:
						System.out.println("请输入书名:");
						String str = scan.next();
						book.setBookname(str);
						System.out.println("修改成功");break;
						
					case 2:
						System.out.println("请输入作者:");
						String author = scan.next();
						book.setAuthor(author);
						System.out.println("修改成功");break;
						
						
					case 3:
						System.out.println("请输入单价:");
						float price = scan.nextFloat();
						book.setPrice(price);
						System.out.println("修改成功");break;
						
					}
					
					printAllBook();		
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
				}
				else
				{
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
			System.out.println("第"+(i+1)+"本书名:"+book.getBookname()+"\t作者:"+book.getAuthor()+"\t单价:"+book.getPrice()+"元/本");
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
