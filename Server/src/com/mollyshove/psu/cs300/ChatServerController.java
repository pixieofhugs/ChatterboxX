package com.mollyshove.psu.cs300;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Collections;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by pixie on 6/5/2017 for CS202.
 */
public class ChatServerController {
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static SortedMap<String, User> Users = Collections.synchronizedSortedMap(new TreeMap<String, User>());
    private static Scanner in = new Scanner(System.in);
    private static String filename =  "users.txt";

    public static boolean analyzeMessage(NetworkData.Message message, Channel incoming) {
        switch (message.getMessageTypeCase()) {
            case LOGININFO:
                authenticate(message, incoming);
                break;

            case PRIVATEMESSAGE:
                for (Channel channel : ChatServerController.channels) {

                    if (channel != incoming) {
                        channel.writeAndFlush(message);
                    }
                }//todo implement this more sucsessfully

                break;
            case PUBLICMESSAGE:
                //public message case
                for (Channel channel : ChatServerController.channels) {
                    if (channel != incoming) {
                        channel.writeAndFlush(message);
                    }
                }
                break;
        }
        return true;
    }

    public static boolean authenticate(NetworkData.Message loginInfo, Channel channel) {

        User currentUser = Users.get(loginInfo.getLoginInfo().getUserName());
        if (currentUser != null) {//if there is a user

            if (currentUser.loginCheck(loginInfo)) {//this checks, and if true changes status to online
                channel.writeAndFlush(ProtobuffHelper.changeOnline(true, loginInfo));//sends it back
                return true;
            } else {
                channel.writeAndFlush(ProtobuffHelper.changeOnline(false, loginInfo));//sends it back with no online status
                return false;
            }
        } else {
            registerUser(loginInfo, channel);
            channel.writeAndFlush(ProtobuffHelper.changeOnline(true, loginInfo));
            return true;
        }
    }

    public static boolean registerUser(NetworkData.Message loginInfo, Channel channel) {

        Users.putIfAbsent(loginInfo.getLoginInfo().getUserName(), new User(loginInfo));
        return true;

    }



    //make a private helper function to build what I will write and flush out to the client
}