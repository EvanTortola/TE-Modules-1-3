package com.techelevator.view;

import com.techelevator.inventory.Stockable;
import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenuCLI;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {
			MAIN_MENU_OPTION_DISPLAY_ITEMS,
			MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT
	};

	private Menu menu;
	private Stockable stockedInventory;
	private PurchaseMenuCLI purchaseMenuCLI;

	public VendingMachineCLI(Menu menu, Stockable stockedInventory, PurchaseMenuCLI purchaseMenuCLI) {
		this.menu = menu;
		this.stockedInventory = stockedInventory;
		this.purchaseMenuCLI = purchaseMenuCLI;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					System.out.println(stockedInventory.printInventory());
					break;
				case MAIN_MENU_OPTION_PURCHASE:
					this.purchaseMenuCLI.run();
					break;
				case MAIN_MENU_OPTION_EXIT:
					System.out.println("Thanks for stopping by!");
					System.exit(0);
					break;
			}
		}
	}


}
