package com.mollyshove.psu.cs300;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by pixie on 5/2/2017 for CS202.
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<NetworkData.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NetworkData.Message message) throws Exception {

        System.out.print(message.getPublicMessage().getSender() + ": " + message.getPublicMessage().getMessage());

    }



    //TODO add print message for testing
}