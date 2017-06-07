package com.mollyshove.psu.cs300;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by pixie on 6/6/2017 for CS202.
 */
public class ChatScreen {
    private JList list1;
    private JTextField textField1;
    private JTextArea textArea1;


    public ChatScreen() {
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {//if they hit enter key stroke works
                    try {
                        ChatClient.sendMessage(textField1.getText(), "snuggle kitten");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}


