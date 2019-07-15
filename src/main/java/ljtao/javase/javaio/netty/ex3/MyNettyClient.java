package ljtao.javase.javaio.netty.ex3;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyNettyClient {
    public static void main(String[] args) throws Exception{
        System.out.println("客户端启动...");
        Bootstrap bootstrap=new Bootstrap();
        EventLoopGroup group= new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new MyClientFilter());

        Channel ch = bootstrap.connect("127.0.0.1", 8888).sync().channel();

        String str="Hello netty!";
        ch.writeAndFlush(str+"\n");
        System.out.println("客户端发送信息："+str);

    }
}
