package ljtao.javase.javaio.nio2;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class MySelectorClientTest {
    public static void main(String[] args) {
        try{
            Selector selecor= Selector.open();
            SocketChannel open = SocketChannel.open();
            open.configureBlocking(false);
            open.register(selecor, SelectionKey.OP_CONNECT);
            open.connect(new InetSocketAddress("localhost",9090));
            ByteBuffer outByte= ByteBuffer.allocate(1024);
            ByteBuffer inByte=ByteBuffer.allocate(1024);
            while (true){
                int select = selecor.select();
                //if(select==0)
                    //continue;
                Iterator<SelectionKey> iterator = selecor.selectedKeys().iterator();



                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if(key.isConnectable()){
                        SocketChannel sc = (SocketChannel)key.channel();
                        if(sc.isConnectionPending()){
                            sc.finishConnect();//这里要设置完成连接，要不然下面写数据会发生异常
                            outByte.clear();
                            System.out.println("客户端向服务器发送信息：");
                            outByte.put("client info".getBytes());
                            outByte.flip();
                            sc.write(outByte);
                        }

                        sc.register(selecor,SelectionKey.OP_READ);
                    }
                    if(key.isReadable()){
                        SocketChannel sc = (SocketChannel)key.channel();
                        inByte.clear();
                        System.out.println("客户端接收数据：");
                        int len = sc.read(inByte);
                        System.out.println(new String(inByte.array(),0,len));
                        //key.cancel();
                    }
                    if(key.isWritable()){
                        System.out.println("client write");
                        key.cancel();
                    }
                }

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
