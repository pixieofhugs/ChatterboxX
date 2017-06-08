package com.mollyshove.psu.cs300;

import io.netty.channel.Channel;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.Scanner;

import static com.mollyshove.psu.cs300.ChatClientController.server;


/**
 * Created by pixie on 5/2/2017 for CS202.
 */

public class ChatClient {
    private final String host;
    private final int port;
    private static EventLoopGroup group;


    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws InterruptedException, IOException {
        group = new NioEventLoopGroup();

            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChatClientInitializer());//initializer in the original
            server = bootstrap.connect(host, port).sync().channel();//creates the server

    }

    public static void sendMessage(String message, String user) throws Exception {

        //this sends the message and I should probably not delete it
        Scanner in = new Scanner(System.in);

            server.writeAndFlush(
                    ProtobuffHelper.buildPublicMessage(
                            user,
                            message + "\n"
                    )
            );

    }

    public static void stop(){
        group.shutdownGracefully();

    }
}

