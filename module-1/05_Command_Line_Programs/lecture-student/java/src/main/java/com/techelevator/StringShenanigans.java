package com.techelevator;

public class StringShenanigans {

    public static void main (String [] args) {

        String name1 = "Steve";
        String name2 = "Steve";

        String name3 = new String ( "Steve");
        String name4 = new String  ("Steve");

        System.out.println("Steve == Steve: " + (name1 == name2));
        System.out.println("Steve.equals(Steve): " + name1.equals(name2));

        System.out.println("Steve == Steve: " + (name3 == name4));
        System.out.println("Steve.equals(Steve): " + name4.equals(name4));



    }
}
