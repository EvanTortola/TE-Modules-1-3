package com.techelevator;

public class BuyoutAuction extends Auction {

    private int buyoutPrice;
    boolean isActive = true;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        //if it meets the buyout price and the auction is active, then it's the winner and end the auction
        if(isActive) {
            if (offeredBid.getBidAmount() >= buyoutPrice) {
                isActive = false;
            }
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

}
