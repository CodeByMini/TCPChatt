package com.company;

import java.io.Serializable;

public class LoginObject implements Serializable {

    public int userId;
    public String userName;

    public LoginObject(String userName){
        this.userName = userName;
    }

    public String GetUserName() {
        return userName;
    }
}
