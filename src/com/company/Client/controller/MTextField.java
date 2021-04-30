package com.company.Client.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MTextField extends JTextField implements ActionListener {

    private static MTextField textFieldInstance = null;

    public JTextField textField;

    private MTextField(){
        this.textField = new JTextField();
    }

    public static MTextField getInstance(){
        if (textFieldInstance == null) {
            textFieldInstance = new MTextField();
        }
        return textFieldInstance;
    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }
}