package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.File;

public class Application {

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/vending_machine");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        File inputFile = new File("vendingmachine.csv");

        VendingMachine dbVm = new VendingMachine(dataSource);
        VendingMachine fileVm = new VendingMachine(inputFile);
    }
}
