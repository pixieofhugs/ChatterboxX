package com.mollyshove.psu.cs300;

import java.util.List;

/**
 * Created by pixie on 5/30/2017 for CS202.
 */
public class publicHistory {

    protected List<PublicMessage> publicMessageHistory;

    public publicHistory() {
    }

    public int storeMessage(PublicMessage toAdd){
        publicMessageHistory.add(toAdd);
        return 1;
    }

    public PublicMessage getRecentMessage(){
        return publicMessageHistory.get(0);

    }

    public PublicMessage getSpecificMessage(int indexToGet){
        return publicMessageHistory.get(indexToGet);

    }

}
