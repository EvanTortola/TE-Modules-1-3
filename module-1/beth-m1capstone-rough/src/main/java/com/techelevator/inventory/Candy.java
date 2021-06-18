package com.techelevator.inventory;

public class Candy extends Product {
    public Candy(String productName) {
        this.productName = productName;
    }

    @Override
    public String enjoyProduct() {
        return "Munch Munch, Yum!";
    }
}
