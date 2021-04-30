package com.company.Client;

import com.company.Client.controller.Controller;
import com.company.Client.model.Model;
import com.company.Client.view.View;

import javax.swing.*;

public class Client {

    public static void main(String[] args){
        String ip = args[0];
        int port = Integer.parseInt(args[1]);
        Model user = new Model(JOptionPane.showInputDialog("Skriv ditt namn: "));
        Controller controller = new Controller(ip, port, user);
        Thread control = new Thread(controller);
        control.start();



        new View(user, controller);


    }
}
