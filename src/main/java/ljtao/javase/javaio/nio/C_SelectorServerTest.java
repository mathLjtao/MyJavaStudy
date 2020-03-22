package ljtao.javase.javaio.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
/*
学习例子
这个例子可以更好的理解NIO
 */
public class C_SelectorServerTest {
    private Selector selector ;
    private ServerSocketChannel serverChannel=null;
    private int keys=0;
    public void  initServer() throws  Exception{
        this.selector=Selector.open();
        serverChannel=ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(9010));
        serverChannel.configureBlocking(false);//设置非阻塞
        serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);

    }
    public void listen() throws Exception{
         System.out.println("服务器开始启动：");
        while (true){
            keys=selector.select();
            if (keys==0){
                System.out.println("select finished without any keys");
                continue;
            }

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if(key.isAcceptable()){
                    serverChannel = (ServerSocketChannel)key.channel();
                    SocketChannel sc=serverChannel.accept();
                    sc.configureBlocking(false);
                    System.out.println("收到新连接："+sc.getRemoteAddress());
                    sc.write(ByteBuffer.wrap("hello client.".getBytes()));
                    sc.register(this.selector,SelectionKey.OP_READ);
                }
                else if(key.isReadable()){
                    read(key);
                }
            }
        }
    }
    public void read(SelectionKey key) throws  Exception{
        SocketChannel sc=(SocketChannel)key.channel();
        ByteBuffer inBuff=ByteBuffer.allocate(1024);
        int len = sc.read(inBuff);
        System.out.println("服务器收到的信息:"+new String (inBuff.array(),0,len));
    }
    public void  start() {
        try {
            C_SelectorServerTest ss=new C_SelectorServerTest();
            ss.initServer();
            ss.listen();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new C_SelectorServerTest().start();
    }
}
