package com.mollyshove.psu.cs300;

import java.util.List;

/**
 * Created by pixie on 5/30/2017 for CS202.
 */
public class User{
    private List<History> personalHistory;
    private static NetworkData.Message.LoginInfo.Builder credentials;

    public static boolean loginCheck(NetworkData.Message toCheck) {
        if(credentials.equals(toCheck.getLoginInfo())) {
            credentials.setOnline(true);
            return true;
        } else {
            return false;
        }

    }











}
