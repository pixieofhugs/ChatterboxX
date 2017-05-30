package com.mollyshove.psu.cs300;

import java.util.List;

/**
 * Created by pixie on 5/30/2017 for CS202.
 */
public class privateHistory {

    protected List<PrivateMessage> privateMessageHistory;

    public privateHistory() {
    }

    public int storeMessage(PrivateMessage toAdd){
        privateMessageHistory.add(toAdd);
        return 1;
    }

    public PrivateMessage getRecentMessage(){
        return privateMessageHistory.get(0);

    }

    public PrivateMessage getSpecificMessage(int indexToGet) {
        return privateMessageHistory.get(indexToGet);

    }

}
