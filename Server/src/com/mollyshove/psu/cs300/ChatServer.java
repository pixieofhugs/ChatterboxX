package com.mollyshove.psu.cs300;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by pixie on 5/2/2017 for CS202.
 */
public class ChatServer {

    private final int port;

    public ChatServer(int port) {
        this.port = port;
    }

    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    public void run() throws InterruptedException {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChatServerInitalizer());

        bootstrap.bind(port).sync().channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {

        new ChatServer(8000).run();

    }

    public void stop() {

        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}

