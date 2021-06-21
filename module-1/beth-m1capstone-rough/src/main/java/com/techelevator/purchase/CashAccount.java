package com.techelevator.purchase;

import com.techelevator.change.Change;
import com.techelevator.change.ChangeMaker;
import com.techelevator.change.MinimumChangeMaker;

import java.math.BigDecimal;

public class CashAccount implements Fundable {
    private BigDecimal availableFunds = new BigDecimal(0);
    private final ChangeMaker changeMaker = new MinimumChangeMaker();;

    @Override
    public BigDecimal getBalance() {
        return availableFunds;
    }

    @Override
    public boolean creditFunds(BigDecimal creditAmount) {
        if (isValidAmount(creditAmount)) {
            availableFunds = availableFunds.add(creditAmount);
            return true;
        }
        return false;

    }

    @Override
    public boolean debitFunds(BigDecimal debitAmount) {
        if (availableFunds.compareTo(debitAmount) >= 0) {
            availableFunds = availableFunds.subtract(debitAmount);
            return true;
        }
        else throw new InsufficientFundsException();
    }

    private boolean isValidAmount(BigDecimal amount) {
        if (amount == null)
            return false;

        if (amount.compareTo(BigDecimal.valueOf(1)) == 0) { // 1 Dollar
            return true;
        } else if (amount.compareTo(BigDecimal.valueOf(2)) == 0) { // 2 Dollars
            return true;
        } else if (amount.compareTo(BigDecimal.valueOf(5)) == 0) { // 5 Dollars
            return true;
        } else if (amount.compareTo(BigDecimal.valueOf(10)) == 0) { // 10 Dollars
            return true;
        }

        return false;
    }

    public String refundBalance() {
        Change change = changeMaker.getChangeFor(availableFunds);
        availableFunds = availableFunds.subtract(availableFunds);
        return change.toString();
    }

}
