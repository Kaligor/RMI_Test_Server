package com.dragonfire;

import java.rmi.*;

public interface GameLogicInterface extends Remote
{
    public void increaseValue(int i) throws RemoteException;
    
    public int getValue(int i) throws RemoteException;
    
    public int assignPlayer() throws RemoteException;
    
    public boolean getPlayerStatus(int i) throws RemoteException;
    
    public boolean getReady() throws RemoteException;
}
