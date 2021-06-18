package com.techelevator.inventory;

public class Drink extends Product {
    public Drink(String productName) {
        this.productName = productName;
    }

    @Override
    public String enjoyProduct() {
        return "Glug Glug, Yum!";
    }
}
