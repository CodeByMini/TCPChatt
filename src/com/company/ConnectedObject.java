package com.company;


import java.io.Serializable;
import java.util.List;

public class ConnectedObject implements Serializable {

    public int userId;
    public List<String> UsersOnline;

    public ConnectedObject(int userId, List<String> usersOnline){

        this.userId = userId;
        this.UsersOnline = usersOnline;
    }

    public int GetUserId() {
        return userId;
    }

    public List GetUsersOnline(){
        return this.UsersOnline;
    }
}
