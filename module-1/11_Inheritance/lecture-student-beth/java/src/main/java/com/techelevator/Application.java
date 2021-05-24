package com.techelevator;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

//        Auction generalAuction = new Auction("Tech Elevator t-shirt");
//
//        generalAuction.placeBid(new Bid("Josh", 1));
//        generalAuction.placeBid(new Bid("Fonz", 23));
//        generalAuction.placeBid(new Bid("Rick Astley", 13));
//
//        List<Bid> allOfThem = generalAuction.getAllBids();
//        for(Bid individualBid : allOfThem) {
//            System.out.println(individualBid.getBidder() + " " + individualBid.getBidAmount());
//        }
//
//        Auction reserveAuction = new ReserveAuction("giant-sized x men", 200000);
//        reserveAuction.placeBid(new Bid("Rick Astley", 13));
//        reserveAuction.placeBid(new Bid("Mike", 10000000));
//        reserveAuction.placeBid(new Bid("Rory MacElroy", 200100));
//
        Auction buyoutAuction = new BuyoutAuction("super old book", 2000);
        buyoutAuction.placeBid(new Bid("JS AF", 1400));
        buyoutAuction.placeBid(new Bid("Rick Astley", 1800));
        buyoutAuction.placeBid(new Bid("JS AF", 2000));
        buyoutAuction.placeBid(new Bid("Rick Astley", 2100));

        buyoutAuction.itemForSale = "super super old book";




        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

    }
}
