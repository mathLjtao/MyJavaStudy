package ljtao.javase.javaio.bio;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9020)) {
            OutputStream out = socket.getOutputStream();
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入");
            String next=sc.nextLine();
            out.write(next.getBytes("utf-8"));
            //out.flush();




        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
