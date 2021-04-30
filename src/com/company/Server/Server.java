package com.company.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Server {

   private int port;


    Server(int port){
        this.port = port;
        UserId userIdGetter = UserId.getInstance();
        try(ServerSocket serverSocket = new ServerSocket(this.port)) {

            while(true){
                System.out.println("tjoho");
                Socket socket = serverSocket.accept();
                //if(socket != null) {
                    int userId = userIdGetter.GetNextId();
                    User user = new User(userId, socket);
                    ServerUsers.getInstance().Add(userId, user);
                    user.start();
                //}
            }
        } catch (IOException e) {
            System.out.println("Server failed to connect");
        }
    }

    public static void main(String[] args){
        new Server(5566);


    }


}
