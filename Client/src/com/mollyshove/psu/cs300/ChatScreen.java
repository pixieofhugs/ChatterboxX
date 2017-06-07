package com.mollyshove.psu.cs300;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by pixie on 6/6/2017 for CS202.
 */
public class ChatScreen {
    private JList userList;
    private JTextField boxToRead;
    private JTextArea boxForText;


    public ChatScreen() {
        boxToRead.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {//if they hit enter key stroke works
                    try {
                        ChatClient.sendMessage(boxToRead.getText(), "snuggle kitten");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }





        });
        boxToRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }






}



