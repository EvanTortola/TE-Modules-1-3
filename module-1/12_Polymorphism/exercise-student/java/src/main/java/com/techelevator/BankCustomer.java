package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<Accountable>();

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] thisArray = new Accountable[accounts.size()];
        return accounts.toArray(thisArray);
    }

    public boolean isVip(){
        int totalBalance = 0;
        for (Accountable account : accounts){
            totalBalance += account.getBalance();

        }
        if (totalBalance >= 25000) {
            return true;
        }
        return false;
    }
}
