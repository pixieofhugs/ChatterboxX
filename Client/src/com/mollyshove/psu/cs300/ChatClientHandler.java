package com.mollyshove.psu.cs300;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by pixie on 5/2/2017 for CS202.
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

    }//FIXME change string to protobuffer once I have one
    //TODO add print message for testing
}