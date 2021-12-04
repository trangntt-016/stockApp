package com.example.stockapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.stockapp.model.Wallet;

@Dao
public interface IWalletDao {
    @Insert
    void insert(Wallet user);
}