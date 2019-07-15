package ljtao.javase.javaio;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//可以通过Java IO中的PipedOutputStream和PipedInputStream创建管道。一个PipedInputStream流应该和一个PipedOutputStream流相关联。
//一个线程通过PipedOutputStream写入的数据可以被另一个线程通过相关联的PipedInputStream读取出来。
//这是一个如何将PipedInputStream和PipedOutputStream关联起来的简单例子：
public class A_pipeExemple  {
	public static void main(String[] args) throws Exception{
		final PipedOutputStream out=new PipedOutputStream();
		final PipedInputStream in=new PipedInputStream(out);
		Thread thread1=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					out.write("hello man!!".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread thread2=new Thread(new Runnable() {
			@Override
			public void run() {
				int data;
				try {
					data = in.read();
					while(data!=-1){
						System.out.println((char)data);
						data=in.read();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		thread1.start();
		thread2.start();
	}
}
