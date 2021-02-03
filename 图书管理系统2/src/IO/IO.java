package IO;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Book.Book;
import User.TextAdministrator;
import User.TextUser;
 
public class IO {
	
	public void load(TextAdministrator mainClass){
		try {
			File file = new File("D:\\Java\\workplace\\图书管理系统2\\first\\book.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line=reader.readLine())!=null) {
				String bookname=line.split(",")[0];
				String author=line.split(",")[1];
				String guodu=line.split(",")[2];
				float price=Float.parseFloat(guodu);
				
				Book book = new Book(bookname,author,price);
				mainClass.booklist.add(book);
				mainClass.count++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save(TextAdministrator mainClass)
	{
		String allbook="";
		for(int i = 0; i < mainClass.booklist.size(); i++)
		{
			Book book = (Book)mainClass.booklist.get(i);
			String temp = book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "\r\n";
			allbook += temp;
		}
		try {
			File file1 = new File("D:\\Java\\workplace\\图书管理系统2\\first\\book.txt");
			FileWriter fw= new FileWriter(file1);
			fw.write(allbook);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void load(TextUser mainClass){
		try {
			File file = new File("D:\\Java\\workplace\\图书管理系统2\\first\\book.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line=reader.readLine())!=null) {
				String bookname=line.split(",")[0];
				String author=line.split(",")[1];
				String guodu=line.split(",")[2];
				float price=Float.parseFloat(guodu);
				
				Book book = new Book(bookname,author,price);
				mainClass.booklist.add(book);
				mainClass.count++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void save(TextUser mainClass) {
		String allbook="";
		for(int i=0;i<mainClass.booklist.size();i++) {
			Book book=(Book)mainClass.booklist.get(i);
			String temp=book.getBookname()+","+book.getAuthor()+","+book.getPrice()+"\r\n";
			allbook+=temp;
		}
		try {
			File file1=new File("D:\\Java\\workplace\\图书管理系统2\\first\\book.txt");
			FileWriter fw=new FileWriter(file1);
			fw.write(allbook);
			fw.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


