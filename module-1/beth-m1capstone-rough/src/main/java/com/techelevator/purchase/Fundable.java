package com.techelevator.purchase;

import java.math.BigDecimal;

public interface Fundable {

    public BigDecimal getBalance();
    public boolean creditFunds(BigDecimal creditAmount);
    public boolean debitFunds(BigDecimal debitAmount);
    public String refundBalance();
}
