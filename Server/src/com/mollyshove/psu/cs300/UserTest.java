package com.mollyshove.psu.cs300;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pixie on 6/8/2017 for CS202.
 */
public class UserTest {

    @Test
    public void loginCheck() throws Exception {
        NetworkData.Message testLogin = ProtobuffHelper.buildLoginInfo("Testing", "Testing");
        NetworkData.Message testBadLogin = ProtobuffHelper.buildLoginInfo("Testing", "FAILURE");
        User snuggleKitten = new User(testLogin);
        if(snuggleKitten.loginCheck(testLogin))//if they are registering
            System.out.print("It worked!");
        else
            System.out.print("It did not work!");

        if(snuggleKitten.loginCheck(testLogin))//if they are registering with a remembered name
            System.out.print("It worked!");
        else
            System.out.print("It did not work!");

        if(!snuggleKitten.loginCheck(testBadLogin))//if they have a bad password
            System.out.print("It worked!");
        else
            System.out.print("It did not work!");


    }
}