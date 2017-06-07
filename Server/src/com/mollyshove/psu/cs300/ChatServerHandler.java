package com.mollyshove.psu.cs300;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by pixie on 5/2/2017 for CS202.
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<NetworkData.Message> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NetworkData.Message message) throws Exception {
        System.out.println(message.toString()); //For shooting trouble when you walked in (so shame on me)

        ChatServerController.analyzeMessage(message, channelHandlerContext.channel());
        //passes to a function that figures out what kind of message it is and does the right thing.

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ChatServerController.channels.add(ctx.channel());
    }
}

