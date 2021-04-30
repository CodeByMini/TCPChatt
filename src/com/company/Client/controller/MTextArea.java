package com.company.Client.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MTextArea extends JTextArea implements ActionListener {

    private static MTextArea MTextAreaInstance = null;

    public JTextArea textArea;

    private MTextArea(){
        this.textArea = new JTextArea();
    }

    public static MTextArea getInstance(){
        if (MTextAreaInstance == null) {
            MTextAreaInstance = new MTextArea();
        }
        return MTextAreaInstance;
    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }
}