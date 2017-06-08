package com.mollyshove.psu.cs300;

import java.util.List;

/**
 * Created by pixie on 5/30/2017 for CS202.
 */
public class User{
    private NetworkData.Message.LoginInfo.Builder credentials;

    public User(NetworkData.Message login) {
        credentials = login.getLoginInfo().toBuilder();
    }

    public boolean loginCheck(NetworkData.Message toCheck) {
        if(credentials.equals(toCheck.getLoginInfo())) {
            credentials.setOnline(true);
            return true;
        } else {
            return false;
        }

    }











}
