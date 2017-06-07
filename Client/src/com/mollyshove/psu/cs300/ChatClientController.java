package com.mollyshove.psu.cs300;


import io.netty.channel.Channel;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by pixie on 6/5/2017 for CS202.
 */
public class ChatClientController {

    private static Scanner in = new Scanner(System.in);
    public static Channel server;
    private static JFrame loginScreen;

    public static NetworkData.Message promptLoginInfo(){
        //promt the user and get their crap
        System.out.print("Welcome to the program" + "\n" + "Please Enter your username: ");
        String username = in.nextLine();
        System.out.print("\n" + "Please Enter your password: ");
        String password = in.nextLine();

        return ProtobuffHelper.buildLoginInfo(username, password);//make a new message to check

    }

    public static boolean sendLoginMessage(String username, String password) {

        server.writeAndFlush(ProtobuffHelper.buildLoginInfo(username, password));
        return true;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ChatClient client = new ChatClient("localhost", 8000);
        client.run();//makes connection from client to server
        loginScreen = LoginScreen.createAndShowLogin();//creates login screen



    }


    public boolean chatWindowBehavior(){

        return true;

    }
}
