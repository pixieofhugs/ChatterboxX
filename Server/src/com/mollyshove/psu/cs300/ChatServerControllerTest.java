package com.mollyshove.psu.cs300;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pixie on 6/8/2017 for CS202.
 */
public class ChatServerControllerTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void analyzeMessage() throws Exception {

        ChatServer.main(null);

        io.netty.channel.Channel testChannel;
        testChannel = null;
        NetworkData.Message testLogin = ProtobuffHelper.buildLoginInfo("Testing", "Testing");
        NetworkData.Message testPublicMessage =  ProtobuffHelper.buildPublicMessage("username", "Testing Testing I am a message");
        if(ChatServerController.analyzeMessage(testLogin, testChannel))
            System.out.print("It worked!");
        else
            System.out.print("It did not work and I am sad");
        if (ChatServerController.analyzeMessage(testPublicMessage,testChannel))
            System.out.print("It worked!");
        else
            System.out.print("It did not work. CURSES");
    }

    @Test
    public void authenticate() throws Exception {
        ChatServer.main(null);

        io.netty.channel.Channel testChannel;
        testChannel = null;
        NetworkData.Message testLogin = ProtobuffHelper.buildLoginInfo("Testing", "Testing");
        if(ChatServerController.authenticate(testLogin, testChannel))
            System.out.print("It worked!");
        else
            System.out.print("It did not work!");
    }

    @Test
    public void registerUser() throws Exception {

        ChatServer.main(null);

        io.netty.channel.Channel testChannel;
        testChannel = null;
        NetworkData.Message testLogin = ProtobuffHelper.buildLoginInfo("Testing", "Testing");
        if(ChatServerController.registerUser(testLogin, testChannel))
            System.out.print("It worked!");
        else
            System.out.print("It doesn't work. I shall cry eternally");
    }

}