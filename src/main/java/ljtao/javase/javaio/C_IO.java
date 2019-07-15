package ljtao.javase.javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;


public class C_IO {
	public static void main(String[] args) throws Exception{
		fun5();
	}
	//测试用缓冲处理IO，是否提高性能,（明显提高）
	public static void fun5() throws Exception{
		int circle=100000;
		FileWriter fw=new FileWriter("d:\\student.txt");
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < circle; i++) {
			fw.write(i);
		}
		fw.close();
		System.out.println("不加缓冲耗时："+(System.currentTimeMillis()-time1));//42
		
		
		BufferedWriter fwb=new BufferedWriter(new FileWriter("d:\\student.txt"));
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < circle; i++) {
			fwb.write(i);
		}
		fwb.close();
		System.out.println("加缓冲耗时："+(System.currentTimeMillis()-time2));//9
		
	}
	//读取文件的信息，基于字节的读取
	public static void fun1() throws Exception{
		InputStream input=null;
		IOException processException = null;
		try {
			input=new FileInputStream("c:\\Users\\ljtao3\\Desktop\\record.txt");
			int data=input.read();
			while(data!=-1){
				System.out.print((char)data);
				data=input.read();
			}
			//如果出现了异常，这里不一定能关掉流，所以可以放在finally中，并且可以创建一个模板类，以便后续其他方式可以使用
			//input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			processException=e;
		}
		finally{
			String fileName="ss";
			if(input != null){
	          try {
	             input.close();
	          } catch(IOException e){
	             if(processException != null){
	                throw new Exception("processException"+e+
	                  "Error message..." + 
	                  fileName);
	             } else {
	                throw new Exception(e+
	                    "Error closing InputStream for file " +
	                    fileName);
	             }
	          }
	       }
	       if(processException != null){
	          throw new Exception("processException"+
	            "Error processing InputStream for file " +
	                fileName);
	       }
		}
	}
	//将信息写入到文件中去
	public static void fun2(){
		try {
			OutputStream out=new FileOutputStream("c:\\Users\\ljtao3\\Desktop\\record2.txt");//没有文件的话，会自建文件出来
			out.write("addda".getBytes());
			out.close();
		} catch (Exception e) {
			//
			e.printStackTrace();
		}
	}
	//基于字符的读取
	public static void fun3(){
		try {
			Reader reader=new FileReader("c:\\Users\\ljtao3\\Desktop\\record3.txt");
			int read = reader.read();
			while(read!=-1){
				System.out.print((char)read);
				read=reader.read();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void fun4(){
		try {
			Reader reader=new BufferedReader(new FileReader("c:\\Users\\ljtao3\\Desktop\\record3.txt"));
			Writer writer =new BufferedWriter(new FileWriter("c:\\Users\\ljtao3\\Desktop\\record2.txt"));
			int read = reader.read();
			while(read!=-1){
				writer.append((char)read);
				read = reader.read();
			}
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
