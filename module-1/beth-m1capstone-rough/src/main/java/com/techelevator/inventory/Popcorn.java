package com.techelevator.inventory;

public class Popcorn extends Product{

    public Popcorn(String productName) {
        this.productName = productName;
    }

    @Override
    public String enjoyProduct() {
        return "Pop Pop, Yum!";
    }
}
