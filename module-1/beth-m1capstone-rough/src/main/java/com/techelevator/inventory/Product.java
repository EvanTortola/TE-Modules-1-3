package com.techelevator.inventory;

import java.math.BigDecimal;

public abstract class Product {

    protected String productName;

    public String getProductName() {
        return this.productName;
    }
    public abstract String enjoyProduct();

    public static Product createProductOfType(String snackType, String productName) {
        if (snackType != null) {
            switch (snackType) {
                case "Candy":
                    return new Candy(productName);
                case "Chip":
                    return new Chip(productName);
                case "Drink":
                    return new Drink(productName);
                case "Gum":
                    return new Gum(productName);
                case "Popcorn":
                    return new Popcorn(productName);
            }
        }

        throw new IllegalArgumentException("No snack exists for snack type: " + snackType);
    }

}
