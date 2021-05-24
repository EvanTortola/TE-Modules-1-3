package com.techelevator;

public class Card {

    //Attributes
    private int numericValue;
    private boolean isFaceUp = false;
    private String suit;
    private String valueName;
    private String color;

    //Constructor(s)
    public Card (String suit, String valueName) {
        this.suit = suit;
        this.valueName = valueName;
    }

    public Card (String suit, String valueName, int numericValue) {
        this.suit = suit;
        this.valueName = valueName;
        this.numericValue = numericValue;
    }


    //Methods
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

    public String getValueName() {
        return valueName;
    }

    public String toString() {
        return suit + valueName;
    }

}
