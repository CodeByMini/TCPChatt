package com.company;

import java.io.Serializable;
import java.util.List;

public class DisconnectedObject implements Serializable {

    public List<String> UsersOnline;

    public DisconnectedObject(List<String> usersOnline){

        this.UsersOnline = usersOnline;
    }



    public List GetUsersOnline(){
        return this.UsersOnline;
    }
}
