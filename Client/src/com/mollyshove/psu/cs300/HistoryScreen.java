package com.mollyshove.psu.cs300;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by pixie on 6/8/2017 for CS202.
 */
public class HistoryScreen {
    private JPanel historyScreen;
    private JTextArea textArea1;

    public int load(){
        FileReader inputFile = null;
        try {
            inputFile = new FileReader( ChatClientController.user + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(inputFile);

        try {
            textArea1.read(br,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
    }

    public HistoryScreen() {
        JFrame frame = new JFrame("HistoryScreen");
        frame.setContentPane(historyScreen);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        load();
    }
}
