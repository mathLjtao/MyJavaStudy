package ljtao.javase.javaio.netty.ex3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyNettyServer {
    private  static EventLoopGroup group=new NioEventLoopGroup();
    public static void main(String[] args) throws Exception{
        try{
            ServerBootstrap serverBootstrap=new ServerBootstrap();

            serverBootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new MyServerFilter());
            ChannelFuture f = serverBootstrap.bind(8888).sync();
            System.out.println("服务器启动成功！！");
            f.channel().closeFuture().sync();
        }
        finally{
            group.shutdownGracefully(); ////关闭EventLoopGroup，释放掉所有资源包括创建的线程
        }

    }

}
