package com.company.Client.controller;

import com.company.*;
import com.company.Client.model.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Controller implements Runnable {
    Socket socket;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    Model user;

    public Controller(String ip, int port, Model user) {
        try {
            System.out.println("controller started");
            this.user = user;
            this.socket = new Socket(ip, port);
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        LoginObject login = new LoginObject(this.user.GetName());
        SendObject(login);

        while (true) {
            try {
                Object object;
                object = objectInputStream.readObject();

                if (object instanceof ConnectedObject) {
                    MUserList.getInstance().setText("");
                    if(((ConnectedObject) object).userId != -1)
                        user.SetUserId(((ConnectedObject) object).userId);
                    user.SetUserList(((ConnectedObject) object).GetUsersOnline());
                    for (String userName : (ArrayList<String>) user.GetUserList()) {
                        if (!(userName == (null)))
                            MUserList.getInstance().append(userName + "\n");
                    }
                }

                if (object instanceof LoginObject) {
                    System.out.println(((LoginObject) object).GetUserName());
                    MUserList.getInstance().append(((LoginObject) object).GetUserName() + "\n");
                }

                if (object instanceof MessageObject) {
                    System.out.println(((MessageObject) object).GetMessage());
                    MTextArea.getInstance().append(((MessageObject) object).GetMessage() + "\n");
                    MTextArea.getInstance().setCaretPosition(MTextArea.getInstance().getDocument().getLength());
                }

                if (object instanceof DisconnectedObject) {
                    break;/*
                    MUserList.getInstance().setText("");
                    user.SetUserList(((ConnectedObject) object).GetUsersOnline());
                    for (String userName : (ArrayList<String>) user.GetUserList()) {
                        if (!(userName == (null)))
                            MUserList.getInstance().append(userName + "\n");
                    }*/
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void SendObject(Object object) {
        try {
            this.objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}