package com.mollyshove.psu.cs300;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by pixie on 6/5/2017 for CS202.
 */
public class ChatClientController {
    private static Scanner in = new Scanner(System.in);
    private JPanel Login;
    private JPasswordField passwordField1;
    private JTextField usernameFeild;
    private JButton loginRegisterButton;
    private JTextArea instructionBox;
    private String username;
    private String password;
    private JList OnlineUsers;
    private JTextField boxToType;
    private JTextArea boxToRead;

    public static NetworkData.Message promptLoginInfo(){
        //promt the user and get their crap
        System.out.print("Welcome to the program" + "\n" + "Please Enter your username: ");
        String username = in.nextLine();
        System.out.print("\n" + "Please Enter your password: ");
        String password = in.nextLine();

        return ProtobuffHelper.buildLoginInfo(username, password);//make a new message to check

    }

    public NetworkData.Message sendLoginInfo() {


        while (true) {

            if (/*button click*/ false) {//if you press button
                username = new String(usernameFeild.getText());
                password = new String(passwordField1.getPassword());

                return ProtobuffHelper.buildLoginInfo(username, password);
            }
        }
    }

    public boolean chatWindowBehavior(){
        return true;

    }
}
