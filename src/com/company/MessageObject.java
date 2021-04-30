package com.company;

import java.io.Serializable;

public class MessageObject implements Serializable {
    public String message;

    public MessageObject(String message){
        this.message = message;
    }

    public String GetMessage() {
        return message;
    }
    public void SetMessage(String message){
        this.message = message;
    }
}
