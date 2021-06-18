package com.techelevator.inventory;

import java.io.File;
import java.util.Map;

public interface Stockable {
    public void restock();
    public Map<String, Slot> getActiveInventory();
    public String printInventory();



}
