package ljtao.javase.javaio.bio.ex2;
import java.net.*;
import java.io.*;
 
public class GreetingServer extends Thread
{
   private ServerSocket serverSocket;
   
   public GreetingServer(int port) throws IOException
   {
	   //设置服务端的端口号
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }
 
   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("等待远程连接,端口号为：" + serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();//获得的是 连接该主机地址的对象
            System.out.println("(server)远程主机地址：" + server.getRemoteSocketAddress());
            //从client接收的内容
            DataInputStream in = new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            //server输出的内容
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");//getLocalSocketAddress（）获取自己的地址
           // server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
	   //设置服务端的端口号
      int port = Integer.parseInt("8080");
      try
      {
         Thread t = new GreetingServer(port);
         t.start();
         //t.interrupt();//中断线程
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
