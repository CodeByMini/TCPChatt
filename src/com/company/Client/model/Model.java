package com.company.Client.model;

import com.company.LoginObject;
import com.company.UsersOnline;

import java.util.ArrayList;
import java.util.List;

public class Model {
    int userId;
    String userName;
    List userList;

    public Model(String userName){

        this.userName = userName;
        this.userList = new ArrayList();
        //userList.add(userName);
    }

    public String GetName(){
        return this.userName;
    }

    public void SetUserList(List userList){
        this.userList = userList;
    }

    public List GetUserList(){
        return this.userList;
    }

    public void SetUserId(int userId){
        this.userId = userId;
    }
    public int GetUserId(){
        return this.userId;
    }
}
