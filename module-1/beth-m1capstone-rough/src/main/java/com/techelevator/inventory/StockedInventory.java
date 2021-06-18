package com.techelevator.inventory;

import com.techelevator.purchase.ItemPurchased;
import com.techelevator.restock.FileRestockDao;
import com.techelevator.restock.JdbcRestockDao;
import com.techelevator.restock.RestockDao;
import com.techelevator.restock.RestockProduct;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class StockedInventory implements Stockable, Vendable {

    private final int INITIAL_QUANTITY = 5;
    private Map<String, Slot> activeInventory = new LinkedHashMap<>();
    private RestockDao restockDao;

    public StockedInventory(File inputFile) {
        restockDao = new FileRestockDao(inputFile);
        this.restock();
    }

    public StockedInventory(DataSource dataSource) {
        restockDao = new JdbcRestockDao(dataSource);
        this.restock();
    }

    @Override
    public void restock() {
        List<RestockProduct> restockProductList = restockDao.getRestockList();

        for(RestockProduct restockProduct : restockProductList) {
                Product individualProduct = Product.createProductOfType(
                        restockProduct.getProductClass(),
                        restockProduct.getProductName()
                );

                Slot thisSlot;
                if (activeInventory.containsKey(restockProduct.getSlotName())) {
                    thisSlot = activeInventory.get(restockProduct.getSlotName());
                } else {
                    thisSlot = new Slot(restockProduct.getSlotName(), restockProduct.getSalePrice());
                    activeInventory.put(restockProduct.getSlotName(), thisSlot);
                }

                // Add 5 of the Snacks to the Slot
                for (int i = 0; i < INITIAL_QUANTITY; i++) {
                    thisSlot.getAvailableProducts().push(individualProduct);
                }
            }
    }

    @Override
    public Map<String, Slot> getActiveInventory() {
        return activeInventory;
    }

    @Override
    public String printInventory(){
        String displayString = "";
        for (String slotName : activeInventory.keySet()) {
            Slot currSlot = activeInventory.get(slotName);
            displayString += slotName + "\t";
            displayString += currSlot.printSlotInventoryInfo() + "\n";
        }

        return displayString;
    }

    @Override
    public ItemPurchased vendItem() {
        return null;
    }
}
