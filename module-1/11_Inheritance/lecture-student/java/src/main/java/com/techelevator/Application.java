package com.techelevator;

import java.util.List;

public class Application {

    public static void main(String[] args) {

//        // Create a new general auction
//        System.out.println("Starting a general auction");
//        System.out.println("-----------------");
//
//        Auction generalAuction = new Auction("Tech Elevator t-shirt");
//
//        generalAuction.placeBid(new Bid("Josh", 1));
//        generalAuction.placeBid(new Bid("Fonz", 23));
//        generalAuction.placeBid(new Bid("Rick Astley", 13));
//
//        List<Bid> allOfThem = generalAuction.getAllBids();
//        for (Bid individualBid : allOfThem) {
//            System.out.println(individualBid.getBidder() + " " + individualBid.getBidAmount());
//        }

        Auction reserveAuction = new ReserveAuction("giant-size x men", 200000);

        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

    }
}