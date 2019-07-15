package ljtao.javase.javaio.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
/*
* 百度云上课程的案例
*
* */
public class C_SelectorClientTest {
    private Selector selector;
    private ByteBuffer outBuff=ByteBuffer.allocate(1024);
    private ByteBuffer inBuff=ByteBuffer.allocate(1024);
    private int keys=0;
    private SocketChannel channel=null;

    public void initClient() throws  Exception{
        channel=SocketChannel.open();
        selector=Selector.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("localhost",9010));
        channel.register(selector, SelectionKey.OP_CONNECT);
    }
    public void listen() throws Exception{
        while (true){
            keys=this.selector.select();
            if(keys==0)
                continue;
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if(key.isConnectable()){
                    SocketChannel sc = (SocketChannel)key.channel();
                    if(sc.isConnectionPending()){
                        sc.finishConnect();
                        System.out.println("完成连接");
                    }
                    sc.register(this.selector,SelectionKey.OP_WRITE);
                }
                else if(key.isWritable()){
                    SocketChannel sc = (SocketChannel)key.channel();
                    outBuff.clear();
                    System.out.println("客户端正在写数据....");
                    outBuff.put("我是clientA".getBytes());
                    outBuff.flip();
                    sc.write(outBuff);
                    sc.register(this.selector,SelectionKey.OP_READ);
                    System.out.println("客户端写数据完成");
                }
                else if(key.isReadable()){
                    SocketChannel sc = (SocketChannel)key.channel();
                    inBuff.clear();
                    System.out.println("client开始读数据：");
                    sc.read(inBuff);
                    System.out.println("==>"+new String(inBuff.array()));
                    System.out.println("client读数据结束。");
                }
            }

        }
    }
    public static void main(String[] args) {
        C_SelectorClientTest sc=new C_SelectorClientTest();
        try{
            sc.initClient();
            sc.listen();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
