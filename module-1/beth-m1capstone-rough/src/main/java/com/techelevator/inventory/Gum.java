package com.techelevator.inventory;

public class Gum extends Product {
    public Gum(String productName) {
        this.productName = productName;
    }

    @Override
    public String enjoyProduct() {
        return "Chew Chew, Yum!";
    }
}
