package ljtao.javase.javaio.nio2;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
/*
自己结合学习的知识，实现出来的
 */
public class MySelectorServerTest {
    public static void main(String[] args) {
        try{
            Selector selector =Selector.open();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(9090));
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            ByteBuffer outByte=ByteBuffer.allocate(1024);
            ByteBuffer inByte=ByteBuffer.allocate(1024);
            while(true){
                int select = selector.select();
                if(select==0)
                    continue;
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()){
                        ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                        SocketChannel accept = channel.accept();
                        outByte.clear();
                        accept.configureBlocking(false);
                        System.out.println("服务发送信息：");
                        outByte.put("server info".getBytes());
                        outByte.flip();
                        accept.write(outByte);
                        accept.register(selector,SelectionKey.OP_READ);
                    }
                    else if(key.isReadable()){
                        inByte.clear();
                        SocketChannel sc = (SocketChannel)key.channel();
                        int len = sc.read(inByte);
                        System.out.println("读取客户端发送过来的数据：");
                        System.out.println(new String(inByte.array(),0,len));

                        System.out.println("读取数据后，再向客户端发送信息：");
                        outByte.clear();
                        outByte.put("second server info".getBytes());
                        outByte.flip();
                        sc.write(outByte);
                        key.cancel();//取消在选择器上的注册，要不然会一直循环走这个，报错
                    }
                    else if(key.isWritable()){
                        System.out.println("server write");
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
