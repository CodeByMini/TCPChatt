package com.company.Client.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MUserList extends JTextArea implements ActionListener {

    private static MUserList MUserListInstance = null;

    public JTextArea textArea;

    private MUserList(){
        this.textArea = new JTextArea(25, 25);
    }

    public static MUserList getInstance(){
        if (MUserListInstance == null) {
            MUserListInstance = new MUserList();
        }
        return MUserListInstance;
    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }
}