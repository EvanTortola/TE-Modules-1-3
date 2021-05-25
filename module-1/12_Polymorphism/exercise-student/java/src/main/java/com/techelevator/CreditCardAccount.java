package com.techelevator;

public class CreditCardAccount implements Accountable {

    private String accountHolder;
    private String accountNumber;
    private int debt;

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }
}
