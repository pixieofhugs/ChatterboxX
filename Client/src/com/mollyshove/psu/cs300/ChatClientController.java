package com.mollyshove.psu.cs300;

import java.util.Scanner;

/**
 * Created by pixie on 6/5/2017 for CS202.
 */
public class ChatClientController {
    private static Scanner in = new Scanner(System.in);

    public static NetworkData.Message promptLoginInfo(){
        //promt the user and get their crap
        System.out.print("Welcome to the program" + "\n" + "Please Enter your username: ");
        String username = in.nextLine();
        System.out.print("\n" + "Please Enter your password: ");
        String password = in.nextLine();

        return ProtobuffHelper.buildLoginInfo(username, password);//make a new message to check

    }
}
