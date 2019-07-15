package ljtao.javase.javaio.aio.style1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * AsynchronousServerSocketChannel
 */
public class AIOServer implements Runnable{

    private int port = 8889;
    private int threadSize = 10;
    protected AsynchronousChannelGroup asynchronousChannelGroup;

    protected AsynchronousServerSocketChannel serverChannel;

    public AIOServer(int port, int threadSize) {
        this.port = port;
        this.threadSize = threadSize;
        init();
    }

    private void init(){
        try {
            asynchronousChannelGroup = AsynchronousChannelGroup.withCachedThreadPool(Executors.newCachedThreadPool(), 10);
            serverChannel = AsynchronousServerSocketChannel.open(asynchronousChannelGroup);
            serverChannel.bind(new InetSocketAddress(port));
            System.out.println("listening on port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try{
            if(serverChannel == null) return;
            serverChannel.accept(this,new AcceptHandler());
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        new Thread(new AIOServer(8989, 19)).start();
    }
}