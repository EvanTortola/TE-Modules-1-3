package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Deck {


    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    //attributes / state
    public String deckName = "Deck 1";
    public List<Card> cards = new ArrayList<Card>();


    //BEHAVIORS
    //constructors (special methods)


    //methods
    public boolean shuffle() {
        return true;
    }

    public Card dealOne() {
        Card cardToDeal = null;
        if (cards.size() > 0) {
            cardToDeal = cards.remove(0);
        }
        return cardToDeal;
    }
}