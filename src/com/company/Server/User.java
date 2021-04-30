package com.company.Server;

import com.company.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class User extends Thread {
    public String name;
    public Socket socket;
    public int userId;
    public ObjectInputStream objectInputStream;
    public ObjectOutputStream objectOutputStream;

    User(int userId, Socket socket) throws IOException {
        this.socket = socket;
        this.userId = userId;
        this.objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
        this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());
    }

    public String GetName() {
        return this.name;
    }

    public ObjectOutputStream GetOutputStream() {
        return this.objectOutputStream;
    }

    public void SendObject(Object object) {

        for (Map.Entry<String, User> entry : ServerUsers.getInstance().users.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            try {
                entry.getValue().objectOutputStream.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void SendObject(Object object, int userId) {
        try {
            ServerUsers.getInstance().users.get((String.valueOf(userId))).objectOutputStream.writeObject(object);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        ConnectedObject connectedObject = new ConnectedObject(this.userId, ServerUsers.getInstance().GetUserList());
        try {
            this.objectOutputStream.writeObject(connectedObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (!Thread.interrupted()) {
                Object object = objectInputStream.readObject();

                if (object instanceof LoginObject) {
                    this.name = ((LoginObject) object).GetUserName();
                    System.out.println(this.name + " logged in");
                    SendObject(object);
                }

                if (object instanceof MessageObject) {
                    System.out.println("message: " + ((MessageObject) object).GetMessage());
                    SendObject(object);
                }
                if (object instanceof LogoutObject) {
                    //if (!ServerUsers.getInstance().users.isEmpty()) {
                    DisconnectedObject disconnect = new DisconnectedObject(ServerUsers.getInstance().GetUserList());
                    SendObject(disconnect, ((LogoutObject) object).GetUserId());
                    ServerUsers.getInstance().RemoveUser(((LogoutObject) object).GetUserId());
                    ConnectedObject newList = new ConnectedObject(-1, ServerUsers.getInstance().GetUserList());
                    SendObject(newList);

                    //}

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
