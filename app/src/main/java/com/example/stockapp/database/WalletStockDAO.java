package com.example.stockapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.stockapp.model.Stock;
import com.example.stockapp.model.WalletStock;

import java.util.List;

@Dao
public interface WalletStockDAO {
    @Insert
    void insertNewStock(WalletStock stock);

    @Delete
    void deleteAStock(WalletStock toDelete);

    @Query("SELECT * FROM WalletStock")
    List<WalletStock> getAll();




}