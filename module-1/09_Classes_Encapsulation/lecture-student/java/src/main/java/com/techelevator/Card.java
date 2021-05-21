package com.techelevator;

public class Card {

    //attributes
    private int numericValue;
    private boolean isFaceUp;
    private String suit;

    public String getValueName() {
        return valueName;
    }

    private String valueName;
    private String color;



    //constructors
    public Card (String suit, String valueName){
        this.suit = suit;
        this.valueName = valueName;
    }

    //methods
    public int getNumericValue() {
        return this.numericValue;
    }

    public void setNumericValue(int numericValue) {
        this.numericValue = numericValue;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }


    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean turnOver() {
        this.isFaceUp = !this.isFaceUp;
        return this.isFaceUp;
    }
}
