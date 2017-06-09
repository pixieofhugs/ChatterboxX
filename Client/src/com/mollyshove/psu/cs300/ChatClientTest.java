package com.mollyshove.psu.cs300;

import static org.junit.Assert.*;

/**
 * Created by pixie on 6/8/2017 for CS202.
 */
public class ChatClientTest {
    @org.junit.Before
    public void setUp() throws Exception {
        run();
        sendMessage();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        stop();
    }

    @org.junit.Test
    public void run() throws Exception {
        ChatClient test = new ChatClient("test", 8000);
        if (test.run())
            System.out.print("It works");
        else
            System.out.print("It is flaming doom");
    }

    @org.junit.Test
    public void sendMessage() throws Exception {

        if (ChatClient.sendMessage("Test Sending", "Test Username"))
            System.out.print("It works");
        else
            System.out.print("It is doom doom doom");

    }

    @org.junit.Test
    public void stop() throws Exception {

        if (ChatClient.stop())
            System.out.print("It works");
        else
            System.out.print("It is freezing doom");

    }

}