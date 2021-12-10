package com.example.stockapp;

import android.graphics.Bitmap;

import com.example.stockapp.model.Stock;

import java.util.List;

public class DatabaseService {
    private NetworkingService networkingManager;

    private List<Stock>stockList = null;

    private static DatabaseService dbInstance;

    private DatabaseService(){
        networkingManager = new NetworkingService();
    }

    public static DatabaseService getDbInstance(){
        if(dbInstance == null){
            dbInstance = new DatabaseService();
        }
        return dbInstance;
    }

    public void setStockList(List<Stock>stockList){
        this.stockList = stockList;
    }
    public List<Stock> getStocksFromApi(){
        return this.stockList;
    }

}
