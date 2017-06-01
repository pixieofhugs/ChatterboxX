package com.mollyshove.psu.cs300;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;



/**
 * Created by pixie on 5/2/2017 for CS202.
 */
public class ChatServerInitalizer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel arg0) throws Exception{

        ChannelPipeline pipeline = arg0.pipeline();

        // Decoders
        pipeline.addLast("frameDecoder",
                new LengthFieldBasedFrameDecoder(1048576, 0, 4, 0, 4));
        pipeline.addLast("protobufDecoder",
                new ProtobufDecoder(NetworkData.Message.getDefaultInstance()));
        pipeline.addLast("handler", new ChatServerHandler());

        // Encoder
        pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
        pipeline.addLast("protobufEncoder", new ProtobufEncoder());


    }
//TODO look up the API for all of the simple functions
}
