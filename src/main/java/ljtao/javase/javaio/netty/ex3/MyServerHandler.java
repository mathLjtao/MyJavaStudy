package ljtao.javase.javaio.netty.ex3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;
import java.util.Date;

public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("服务端接受的消息 : " + msg);
        if("quit".equals(msg)){//服务端断开的条件
            ctx.close();
        }
        Date date=new Date();
        ctx.writeAndFlush(date+"\n");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端的地址："+ctx.channel().remoteAddress());
        ctx.writeAndFlush("客户端("+ InetAddress.getLocalHost().getHostName() +")成功与服务器建立连接\n");
        super.channelActive(ctx);
    }
}
