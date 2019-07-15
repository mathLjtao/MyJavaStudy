package ljtao.javase.javaio.aio.style1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

//作为接收客户端的Handler
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AIOServer> {
    final ByteBuffer echoBuffer = ByteBuffer.allocateDirect(1024);
    @Override
    public void completed(AsynchronousSocketChannel result, AIOServer attachment) {
        System.out.println("==============================================================");
        System.out.println("server process begin ...");
        try {
            System.out.println("client host: " + result.getRemoteAddress());
            echoBuffer.clear();
            result.read(echoBuffer).get();
            echoBuffer.flip();
            System.out.println("received : " + Charset.defaultCharset().decode(echoBuffer));

            int random = ThreadLocalRandom.current().nextInt(5);
            printProcess(random);
            System.out.println("server deal request execute: " + random + "s");

            String msg = "server test msg-" + Math.random();
            System.out.println("server send data: " + msg);
            result.write(ByteBuffer.wrap(msg.getBytes()));
            System.out.println("server process end ...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            attachment.serverChannel.accept(attachment, this);// 监听新的请求，递归调用。
        }
    }
    @Override
    public void failed(Throwable exc, AIOServer attachment) {
        System.out.println("received failed");
        exc.printStackTrace();
        attachment.serverChannel.accept(attachment, this);
    }
    private void printProcess(int s) throws InterruptedException {
        String dot = "";
        for (int i = 0; i < s; i++) {
            Thread.sleep(1000);
            dot += ".";
            System.out.println(dot);
        }
    }
}
