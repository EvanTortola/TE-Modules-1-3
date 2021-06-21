package com.techelevator.view;

import com.techelevator.change.Change;
import com.techelevator.inventory.Stockable;
import com.techelevator.purchase.*;
import com.techelevator.view.Menu;


import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseMenuCLI {
	private static final String MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String MENU_OPTION_FINISH = "Finish Transaction";

	private static final String[] MENU_OPTIONS = 
		{ 
			MENU_OPTION_FEED_MONEY, 
			MENU_OPTION_SELECT_PRODUCT,
			MENU_OPTION_FINISH 
		};

	private final Menu menu;
	private Stockable stockedInventory;
	private Fundable funds;

	private final Scanner keyboardInput = new Scanner(System.in);

	public PurchaseMenuCLI(Menu menu, Stockable stockedInventory, Fundable funds) {
		this.menu = menu;
		this.stockedInventory = stockedInventory;
		this.funds = funds;
	}

	public void run() {
		boolean finishedWithPurchase = false;
		do {
			System.out.println();
			System.out.println("Current Money Provided: " + funds.getBalance());

			String subMenuChoice = (String) menu.getChoiceFromOptions(MENU_OPTIONS);

			switch (subMenuChoice) {
			case MENU_OPTION_FEED_MONEY:

				boolean moneyAccepted = false;
				do {
					BigDecimal amount = getAmountToFeed();
					moneyAccepted = funds.creditFunds(amount);
					if (!moneyAccepted) {
						System.out.println("Invalid amount");
					}
				} while (!moneyAccepted);

				break;
			case MENU_OPTION_SELECT_PRODUCT:

				System.out.println(stockedInventory.printInventory()); // display items once for them to review
				boolean tryAgain;

				do {
					try {
						tryAgain = false;

						String slotName = getSlotName();
						ItemPurchased itemPurchased;
						if(stockedInventory.getActiveInventory().containsKey(slotName)) {
							if(stockedInventory.getActiveInventory().get(slotName).getRemainingQuantity() > 0) {
								funds.debitFunds(stockedInventory.getActiveInventory().get(slotName).viewNextProdcut().getPurchasePrice());
								itemPurchased = stockedInventory.getActiveInventory().get(slotName).vendProduct();
							}
							else {
								throw new SoldOutException();
							}
						}
						else {
							throw new InvalidSlotLocationException();
						}
						System.out.println();
						System.out.println(itemPurchased.getItemPurchased().enjoyProduct());
						System.out.println("Remaining Balance: " + funds.getBalance().toString());

					} catch (SoldOutException e) {
						System.out.println("This item is sold out. Please make another selection.");
						tryAgain = true;
					} catch (InvalidSlotLocationException e) {
						System.out.println("You have chosen an invalid slot location. Please make another selection.");
						tryAgain = true;
					} catch (InsufficientFundsException e) {
						System.out.println("Insufficient funds. Please add money to make this purchase.");
						tryAgain = false;
					}

				} while (tryAgain);

				break;
			case MENU_OPTION_FINISH:

				System.out.println("Change given: " + funds.refundBalance());
				finishedWithPurchase = true;
				break;
			}

		} while (!finishedWithPurchase);
	}

	private String getSlotName() {
		System.out.print("Choose a slot: ");
		return keyboardInput.nextLine().toUpperCase();
	}

	private BigDecimal getAmountToFeed() {
		System.out.print("How much ($1, $2, $5, $10)? ");
		String line = keyboardInput.nextLine();

		double amountAsDouble;

		try {
			amountAsDouble = Double.parseDouble(line);

		} catch (NumberFormatException e) {
			return BigDecimal.valueOf(-1); // invalid amount
		}

		return BigDecimal.valueOf(amountAsDouble);
	}
}
