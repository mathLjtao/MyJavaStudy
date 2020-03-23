package ljtao.javase.javaio.bio.ex1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class BIOClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            OutputStream out = socket.getOutputStream();
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入");
            String next=sc.nextLine();
            out.write(next.getBytes("utf-8"));
            out.flush();
            //out.close();
            System.out.println(socket.isClosed());

        }  catch (Exception e) {
            e.printStackTrace();
        }

    }

}
