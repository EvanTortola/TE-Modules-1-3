package com.techelevator.purchase;

import com.techelevator.inventory.Product;

import java.math.BigDecimal;

public class ItemPurchased {

    private Product itemPurchased;
    private BigDecimal purchasePrice;

    public ItemPurchased(Product itemPurchased, BigDecimal purchasePrice) {
        this.itemPurchased = itemPurchased;
        this.purchasePrice = purchasePrice;
    }

    public Product getItemPurchased() {
        return itemPurchased;
    }


    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }



}
