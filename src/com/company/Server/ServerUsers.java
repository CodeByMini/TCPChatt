package com.company.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerUsers {

    private static ServerUsers serverUsersInstance = null;

    public Map<String, User> users;

    private ServerUsers() {
        users = new HashMap<String, User>();
    }

    public static ServerUsers getInstance() {
        if (serverUsersInstance == null) {
            serverUsersInstance = new ServerUsers();
        }
        return serverUsersInstance;
    }

    public void RemoveUser(int userId) throws InterruptedException, IOException {
        users.get(String.valueOf(userId)).interrupt();
        users.get(String.valueOf(userId)).socket.close();
        users.remove(String.valueOf(userId));

        //send new list to all users
    }

    public void Add(int userId, User user) {

        this.users.put(String.valueOf(userId), user);
        //user.start();
    }

    public List GetUserList() {
        List userList = new ArrayList();
        //if (!userList.isEmpty()) {
            for (Map.Entry<String, User> entry : users.entrySet()) {
                userList.add(entry.getValue().GetName());
                System.out.println("users: " + entry.getValue().GetName());
            }
        //}
        return userList;
    }

}

