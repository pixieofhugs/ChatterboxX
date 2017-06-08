package com.mollyshove.psu.cs300;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by pixie on 6/6/2017 for CS202.
 */
public class ChatScreen {
    private JList userList;
    private JTextField boxToRead;
    public JTextArea boxForText;
    private JPanel ChatScreen;
    public JFrame frame;


    public ChatScreen() {
        boxToRead.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {//if they hit enter key stroke works
                    if(boxToRead.getText().equals("/history")) {
                        HistoryScreen historyScreen = new HistoryScreen();
                    }
                        else{
                        try {
                            ChatClient.sendMessage(boxToRead.getText(), ChatClientController.user);
                            boxForText.append(ChatClientController.user + ": " + boxToRead.getText() + "\n");//displays!
                            ChatClientController.write(ChatClientController.user + ": " + boxToRead.getText() + "\n");//writes it to history

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        boxToRead.setText("");//clears text
                    }
                }
            }
        });

        frame = new JFrame("ChatScreen");
        frame.setContentPane(ChatScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }






}



