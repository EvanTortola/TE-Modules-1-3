package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    public static final String[] SUITS_FOR_CARDS = {"HEARTS", "CLUBS", "SPADES", "DIAMONDS"};
    //ATTRIBUTES / STATE
    private String deckName = "Deck 1";
    private List<Card> cards = new ArrayList<Card>();

    //BEHAVIORS
    // constructors (special methods)
    public Deck() {

        String[] valueNames = { "A", "2","3","4","5","6","7","8","9","10","J","Q","K"};

        for( String suit : SUITS_FOR_CARDS) {
            for( String valueName : valueNames) {
                Card nextCard = new Card( suit, valueName);
                cards.add(nextCard);
            }
        }
    }


    //methods
    public boolean shuffle() {
        return true;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public Card dealOne() {
        Card cardToDeal = null;
        if(cards.size() > 0) {
            cardToDeal = cards.remove(0);
        }
        return cardToDeal;
    }


}
