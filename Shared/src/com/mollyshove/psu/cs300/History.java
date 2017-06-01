package com.mollyshove.psu.cs300;

import java.util.List;

/**
 * Created by pixie on 5/30/2017 for CS202.
 */
public class History {

    protected List<NetworkData.Message> privateMessageHistory;

    public History() {
    }

    public int storeMessage(NetworkData.Message toAdd){
        privateMessageHistory.add(toAdd);
        return 1;
    }

    public NetworkData.Message getRecentMessage(){
        return privateMessageHistory.get(0);

    }

    public NetworkData.Message getSpecificMessage(int indexToGet) {
        return privateMessageHistory.get(indexToGet);

    }

}
