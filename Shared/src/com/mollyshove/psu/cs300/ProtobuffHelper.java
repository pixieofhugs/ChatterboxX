package com.mollyshove.psu.cs300;

/**
 * Created by pixie on 6/5/2017 for CS202.
 */
public class ProtobuffHelper {


    public static NetworkData.Message buildPublicMessage(String userName, String message){
        return NetworkData.Message.newBuilder()
                .setPublicMessage(
                        NetworkData.Message.PublicMessage.newBuilder()
                                .setMessage(message)
                                .setSender(userName)
                                .build()
                ).build();
    }

    public static NetworkData.Message buildPrivateMessage(String sender, String recipient, String message) {
        return NetworkData.Message.newBuilder()
                .setPrivateMessage(
                        NetworkData.Message.PrivateMessage.newBuilder()
                                .setMessage(message)
                                .setRecipient(recipient)
                                .setSender(sender)
                                .build()
                ).build();
    }

    public static NetworkData.Message buildLoginInfo(String username, String password){
        return NetworkData.Message.newBuilder()
                .setLoginInfo(
                        NetworkData.Message.LoginInfo.newBuilder()
                            .setUserName(username)
                            .setPassword(password)
                            .setOnline(false)
                            .build()
                ).build();

    }
}
