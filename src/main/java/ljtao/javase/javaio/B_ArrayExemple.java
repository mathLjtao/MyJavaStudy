package ljtao.javase.javaio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class B_ArrayExemple {
	public static void main(String[] args) {
		try {
			//将数据写入到数组中
			OutputStream outArr=new ByteArrayOutputStream();
			outArr.write("This text is converted to bytes,哈哈1".getBytes("UTF-8"));
			byte[] by=((ByteArrayOutputStream) outArr).toByteArray();
			System.out.println(by.length);
			
			InputStream in=new ByteArrayInputStream(by);
			int data =in.read();
			while(data!=-1){
				System.out.print((char)data);
				data =in.read();
			}
			
			
			outArr.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
