package com.techelevator;

import com.techelevator.inventory.Stockable;
import com.techelevator.inventory.StockedInventory;
import com.techelevator.purchase.CashAccount;
import com.techelevator.purchase.Fundable;
import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenuCLI;
import com.techelevator.view.VendingMachineCLI;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.File;

public class VendingMachine {

    Menu menu = new Menu(System.in, System.out);
    Fundable currentFunds = new CashAccount();
    PurchaseMenuCLI purchaseMenuCLI;
    VendingMachineCLI cli;
    Stockable currentInventory;

    public VendingMachine(DataSource dataSource) {
        currentInventory = new StockedInventory(dataSource);
        this.run();
    }

    public VendingMachine(File file) {
        currentInventory = new StockedInventory(file);
        this.run();
    }

    public void run() {
        purchaseMenuCLI = new PurchaseMenuCLI(menu, currentInventory, currentFunds);
        cli = new VendingMachineCLI(menu, currentInventory, purchaseMenuCLI);
        cli.run();
    }
}
