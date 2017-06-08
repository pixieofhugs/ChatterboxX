package com.mollyshove.psu.cs300;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by pixie on 5/2/2017 for CS202.
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<NetworkData.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NetworkData.Message message) throws Exception {

        ChatClientController.analyzeMessage(message);
        //   System.out.print(message.getPublicMessage().getSender() + ": " + message.getPublicMessage().getMessage());

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println("Connection inactive.");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("Connection active.");
    }
//TODO add print message for testing
}