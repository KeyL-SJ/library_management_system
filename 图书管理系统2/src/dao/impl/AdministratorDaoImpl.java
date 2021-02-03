package dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dao.AdministratorDao;
import pojo.Administrator;


public class AdministratorDaoImpl implements AdministratorDao {
	private static File file =new File ("Administrator.txt");
	static {
		try { 
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("创建文件失败");
		}
		
	}
	public boolean isLogin(String administratorname, String password2) {
		boolean flag2=false;
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(file));
			String line =br.readLine();
			while((line=br.readLine())!=null) {
				String[] datas=line.split("=");
				if(datas[0].equals(administratorname)&&datas[1].equals(password2)) {
					flag2=true;
					break;
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("管理员登录找不到信息所在的文件");
		}catch(IOException e) {
			System.out.println("管理员登录失败");
//			e.printStackTrace();
		}finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
//					e.printStackTrace();
					System.out.println("管理员登录资源释放失败");
				}
			}
		}
		return flag2;
	}

	@Override
	public void regist(Administrator administrator) {
		
		BufferedWriter bw=null;
		try {
			//为了保证数据是追加写入，必须加true
		bw=new BufferedWriter(new FileWriter(file,true));
		bw.write(administrator.getAdministratorname()+"="+administrator.getPassword2());
		bw.newLine();
		bw.flush(); 
		
	}catch(IOException e) {
		System.out.println("管理员注册失败");
	}finally {
		if(bw!=null) {
			try {
			bw.close();
			}catch (IOException e) {
				System.out.println("管理员注册释放资源失败");
			}
		}
	}
	}
}
