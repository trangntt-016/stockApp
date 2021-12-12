package com.example.stockapp.database;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;


import androidx.room.Room;

import com.example.stockapp.model.WalletStock;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseManager {
    static WalletStockDatabase db;

    ExecutorService databaseExecutor = Executors.newFixedThreadPool(4);

    Handler db_handler = new Handler(Looper.getMainLooper());

    public interface DatabaseListener {
        void databaseAllWalletStocksListener(List<WalletStock> list);
    }

    public DatabaseListener listener;

    private static void BuildDBInstance (Context context) {
        db = Room.databaseBuilder(context,WalletStockDatabase.class,"wallet_db")
                .fallbackToDestructiveMigration().build();
    }

    public static WalletStockDatabase getDBInstance(Context context){
        if (db == null){
            BuildDBInstance(context);
        }
        return db;
    }

    public void insertNewWalletStock(WalletStock s){
        databaseExecutor.execute(new Runnable() {
            @Override
            public void run() {
                db.getWalletStockDAO().insertNewStock(s);
            }
        });
    }

    public void getAllWalletStocks(){
        databaseExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<WalletStock> list =  db.getWalletStockDAO().getAll();
                db_handler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.databaseAllWalletStocksListener(list);
                    }
                });

            }
        });

    }


}
