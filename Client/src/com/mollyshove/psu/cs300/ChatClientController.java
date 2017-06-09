package com.mollyshove.psu.cs300;


import io.netty.channel.Channel;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by pixie on 6/5/2017 for CS202.
 */
public class ChatClientController {

    private static Scanner in = new Scanner(System.in);
    public static Channel server;
    private static JFrame loginScreen;
    private static ChatScreen chatScreen;
    public static String user;
    private static FileWriter log;


    public static NetworkData.Message promptLoginInfo(){
        //promt the user and get their crap
        System.out.print("Welcome to the program" + "\n" + "Please Enter your username: ");
        String username = in.nextLine();
        System.out.print("\n" + "Please Enter your password: ");
        String password = in.nextLine();

        return ProtobuffHelper.buildLoginInfo(username, password);//make a new message to check

    }//this was for testing on the console!

    public static boolean sendLoginMessage(String username, String password) {

        server.writeAndFlush(ProtobuffHelper.buildLoginInfo(username, password));
        return true;

    }

    public static void main(Object o) throws IOException, InterruptedException {
        ChatClient client = new ChatClient("localhost", 8000);
        client.run();//makes connection from client to server
        loginScreen = LoginScreen.createAndShowLogin();//creates login screen



    }


    public static boolean analyzeMessage(NetworkData.Message message) {
        switch (message.getMessageTypeCase()) {
            case LOGININFO:
                if(message.getLoginInfo().getOnline()){
                        loginScreen.setVisible(false);
                    chatScreen = new ChatScreen();
                        chatScreen.frame.setVisible(true);
                        user = message.getLoginInfo().getUserName();
                    try {
                        log = new FileWriter(user + ".txt", true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                        //or add them to the group chat
                }
                else{
                    //display error message
                    ChatClient.stop();
                }
                //
                break;

            case PRIVATEMESSAGE:
                //todo implement this more successfully

                break;
            case PUBLICMESSAGE:
                String toDisplay =  message.getPublicMessage().getMessage();
                chatScreen.boxForText.append(message.getPublicMessage().getSender() + ": " + toDisplay);
                write(toDisplay);
                break;
        }
        return true;
    }

    public static boolean write(String toLog){
        try {
            log.write(toLog);
            log.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

}
