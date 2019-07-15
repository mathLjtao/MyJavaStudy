package ljtao.javase.javaio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
服务器读取数据的时候有分另外的一个线程来处理
对ByteBuffer缓冲区进行动态的扩大
 */
public class A_NIOServer {
    //需要去理解下面这两个是什么
    public static Charset charset =Charset.forName("UTF-8");
    public static CharsetDecoder decoder=charset.newDecoder();


    public static void main(String[] args) throws IOException {
        Selector selector =Selector.open();
        int port=9020;
        ServerSocketChannel ssc=ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(port));
        //注册到selector
        //设置非阻塞
        ssc.configureBlocking(false);
        //ssc象selector注册，监听连接到来
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        //连接的计数
        int connectionCount=0;
        //设置线程池中的线程数
        int threads=10;
        ExecutorService tpool = Executors.newFixedThreadPool(threads);
        while(true){
            //阻塞等待就绪的事件
            int readChannelsCount = selector.select();
            //因为select()阻塞可以被中断
            if(readChannelsCount==0){
                continue;
            }

            //得到就绪channel的key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator= selectionKeys.iterator();
            while (keyIterator.hasNext()){

                SelectionKey key = keyIterator.next();

                if(key.isAcceptable()){
                    //通过ServerSocketChannel获取连接
                    ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                    //接收连接
                    SocketChannel accept = channel.accept();
                    //设置非阻塞
                    accept.configureBlocking(false);
                    //让selector帮忙监测数据到了没
                    //向selector注册
                    accept.register(selector,SelectionKey.OP_READ,++connectionCount);
                }
                else if(key.isConnectable()){
                    // 与远程服务器建立了连接。
                    System.out.println("isConnectable");
                }
                else if(key.isReadable()) {
                    tpool.execute(new SocketProcess(key));
                    //取消selector注册，防止线程池处理不及时，重复处理

                    key.cancel();
                }
                else if(key.isWritable()){
                    System.out.println("write");

                    key.channel();
                }
                keyIterator.remove();
            }
        }
    }
    //创建一个线程
    static class SocketProcess implements  Runnable{
        SelectionKey key;
        SocketProcess( SelectionKey key ){
            super();
            this.key=key;
        }
        public  void run() {

            try {
                System.out.println("连接"+ key.attachment()+"发来："+readFromChannel());
                SocketChannel sc = (SocketChannel) key.channel();
                sc.write(ByteBuffer.allocate(1024).put("aa".getBytes()));
                //key.channel().close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
         String readFromChannel()throws  IOException{
            SocketChannel sc = (SocketChannel) key.channel();
            int bfsize=1024;
            //向内存要一个大小1024的空间
            ByteBuffer rbf=ByteBuffer.allocateDirect(bfsize);
            //定义一个更大的buffer
            ByteBuffer bigBf=null;
            //读的次数计数
            int count=0;
            while(sc.read(rbf)!=-1){
                count++;
                ByteBuffer temp = ByteBuffer.allocateDirect(bfsize * (count + 1));
                if(bigBf!=null){
                    //将bigBf转为读模式
                    bigBf.flip();
                    temp.put(bigBf);
                }
                bigBf=temp;
                //将这次的读到的数据存入到更大的Buffer中
                rbf.flip();
                bigBf.put(rbf);
                rbf.clear();
            }
            if (bigBf!=null){
                bigBf.flip();
                return decoder.decode(bigBf).toString();
            }
            return null;
        }
    }
}

