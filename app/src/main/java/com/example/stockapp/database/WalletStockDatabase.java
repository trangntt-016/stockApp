package com.example.stockapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.stockapp.model.WalletStock;

@Database(version = 2, exportSchema = false,entities = {WalletStock.class})
public abstract class WalletStockDatabase extends RoomDatabase {

    abstract public WalletStockDAO getWalletStockDAO();

}