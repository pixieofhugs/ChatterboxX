package com.mollyshove.psu.cs300;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pixie on 6/6/2017 for CS202.
 */
public class LoginScreen {
    private JTextField usernameFeild;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel grootPanel;


    public LoginScreen() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatClientController.sendLoginMessage(usernameFeild.getText(), new String(passwordField.getPassword()));

            }
        });
    }

    public static JFrame createAndShowLogin() {
        JFrame frame = new JFrame("LoginScreen");
        frame.setContentPane(new LoginScreen().grootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
