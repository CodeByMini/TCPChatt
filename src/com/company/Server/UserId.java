package com.company.Server;

public class UserId {

    private static UserId userIdinstance = null;

    public int id;

    private UserId(){
        this.id = -1;
    }
    public static UserId getInstance(){
        if (userIdinstance == null){
            userIdinstance = new UserId();
        }
        return userIdinstance;
    }

    public int GetNextId(){
        this.id +=1;
        return this.id;
    }
}
