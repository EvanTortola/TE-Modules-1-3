package com.techelevator;

public class BuyoutAuction extends Auction {

    private int buyoutPrice;
    boolean isActive = true;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;

    }

    @Override
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid = false;
        if (isActive){
        if (offeredBid.getBidAmount() >= buyoutPrice){
            isCurrentWinningBid = super.placeBid(offeredBid);
            isActive = false;

        }
        isCurrentWinningBid = super.placeBid(offeredBid);


        }
        return isCurrentWinningBid;
    }

}
