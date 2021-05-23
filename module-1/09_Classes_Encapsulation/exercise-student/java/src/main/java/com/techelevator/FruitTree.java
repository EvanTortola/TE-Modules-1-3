package com.techelevator;

public class FruitTree {

    private String typeOfFruit;
    private int piecesOfFruitLeft;

    public FruitTree (String typeOfFruit, int startingPiecesOfFruit){
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public boolean pickFruit(int numberOfPiecesToRemove){
        if (piecesOfFruitLeft == 0){
            return false;
        }
        else if (numberOfPiecesToRemove > piecesOfFruitLeft ){
            return false;
        }
        else {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        }

    }
}
