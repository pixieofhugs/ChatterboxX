package com.mollyshove.psu.cs300;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pixie on 6/8/2017 for CS202.
 */
public class ChatClientControllerTest {
    @Before
    public void setUp() throws Exception {
    main();
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void sendLoginMessage() throws Exception {

    if(ChatClientController.sendLoginMessage("TestUserName", "testPassowrd"))
        System.out.print("It worked!");
    else
        System.out.print("It did not work and I am sad");

    }

    @Test
    public void main() throws Exception {
    ChatClientController.main(null);
    }

    @Test
    public void analyzeMessage() throws Exception {

        NetworkData.Message testLogin = ProtobuffHelper.buildLoginInfo("Testing", "Testing");
        NetworkData.Message testPublicMessage =  ProtobuffHelper.buildPublicMessage("username", "Testing Testing I am a message");
        if(ChatClientController.analyzeMessage(testLogin))
            System.out.print("It worked!");
        else
            System.out.print("It did not work and I am sad");
        if (ChatClientController.analyzeMessage(testPublicMessage))
            System.out.print("It worked!");
        else
            System.out.print("It did not work. CURSES");
    }

    @Test
    public void write() throws Exception {
        if(ChatClientController.write("Testing History"))
            System.out.print("It worked!");
        else
            System.out.print("It did not work and I am sad");

    }

}