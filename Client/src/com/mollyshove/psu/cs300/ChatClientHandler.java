package com.mollyshove.psu.cs300;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by pixie on 5/2/2017 for CS202.
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<NetworkData.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NetworkData.Message Data) throws Exception {

        //call method in controller to po

    }


    //TODO add print message for testing
}