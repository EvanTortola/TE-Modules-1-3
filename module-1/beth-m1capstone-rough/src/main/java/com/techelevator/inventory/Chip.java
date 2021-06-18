package com.techelevator.inventory;

public class Chip extends Product {
    public Chip(String productName) {
        this.productName = productName;
    }

    @Override
    public String enjoyProduct() {
        return "Crunch Crunch, Yum!";
    }
}
