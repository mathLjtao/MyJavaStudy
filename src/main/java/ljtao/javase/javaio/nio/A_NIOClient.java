package ljtao.javase.javaio.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class A_NIOClient {
    public static Charset charset=Charset.forName("utf-8");
    public static void main(String[] args) {
        try  {
            SocketChannel sc = SocketChannel.open();
            //连接会阻塞
            boolean connect = sc.connect(new InetSocketAddress(9090));
            System.out.println("connect:"+connect);
            //写
            Scanner scanner=new Scanner(System.in);
            System.out.println("请输入：");
            String s = scanner.nextLine();
            //将一个字节数组包装到缓冲区中。
            ByteBuffer bf=ByteBuffer.wrap(s.getBytes(charset));
            while (bf.hasRemaining()){
                sc.write(bf);
            }
            //Thread.sleep(3000);
            //bf.flip();
            //int len = sc.read(bf);
            //System.out.println(new String(bf.array(),0,len));
            //通道关闭后，服务器那边才开始读取数据
            sc.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
