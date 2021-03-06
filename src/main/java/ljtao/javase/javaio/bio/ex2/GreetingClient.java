package ljtao.javase.javaio.bio.ex2;

import java.net.*;
import java.io.*;
 
public class GreetingClient
{
   public static void main(String [] args)
   {
      String serverName = "localhost";
      int port = Integer.parseInt("8080");
      try
      {
         System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
         Socket client = new Socket(serverName, port);//获得的是开启这个主机的对象
         System.out.println("(client)远程主机地址：" + client.getRemoteSocketAddress());
         
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         System.out.println("服务器响应： " + in.readUTF());
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}