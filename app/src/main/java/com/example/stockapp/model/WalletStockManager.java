package com.example.stockapp.model;

import java.util.ArrayList;

public class WalletStockManager {

    ArrayList<WalletStock> listOfWalletStocks = new ArrayList<>(0);

    public ArrayList<WalletStock> getListOfWalletStocks() {

        return this.listOfWalletStocks;
    }

    public void addNewWalletStock(WalletStock s){
        this.listOfWalletStocks.add(s);// database locally // webservice  // cloud database
    }

}
