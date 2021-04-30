package com.company;

import java.io.Serializable;

public class LogoutObject implements Serializable {
    public int userId;


    public LogoutObject(int userId){
        this.userId = userId;
    }

    public int GetUserId(){
        return this.userId;
    }

}
