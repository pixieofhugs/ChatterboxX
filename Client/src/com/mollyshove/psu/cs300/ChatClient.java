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


/**
 * Created by pixie on 5/2/2017 for CS202.
 */

public class ChatClient {
    private final String host;
    private final int port;


    public static void main(String[] args) throws IOException, InterruptedException {
        new ChatClient("localhost", 8000).run();

    }


    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws InterruptedException, IOException {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChatClientInitializer());//initializer in the original
            Channel channel = bootstrap.connect(host, port).sync().channel();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            channel.writeAndFlush(
                    ChatClientController.promptLoginInfo()
            );


            //this sends the message and I should probably not delete it
            while(true) {
                    channel.writeAndFlush(
                            ProtobuffHelper.buildPublicMessage(
                                    "snuggleKitten",
                                    in.readLine() + "\n"
                            )
                    );
            }
        }finally{
            group.shutdownGracefully();
        }

    }
}

