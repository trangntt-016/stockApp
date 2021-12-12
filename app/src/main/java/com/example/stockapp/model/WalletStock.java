package com.example.stockapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WalletStock implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int stockId;

    @ColumnInfo(name = "symbol")
    public String symbol;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "logo")
    public String logo;

    public WalletStock(){
        this.symbol = null;
        this.name = null;
        this.logo = null;
    }

    public WalletStock(String symbol, String name, String logo){
        this.symbol = symbol;
        this.name = name;
        this.logo = logo;
    }

    protected WalletStock(Parcel in) {
        stockId = in.readInt();
        symbol = in.readString();
        name = in.readString();
        logo = in.readString();
    }

    public static final Creator<WalletStock> CREATOR = new Creator<WalletStock>() {
        @Override
        public WalletStock createFromParcel(Parcel in) {
            return new WalletStock(in);
        }

        @Override
        public WalletStock[] newArray(int size) {
            return new WalletStock[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(stockId);
        dest.writeString(symbol);
        dest.writeString(name);
        dest.writeString(logo);
    }
}
