package ljtao.javase.javaio.nio.basics;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class server {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(9010));
        while (true){
            SocketChannel accept = ssc.accept();
            accept.configureBlocking(false);
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            IntBuffer intBuffer = byteBuffer.asIntBuffer();


            if (accept!=null){
                System.out.print("服务器：来自客户端的数据：");
                accept.read(byteBuffer);
                System.out.println(intBuffer.get(0)+","+intBuffer.get(1));
                int sum=intBuffer.get(0)+intBuffer.get(1);
                byteBuffer.clear();

                intBuffer.put(0,sum);
                //System.out.println(intBuffer.get(0));
                accept.write(byteBuffer);
            }

        }



    }
}
