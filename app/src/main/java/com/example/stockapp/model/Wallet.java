package com.example.stockapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Wallet {
    @PrimaryKey
    public int walletId;

    @ColumnInfo(name = "userCreatorId")
    public int userCreatorId;

    @ColumnInfo(name = "walletName")
    public String walletName;

    public Wallet(int userCreatorId, String walletName){
        this.userCreatorId = userCreatorId;
        this.walletName = walletName;
    }
}
