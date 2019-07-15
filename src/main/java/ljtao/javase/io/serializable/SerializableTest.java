package ljtao.javase.io.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SerializableTest {
	public static void main(String[] args) {
		write();
		read();
	}
	public static void write(){
		Student stu=new Student("哈哈",21,"女");
		try {
			ObjectOutputStream out=new 	ObjectOutputStream(new FileOutputStream("d:\\student.txt"));
			out.writeObject(stu);//如果Student 没继承 Serializable，这里会报错
			//out.writeBytes(stu.getName()); 这个就不会，应该String本身就有继承 Serializable
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void read(){
		ObjectInputStream in;
		int i=-1;
		try {
			in=new ObjectInputStream(new FileInputStream("d:\\student.txt"));
			Student stu = (Student)in.readObject();
			System.out.println(stu.getName()+","+stu.getAge()+","+stu.getSex()+","+stu.countryName);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
	}
}
