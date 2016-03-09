package com.dragonfire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameLogic extends UnicastRemoteObject implements GameLogicInterface
{

    //<editor-fold defaultstate="collapsed" desc="Old Game Values">
    int value1 = 0;
    int value2 = 0;
    int mainValue = 0;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Deck Values">
    ArrayList<Card> deck = new ArrayList<>();
    long seed = System.nanoTime();
    Card joker = new Card("Joker", 0);
//</editor-fold>

    int deckSize;
    int player1Hand;
    int player2Hand;

    //<editor-fold defaultstate="collapsed" desc="2 Player Multiplayer Functonallity Values">
    boolean Player1 = false;
    boolean Player2 = false;
    static int nextPlayer = 0;
    //</editor-fold>

    public GameLogic() throws RemoteException
    {
        super();
        fillDeck();
        shuffleDeck();
    }

    //<editor-fold defaultstate="collapsed" desc="Old Game Logics">
    @Override
    @Deprecated
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
    @Deprecated
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
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="2 Player Multiplayer Functionallity">
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
//</editor-fold>

    @Override
    public int getPlayerHandSize() throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Send in a Player to let that Player draw a card from the shared Deck.
     * It then return that card to be stored Localy.
     * @param Player
     * @return
     * @throws RemoteException 
     */
    @Override
    public final Card drawCardFromDeck(int Player) throws RemoteException
    {
        if (deck.size() > 0)
        {
            shuffleDeck();
            Card card = new Card(deck.get(0).face, deck.get(0).value);
            deck.remove(0);
            return card;
        }

        return joker;
    }

    @Override
    public final void shuffleDeck() throws RemoteException
    {
        Collections.shuffle(deck, new Random(seed));
    }

    public final void fillDeck()
    {
        deck.add(new Card(Card.HEART, 1));
        deck.add(new Card(Card.HEART, 2));
        deck.add(new Card(Card.HEART, 3));
        deck.add(new Card(Card.HEART, 4));
        deck.add(new Card(Card.HEART, 5));
        deck.add(new Card(Card.HEART, 6));
        deck.add(new Card(Card.HEART, 7));
        deck.add(new Card(Card.HEART, 8));
        deck.add(new Card(Card.HEART, 9));
        deck.add(new Card(Card.HEART, 10));
        deck.add(new Card(Card.HEART, 11));
        deck.add(new Card(Card.HEART, 12));
        deck.add(new Card(Card.HEART, 13));

        deck.add(new Card(Card.DIAMOND, 1));
        deck.add(new Card(Card.DIAMOND, 2));
        deck.add(new Card(Card.DIAMOND, 3));
        deck.add(new Card(Card.DIAMOND, 4));
        deck.add(new Card(Card.DIAMOND, 5));
        deck.add(new Card(Card.DIAMOND, 6));
        deck.add(new Card(Card.DIAMOND, 7));
        deck.add(new Card(Card.DIAMOND, 8));
        deck.add(new Card(Card.DIAMOND, 9));
        deck.add(new Card(Card.DIAMOND, 10));
        deck.add(new Card(Card.DIAMOND, 11));
        deck.add(new Card(Card.DIAMOND, 12));
        deck.add(new Card(Card.DIAMOND, 13));

        deck.add(new Card(Card.CLUB, 1));
        deck.add(new Card(Card.CLUB, 2));
        deck.add(new Card(Card.CLUB, 3));
        deck.add(new Card(Card.CLUB, 4));
        deck.add(new Card(Card.CLUB, 5));
        deck.add(new Card(Card.CLUB, 6));
        deck.add(new Card(Card.CLUB, 7));
        deck.add(new Card(Card.CLUB, 8));
        deck.add(new Card(Card.CLUB, 9));
        deck.add(new Card(Card.CLUB, 10));
        deck.add(new Card(Card.CLUB, 11));
        deck.add(new Card(Card.CLUB, 12));
        deck.add(new Card(Card.CLUB, 13));

        deck.add(new Card(Card.SPADE, 1));
        deck.add(new Card(Card.SPADE, 2));
        deck.add(new Card(Card.SPADE, 3));
        deck.add(new Card(Card.SPADE, 4));
        deck.add(new Card(Card.SPADE, 5));
        deck.add(new Card(Card.SPADE, 6));
        deck.add(new Card(Card.SPADE, 7));
        deck.add(new Card(Card.SPADE, 8));
        deck.add(new Card(Card.SPADE, 9));
        deck.add(new Card(Card.SPADE, 10));
        deck.add(new Card(Card.SPADE, 11));
        deck.add(new Card(Card.SPADE, 12));
        deck.add(new Card(Card.SPADE, 13));
    }

}
