package com.dragonfire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GameLogic extends UnicastRemoteObject implements GameLogicInterface
{

    int value1 = 0;
    int value2 = 0;
    int mainValue = 0;
    boolean Player1 = false;
    boolean Player2 = false;
    static int nextPlayer = 0;

    public GameLogic() throws RemoteException
    {
        super();
    }

    @Override
    public void increaseValue(int i) throws RemoteException
    {
        if (i == 1)
        {
            value1++;
            mainValue++;
        } else if (i == 2)
        {
            value2++;
            mainValue++;
        }
    }

    @Override
    public int getValue(int i) throws RemoteException
    {
        switch (i)
        {
            case 1:
                return value1;       
            case 2:
                return value2;
            case 9:
                return mainValue;
            default:
                return -1;
        }
    }

    @Override
    public int assignPlayer() throws RemoteException
    {
        switch (nextPlayer)
        {
            case 0:
                Player1 = true;
                nextPlayer++;
                return nextPlayer;
            case 1:
                Player2 = true;
                nextPlayer++;
                return nextPlayer;
            default:
                return -1;
        }
    }

    @Override
    public boolean getPlayerStatus(int i) throws RemoteException
    {
        switch (i)
        {
            case 1:
                return Player1;
            case 2:
                return Player2;
            default:
                return false;
        }
    }

    @Override
    public boolean getReady() throws RemoteException
    {
        return Player1 == true && Player2 == true;
    }

}
