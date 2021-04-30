package com.company;

import com.company.Server.ServerUsers;
import com.company.Server.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsersOnline implements Serializable {

    public List usersOnline;

    public UsersOnline() {
        usersOnline = new ArrayList();
    }

    public List GetUsers() {
        for (Map.Entry<String, User> entry : ServerUsers.getInstance().users.entrySet()) {
            usersOnline.add(entry.getKey());
        }
        return usersOnline;
    }
}
