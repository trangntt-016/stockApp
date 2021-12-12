package com.example.stockapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stockapp.database.DatabaseManager;
import com.example.stockapp.model.WalletStock;

import java.util.ArrayList;
import java.util.List;

public class WalletStockListActivity extends AppCompatActivity implements DatabaseManager.DatabaseListener {
    TextView symbolTv;
    ListView walletStockLV;

    DatabaseManager dbManager;
    ArrayList<WalletStock> walletStockListFromDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_stock_list);
        symbolTv = findViewById(R.id.symbol);
        walletStockLV = findViewById(R.id.list_of_wallet_stocks);
        dbManager = ((myApp) getApplication()).getDatabaseManager();
        dbManager.listener = this;
        //listFromMA = getIntent().getParcelableArrayListExtra("listOfDonations");
        dbManager.getAllWalletStocks();

    }
    @Override
    public void databaseAllWalletStocksListener(List<WalletStock> list) {
        walletStockListFromDB = new ArrayList<>(list);
        WalletStockListAdapter adapter = new WalletStockListAdapter(walletStockListFromDB,this);
        walletStockLV.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        Intent intent = new Intent(getApplicationContext(), CompanyActivity.class);
        startActivity(intent);

        return true;
    }
}
