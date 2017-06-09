package com.mollyshove.psu.cs300;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pixie on 6/8/2017 for CS202.
 */
public class ChatServerTest {

    @Test
    public void run() throws Exception {
        ChatServer chatterbox = new ChatServer(8000);
        if (chatterbox.run()) {
            System.out.print("it works");
        }else {
            System.out.print("it does not work");
        }
    }

    @Test
    public void main() throws Exception {
        String[] test = new String[1];
        ChatServer.main(test);
    }

    @Test
    public void stop() throws Exception {
        ChatServer chatterbox = new ChatServer(8000);
        if (chatterbox.stop()) {
            System.out.print("it works");
        }else {
            System.out.print("it does not work");
        }

    }

}