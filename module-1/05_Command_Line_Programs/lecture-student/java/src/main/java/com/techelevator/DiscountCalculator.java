package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String userDiscount = scanner.nextLine();
        double discountPercent = Double.parseDouble(userDiscount);







        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String userPricesToDiscount = scanner.nextLine();
         // split the input on spaces and get them to an array of doubles

            //1- split string -> gives me an array of strings
        String[] arrStrPrice;
        arrStrPrice = userPricesToDiscount.split( " ");
            //2 - use array of strings to build array of doubles

        // double [] prices = new double[arrStrPrice.length];
        // 2v1 - iterate over string array, parse, calculate, print

        for (int i = 0; i < arrStrPrice.length; i ++ ) {

            double = originalPrice = Double.parseDouble(arrStrPrice[i]);

            System.out.println("Original Price: $" +
                    originalPrice +
                    "Discounted Price: $ + );

        }





    }

}