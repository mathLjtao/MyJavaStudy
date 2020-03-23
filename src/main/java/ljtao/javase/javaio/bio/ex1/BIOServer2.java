package ljtao.javase.javaio.bio.ex1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ljtao
 * @date 2020/3/21
 * 可以返回http内容的服务端
 */
public class BIOServer2 {
    public static void main(String[] args) throws Exception {
        ExecutorService executors=Executors.newCachedThreadPool();
        ServerSocket ss=new ServerSocket(8080);
        System.out.println("服务器启动");
        while(!ss.isClosed()){
            Socket request = ss.accept();
            executors.execute(()->{
                try {
                    InputStream inputStream = request.getInputStream();
                    System.out.println("收到请求:");
                    BufferedReader bd=new BufferedReader(new InputStreamReader(inputStream, Charset.forName("utf-8")));
                    String msg=null;
                    while ((msg=bd.readLine())!=null){
                        if(msg.length()==0){
                            break;
                        }
                        System.out.println(msg);
                    }
                    //响应结果
                    OutputStream outputStream = request.getOutputStream();
                    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                    outputStream.write("Content-Length: 11\r\n\r\n".getBytes());
                    outputStream.write("Hello World".getBytes());
                    outputStream.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
