package ljtao.javase.javaio.nio.basics;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;

public class client {
    public static void main(String[] args) throws Exception{
        SocketChannel open = SocketChannel.open(new InetSocketAddress("localhost",9010));
        open.configureBlocking(false);
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(0,45);
        intBuffer.put(1,55);
        //System.out.println(byteBuffer.get());
        open.write(byteBuffer);
        byteBuffer.clear();
        System.out.println("服务端返回结果：");
        open.read(byteBuffer);
        System.out.println(byteBuffer.get(0));
        int read;
        while((read=intBuffer.get())!=-1){
            System.out.println(read);
        }
        open.close();
    }
}
