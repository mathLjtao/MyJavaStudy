package ljtao.javase.javaio.bio.ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
//blocking IO
public class BIOServer {
    public static void main(String[] args) {
        int port=9020;
        try (ServerSocket ss = new ServerSocket(port)) {
            while (true){
                Socket socket=ss.accept();
                BufferedReader bd=new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("utf-8")));
                String msg=null;
                while ((msg  =bd.readLine()) !=null){
                    System.out.println(msg);
                }
                socket.close();
            }
        }catch (Exception e){

        }
    }

}
