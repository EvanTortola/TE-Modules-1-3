package com.techelevator.inventory;

import java.math.BigDecimal;
import java.util.Stack;
import com.techelevator.inventory.Product;
import com.techelevator.purchase.ItemPurchased;
import com.techelevator.purchase.SoldOutException;

public class Slot {

    private String slotName;
    private BigDecimal salePrice;
    private Stack<Product> availableProducts = new Stack<Product>();

    public Slot(String slotName, BigDecimal salePrice) {
        this.slotName = slotName;
        this.salePrice = salePrice;
    }

    public int getRemainingQuantity() {
        return this.availableProducts.size();
    }

    boolean isSoldOut() {
        return this.availableProducts.size() == 0;
    }

    public Stack getAvailableProducts() {
        return this.availableProducts;
    }

    public ItemPurchased viewNextProdcut()  {
        return new ItemPurchased(
                this.availableProducts.peek(),
                this.salePrice);
    }

    public ItemPurchased vendProduct() {
        ItemPurchased itemPurchased = null;
        if ( !isSoldOut() ){
            itemPurchased = new ItemPurchased(
                    this.availableProducts.pop(),
                    this.salePrice);
        }
        else {
            throw new SoldOutException();
        }
        return itemPurchased;
    }

    public String printSlotInventoryInfo(){
        if ( !isSoldOut() ) {
            return viewNextProdcut().getItemPurchased().getProductName() + " " +
                    viewNextProdcut().getPurchasePrice().toString() + " " +
                    getRemainingQuantity();
        }
        else return "SOLD OUT";
    }

}
