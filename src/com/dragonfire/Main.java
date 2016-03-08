package com.dragonfire;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Main
{

    public static void main(String[] args)           
    {

        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("Registry created on Server");
        } catch (RemoteException e) {
            System.err.println(e.getMessage());
        }
        
        try
        {
//            System.setProperty("localhost","127.0.0.1");
            
//            Registry registry = LocateRegistry.getRegistry();
            GameLogicInterface stub = new GameLogic();
            Naming.rebind("//172.16.1.73:1099/test", stub);
            System.out.println("Server is Running...");
        } catch (RemoteException | MalformedURLException e)
        {
            System.err.println(e.getMessage());
        }

    }

}
