package com.techelevator;

public class MainProgram {

    public static void main(String[] args) {

//        Deck aDeck = new Deck();
//        Deck anotherDeck = new Deck();
//
//        anotherDeck.setDeckName("Renamed Deck");
//        System.out.println("");

        Deck myActualDeck = new Deck();

        Card nextCard = new Card("JOKER", "JOKER");
        while ( nextCard != null) {
            nextCard = myActualDeck.dealOne();
            System.out.println(nextCard);

        }



        String[] suits = Deck.SUITS_FOR_CARDS;





    }

}
